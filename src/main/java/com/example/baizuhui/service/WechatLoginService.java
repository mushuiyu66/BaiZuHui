package com.example.baizuhui.service;

import com.example.baizuhui.domain.User;
import com.example.baizuhui.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class WechatLoginService {

    private static final Logger logger = LoggerFactory.getLogger(WechatLoginService.class);
    private final RestTemplate restTemplate;
    private final String appid;
    private final String secret;
    private final String loginUrl;
    private final ObjectMapper objectMapper;
    private final UserMapper userMapper; // 注入 UserMapper

    @Autowired
    public WechatLoginService(
            @Value("${wechat.appid}") String appid,
            @Value("${wechat.secret}") String secret,
            @Value("${wechat.login-url}") String loginUrl,
            RestTemplate restTemplate,
            ObjectMapper objectMapper,
            UserMapper userMapper // 新增 UserMapper 注入
    ) {
        this.appid = appid;
        this.secret = secret;
        this.loginUrl = loginUrl;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.userMapper = userMapper;
    }

    public Map<String, Object> wechatLogin(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("微信登录code不能为空");
        }

        String url = String.format("%s?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                loginUrl, appid, secret, code);

        logger.info("请求微信登录API: {}", loginUrl);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<?> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            if (!response.getStatusCode().is2xxSuccessful()) {
                logger.error("微信API响应失败，状态码: {}", response.getStatusCode());
                logger.error("微信API响应内容: {}", response.getBody());
                throw new RuntimeException("微信API响应异常: " + response.getStatusCode());
            }

            String responseBody = response.getBody();
            logger.info("微信API响应内容: {}", responseBody);

            // 解析微信返回的JSON
            @SuppressWarnings("unchecked")
            Map<String, Object> resultMap = objectMapper.readValue(responseBody, Map.class);

            String openid = (String) resultMap.get("openid");
            String unionid = (String) resultMap.get("unionid"); // 假设微信返回了 unionid

            // 检查微信接口返回的错误
            if (resultMap.containsKey("errcode") && !resultMap.get("errcode").equals(0)) {
                String errmsg = (String) resultMap.get("errmsg");
                logger.error("微信登录失败，错误码: {}, 错误信息: {}",
                        resultMap.get("errcode"), errmsg);

                // 返回结构化错误信息给前端
                Map<String, Object> errorResult = new HashMap<>();
                errorResult.put("code", 500);
                errorResult.put("message", "微信登录验证失败: " + errmsg);
                errorResult.put("detail", resultMap);

                // 这里应该抛出异常，由全局异常处理器处理
                throw new RuntimeException("微信登录失败: " + errmsg);
            }

            // 确保返回数据包含必要字段
            if (!resultMap.containsKey("openid") || !resultMap.containsKey("session_key")) {
                logger.error("微信API响应缺少必要字段: {}", resultMap);
                throw new RuntimeException("微信API返回格式异常");
            }

            // 保存或更新用户信息到数据库
            saveOrUpdateUser(unionid, openid);

            // 构建统一的返回格式
            Map<String, Object> returnData = new HashMap<>();
            returnData.put("code", 200);
            returnData.put("message", "成功");
            returnData.put("data", Map.of(
                    "openid", resultMap.get("openid"),
                    "session_key", resultMap.get("session_key")
            ));

            return returnData;

        } catch (Exception e) {
            logger.error("微信登录过程发生异常", e);

            // 返回统一的错误格式
            Map<String, Object> errorResult = new HashMap<>();
            errorResult.put("code", 500);
            errorResult.put("message", "微信登录处理失败: " + e.getMessage());

            throw new RuntimeException("微信登录处理失败", e);
        }
    }

    private void saveOrUpdateUser(String unionid, String miniOpenId) {
        // 先根据 unionid 或 miniOpenId 查询用户是否存在
        User user = null;
        if (unionid != null) {
            // 这里需要在 UserMapper 中添加根据 unionid 查询用户的方法
            // user = userMapper.findByUnionId(unionid);
        }
        if (user == null && miniOpenId != null) {
            // 这里需要在 UserMapper 中添加根据 miniOpenId 查询用户的方法
            // user = userMapper.findByMiniOpenId(miniOpenId);
        }

        if (user == null) {
            // 用户不存在，插入新记录
            user = new User();
            user.setUnionId(unionid);
            user.setMiniOpenId(miniOpenId);
            userMapper.saveUser(user);
        } else {
            // 用户存在，更新 unionid 和 miniOpenId
            user.setUnionId(unionid);
            user.setMiniOpenId(miniOpenId);
            userMapper.dynamicUpdateUser(user);
        }
    }
}
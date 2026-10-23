package com.example.baizuhui.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.baizuhui.domain.Product;
import com.example.baizuhui.service.ProductService;
import com.example.baizuhui.mapper.ProductMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author LENOVO
* @description 针对表【product(商品表)】的数据库操作Service实现
* @createDate 2025-06-23 09:59:33
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{
@Resource
private ProductMapper productMapper;
    @Override
    public List<Product> FindAll() {
        List<Product> FindAll=productMapper.FindAll();
        return FindAll;
    }

    @Override
    public boolean saveProduct(Product product) {
        boolean saveProduct = productMapper.saveProduct(product);
        return saveProduct;
    }

    @Override
    public List<Product> findByPage(Integer offset, Integer pageSize) {
        return productMapper.findByPage(offset,pageSize);
    }

    @Override
    public Integer countProduct() {
        return productMapper.countProduct();
    }

    @Override
    public boolean dynamicUpdateProduct(Product product) {
        // 调用Mapper的动态更新方法
        int rows = productMapper.dynamicUpdateProduct(product);
        // 返回更新结果
        return rows > 0;
    }


    @Override
    public boolean deleteById(Long id) {
        if(id==null){
            return false;
        }
        productMapper.deleteById(id);
        return true;
    }
}





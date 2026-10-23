package com.example.baizuhui.controller;
import com.example.baizuhui.domain.Product;
import com.example.baizuhui.service.ProductService;
import com.example.baizuhui.vo.ProductPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Resource
    private ProductService productService;


    /**
     * 分页查询
     */
    @GetMapping("/findBy-page-product")
    public ProductPage<Product> findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        Integer offset=(pageNum-1)*pageSize;
        List<Product> productData = productService.findByPage(offset, pageSize);
        ProductPage<Product> productPage = new ProductPage<>();
        productPage.setData(productData);

        Integer total= productService.countProduct();
        productPage.setTotal(total);
        productPage.setPageNum(pageNum);
        productPage.setPageSize(pageSize);
        return productPage;
    }


    /**
     *查询所有数据
     */
    @GetMapping("/get-product")
    public List<Product> getProduct(){
        return productService.FindAll();
    }


    /**
     *添加数据
     */
    @PostMapping("/add")
    public String addProduct(@RequestBody Product product){
        boolean b = productService.saveProduct(product);
        if (!b) {
            return "失败";
        }
        return"success!";
    }


    @PutMapping("/dynamicUpdate-product")
    public String dynamicUpdate(@RequestBody Product product) {
        // 调用Service的动态更新方法
        boolean result = productService.dynamicUpdateProduct(product);
        // 返回结果
        if (result) {
            return "用户动态更新成功";
        } else {
            return "用户动态更新失败";
        }
    }



    @DeleteMapping("/product-{id}")
    public String deleteProduct(@PathVariable("id")long id){
        productService.deleteById(id);
        return "success";
    }
}

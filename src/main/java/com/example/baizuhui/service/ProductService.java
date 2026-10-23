package com.example.baizuhui.service;

import com.example.baizuhui.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.baizuhui.domain.User;

import java.util.List;
/**
* @author LENOVO
* @description 针对表【product(商品表)】的数据库操作Service
* @createDate 2025-06-23 09:59:33
*/
public interface ProductService extends IService<Product> {

    List<Product> FindAll();

    boolean saveProduct(Product product);

    List<Product> findByPage(Integer offset, Integer pageSize);

    Integer countProduct();

    boolean dynamicUpdateProduct(Product product);

    boolean deleteById(Long id);
}

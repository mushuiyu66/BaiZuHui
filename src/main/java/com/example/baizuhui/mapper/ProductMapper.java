package com.example.baizuhui.mapper;

import com.example.baizuhui.domain.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author LENOVO
* @description 针对表【product(商品表)】的数据库操作Mapper
* @createDate 2025-06-23 09:59:33
* @Entity generator.domain.Product
*/
public interface ProductMapper extends BaseMapper<Product> {

    @Select("select * from product limit #{offset}, #{pageSize}")
    List<Product> findByPage(Integer offset, Integer pageSize);

    @Select("select count(id) from product")
    Integer countProduct();


    @Select("select * from product")
    List<Product> FindAll();


    @Insert("INSERT INTO `product` (`id`, `name`, `category_id`, `brand_id`, `price`, `original_price`, `stock`, `sales`, `weight`, `status`, `is_hot`, `is_new`, `description`, `main_image`, `detail_images`, `specs`, `created_at`, `updated_at`) VALUES (#{id}, #{name}, #{category_id}, #{brand_id}, #{price}, #{original_price}, #{stock}, #{sales}, #{weight}, #{status}, #{is_hot}, #{is_new}, #{description}, #{main_image}, #{detail_images}, #{specs}, #{created_at}, #{updated_at})")
    @Transactional
    boolean saveProduct(Product product);


    @Update("<script>" +
            "UPDATE product " +
            "<set>" +
            "<if test=\"name != null\">name = #{name},</if>" +
            "<if test=\"category_id != null\">category_id = #{category_id},</if>" +
            "<if test=\"brand_id != null\">brand_id = #{brand_id},</if>" +
            "<if test=\"price != null\">price = #{price},</if>" +
            "<if test=\"original_price != null\">original_price = #{original_price},</if>" +
            "<if test=\"stock != null\">stock = #{stock},</if>" +
            "<if test=\"sales != null\">sales = #{sales},</if>" +
            "<if test=\"weight != null\">weight = #{weight},</if>" +
            "<if test=\"status != null\">status = #{status},</if>" +
            "<if test=\"is_hot != null\">is_hot = #{is_hot},</if>" +
            "<if test=\"is_new != null\">is_new = #{is_new},</if>" +
            "<if test=\"description != null\">description = #{description},</if>" +
            "<if test=\"main_image != null\">main_image = #{main_image},</if>" +
            "<if test=\"detail_images != null\">detail_images = #{detail_images},</if>" +
            "<if test=\"specs != null\">specs = #{specs},</if>" +
            "</set>" +
            "WHERE id=#{id}" +
            "</script>")
    int dynamicUpdateProduct(Product product);

    @Delete("delete from product where id=#{id}")
    void deleteById(Long id);
}





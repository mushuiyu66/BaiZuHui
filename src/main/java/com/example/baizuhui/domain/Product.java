package com.example.baizuhui.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 * @TableName product
 */
@TableName(value ="product")
public class Product implements Serializable {
    /**
     * 商品ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品分类ID
     */
    private Long category_id;

    /**
     * 品牌ID
     */
    private Long brand_id;

    /**
     * 销售价格
     */
    private BigDecimal price;

    /**
     * 原价
     */
    private BigDecimal original_price;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 商品重量(kg)
     */
    private BigDecimal weight;

    /**
     * 商品状态: 0=下架, 1=上架, 2=缺货
     */
    private Integer status;

    /**
     * 是否热门: 0=否, 1=是
     */
    private Integer is_hot;

    /**
     * 是否新品: 0=否, 1=是
     */
    private Integer is_new;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 主图URL
     */
    private String main_image;

    /**
     * 详情图列表(JSON数组)
     */
    private Object detail_images;

    /**
     * 商品规格(JSON对象)
     */
    private Object specs;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created_at;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(BigDecimal original_price) {
        this.original_price = original_price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Integer getIs_new() {
        return is_new;
    }

    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain_image() {
        return main_image;
    }

    public void setMain_image(String main_image) {
        this.main_image = main_image;
    }

    public Object getDetail_images() {
        return detail_images;
    }

    public void setDetail_images(Object detail_images) {
        this.detail_images = detail_images;
    }

    public Object getSpecs() {
        return specs;
    }

    public void setSpecs(Object specs) {
        this.specs = specs;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category_id=" + category_id +
                ", brand_id=" + brand_id +
                ", price=" + price +
                ", original_price=" + original_price +
                ", stock=" + stock +
                ", sales=" + sales +
                ", weight=" + weight +
                ", status=" + status +
                ", is_hot=" + is_hot +
                ", is_new=" + is_new +
                ", description='" + description + '\'' +
                ", main_image='" + main_image + '\'' +
                ", detail_images=" + detail_images +
                ", specs=" + specs +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
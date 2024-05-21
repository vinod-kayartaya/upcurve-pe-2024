package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
//@ToString(exclude = "category")
@Entity
@Table(name = "PRODUCTS")
@NamedQuery(name="category-stock-value", query = "select sum(unitPrice*unitsInStock) " +
        "from Product where category.categoryId=?1")
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_name")
    private String productName;

    @Column(name = "supplier_id")
    private Integer supplierId;
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "units_in_stock")
    private Integer unitsInStock;
    @Column(name = "units_on_order")
    private Integer unitsOnOrder;
    @Column(name = "reorder_level")
    private Integer reorderLevel;
    private Boolean discontinued;

    @ManyToOne // fetch type is EAGER for many-to-one
    @JoinColumn(name = "category_id")
    private Category category;

}

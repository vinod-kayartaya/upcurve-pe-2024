package com.abb.productservice.dto;

import com.abb.productservice.entity.Product;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer productId;
    private String productName;
    private SupplierDTO supplier;
    private CategoryDTO category;
    private String quantityPerUnit;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Boolean discontinued;

    public static ProductDTO toProductDTO(Product product){
        if(product==null){
            return null;
        }
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setQuantityPerUnit(product.getQuantityPerUnit());
        dto.setUnitPrice(product.getUnitPrice());
        dto.setUnitsInStock(product.getUnitsInStock());
        dto.setUnitsOnOrder(product.getUnitsOnOrder());
        dto.setReorderLevel(product.getReorderLevel());
        dto.setDiscontinued(product.getDiscontinued());
        return dto;
    }

    public static Product toProduct(ProductDTO dto){
        if(dto==null){
            return null;
        }
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setQuantityPerUnit(dto.getQuantityPerUnit());
        product.setUnitPrice(dto.getUnitPrice());
        product.setUnitsInStock(dto.getUnitsInStock());
        product.setUnitsOnOrder(dto.getUnitsOnOrder());
        product.setReorderLevel(dto.getReorderLevel());
        product.setDiscontinued(dto.getDiscontinued());
        return product;
    }

}

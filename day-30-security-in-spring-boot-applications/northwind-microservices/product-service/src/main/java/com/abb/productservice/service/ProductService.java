package com.abb.productservice.service;

import com.abb.productservice.dto.CategoryDTO;
import com.abb.productservice.dto.ProductDTO;
import com.abb.productservice.dto.SupplierDTO;
import com.abb.productservice.entity.Product;
import com.abb.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository repo;

    @Value("${category.service.url}")
    private String categoryServiceUrl;

    @Value("${supplier.service.url}")
    private String supplierServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<ProductDTO> getAllProducts() {
//        return repo.findAll().stream().map(p -> {
//            var dto = ProductDTO.toProductDTO(p);
//            dto.setCategory(this.getCategoryDTO(p));
//            dto.setSupplier(this.getSupplierDTO(p));
//            return dto;
//        }).toList();

        return repo.findAll().stream().map(ProductDTO::toProductDTO).toList();
    }

    public ProductDTO getProduct(Integer id) {
        var product = repo.findById(id).orElse(null);
        var productDTO = ProductDTO.toProductDTO(product);
        CategoryDTO categoryDTO = null;
        SupplierDTO supplierDTO = null;

        categoryDTO = getCategoryDTO(product);
        productDTO.setCategory(categoryDTO);
        supplierDTO = getSupplierDTO(product);
        productDTO.setSupplier(supplierDTO);

        return productDTO;
    }

    private SupplierDTO getSupplierDTO(Product product) {
        try {
            return restTemplate.getForObject(supplierServiceUrl + product.getSupplierId(), SupplierDTO.class);
        } catch (Exception e) {
            log.warn("error while fetching supplier information for supplier id " + product.getSupplierId());
        }
        return null;
    }

    private CategoryDTO getCategoryDTO(Product product) {
        try {
            return restTemplate.getForObject(categoryServiceUrl + product.getCategoryId(), CategoryDTO.class);
        } catch (Exception e) {
            log.warn("error while fetching category information for category id " + product.getCategoryId());
        }
        return null;
    }
}

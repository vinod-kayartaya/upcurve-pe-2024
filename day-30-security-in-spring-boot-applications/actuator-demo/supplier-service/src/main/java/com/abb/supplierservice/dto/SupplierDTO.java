package com.abb.supplierservice.dto;

import com.abb.supplierservice.entity.Supplier;
import lombok.Data;

@Data
public class SupplierDTO {
    private Integer supplierId;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String homepage;

    public static SupplierDTO toSupplierDTO(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        SupplierDTO dto = new SupplierDTO();
        dto.setSupplierId(supplier.getSupplierId());
        dto.setCompanyName(supplier.getCompanyName());
        dto.setContactName(supplier.getContactName());
        dto.setContactTitle(supplier.getContactTitle());
        dto.setAddress(supplier.getAddress());
        dto.setCity(supplier.getCity());
        dto.setRegion(supplier.getRegion());
        dto.setPostalCode(supplier.getPostalCode());
        dto.setCountry(supplier.getCountry());
        dto.setPhone(supplier.getPhone());
        dto.setFax(supplier.getFax());
        dto.setHomepage(supplier.getHomepage());
        return dto;
    }

    public static Supplier toSupplier(SupplierDTO dto) {
        if (dto == null) {
            return null;
        }
        Supplier supplier = new Supplier();
        supplier.setSupplierId(dto.supplierId);
        supplier.setCompanyName(dto.companyName);
        supplier.setContactName(dto.contactName);
        supplier.setContactTitle(dto.contactTitle);
        supplier.setAddress(dto.address);
        supplier.setCity(dto.city);
        supplier.setRegion(dto.region);
        supplier.setPostalCode(dto.postalCode);
        supplier.setCountry(dto.country);
        supplier.setPhone(dto.phone);
        supplier.setFax(dto.fax);
        supplier.setHomepage(dto.homepage);
        return supplier;
    }
}

package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;
import jakarta.persistence.EntityManager;

public class GetOneCategory {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("enter category id to search: ");
        Category c = null;
        try (EntityManager em = JpaUtil.createEntityManager()) {
            c = em.find(Category.class, id);
            if (c == null) {
                System.out.println("invalid category id");
                return;
            }

            Printer.print(c, "picture", "products");
            System.out.println("products that belong to this category are:");
            c.getProducts().forEach(GetOneCategory::printProductInfo);
        } // em.close() called
    }

    static void printProductInfo(Product p) {
        System.out.println(p.getProductId() + " --> " + p.getProductName());
    }
}

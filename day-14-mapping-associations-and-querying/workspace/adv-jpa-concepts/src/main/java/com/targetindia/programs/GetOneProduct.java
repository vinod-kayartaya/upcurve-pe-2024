package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;
import jakarta.persistence.EntityManager;

public class GetOneProduct {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("enter product id to search: ");
        Product p = null;
        try (EntityManager em = JpaUtil.createEntityManager()) {
            p = em.find(Product.class, id);
        } // em.close() called


        if (p == null) {
            System.out.println("no product found for id " + id);
        } else {
            Printer.print(p, "category");
            Printer.print(p.getCategory(), "picture");
        }

    }
}

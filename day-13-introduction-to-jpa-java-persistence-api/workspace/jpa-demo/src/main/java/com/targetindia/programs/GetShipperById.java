package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetShipperById {
    public static void main(String[] args) {
        Shipper shipper = null;

        int id = KeyboardUtil.getInt("enter shipper id to search: ");
        try (EntityManager em = JpaUtil.createEntityManager()) {

            System.out.println("----pass1");
            shipper = em.find(Shipper.class, id); // GOES TO THE DB TO FETCH, AND KEEPS THE RESULT IN THE CACHE
            // shipper object is a managed object (created by entity manager)

            shipper = em.find(Shipper.class, id); // ALREADY IN CACHE; NO NEED TO VISIT DB
            shipper = em.find(Shipper.class, id); // ALREADY IN CACHE; NO NEED TO VISIT DB
            shipper = em.find(Shipper.class, id); // ALREADY IN CACHE; NO NEED TO VISIT DB
            shipper = em.find(Shipper.class, id); // ALREADY IN CACHE; NO NEED TO VISIT DB

            System.out.println("----pass2");
            System.out.println(shipper);
        }// em.close() called here automatically

        // shipper is no longer part of the entity manager
        // hence it is a `detached` object
    }
}
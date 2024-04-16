package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class SearchAndUpdateShipper {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("enter shipper id to search: ");
        Shipper shipper = null;

        try (
                EntityManager em = JpaUtil.createEntityManager();
        ) {
            shipper = em.find(Shipper.class, id);
            // at this time, `shipper` is a managed object.
            System.out.println(shipper);
            var phone = KeyboardUtil.getString("enter phone# to update: ");
            shipper.setPhone(phone); // mutating the `managed` object makes it DIRTY (after a dirty check)
            var tx = em.getTransaction();
            tx.begin();
            try{
                tx.commit(); // SQL UPDATE command for all DIRTY entities
                System.out.println("updated!");
            }
            catch (Exception e){
                tx.rollback();
                System.out.println("couldn't update");
            }
        }
    }
}

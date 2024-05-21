package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class SearchAndUpdateShipper {

    static Shipper getShipper(Integer id){
        try (
                EntityManager em = JpaUtil.createEntityManager();
        ) {
            return em.find(Shipper.class, id);
        } // current entity-manager is closed; hence the shipper is detached
    }
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("enter shipper id to search: ");
        Shipper shipper = getShipper(id);

        try (
                EntityManager em = JpaUtil.createEntityManager();
        ) {
            var phone = KeyboardUtil.getString("enter phone# to update: ");
            shipper.setPhone(phone);  // still a detached entity
            var tx = em.getTransaction();
            tx.begin();
            try{
                em.merge(shipper); // if succeeds, shipper is a managed entity
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

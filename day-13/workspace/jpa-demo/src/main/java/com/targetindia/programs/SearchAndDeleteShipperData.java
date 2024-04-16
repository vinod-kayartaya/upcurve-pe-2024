package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class SearchAndDeleteShipperData {
    public static void main(String[] args) {

        int id = KeyboardUtil.getInt("enter shipper id to delete: ");
        Shipper shipper = null;

        try (
                EntityManager em = JpaUtil.createEntityManager();
        ) {
            shipper = em.find(Shipper.class, id);
            // at this time, `shipper` is a managed object.

            System.out.println(shipper);
            var choice = KeyboardUtil.getString("are you sure to delete this? (yes/no) [no] ");
            if(choice.equalsIgnoreCase("yes")){
                var tx = em.getTransaction();
                tx.begin();

                try{
                    em.remove(shipper);
                    tx.commit();
                    System.out.println("deleted!");
                }
                catch (Exception e){
                    tx.rollback();
                    System.out.println("couldn't delete");
                }
            }
        }// em.close() called

        System.out.println(shipper);
        // at this time, there is no record in the db corresponding to this `shipper`
        // hence it is called `removed` object

    }
}

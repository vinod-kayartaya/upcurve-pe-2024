package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class AddNewShipperData {

    public static void main(String[] args) {
        System.out.println("Give new shipper data to add: ");
        int id = KeyboardUtil.getInt("id: ");
        String name = KeyboardUtil.getString("name: ");
        String phone = KeyboardUtil.getString("phone: ");

        Shipper shipper = new Shipper();
        shipper.setId(id);
        shipper.setName(name);
        shipper.setPhone(phone);

        // at this time shipper is a `new` object (NOTHING TO DO WITH ENTITY MANAGER)

        try (
                EntityManager em = JpaUtil.createEntityManager();
        ) {
            var tx = em.getTransaction();
            tx.begin();
            try {
                System.out.println("-----pass1");
                em.persist(shipper);    // STATE --> NEW        --> sql INSERT
                // now `shipper` is managed by the entity manager; hence called `managed object`

                // em.merge(emp1)       // STATE --> DIRTY      --> sql UPDATE
                // em.remove(product1)  // STATE --> DELETE     --> sql DELETE
                System.out.println("-----pass2");
                tx.commit(); // consolidated SQL DML commands (insert/update/delete) are executed here
                System.out.println("-----pass3");
            } catch (Exception e) {
                tx.rollback();
                System.out.println(e.getMessage());
                System.out.println("-----pass4");
            }
        }// em.close() called here

        // now that there is no entity manager, `shipper` is a detached object
        System.out.println(shipper);
    }
}

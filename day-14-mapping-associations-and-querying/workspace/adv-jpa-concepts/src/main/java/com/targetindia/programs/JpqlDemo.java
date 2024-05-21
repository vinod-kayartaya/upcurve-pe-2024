package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class JpqlDemo {

    static EntityManager em;

    public static void main(String[] args) {
        em = JpaUtil.createEntityManager();

        // getAllCategories();
        // getProductsByPriceRange();
        // getProductAndCategoryNames();
        // getCategoryWiseCostliestProduct();
        // getOrderTotal();
        getCategoryStockValue();

        em.close();
    }

    static void getCategoryStockValue() {
        var categoryId = KeyboardUtil.getInt("enter category id: ");
        var qry = em.createNamedQuery("category-stock-value", Double.class);
        qry.setParameter(1, categoryId);
        var stockValue = qry.getSingleResult();
        //  var stockValue = qry.getResultList().get(0);
        System.out.println("stock value = $" + stockValue);
    }

    static void getOrderTotal() {
        var orderId = KeyboardUtil.getInt("enter order id: ");
        var sql = "select sum(unit_price*quantity*(1-discount)) ORDER_TOTAL from ORDER_DETAILS where order_id=?1";
        var qry = em.createNativeQuery(sql);
        qry.setParameter(1, orderId);
        var total = qry.getSingleResult();
        System.out.println("order total is $" + total);
    }

    static void getCategoryWiseCostliestProduct() {
        String qlString = "from Product p where p.unitPrice = (select max(unitPrice) from Product where category=p.category)";
        em.createQuery(qlString, Product.class)
                .getResultList()
                .forEach(p -> System.out.println(
                        p.getProductName() + " (" +
                                p.getCategory().getCategoryName() + ") " +
                                p.getUnitPrice()
                ));
    }

    static void getProductAndCategoryNames() {
        String qlString = "select productName, category.categoryName from Product";
        var qry = em.createQuery(qlString, Object[].class);
        qry.getResultList()
                .forEach(result -> System.out.println(result[0] + " --> " + result[1]));
    }

    static void getProductsByPriceRange() {
        double min = KeyboardUtil.getDouble("enter minimum price: ");
        double max = KeyboardUtil.getDouble("enter maximum price: ");
        // String qlString = "from Product where unitPrice between ?1 and ?2";
        String qlString = "from Product where unitPrice between :min and :max";
        var qry = em.createQuery(qlString, Product.class);
        // qry.setParameter(1, min);
        // qry.setParameter(2, max);
        qry.setParameter("min", min);
        qry.setParameter("max", max);
        qry.getResultList()
                .forEach(p -> System.out.printf("%s --> %.2f\n", p.getProductName(), p.getUnitPrice()));
    }

    static void getAllCategories() {
        // sql = "select * from CATEGORIES"
        // jpql = "select c from Category c"
        //        "from Category"
        String jpql = "from Category";
        var qry = em.createQuery(jpql, Category.class);
        qry.getResultList()
                .forEach(c -> System.out.println(c.getCategoryId() + " --> " + c.getCategoryName()));

    }
}

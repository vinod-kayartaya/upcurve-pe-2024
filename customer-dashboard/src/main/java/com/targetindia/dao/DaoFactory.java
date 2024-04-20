package com.targetindia.dao;

import java.util.ResourceBundle;

public final class DaoFactory {

    private DaoFactory() {
    }

    private static final ResourceBundle rb;

    static {
        rb = ResourceBundle.getBundle("jpa");
    }

    public static CustomerDao getCustomerDao() throws DaoException {
        var customerDaoImplClassName = rb.getString("CustomerDao.impl-class");
        try {
            return (CustomerDao) Class.forName(customerDaoImplClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}

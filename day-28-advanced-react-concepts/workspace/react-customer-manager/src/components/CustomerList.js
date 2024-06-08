import React from 'react';
import CustomerCard from './CustomerCard';

function CustomerList({ customers, deleteCustomer }) {
  const customersJsx = customers.map((c) => (
    <CustomerCard customer={c} key={c.id} deleteCustomer={deleteCustomer} />
  ));

  return (
    <>
      {customers.length > 0 && <div className='list-group'>{customersJsx}</div>}
      {customers.length === 0 && (
        <h5>There are no customers. Use the customer form to add a new one.</h5>
      )}
    </>
  );
}

export default CustomerList;

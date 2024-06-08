import React from 'react';

function CustomerCard({ customer, deleteCustomer }) {
  const deleteButtonHandler = () => {
    if (!window.confirm('Are you sure to delete this?')) {
      return;
    }

    deleteCustomer(customer.id);
  };

  return (
    <>
      <div className='list-group-item rcm-buttons-wrapper'>
        <div className='row '>
          <div className='col-md-3'>
            <img
              className='rcm-img-circle img-thumbnail'
              src={customer.avatar}
              alt={customer.name}
            />
          </div>

          <div className='col-md-6'>
            <h3>{customer.name}</h3>
            <p className='lead'>
              <i className='bi bi-envelope'></i> {customer.email}
              <br />
              <i className='bi bi-telephone'></i> {customer.phone}
            </p>
          </div>
          <div className='col-md-3 rcm-buttons text-end'>
            <button className='btn btn-link text-primary'>
              <h4 className='bi bi-pencil'></h4>
            </button>

            <button
              onClick={deleteButtonHandler}
              className='btn btn-link text-danger'
            >
              <h4 className='bi bi-trash'></h4>
            </button>
          </div>
        </div>
      </div>
    </>
  );
}

export default CustomerCard;

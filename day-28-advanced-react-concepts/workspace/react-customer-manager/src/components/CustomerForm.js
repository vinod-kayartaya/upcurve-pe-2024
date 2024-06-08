import React, { useRef, useState } from 'react';

function CustomerForm({ addCustomer }) {
  const [customer, setCustomer] = useState({
    name: '',
    email: '',
    phone: '',
    avatar:
      'https://img.freepik.com/premium-vector/default-male-user-profile-icon-vector-illustration_276184-168.jpg',
  });

  const textChangeHandler = (evt) => {
    console.log(evt.target.value);
    setCustomer({ ...customer, [evt.target.name]: evt.target.value });
  };

  const submitHandler = (evt) => {
    evt.preventDefault(); // prevents the default behavior of form-submission

    // collect the values from form inputs and process here (not sending to the server)
    // or send it to the server via a REST endpoint (usual using the fetch api or other 3rd party libraries e.g, axios)

    addCustomer(customer);
    setCustomer({
      name: '',
      email: '',
      phone: '',
      avatar:
        'https://img.freepik.com/premium-vector/default-male-user-profile-icon-vector-illustration_276184-168.jpg',
    });
  };

  return (
    <>
      <h5>New customer data</h5>
      <form onSubmit={submitHandler}>
        <div className='mb-3'>
          <label htmlFor='nameInput' className='form-label'>
            Name
          </label>
          <input
            type='text'
            className='form-control'
            id='nameInput'
            value={customer.name}
            onChange={textChangeHandler}
            name='name'
          />
        </div>
        <div className='mb-3'>
          <label htmlFor='emailInput' className='form-label'>
            Email address
          </label>
          <input
            type='email'
            className='form-control'
            id='emailInput'
            value={customer.email}
            onChange={textChangeHandler}
            name='email'
          />
        </div>
        <div className='mb-3'>
          <label htmlFor='phoneInput' className='form-label'>
            Phone number
          </label>
          <input
            type='tel'
            className='form-control'
            id='phoneInput'
            value={customer.phone}
            onChange={textChangeHandler}
            name='phone'
          />
        </div>
        <div className='mb-3'>
          <label htmlFor='avararInput' className='form-label'>
            Avarar URL
          </label>
          <input
            type='text'
            className='form-control'
            id='avararInput'
            value={customer.avatar}
            onChange={textChangeHandler}
            name='avatar'
          />
        </div>

        <button type='submit' className='btn btn-primary'>
          Submit
        </button>
      </form>
    </>
  );
}

export default CustomerForm;

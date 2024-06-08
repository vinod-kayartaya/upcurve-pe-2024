import Header from './components/Header';
import Footer from './components/Footer';
import CustomerForm from './components/CustomerForm';
import CustomerList from './components/CustomerList';
import { useState } from 'react';

const initialData = [
  {
    id: 1,
    name: 'Vinod Kumar',
    email: 'vinod@vinod.co',
    phone: '9731424784',
    avatar: 'https://avatars.githubusercontent.com/u/109946821?v=4',
  },
  {
    id: 2,
    name: 'Ramesh Iyer',
    email: 'rameshiyer@xmpl.com',
    phone: '9731412345',
    avatar:
      'https://www.shutterstock.com/image-photo/closeup-portrait-young-smiling-hispanic-260nw-2327799157.jpg',
  },
  {
    id: 3,
    name: 'Suresh Kumar',
    email: 'suresh.kumar@xmpl.com',
    phone: '9731445678',
    avatar:
      'https://img.freepik.com/free-photo/smiling-businessman-face-portrait-wearing-suit_53876-148138.jpg',
  },
];

function App() {
  const [customers, setCustomers] = useState(initialData);

  const deleteCustomer = (id) => {
    const remainingCustomers = customers.filter((c) => c.id !== id);
    setCustomers(remainingCustomers); // state change will trigger rerendering of App component all the components
    // that depend this data
  };

  const addCustomer = (customer) => {
    customer.id = Date.now();
    const newCustomers = [...customers, customer];
    setCustomers(newCustomers);
  };

  return (
    <>
      <Header />
      <div className='container rcm-main'>
        <div className='row'>
          <div className='col-md-5'>
            <CustomerForm addCustomer={addCustomer} />
          </div>
          <div className='col-md-7'>
            <CustomerList
              customers={customers}
              deleteCustomer={deleteCustomer}
            />
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default App;

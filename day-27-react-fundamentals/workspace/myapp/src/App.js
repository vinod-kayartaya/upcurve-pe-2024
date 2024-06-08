import { useState } from 'react';
import Counter from './components/Counter';
import CustomerList from './components/CustomerList';
import Header from './components/Header';
import NameList from './components/NameList';

function App() {
  const heading = 'React fundamentals';
  const subheading = 'React is very powerful and fast';

  const [showCounterApp, setShowCounterApp] = useState(true);
  const [showNameListApp, setShowNameListApp] = useState(true);
  const [showCustomerListApp, setShowCustomerListApp] = useState(true);

  return (
    <>
      <div className='container'>
        <Header title={heading} subtitle={subheading} />

        <button
          onClick={() => setShowCounterApp(!showCounterApp)}
          className='btn btn-outline-primary me-3'
        >
          {showCounterApp ? 'Hide' : 'Show'} Counter app
        </button>
        <button
          onClick={() => setShowNameListApp(!showNameListApp)}
          className='btn btn-outline-primary me-3'
        >
          {showNameListApp ? 'Hide' : 'Show'} NameList app
        </button>
        <button
          onClick={() => setShowCustomerListApp(!showCustomerListApp)}
          className='btn btn-outline-primary me-3'
        >
          {showCustomerListApp ? 'Hide' : 'Show'} CustomerList app
        </button>

        {showCounterApp && <Counter />}
        {showNameListApp && <NameList />}
        {showCustomerListApp && <CustomerList />}
      </div>
    </>
  );
}

export default App;

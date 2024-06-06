import Counter from './components/Counter';
import CustomerList from './components/CustomerList';
import Header from './components/Header';
import NameList from './components/NameList';

function App() {
  const heading = 'React fundamentals';
  const subheading = 'React is very powerful and fast';

  return (
    <>
      <div className='container'>
        <Header title={heading} subtitle={subheading} />
        <Counter />
        <NameList />
        <CustomerList />
      </div>
    </>
  );
}

export default App;

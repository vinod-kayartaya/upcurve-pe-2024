import CategoryList from './components/CategoryList';
import ProductList from './components/ProductList';
import About from './components/About';
import Layout from './components/Layout';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Layout />}>
            <Route path='' element={<CategoryList />} />
            <Route path='categories' element={<CategoryList />} />
            <Route path='categories/:categoryId/products' element={<ProductList />} />
            <Route path='about' element={<About />} />
            <Route path='*' element={<h1>404!!</h1>} />
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

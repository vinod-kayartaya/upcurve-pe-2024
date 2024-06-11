import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';

function ProductList() {
  const [categoryId, setCategoryId] = useState(null);
  const [category, setCategory] = useState(null);
  const [products, setProducts] = useState([]);
  const params = useParams();
  const navigate = useNavigate();

  // the callback for the following useEffect() is called whenever the
  // value of `params` change
  useEffect(() => {
    const catId = parseInt(params.categoryId);
    if (isNaN(catId)) {
      navigate('/');
      return;
    }
    setCategoryId(catId);

    fetch('http://localhost:8080/api/categories/' + catId)
      .then((resp) => resp.json())
      .then((data) => setCategory(data));

    fetch('http://localhost:8081/api/products/for-category/' + catId)
      .then((resp) => resp.json())
      .then((data) => setProducts(data));
  }, [params]);

  if (category === null) {
    return null;
  }

  return (
    <>
      <h3>Products in the category "{category.name}"</h3>

      <table className='table'>
        <thead>
          <tr>
            <th>Name</th>
            <th>Unit price</th>
            <th>Units in stock</th>
            <th>Unit description</th>
            <th>Units on order</th>
            <th>Reorder level</th>
            <th>Discontinued?</th>
          </tr>
        </thead>
        <tbody>
          {products.map((p) => (
            <tr key={p.id} className={p.discontinued && 'table-danger'}>
              <td>{p.name}</td>
              <td className='text-end'>{p.unitPrice}</td>
              <td className='text-end'>{p.unitsInStock}</td>
              <td>{p.quantityPerUnit}</td>
              <td className='text-end'>{p.unitsOnOrder}</td>
              <td className='text-end'>{p.reorderLevel}</td>
              <td>{p.discontinued ? 'Yes' : 'No'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}

export default ProductList;

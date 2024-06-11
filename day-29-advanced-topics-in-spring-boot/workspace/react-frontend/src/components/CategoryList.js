import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

function CategoryList() {
  const [categories, setCategories] = useState([]);

  // this is a react hook, which gets executed automatically
  // when the component is rendered for the first time
  useEffect(() => {
    fetch('http://localhost:8080/api/categories')
      .then((resp) => resp.json())
      .then((data) => setCategories(data));
  }, []);

  const categoriesJsx = categories.map((c) => (
    <tr key={c.id}>
      <td>
        <Link to={'/categories/' + c.id + '/products'}>{c.name}</Link>
      </td>
      <td>{c.description}</td>
    </tr>
  ));

  return (
    <>
      <h3>Category List</h3>

      <table className='table table-hover'>
        <thead>
          <tr>
            <th>Category name</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>{categoriesJsx}</tbody>
      </table>
    </>
  );
}

export default CategoryList;

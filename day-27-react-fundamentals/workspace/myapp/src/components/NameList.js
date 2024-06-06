import React from 'react';

function NameList() {
  const names = ['Vinod', 'John', 'Shyam', 'John', 'Jane'];

  const namesJsx = names.map((name, index) => <li key={index}>{name}</li>);

  return (
    <>
      <h3>Name list component</h3>
      <ul>{namesJsx}</ul>
    </>
  );
}

export default NameList;

import React, { useState } from 'react';

const initialCount = parseInt(localStorage.getItem('count') || '0');

function Counter() {
  console.log('Counter component is rendered to the UI at', Date.now());

  // let count = 0; // local variable of the Counter component

  const [count, setCount] = useState(initialCount);
  // useState() is called when the component is rendered for the first time with an
  // intial value (i.e, 0). React will collect that initial value and keeps it in
  // a memory location outside of this component, which it refers to as `state`.
  // The return value from the useState() is an array of two elements:
  // 1. current state (for the first time, same as initial value)
  // 2. a function that can mutate the state (setter for the state)
  // When the setter is called, it asks react to change the value of state, and then
  // react will update the state, and rerender the component.
  // When the component is re-rendered, useState() will not take the initial value, but
  // simply returns the current state from the memory along with the setter for the same.

  const increment = () => {
    console.log('increment() called at', Date.now());
    setCount(count + 1);
    localStorage.setItem('count', count + 1);
  };

  const decrement = () => {
    console.log('decrement() called at', Date.now());
    setCount(count - 1);
    localStorage.setItem('count', count - 1);
  };

  return (
    <>
      <h3>Counter App</h3>
      <p>Example of using state in a component</p>
      <p className='lead'>Value of count is {count}</p>
      <button onClick={decrement} className='btn btn-primary'>
        Decrement
      </button>{' '}
      <button onClick={increment} className='btn btn-primary'>
        Increment
      </button>
    </>
  );
}

export default Counter;

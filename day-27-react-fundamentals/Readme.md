# React Fundamentals

## Event Handling in React

Event handling in React is very similar to handling events on DOM elements. However, there are some syntactical differences:

1. **React events are named using camelCase, rather than lowercase.**
2. **With JSX, you pass a function as the event handler, rather than a string.**

### Example

```jsx
import React from 'react';

function EventHandling() {
  function handleClick() {
    alert('Button clicked!');
  }

  return <button onClick={handleClick}>Click me</button>;
}

export default EventHandling;
```

In this example, `onClick` is a React event handler, and `handleClick` is the function that will be called when the button is clicked.

## Using Conditional Statements in JSX

Conditional statements in JSX can be handled using JavaScript conditional operators or ternary operators.

### Example

```jsx
import React from 'react';

function ConditionalRendering({ isLoggedIn }) {
  return (
    <div>{isLoggedIn ? <h1>Welcome back!</h1> : <h1>Please sign up.</h1>}</div>
  );
}

export default ConditionalRendering;
```

In this example, the ternary operator is used to conditionally render a message based on the `isLoggedIn` prop.

## Rendering Components Conditionally

Sometimes, you need to render a component conditionally. This can be done using simple if-else statements within your component.

### Example

```jsx
import React from 'react';

function Greeting({ isLoggedIn }) {
  if (isLoggedIn) {
    return <h1>Welcome back!</h1>;
  }
  return <h1>Please sign up.</h1>;
}

export default Greeting;
```

In this example, the `Greeting` component renders different elements based on the `isLoggedIn` prop.

## Conditional Rendering with Ternary Operators and Logical && Operator

You can use ternary operators and logical `&&` operators for conditional rendering in a more concise manner.

### Example with Ternary Operator

```jsx
import React from 'react';

function TernaryRendering({ isLoggedIn }) {
  return (
    <div>{isLoggedIn ? <h1>Welcome back!</h1> : <h1>Please sign up.</h1>}</div>
  );
}

export default TernaryRendering;
```

### Example with Logical && Operator

```jsx
import React from 'react';

function LogicalRendering({ showWarning }) {
  return <div>{showWarning && <div className='warning'>Warning!</div>}</div>;
}

export default LogicalRendering;
```

In these examples, the ternary operator provides a concise way to render one of two possible elements, while the logical `&&` operator allows for rendering an element only if a certain condition is true.

## Rendering Lists in React

Rendering lists in React is straightforward using the `map()` function to iterate over an array of items.

### Example

```jsx
import React from 'react';

function NumberList({ numbers }) {
  return (
    <ul>
      {numbers.map((number) => (
        <li key={number.toString()}>{number}</li>
      ))}
    </ul>
  );
}

export default NumberList;
```

In this example, the `numbers` prop is an array of numbers, and each number is rendered as a list item.

## Using the `map()` Function to Iterate Over Lists

The `map()` function is used to iterate over an array and return a new array of elements.

### Example

```jsx
import React from 'react';

function NameList({ names }) {
  return (
    <ul>
      {names.map((name, index) => (
        <li key={index}>{name}</li>
      ))}
    </ul>
  );
}

export default NameList;
```

In this example, the `names` prop is an array of strings, and each name is rendered as a list item.

## Understanding the Importance of Keys in React Lists

Keys help React identify which items have changed, are added, or are removed. They should be given to the elements inside the array to give the elements a stable identity.

### Example

```jsx
import React from 'react';

function FruitList({ fruits }) {
  return (
    <ul>
      {fruits.map((fruit) => (
        <li key={fruit.id}>{fruit.name}</li>
      ))}
    </ul>
  );
}

export default FruitList;
```

In this example, each fruit object has a unique `id` property, which is used as the key.

## Handling Forms in React

Forms in React can be controlled or uncontrolled components. Controlled components have their state managed by React, whereas uncontrolled components maintain their own state.

### Example of a Controlled Component

```jsx
import React, { useState } from 'react';

function ControlledForm() {
  const [value, setValue] = useState('');

  const handleChange = (e) => {
    setValue(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    alert('A name was submitted: ' + value);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input type='text' value={value} onChange={handleChange} />
      </label>
      <button type='submit'>Submit</button>
    </form>
  );
}

export default ControlledForm;
```

In this example, the form state is controlled by React using the `useState` hook.

## Controlled Components vs. Uncontrolled Components

### Controlled Components

Controlled components are those where form data is handled by a React component. The mutable state is kept in the state property and updated only with setState().

### Example

```jsx
import React, { useState } from 'react';

function ControlledInput() {
  const [inputValue, setInputValue] = useState('');

  const handleChange = (e) => {
    setInputValue(e.target.value);
  };

  return <input type='text' value={inputValue} onChange={handleChange} />;
}

export default ControlledInput;
```

### Uncontrolled Components

Uncontrolled components are those where form data is handled by the DOM itself. Instead of writing an event handler for every state update, you can use a ref to get form values from the DOM.

### Example

```jsx
import React, { useRef } from 'react';

function UncontrolledInput() {
  const inputRef = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();
    alert('A name was submitted: ' + inputRef.current.value);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type='text' ref={inputRef} />
      <button type='submit'>Submit</button>
    </form>
  );
}

export default UncontrolledInput;
```

In this example, the input value is accessed directly via the ref instead of being controlled by React state.

By understanding and applying these fundamental concepts, you can effectively build and manage React applications with functional components.

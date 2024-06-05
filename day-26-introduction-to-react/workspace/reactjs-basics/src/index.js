import ReactDOM from 'react-dom/client';
import App from './App';
import './styles.css';

// HTML element in the DOM with an id of 'root'
const rootElement = document.getElementById('root');

// react version of the same HTML element
const root = ReactDOM.createRoot(rootElement);

// we are asking React to render a HTML element inside the root element
// following syntax is called JSX (JavaScript and XML)
// the XML consists of HTML tags combined with React components in XML format
root.render(<App />);

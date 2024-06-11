import { Link } from 'react-router-dom';

function Header() {
  return (
    <>
      <div className='alert alert-primary'>
        <div className='container'>
          <h1>Product Dashboard</h1>
        </div>
      </div>
      <div className='container'>
        <Link to='/' className='btn btn-link'>
          Home
        </Link>{' '}
        |
        <Link to='/about' className='btn btn-link'>
          About
        </Link>
      </div>
    </>
  );
}

export default Header;

import Header from './Header';
import Footer from './Footer';
import { Outlet } from 'react-router-dom';

function Layout() {
  return (
    <>
      <Header />
      <div className='container' style={{ minHeight: '650px' }}>
        <Outlet />
      </div>
      <Footer />
    </>
  );
}

export default Layout;

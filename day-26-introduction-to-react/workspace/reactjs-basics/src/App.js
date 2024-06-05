import CustomerCard from './components/CustomerCard';
import Footer, { AUTHOR_NAME } from './components/Footer';
import Heading from './components/Header';

function App() {
  const customers = [
    {
      firstname: 'Vinod',
      lastname: 'Kumar',
      gender: 'Male',
      dob: '1974-01-20',
      email: 'vinod@vinod.co',
      phone: '9731424784',
      picture: 'https://avatars.githubusercontent.com/u/109946821?v=4',
    },
    {
      firstname: 'Jane',
      lastname: 'Doe',
      gender: 'Female',
      dob: '1985-02-12',
      email: 'janedoe@xmpl.com',
      phone: '5551424711',
      picture:
        'https://cdni.iconscout.com/illustration/premium/thumb/woman-profile-8187680-6590622.png',
    },
    {
      firstname: 'Janet',
      lastname: 'Miller',
      gender: 'Female',
      dob: '1985-02-12',
      email: 'janetmiller@xmpl.com',
      phone: '5559282711',
      picture:
        'https://media.istockphoto.com/id/1313720249/photo/profile-of-a-female-doctor.webp?b=1&s=170667a&w=0&k=20&c=9EiyAHvS90AZc7VwfoWf18jtgkwiFwVKHnL_UgI_TZ0=',
    },
  ];

  return (
    <>
      <Heading />
      <div className='app-main-content-area container'>
        <p>A simple app created by {AUTHOR_NAME}</p>
        <CustomerCard customer={customers[0]} />
        <CustomerCard customer={customers[1]} />
        <CustomerCard customer={customers[2]} />
      </div>
      <Footer />
    </>
  );
}

export default App;

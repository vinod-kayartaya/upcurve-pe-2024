import React from 'react';

function CustomerList() {
  const customers = [
    {
      id: 1,
      name: 'Samaria Nethercott',
      gender: 'F',
      email: 'snethercott0@cdbaby.com',
      phone: '475-221-6823',
      avatar: 'https://robohash.org/officiismaximequi.png?size=50x50&set=set1',
    },
    {
      id: 2,
      name: 'Hewet Dailey',
      gender: 'M',
      email: 'hdailey1@pagesperso-orange.fr',
      phone: '701-917-9357',
      avatar:
        'https://robohash.org/molestiaeofficiisrepellendus.png?size=50x50&set=set1',
    },
    {
      id: 3,
      name: 'Clair Doward',
      gender: 'M',
      email: 'cdoward2@sciencedirect.com',
      phone: '373-542-3033',
      avatar: 'https://robohash.org/optioaliquidnihil.png?size=50x50&set=set1',
    },
    {
      id: 4,
      name: 'Ede Josipovitz',
      gender: 'M',
      email: 'ejosipovitz3@wiley.com',
      phone: '734-221-1448',
      avatar:
        'https://robohash.org/repellatvoluptatedoloribus.png?size=50x50&set=set1',
    },
    {
      id: 5,
      name: 'Sophia Ochterlonie',
      gender: 'F',
      email: 'sochterlonie4@privacy.gov.au',
      phone: '962-211-0227',
      avatar:
        'https://robohash.org/inrecusandaenesciunt.png?size=50x50&set=set1',
    },
    {
      id: 6,
      name: 'Dottie Moles',
      gender: 'F',
      email: 'dmoles5@senate.gov',
      phone: '257-541-8341',
      avatar: 'https://robohash.org/sitbeataenihil.png?size=50x50&set=set1',
    },
    {
      id: 7,
      name: 'Harold Cantwell',
      gender: 'M',
      email: 'hcantwell6@unblog.fr',
      phone: '753-553-0770',
      avatar:
        'https://robohash.org/veritatisodiotenetur.png?size=50x50&set=set1',
    },
    {
      id: 8,
      name: 'Giordano Merlin',
      gender: 'M',
      email: 'gmerlin7@wikipedia.org',
      phone: '893-166-7083',
      avatar: 'https://robohash.org/dolorumquianumquam.png?size=50x50&set=set1',
    },
    {
      id: 9,
      name: 'Audy Feasby',
      gender: 'M',
      email: 'afeasby8@networkadvertising.org',
      phone: '566-139-7485',
      avatar:
        'https://robohash.org/perferendiseummolestiae.png?size=50x50&set=set1',
    },
    {
      id: 10,
      name: 'Glenden Rootham',
      gender: 'F',
      email: 'grootham9@dmoz.org',
      phone: '366-770-8451',
      avatar:
        'https://robohash.org/laudantiumrerummagni.png?size=50x50&set=set1',
    },
  ];

  const customersJsx = customers.map((c, i) => (
    <tr key={c.id}>
      <td>{i + 1}</td>
      <td>
        <img style={{ maxHeight: '40px' }} src={c.avatar} alt={c.name} />
      </td>
      <td>{c.name}</td>
      <td>{c.phone}</td>
      <td>{c.email}</td>
    </tr>
  ));

  return (
    <>
      <h3>Customer data</h3>

      <table className='table table-hover table-bordered'>
        <thead>
          <tr className='table-primary'>
            <th>Sl no</th>
            <th></th>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>{customersJsx}</tbody>
      </table>
    </>
  );
}

export default CustomerList;

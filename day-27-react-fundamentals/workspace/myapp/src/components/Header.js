function Header({ title, subtitle }) {
  return (
    <div>
      <h1>{title}</h1>
      <hr />
      <p>{subtitle}</p>
      <p className='lead'>
        Visit{' '}
        <a target='_blank' href='https://vinod.co'>
          my website
        </a>{' '}
        for more
      </p>
    </div>
  );
}

export default Header;

function CustomerCard({ customer }) {
  return (
    <>
      <div class='card' style={{ width: '18rem', display: 'inline-block' }}>
        <img
          src={customer.picture}
          class='card-img-top'
          alt={customer.firstname + ' ' + customer.lastname}
        />
        <div class='card-body'>
          <h5 class='card-title'>
            {customer.gender === 'Male' ? 'Mr.' : 'Ms.'}
            {customer.firstname} {customer.lastname}
          </h5>
          <p class='card-text'>
            <i class='bi bi-telephone'></i> {customer.phone}
            <br />
            <i class='bi bi-envelope'></i> {customer.email}
          </p>
          <a href='#' class='btn btn-primary'>
            View full details
          </a>
        </div>
      </div>
    </>
  );
}

export default CustomerCard;

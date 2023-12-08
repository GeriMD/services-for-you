let loadSellersBtn = document.getElementById('loadSellers')

loadSellersBtn.addEventListener('click', onLoadSellers);

function onLoadSellers(event){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    let sellersContainer = document.getElementById('sellers-container')

    sellersContainer.innerHTML = ''

    fetch("http://localhost:8080/sellers/all", requestOptions).then(response => response.json())
        .then(json => json.forEach(seller => {
            let row = document.createElement('tr')

            let emailCol = document.createElement('td')
            let firstNameCol = document.createElement('td')
            let lastNameCol = document.createElement('td')
            let phoneNumberCol = document.createElement('td')
            let ageCol = document.createElement('td')
            let actionCol = document.createElement('td')

            emailCol.textContent = seller.email
            firstNameCol.textContent = seller.firstName
            lastNameCol.textContent = seller.lastName
            ageCol.textContent = seller.age
            phoneNumberCol.textContent = seller.phoneNumber

            row.appendChild(emailCol)
            row.appendChild(firstNameCol)
            row.appendChild(lastNameCol)
            row.appendChild(ageCol)
            row.appendChild(phoneNumberCol)
            row.appendChild(actionCol)

            sellersContainer.appendChild(row);
        }))
        .catch(error => console.log('error', error));
}
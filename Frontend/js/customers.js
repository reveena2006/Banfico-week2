fetch(API_BASE_URL + "/customers")
.then(response => response.json())
.then(customers => {

    let rows = "";

    customers.forEach(customer => {

        rows += `
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.phone}</td>
        </tr>
        `;
    });

    document.getElementById("customerTable").innerHTML = rows;
})
.catch(error => {

    alert("Failed to load customers");

});
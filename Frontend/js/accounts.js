fetch(API_BASE_URL + "/accounts")
.then(response => response.json())
.then(accounts => {

let rows = "";

accounts.forEach(account => {

rows += `
<tr>

<td>${account.id}</td>

<td>${account.accountNumber}</td>

<td>${account.accountType}</td>

<td>${account.balance}</td>

<td>${account.customer.id}</td>

<td>
<a href="account-details.html?id=${account.id}">
View
</a>
</td>

</tr>
`;

});

document.getElementById("accountTable").innerHTML = rows;

})
.catch(error => {

alert("Failed to load accounts");

});
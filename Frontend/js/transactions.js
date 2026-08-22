function loadTransactions(){

const accountId =
document.getElementById("accountId").value;

fetch(
API_BASE_URL +
"/accounts/" +
accountId +
"/transactions"
)

.then(response => response.json())

.then(data => {

let rows = "";

data.forEach(tx => {

rows += `
<tr>
<td>${tx.id}</td>
<td>${tx.type}</td>
<td>${tx.amount}</td>
<td>${tx.transactionDate}</td>
</tr>
`;

});

document.getElementById("transactionTable")
.innerHTML = rows;

})
.catch(error => {

alert("Unable to load transactions");

});

}
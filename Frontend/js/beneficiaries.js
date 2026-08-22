fetch(API_BASE_URL + "/beneficiaries")
.then(response => response.json())
.then(data => {

let rows = "";

data.forEach(b => {

rows += `
<tr>
<td>${b.id}</td>
<td>${b.name}</td>
<td>${b.accountNumber}</td>
<td>${b.bankName}</td>
<td>${b.ifscCode}</td>
</tr>
`;

});

document.getElementById("beneficiaryTable")
.innerHTML = rows;

})
.catch(error => {

alert("Unable to load beneficiaries");

});
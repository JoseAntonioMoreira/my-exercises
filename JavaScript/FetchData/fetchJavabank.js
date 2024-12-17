window.onload = function () {
    const table = document.querySelector(".table tbody");
    const firstNameInput = document.querySelector(".phName");
    const lastNameInput = document.querySelector(".phLastName");
    const emailInput = document.querySelector(".phEmail");
    const phoneInput = document.querySelector(".phPhone");

    async function getCustomerList(url) {
        const response = await fetch(url);
        const data = await response.json();

        if (!response.ok) {
            throw new Error(data.message);
        }

        populateData(data);
    }

    function populateData(data) {
        data.forEach(element => {
            const row = document.createElement("tr");
            row.appendChild(populateRow(element.id));
            row.appendChild(populateRow(element.firstName));
            row.appendChild(populateRow(element.lastName));
            row.appendChild(populateRow(element.email));
            row.appendChild(populateRow(element.phone));


            const editCell = document.createElement("td");
            const editButton = document.createElement("button");
            editButton.type = "button";
            editButton.classList.add("btn", "btn-success", "editButton");
            editButton.textContent = "Edit";
            editButton.addEventListener("click", () => {
                getCustomer("http://localhost:8080/javabank5/api/customer/" + element.id);
            });
            editCell.appendChild(editButton);
            row.appendChild(editCell);

            const deleteCell = document.createElement("td");
            const deleteButton = document.createElement("button");
            deleteButton.type = "button";
            deleteButton.classList.add("btn", "btn-danger", "deleteButton");
            deleteButton.textContent = "Delete";

            deleteCell.appendChild(deleteButton);
            row.appendChild(deleteCell);

            table.appendChild(row);
        });
    }

    function populateRow(data) {
        const newRow = document.createElement("td");
        newRow.textContent = data;
        return newRow;
    }

    async function getCustomer(url) {
        const response = await fetch(url);
        const data = await response.json();

        if (!response.ok) {
            throw new Error(data.message);
        }
        populateInputFields(data);
    }

    function populateInputFields(data){
        firstNameInput.value = data.firstName;
        lastNameInput.value = data.lastName;
        emailInput.value = data.email;
        phoneInput.value = data.phone; 
    }

    getCustomerList("http://localhost:8080/javabank5/api/customer");
}
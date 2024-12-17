let pageIndex = 50;
let currentIndex = 0;
const testOffset = 37;

function render(films) {
    const container = document.querySelector('#container');
    container.innerHTML = ''; // Clears previous content

   
    const table = document.createElement('table');
    table.className = 'table table-striped';  
    table.style.width = '100%'; 

    const thead = document.createElement('thead');
    const headerRow = document.createElement('tr');
    headerRow.innerHTML = `
        <th>App ID</th>
        <th>App Name</th>
    `;
    thead.appendChild(headerRow);
    table.appendChild(thead);

    const tbody = document.createElement('tbody');

    for (let i = currentIndex + testOffset; i < pageIndex + testOffset; i++) {
        const app = films.applist.apps[i];

        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${app.appid}</td>
            <td>${app.name}</td>
        `;
        tbody.appendChild(row);
    }

    table.appendChild(tbody);

    container.appendChild(table);
}

export default { render };

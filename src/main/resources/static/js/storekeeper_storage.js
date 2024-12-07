async function getDataFromServer(url) {
    let products;
    await fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Ошибка сервера: ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            try {
                products = JSON.parse(JSON.stringify(data));
                // console.log(products);
            } catch (error) {
                console.error('Ошибка при парсинге JSON:', error);
            }
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
    console.log(products);
    return products;
}

let products = [];
let currentPage = 1;
const productsPerPage = 30;
const totalPages = Math.ceil(products.length / productsPerPage);

async function renderProducts(page) {
    products = await getDataFromServer('http://localhost:8080/api/product/all')

    const startIndex = (page - 1) * productsPerPage;
    const endIndex = startIndex + productsPerPage;
    const productsToShow = products.slice(startIndex, endIndex);


    let productListHtml = `<table><tr><th>Наименование</th><th>Цена за тонну</th><th>Масса</th><th>Действие</th></tr>`;

    productsToShow.forEach((product, index) => {
        productListHtml += `
      <tr>
        <td>${product.name}</td>
        <td>${product.pricePerTon} руб.</td>
        <td>
          <button onclick="changeMass(${startIndex + index}, -1)">-</button>
          <span id="mass-${startIndex + index}">1</span> тонна
          <button onclick="changeMass(${startIndex + index}, 1)">+</button>
        </td>
        <td><button onclick="deleteForIndex(${startIndex + index})">Удалить товар</button></td>
      </tr>
    `;
    });

    productListHtml += `</table>`;
    document.getElementById('productList').innerHTML = productListHtml;
}

function changeMass(index, delta) {
    const massElement = document.getElementById(`mass-${index}`);
    let massValue = parseInt(massElement.textContent);
    massValue = Math.max(1, massValue + delta);
    massElement.textContent = massValue;
}

function deleteForIndex(index) {
    console.log(index.name)
    // TODO delete отправить на сервак
    alert(`Товар удален!`);
}
function changePage(action) {
    if (action === 'start') {
        currentPage = 1;
    } else if (action === 'prev' && currentPage > 1) {
        currentPage--;
    } else if (action === 'next' && currentPage < totalPages) {
        currentPage++;
    } else if (action === 'end') {
        currentPage = totalPages;
    }
    renderProducts(currentPage);
}
renderProducts(currentPage);
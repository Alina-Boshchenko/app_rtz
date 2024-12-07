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
            } catch (error) {
                console.error('Ошибка при парсинге JSON:', error);
            }
        })
        .catch(error => {
            console.error('Произошла проблема с операцией fetch:', error);
        });
    return products;
}

let products = [];
let currentPage = 1;
const productsPerPage = 10;
let totalPages = 1;

(async function loadProducts() {
    products = await getDataFromServer('http://localhost:8080/api/product/all');
    if (products && products.length > 0) {
        totalPages = Math.ceil(products.length / productsPerPage);
    } else {
        totalPages = 1;
    }
    renderProducts(currentPage);
})();

function renderProducts(page) {
    const startIndex = (page - 1) * productsPerPage;
    const endIndex = startIndex + productsPerPage;
    const productsToShow = products.slice(startIndex, endIndex);

    let productListHtml = `
    <table class="table table-striped">
      <thead class="thead-dark">
        <tr>
          <th>Прокат</th>
          <th>Тип товара</th>
          <th>Наименование</th>
          <th>Стандарт</th>
          <th>Марка стали</th>
          <th>Цена за метр/кг</th>
          <th>Цена за тонну</th>
        </tr>
      </thead>
      <tbody>
  `;

    productsToShow.forEach(product => {
        productListHtml += `
      <tr>
        <td>${product.rolledName}</td>
        <td>${product.typeName}</td>
        <td>${product.name}</td>
        <td>${product.standardName}</td>
        <td>${product.steelGradeName}</td>
        <td>${product.pricePerMeter} руб.</td>
        <td>${product.pricePerTon} руб.</td>
      </tr>
    `;
    });

    productListHtml += `
      </tbody>
    </table>
  `;

    document.getElementById('productList').innerHTML = productListHtml;
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
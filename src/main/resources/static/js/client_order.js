function getSelectedProducts() {
    return [
        {id: 1, name: 'Товар 1', price: 500},
        {id: 2, name: 'Товар 2', price: 1500}
    ];
}

function displaySelectedProducts() {
    const products = getSelectedProducts();
    const container = document.getElementById('selected-products');
    container.innerHTML = '';
    products.forEach(product => {
        const productElement = document.createElement('div');
        productElement.textContent = `${product.name} - ${product.price} руб.`;
        container.appendChild(productElement);
    });
}


document.getElementById('invoice-payment').addEventListener('click', function () {
    console.log('Выбрана оплата по счету');
});

document.getElementById('card-payment').addEventListener('click', function () {
    console.log('Выбрана оплата на месте картой');
});

document.getElementById('place-order').addEventListener('click', function () {
    console.log('Заказ оформлен');
});

displaySelectedProducts();
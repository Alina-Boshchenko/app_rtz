// Допустим, у нас есть функция для получения списка выбранных товаров
function getSelectedProducts() {
  // Здесь должен быть код для получения выбранных товаров, например, из localStorage или API
  return [
    { id: 1, name: 'Товар 1', price: 500 },
    { id: 2, name: 'Товар 2', price: 1500 }
    // ...
  ];
}

// Функция для отображения списка выбранных товаров
function displaySelectedProducts() {
  const products = getSelectedProducts();
  const container = document.getElementById('selected-products');
  container.innerHTML = ''; // Очищаем контейнер
  products.forEach(product => {
    const productElement = document.createElement('div');
    productElement.textContent = `${product.name} - ${product.price} руб.`;
    container.appendChild(productElement);
  });
}

// Обработчики событий для кнопок
document.getElementById('invoice-payment').addEventListener('click', function() {
  console.log('Выбрана оплата по счету');
  // Здесь код для обработки оплаты по счету
});

document.getElementById('card-payment').addEventListener('click', function() {
  console.log('Выбрана оплата на месте картой');
  // Здесь код для обработки оплаты на месте картой
});

document.getElementById('place-order').addEventListener('click', function() {
  console.log('Заказ оформлен');
  // Здесь код для оформления заказа
});

// Отображаем выбранные товары при загрузке страницы
displaySelectedProducts();
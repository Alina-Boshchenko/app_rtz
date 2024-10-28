document.addEventListener('DOMContentLoaded', function() {
    fetchProductData();

    document.getElementById('button-minus').addEventListener('click', decrementQuantity);
    document.getElementById('button-plus').addEventListener('click', incrementQuantity);

    document.getElementById('addToCartButton').addEventListener('click', addToCart);
});

function getProductIdFromUrl() {
    const params = new URLSearchParams(window.location.search);
    return params.get('id');
}

async function fetchProductData() {
    //
    // для проверки пока комечу, хз как передавать сюда айдишку

    // const productId = getProductIdFromUrl();
    // if (!productId) {
    //     console.error('ID товара не найден в URL');
    //     return;
    // }
// если автоматически делать, то в феч передавать нужно будет такой юрик /api/product/${productId}


    try {
        const response = await fetch(`/api/product/1`);
        if (!response.ok) {
            console.error('Ошибка сети');
            return;
        }
        const productData = await response.json();

        if (productData.name) {
            document.getElementById('name').textContent = productData.name;
        }
        if (productData.pricePerTon) {
            document.getElementById('pricePerTon').textContent = productData.pricePerTon;
        }
        if (productData.pricePerMeter) {
            document.getElementById('pricePerMeter').textContent = productData.pricePerMeter;
        }
        if (productData.standardName) {
            document.getElementById('standardName').textContent = productData.standardName;
        }
        if (productData.steelGradeName) {
            document.getElementById('steelGradeName').textContent = productData.steelGradeName;
        }
        if (productData.size) {
            document.getElementById('size').textContent = productData.size;
        }
        if (productData.length) {
            document.getElementById('length').textContent = productData.length;
        }
        if (productData.thickness) {
            document.getElementById('thickness').textContent = productData.thickness;
        }
        if (productData.weight) {
            document.getElementById('weight').textContent = productData.weight;
        }


        updateTotalPrice();

    } catch (error) {
        console.error('Ошибка получения данных:', error);
    }
}

function decrementQuantity() {
    var quantityInput = document.getElementById('quantity');
    var currentQuantity = parseInt(quantityInput.value);
    if (currentQuantity > 1) {
        quantityInput.value = currentQuantity - 1;
        updateTotalPrice();
    }
}

function incrementQuantity() {
    var quantityInput = document.getElementById('quantity');
    var currentQuantity = parseInt(quantityInput.value);
    quantityInput.value = currentQuantity + 1;
    updateTotalPrice();
}

function updateTotalPrice() {
    var quantity = parseInt(document.getElementById('quantity').value);
    var pricePerTonText = document.getElementById('pricePerTon').textContent;
    var pricePerMeterText = document.getElementById('pricePerMeter').textContent;

    var pricePerTon = parseFloat(pricePerTonText.replace(',', '.'));
    var pricePerMeter = parseFloat(pricePerMeterText.replace(',', '.'));

    var totalPrice = 0;

    if (!isNaN(pricePerTon)) {
        totalPrice = pricePerTon * quantity;
    } else if (!isNaN(pricePerMeter)) {
        totalPrice = pricePerMeter * quantity;
    } else {
        totalPrice = 0;
    }

    document.getElementById('totalPrice').textContent = totalPrice.toFixed(2);
}

function addToCart() {
    // Реализация добавления товара в корзину
    console.log('Товар добавлен в корзину');
    // Здесь можно отправить данные на сервер или обновить локальное хранилище
}
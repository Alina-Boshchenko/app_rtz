// Получаем id товара из параметров URL

// потом разкомитить

// const urlParams = new URLSearchParams(window.location.search);
// const productId = urlParams.get('id');


const productId = 1;

async function fetchProductData() {
    try {
        const response = await fetch(`/api/product/${productId}`);
        if (!response.ok) {
            throw new Error('Ошибка сети');
        }
        const productData = await response.json();

        const fields = ['rolledName', 'typeName', 'name', 'standardName', 'steelGradeName', 'size', 'length', 'thickness', 'weight', 'pricePerMeter', 'pricePerTon'];

        fields.forEach(field => {
            const element = document.getElementById(field);
            if (element && productData[field]) {
                element.textContent = productData[field];
            }
        });
    } catch (error) {
        console.error('Ошибка при получении данных товара:', error);
    }
}

fetchProductData();

document.getElementById('editButton').addEventListener('click', handleEditButtonClick);

function handleEditButtonClick() {

    const editButton = document.getElementById('editButton');
    editButton.textContent = 'Сохранить';
    editButton.removeEventListener('click', handleEditButtonClick);
    editButton.addEventListener('click', handleSaveButtonClick);

    const fields = ['rolledName', 'typeName', 'name', 'standardName', 'steelGradeName', 'size', 'length', 'thickness', 'weight', 'pricePerMeter', 'pricePerTon'];

    fields.forEach(field => {
        const element = document.getElementById(field);
        const value = element.textContent;
        const input = document.createElement('input');
        input.type = 'text';
        input.className = 'form-control';
        input.id = field;
        input.value = value ? value : '';

        element.parentNode.replaceChild(input, element);
    });
}

function handleSaveButtonClick() {

    const fields = ['rolledName', 'typeName', 'name', 'standardName', 'steelGradeName', 'size', 'length', 'thickness', 'weight', 'pricePerMeter', 'pricePerTon'];

    const data = {};
    fields.forEach(field => {
        const input = document.getElementById(field);
        data[field] = input.value;
    });

    patchProductData(data);
}

async function patchProductData(data) {
    try {
        const response = await fetch(`/api/product/${productId}`, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        if (!response.ok) {
            throw new Error('Ошибка сети');
        }
        alert('Изменения успешно сохранены. Пожалуйста, перезагрузите страницу.');
        location.reload();

    } catch (error) {
        console.error('Ошибка при сохранении данных товара:', error);
        alert('Ошибка при сохранении данных.');
    }
}
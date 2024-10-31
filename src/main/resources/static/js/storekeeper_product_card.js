// Получаем id товара из параметров URL

// потом разкомитить

// const urlParams = new URLSearchParams(window.location.search);
// const productId = urlParams.get('id');


const productId = 1;

// Функция для запроса данных товара с сервера
async function fetchProductData() {
    try {
        const response = await fetch(`/api/product/${productId}`);
        if (!response.ok) {
            throw new Error('Ошибка сети');
        }
        const productData = await response.json();

        // Заполняем элементы данными
        const fields = ['rolledName', 'typeName', 'name', 'standardName', 'steelGradeName', 'size', 'length', 'thickness', 'weight', 'pricePerMeter', 'pricePerTon'];

        fields.forEach(field => {
            const element = document.getElementById(field);
            if (element && productData[field]) {
                element.textContent = productData[field];
            }
        });
    } catch (error) {
        console.error('Ошибка при получении данных товара:', error);
        // Обработка ошибки, например, вывод сообщения пользователю
    }
}

// Вызываем функцию запроса данных
fetchProductData();

// Обработчик для кнопки "Изменить"
document.getElementById('editButton').addEventListener('click', handleEditButtonClick);

function handleEditButtonClick() {
    // Меняем текст кнопки на "Сохранить"
    const editButton = document.getElementById('editButton');
    editButton.textContent = 'Сохранить';
    editButton.removeEventListener('click', handleEditButtonClick);
    editButton.addEventListener('click', handleSaveButtonClick);

    // Заменяем значения на поля ввода
    const fields = ['rolledName', 'typeName', 'name', 'standardName', 'steelGradeName', 'size', 'length', 'thickness', 'weight', 'pricePerMeter', 'pricePerTon'];

    fields.forEach(field => {
        const element = document.getElementById(field);
        const value = element.textContent;

        // Создаем поле ввода
        const input = document.createElement('input');
        input.type = 'text';
        input.className = 'form-control'; // Добавляем класс Bootstrap для стилизации
        input.id = field;
        input.value = value ? value : '';

        // Заменяем элемент на поле ввода
        element.parentNode.replaceChild(input, element);
    });
}

function handleSaveButtonClick() {
    // Собираем данные из полей ввода
    const fields = ['rolledName', 'typeName', 'name', 'standardName', 'steelGradeName', 'size', 'length', 'thickness', 'weight', 'pricePerMeter', 'pricePerTon'];

    const data = {};
    fields.forEach(field => {
        const input = document.getElementById(field);
        data[field] = input.value;
    });

    // Отправляем PATCH-запрос на сервер
     patchProductData(data);
}

// Функция для отправки PATCH-запроса
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
        // Уведомляем об успешном изменении и предлагаем перезагрузить страницу
        alert('Изменения успешно сохранены. Пожалуйста, перезагрузите страницу.');

        // Можно перезагрузить страницу автоматически
        location.reload();

    } catch (error) {
        console.error('Ошибка при сохранении данных товара:', error);
        alert('Ошибка при сохранении данных.');
    }
}
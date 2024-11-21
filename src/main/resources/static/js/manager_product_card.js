let productData = {};

async function fetchProductData(id) {
    try {
        const response = await fetch(`/api/product/${id}`);
        if (!response.ok) {
            throw new Error('Ошибка сети');
        }
        productData = await response.json();
        productData.id = id; // Убедимся, что id включен
        populateProductData(productData);
    } catch (error) {
        console.error('Ошибка при получении данных о товаре:', error);
    }
}

function populateProductData(data) {
    const fields = ['rolledName', 'typeName', 'name', 'standardName', 'steelGradeName', 'size', 'length', 'thickness', 'weight', 'pricePerMeter', 'pricePerTon'];
    fields.forEach(field => {
        const element = document.getElementById(field);
        if (element && data[field] !== undefined && data[field] !== null) {
            element.textContent = data[field];
        }
    });
}

document.addEventListener('DOMContentLoaded', () => {
    // const urlParams = new URLSearchParams(window.location.search);
    // const id = urlParams.get('id'); // Получаем параметр 'id' из URL
    // // if (id) {
    // //     // fetchProductData(id);
    // // } else {
    // //     console.error('ID товара не указан в параметрах URL.');
    // // }
// вместо части кода выше, пока просто передаю первый айдишник
    fetchProductData(1);

    document.getElementById('editButton').addEventListener('click', () => {
        // Скрываем кнопку "Изменить"
        document.getElementById('editButton').style.display = 'none';
        // Показываем поля ввода и кнопку "Сохранить"
        document.getElementById('editFields').style.display = 'block';
        // Заполняем поля текущими значениями
        const pricePerTonText = document.getElementById('pricePerTon').textContent;
        document.getElementById('pricePerTonInput').value = pricePerTonText;
        const pricePerMeterText = document.getElementById('pricePerMeter').textContent;
        document.getElementById('pricePerMeterInput').value = pricePerMeterText;
    });

    document.getElementById('saveButton').addEventListener('click', async () => {
        // Получаем значения из полей ввода
        const pricePerTonValue = document.getElementById('pricePerTonInput').value;
        const pricePerMeterValue = document.getElementById('pricePerMeterInput').value;

        // Обновляем объект productData
        productData.pricePerTon = pricePerTonValue;
        productData.pricePerMeter = pricePerMeterValue;

        // Отправляем PATCH-запрос на сервер
        // /api/product/${productData.id}
        try {
            const response = await fetch(`/api/product/1`, {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(productData)
            });
            if (response.ok) {
                alert('Изменения успешно сохранены. Пожалуйста, перезагрузите страницу.');


                document.getElementById('editFields').style.display = 'none';

                document.getElementById('editButton').style.display = 'block';

                document.getElementById('pricePerTon').textContent = productData.pricePerTon;
                document.getElementById('pricePerMeter').textContent = productData.pricePerMeter;
            } else {
                throw new Error('Ошибка при сохранении изменений.');
            }
        } catch (error) {
            console.error('Ошибка при отправке данных на сервер:', error);
            alert('Произошла ошибка при сохранении изменений.');
        }
    });
});
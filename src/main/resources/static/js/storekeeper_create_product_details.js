document.getElementById('productForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Получаем значение названия товара
    var name = document.getElementById('name').value.trim();

    // Получаем выбранную радио-кнопку
    var selectedCategory = document.querySelector('input[name="category"]:checked');

    if (!name) {
        alert('Введите название товара');
        return;
    }

    if (!selectedCategory) {
        alert('Выберите категорию');
        return;
    }

    // Определяем URL в зависимости от выбранной категории
    var url;

    switch(selectedCategory.id) {
        case 'rolledName':
            url = 'http://localhost:8080/api/rolled/creat'; // Замените на актуальный адрес для категории "Прокат"
            break;
        case 'typeName':
            url = 'http://localhost:8080/api/typeproduct/creat'; // Замените на актуальный адрес для категории "Тип товара"
            break;
        case 'standardName':
            url = 'http://localhost:8080/api/standard/creat'; // Замените на актуальный адрес для категории "Стандарт"
            break;
        case 'steelGradeName':
            url = 'http://localhost:8080/api/steelgrade/creat'; // Замените на актуальный адрес для категории "Марка Стали"
            break;
        default:
            alert('Неизвестная категория');
            return;
    }

    // Формируем JSON-данные
    var data = {
        name: name
    };

    // Отправляем POST-запрос
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(function(response) {
            if (!response.ok) {
                throw new Error('Ошибка сети');
            }
            // Проверяем, есть ли тело ответа
            return response.text().then(function(text) {
                if (text) {
                    try {
                        return JSON.parse(text);
                    } catch(e) {
                        console.error('Ошибка разбора JSON:', e);
                        return {};
                    }
                } else {
                    return {};
                }
            });
        })
        .then(function(data) {
            // Очищаем поля формы
            document.getElementById('productForm').reset();
            alert('Товар сохранен');
        })
        .catch(function(error) {
            console.error('Ошибка сети:', error);
        });
});

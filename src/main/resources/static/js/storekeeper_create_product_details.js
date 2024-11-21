document.getElementById('productForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var name = document.getElementById('name').value.trim();

    var selectedCategory = document.querySelector('input[name="category"]:checked');

    if (!name) {
        alert('Введите название товара');
        return;
    }

    if (!selectedCategory) {
        alert('Выберите категорию');
        return;
    }

    var url;

    switch(selectedCategory.id) {
        case 'rolledName':
            url = 'http://localhost:8080/api/rolled/create';
            break;
        case 'typeName':
            url = 'http://localhost:8080/api/typeproduct/create';
            break;
        case 'standardName':
            url = 'http://localhost:8080/api/standard/create';
            break;
        case 'steelGradeName':
            url = 'http://localhost:8080/api/steelgrade/create';
            break;
        default:
            alert('Неизвестная категория');
            return;
    }

    var data = {
        name: name
    };

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
            document.getElementById('productForm').reset();
            alert('Товар сохранен');
        })
        .catch(function(error) {
            console.error('Ошибка сети:', error);
        });
});

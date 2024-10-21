
async function getRolledNames() {
    const response = await fetch('http://localhost:8080/api/rolled/all');
    return await response.json();
}

// TODO для примера удалить
// async function fetchData(endpoint) {
//     const response = await fetch(endpoint);
//     if (!response.ok) {
//         throw new Error(`HTTP error! status: ${response.status}`);
//     }
//     return await response.json();
// }

async function getTypeNames() {
    const response = await fetch('http://localhost:8080/api/typeproduct/all');
    return await response.json();
}

async function getStandardNames() {
    const response = await fetch('http://localhost:8080/api/standard/all');
    return await response.json();
}

async function getSteelGradeNames() {
    const response = await fetch('http://localhost:8080/api/steelgrade/all');
    return await response.json();
}

// тут обработаем ответы, что пришли и заполним списки
function populateSelect(id, data) {
    const select = document.getElementById(id);
    data.forEach(obj => {
        console.log(obj)
        const option = document.createElement('option');
        option.value = option.textContent = obj.name;
        select.appendChild(option);
    });
    // Добавляем кнопку "создать новый"
    const createNewOption = document.createElement('option');
    createNewOption.value = createNewOption.textContent = 'Создать новый';
    select.appendChild(createNewOption);
    select.addEventListener('change', function() {
        if (this.value === 'Создать новый') {
            // window.location.href = 'storekeeper_create_product_details.html';  // открывает в том же окне хз как сделать
            window.open('storekeeper_create_product_details.html', '_blank', 'width=800,height=600');
        }
    });
}

// заполнение формы
function initializeForm() {
    getRolledNames()
        .then(data => populateSelect('rolledName', data))
        .catch(() => populateSelect('rolledName', ['Прокат']));
    getTypeNames()
        .then(data => populateSelect('typeName', data))
        .catch(() => populateSelect('typeName', ['Тип товара']));
    getStandardNames()
        .then(data => populateSelect('standardName', data))
        .catch(() => populateSelect('standardName', ['Стандарт']));
    getSteelGradeNames()
        .then(data => populateSelect('steelGradeName', data))
        .catch(() => populateSelect('steelGradeName', ['Марка стали']));
}

// тут на сервер отправляем
function saveProduct() {


    // логика проверки, что данные введены, только обязательные поля проверяю






    const product = {
        rolledName: document.getElementById('rolledName').value,
        typeName: document.getElementById('typeName').value,
        standardName: document.getElementById('standardName').value,
        steelGradeName: document.getElementById('steelGradeName').value,
        name: document.getElementById('name').value,
        size: document.getElementById('size').value,
        length: parseFloat(document.getElementById('length').value),
        thickness: parseFloat(document.getElementById('thickness').value),
        weight: parseFloat(document.getElementById('weight').value),
        pricePerMeter: parseFloat(document.getElementById('pricePerMeter').value),
        pricePerTon: parseFloat(document.getElementById('pricePerTon').value)
    };

    fetch('http://localhost:8080/api/product/creat', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    }).then(response => {
        if (response.ok) {
            //если ответ норм от сервака, очищ. форму+вывод инфо, что товар сохранен
            document.getElementById('productForm').reset();
            alert('Товар сохранен');
        } else {
            console.error('Ошибка сервера:', response.statusText);
        }
    }).catch(error => {
        console.error('Ошибка сети:', error);
    });
}

// Обработчик клика кнопки "сохранить"
document.getElementById('saveProduct').addEventListener('click', saveProduct);

// Инициализация формы при загрузке страницы
document.addEventListener('DOMContentLoaded', initializeForm);
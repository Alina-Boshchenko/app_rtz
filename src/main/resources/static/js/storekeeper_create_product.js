async function getRolledNames() {
    const response = await fetch('http://localhost:8080/api/rolled/all');
    return await response.json();
}
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
function populateSelect(id, data) {
    const select = document.getElementById(id);
    data.forEach(obj => {
        console.log(obj)
        const option = document.createElement('option');
        option.value = option.textContent = obj.name;
        select.appendChild(option);
    });

    const createNewOption = document.createElement('option');
    createNewOption.value = createNewOption.textContent = 'Создать новый';
    select.appendChild(createNewOption);
    select.addEventListener('change', function() {
        if (this.value === 'Создать новый') {
            window.open('storekeeper_create_product_details.html', '_blank', 'width=800,height=600');
        }
    });
}

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

function saveProduct() {

    var name = document.getElementById('name').value.trim();
    var pricePerMeter = parseFloat(document.getElementById('pricePerMeter').value.trim());
    var pricePerTon = parseFloat(document.getElementById('pricePerTon').value.trim());

    if (!name) {
        alert('Введите название товара');
        return;
    }
    if (!pricePerMeter) {
        alert('Введите цену товара за метр');
        return;
    }
    if (!pricePerTon) {
        alert('Введите цену товара за тонну');
        return;
    }

    var data = {
        rolledName: document.getElementById('rolledName').value.trim(),
        typeName: document.getElementById('typeName').value.trim(),
        standardName: document.getElementById('standardName').value.trim(),
        steelGradeName: document.getElementById('steelGradeName').value.trim(),
        name: name,
        size: document.getElementById('size').value.trim(),
        length: parseFloat(document.getElementById('length').value.trim()),
        thickness: parseFloat(document.getElementById('thickness').value.trim()),
        weight: parseFloat(document.getElementById('weight').value.trim()),
        pricePerMeter: pricePerMeter,
        pricePerTon: pricePerTon
    };

    fetch('http://localhost:8080/api/product/create', {
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

}

document.getElementById('saveProduct').addEventListener('click', saveProduct);

document.addEventListener('DOMContentLoaded', initializeForm);
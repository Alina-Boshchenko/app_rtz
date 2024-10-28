
async function fetchProductData() {
    // для проверки пока комечу, хз как передавать сюда айдишку


    // const params = new URLSearchParams(window.location.search);
    // const id = params.get('id');
    // if (!id) {
    //     console.error('Не найден id товара в URL');
    //     return;
    // }
    ///

    ///// если автоматически делать, то в феч передавать нужно будет такой юрик /api/product/${productId}

    try {
        const response = await fetch(`/api/product/1`);
        if (!response.ok) {
            console.error('Ошибка сети');
            return;
        }
        const data = await response.json();

        const fields = ['rolledName', 'typeName', 'name', 'standardName', 'steelGradeName',
            'size', 'length', 'thickness', 'weight', 'pricePerMeter', 'pricePerTon'];

        fields.forEach(field => {
            const element = document.getElementById(field);
            if (element && data[field]) {
                element.textContent = data[field];
            }
        });

    } catch (error) {
        console.error('Ошибка при получении данных:', error);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    fetchProductData();

    // Элементы управления
    const editButton = document.getElementById('editButton');
    const editFields = document.getElementById('editFields');
    const saveButton = document.getElementById('saveButton');
    const pricePerTonField = document.getElementById('pricePerTon');
    const pricePerTonInput = document.getElementById('pricePerTonInput');
    const pricePerMeterField = document.getElementById('pricePerMeter');
    const pricePerMeterInput = document.getElementById('pricePerMeterInput');

    editButton.addEventListener('click', () => {
        editButton.style.display = 'none';
        editFields.classList.remove('d-none');
        pricePerTonInput.value = pricePerTonField.textContent;
        pricePerMeterInput.value = pricePerMeterField.textContent;
    });

    saveButton.addEventListener('click', async () => {

        // для проверки пока комечу, хз как передавать сюда айдишку

        // const params = new URLSearchParams(window.location.search);
        // const id = params.get('id');
        // if (!id) {
        //     console.error('Не найден id товара в URL');
        //     return;
        // }

        const updatedData = {
            pricePerTon: pricePerTonInput.value,
            pricePerMeter: pricePerMeterInput.value
        };
        try {
            ///// потом поменять на переменную пути "/api/product/${id}"
            const response = await fetch(`/api/product/1`, {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(updatedData)
            });
            if (!response.ok) {
                console.error('Ошибка сети при сохранении данных');
                return;
            }
            alert('Изменения успешно сохранены. Пожалуйста, перезагрузите страницу.');
        } catch (error) {
            console.error('Ошибка при сохранении данных:', error);
        }
    });
});
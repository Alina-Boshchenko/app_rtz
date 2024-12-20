function toggleForm() {
    var individualForm = document.getElementById("individualForm");
    var legalEntityForm = document.getElementById("legalEntityForm");
    var entityType = document.querySelector(
        'input[name="entityType"]:checked'
    ).value;
    if (entityType === "individual") {
        individualForm.classList.remove("hidden");
        legalEntityForm.classList.add("hidden");
    } else {
        individualForm.classList.add("hidden");
        legalEntityForm.classList.remove("hidden");
    }
}

async function fetchData() {
    try {
        const response = await fetch("http://localhost:8080/api/user/{id}");
        if (!response.ok) {
            throw new Error("Network response was not ok " + response.statusText);
        }
        const data = await response.json();
        displayData(data);
    } catch (error) {
        document.getElementById("dataLogin").textContent =
            "Error: " + error.message;
    }
}

function displayData(data) {
    const dataLogin = document.getElementById("dataLogin");
    dataLogin.textContent = JSON.stringify(data, null, 2);
}

window.onload = fetchData;
document
    .getElementById("row mb-3-button")
    .addEventListener("click", function () {
        window.location.href = "https:........";
    });

//TODO
async function fetchData() {
    try {
        const response = await fetch("http://localhost:8080/api/user/{id}");
        if (!response.ok) {
            throw new Error("Network response was not ok " + response.statusText);
        }
        const data = await response.json();
        displayData(data);
    } catch (error) {
        document.getElementById("dataPhone").textContent =
            "Error: " + error.message;
    }
}

function displayData(data) {
    const dataPhone = document.getElementById("dataPhone");
    dataPhone.textContent = JSON.stringify(data, null, 2);
}

window.onload = fetchData;

//TODO Функция для получения данных с сервера почта
async function fetchData() {
    try {
        const response = await fetch("http://localhost:8080/api/user/{id}");
        if (!response.ok) {
            throw new Error("Network response was not ok " + response.statusText);
        }
        const data = await response.json();
        displayData(data);
    } catch (error) {
        document.getElementById("dataEmail").textContent =
            "Error: " + error.message;
    }
}

function displayData(data) {
    const dataEmail = document.getElementById("dataEmail");
    dataEmail.textContent = JSON.stringify(data, null, 2);
}

window.onload = fetchData;

document
    .getElementById("saveButtonPerson")
    .addEventListener("click", function () {

        var formData = {
            lastName: document.getElementById("lastName").value,
            firstName: document.getElementById("firstName").value,
            patronymic: document.getElementById("patronymic").value,
        };

        var xhr = new XMLHttpRequest();
        xhr.open("PATCH", "http://localhost:8080/api/user/{id}", true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

        xhr.send(JSON.stringify(formData));

        xhr.onload = function () {
            if (xhr.status === 200) {
                alert("Данные успешно сохранены!");
            } else {
                alert("Произошла ошибка при сохранении данных: " + xhr.statusText);
            }
        };
    });

document.getElementById("saveButton").addEventListener("click", function () {

    var formData = {
        legalAddress: document.getElementById("legalAddress").value,
        ogrn: document.getElementById("ogrn").value,
        inn: document.getElementById("inn").value,
        kpp: document.getElementById("kpp").value,
        BICBank: document.getElementById("BICBank").value,
        bankNames: document.getElementById("bankNames").value,
        paymentAccount: document.getElementById("paymentAccount").value,
        lastName: document.getElementById("lastName").value,
        firstName: document.getElementById("firstName").value,
        patronymic: document.getElementById("patronymic").value
    };

    var xhr = new XMLHttpRequest();
    xhr.open("PATCH", "http://localhost:8080/api/user/{id}", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    xhr.send(JSON.stringify(formData));

    xhr.onload = function () {
        if (xhr.status === 200) {
            alert("Данные успешно сохранены!");
        } else {
            alert("Произошла ошибка при сохранении данных: " + xhr.statusText);
        }
    };
});

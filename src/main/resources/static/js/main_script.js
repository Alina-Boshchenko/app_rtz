var slides = document.querySelectorAll(".slide");
var currentSlide = 0;
var slideInterval = setInterval(nextSlide, 5000);
var manualChange = false;

function nextSlide() {
    goToSlide(currentSlide + 1);
    resetInterval();
}

function prevSlide() {
    goToSlide(currentSlide - 1);
    resetInterval();
}

function goToSlide(n) {
    slides[currentSlide].style.display = "none";
    currentSlide = (n + slides.length) % slides.length;
    slides[currentSlide].style.display = "block";
    updateContent();
}

function updateContent() {
    var title = document.getElementById("slide-title");
    var description = document.getElementById("slide-description");
    var href = document.getElementById("slide-href");
    title.textContent = contents[currentSlide].title;
    description.textContent = contents[currentSlide].description;
    href.href = contents[currentSlide].href;
}

const contents = [
    {
        title: "Производство и продажа металлопроката",
        description:
            "Более 20 лет успешной работы! Более 4 тыс. позиций метоллоконструкций в наличии! " +
            "Более 15 тыс. довольных клиентов!",
        href: "main_about_company.html",
    },
    {
        title: "16 филиалов в России",
        description:
            "Наши офисы: Москва, Белгород, Воронеж, Екатеринбург, Казань, Краснодар, Н.Новгород, " +
            "Новосибирск, Пенза, Ростов-на-Дону, Разнь, Самара, Тверь, Тула, Уфа, Челябинск",
        href: "main_about_company.html",
    },
    {
        title: "Нестандартные профили по чертежам заказчика",
        description:
            "Замкнутые и незамкнутые профили по вашим чертежам или образцам",
        href: "main_about_company.html",
    },
    {
        title: "19 складских площадок",
        description: "Единовременное хранение свыше 150 тыс. тонн металлопродукции",
        href: "main_about_company.html",
    },
];

function resetInterval() {
    if (!manualChange) {
        manualChange = true;
        clearInterval(slideInterval);
        slideInterval = setInterval(nextSlide, 10000);
        setTimeout(function () {
            manualChange = false;
            clearInterval(slideInterval);
            slideInterval = setInterval(nextSlide, 5000);
        }, 10000);
    }
}

document.addEventListener("DOMContentLoaded", (event) => {
    const modal = document.getElementById("myModal");
    const btn = document.getElementById("openModalBtn");
    const span = document.getElementsByClassName("close")[0];
    const showPasswordCheckbox = document.getElementById("showPassword");
    const passwordInput = document.getElementById("password");
    const usernameInput = document.getElementById("username");

    btn.onclick = function () {
        modal.style.display = "block";
    };

    span.onclick = function () {
        modal.style.display = "none";
    };

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    };

    showPasswordCheckbox.addEventListener("change", function () {
        if (this.checked) {
            passwordInput.type = "text";
        } else {
            passwordInput.type = "password";
        }
    });

    const form = document.querySelector('form');
    form.addEventListener("submit", (event) => {
        event.preventDefault();

        var csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
        var csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');

        const username = usernameInput.value.trim();
        const password = passwordInput.value.trim();

        const data = {
            username: username,
            password: password,
        };

        const encodedData = new URLSearchParams(data).toString();

        fetch('http://localhost:8080/login', {
            method: 'POST',
            body: encodedData,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                // [csrfHeader]: csrfToken     /** тут выходила ошибка, т.к. в заголовке должна быть только строка, а не объект */
            },
            credentials: 'same-origin' /** сохран сессии */
        })
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    alert('Ошибка входа')
                }
            })
            .then(html => {
                document.open();
                document.write(html);
                document.close();
            })
            .catch(error => {
                console.error('Ошибка во время входа:', error);
            });
    });
});


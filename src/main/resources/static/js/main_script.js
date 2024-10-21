//логика для пролистывания фонов
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
      "Более 20 лет успешной работы! Более 4 тыс. позиций метоллоконструкций в наличии! Более 15 тыс. довольных клиентов!",
    href: "#",
  },
  {
    title: "16 филиалов в России",
    description:
      "Наши офисы: Москва, Белгород, Воронеж, Екатеринбург, Казань, Краснодар, Н.Новгород, Новосибирск, Пенза, Ростов-на-Дону, Разнь, Самара, Тверь, Тула, Уфа, Челябинск",
    href: "#",
  },
  {
    title: "Нестандартные профили по чертежам заказчика",
    description:
      "Замкнутые и незамкнутые профили по вашим чертежам или образцам",
    href: "#",
  },
  {
    title: "19 складских площадок",
    description: "Единовременное хранение свыше 150 тыс. тонн металлопродукции",
    href: "#",
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
//логика для модального окна
document.addEventListener("DOMContentLoaded", (event) => {
  const modal = document.getElementById("myModal");
  const btn = document.getElementById("openModalBtn");
  const span = document.getElementsByClassName("close")[0];
  const showPasswordCheckbox = document.getElementById("showPassword");
  const passwordInput = document.getElementById("password");

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
});


/*отправка гет-запроса с кнопки "регистрация"
используется нативный JavaScript для создания GET-запроса с помощью объекта `XMLHttpRequest`.
*/
//
// document.addEventListener('DOMContentLoaded', function() {
//   var registrationButton = document.getElementById('registration');
//
//   registrationButton.addEventListener('click', function() {
//     var xhr = new XMLHttpRequest();
//     xhr.open('GET', 'http://localhost:8080/registration', true);
//
//     xhr.onload = function () {
//       if (xhr.status >= 200 && xhr.status < 300) {
//         // Заменяем содержимое текущего документа на полученный HTML
//         document.open();
//         document.write(xhr.responseText);
//         document.close();
//       } else {
//         console.error('The request failed!');
//       }
//     };
//
//     xhr.onerror = function () {
//       console.error('The request failed!');
//     };
//
//     xhr.send();
//   });
// });


// document.addEventListener('DOMContentLoaded', function() {
//   // Получаем кнопку по её ID
//   var registrationButton = document.getElementById('registration');
//
//   // Добавляем обработчик события клика на кнопку
//   registrationButton.addEventListener('click', function() {
//     // Выполняем GET-запрос на сервер
//     fetch('http://localhost:8080/registration', {
//       method: 'GET'
//     })
//         .then(response => {
//           // Проверяем, что ответ успешен (статус 200 OK)
//           if (response.ok) {
//             // Возвращаем текст ответа (предполагается, что сервер возвращает HTML)
//             return response.text();
//           } else {
//             // Если сервер вернул ошибку, выводим её в консоль
//             throw new Error('Network response was not ok.');
//           }
//         })
//         .then(html => {
//           // Заменяем текущее содержимое body на HTML, полученный от сервера
//           document.body.innerHTML = html;
//         })
//         .catch(error => {
//           // В случае ошибки выводим информацию в консоль
//           console.error('There has been a problem with your fetch operation:', error);
//         });
//   });
// });
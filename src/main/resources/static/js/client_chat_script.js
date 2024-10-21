// для этой страницы прописать скрипт при входе запрос аутентицикации пользователя, если анкета уже заполнялась, поменять поля и выводить в них имеющиеся данные о клиенте.

// script.js
const chatWindow = document.getElementById("messages");
const messageInput = document.getElementById("message-input");
const sendButton = document.getElementById("send-button");

// Подключаемся к WebSocket серверу
const socket = new WebSocket("wss://your-websocket-server.com");

// Обработчик входящих сообщений
socket.onmessage = function (event) {
  const message = event.data;
  displayMessage(message, "received");
};

// Отправка сообщения
sendButton.onclick = function () {
  const message = messageInput.value;
  socket.send(message);
  displayMessage(message, "sent");
  messageInput.value = "";
};

// Функция для отображения сообщений в интерфейсе
function displayMessage(message, type) {
  const messageElement = document.createElement("div");
  messageElement.textContent = message;
  messageElement.className = type;
  chatWindow.appendChild(messageElement);
  chatWindow.scrollTop = chatWindow.scrollHeight; // Прокрутка к последнему сообщению
}

// Сохраняем информацию о пользователе в Local Storage
function saveUserInfo(username) {
  localStorage.setItem("username", username);
}

// Получаем информацию о пользователе из Local Storage
function getUserInfo() {
  return localStorage.getItem("username");
}


const chatWindow = document.getElementById("messages");
const messageInput = document.getElementById("message-input");
const sendButton = document.getElementById("send-button");

const socket = new WebSocket("..");

socket.onmessage = function (event) {
    const message = event.data;
    displayMessage(message, "received");
};

sendButton.onclick = function () {
    const message = messageInput.value;
    socket.send(message);
    displayMessage(message, "sent");
    messageInput.value = "";
};

function displayMessage(message, type) {
    const messageElement = document.createElement("div");
    messageElement.textContent = message;
    messageElement.className = type;
    chatWindow.appendChild(messageElement);
    chatWindow.scrollTop = chatWindow.scrollHeight;
}

function saveUserInfo(username) {
    localStorage.setItem("username", username);
}

function getUserInfo() {
    return localStorage.getItem("username");
}

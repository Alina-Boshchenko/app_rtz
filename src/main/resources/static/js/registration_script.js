document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("signup-form");
    const emailInput = document.getElementById('email');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    const phoneInput = document.getElementById('phone');
    const togglePasswordButton = document.getElementById("toggle-password");

    togglePasswordButton.addEventListener("click", () => {
        const type = passwordInput.type === "password" ? "text" : "password";
        passwordInput.type = type;
        togglePasswordButton.textContent = type === "password" ? "Показать" : "Скрыть";
    });

    form.addEventListener("submit", (event) => {
        event.preventDefault();

        const email = emailInput.value.trim();
        const username = usernameInput.value.trim();
        const password = passwordInput.value.trim();
        const phone = phoneInput.value.trim();

        let isValid = true;

        const requiredFields = [
            {input: emailInput, message: 'Введите адрес почты'},
            {input: usernameInput, message: 'Введите логин'},
            {input: passwordInput, message: 'Введите пароль'},
            {input: phoneInput, message: 'Введите телефон'},
        ];

        requiredFields.forEach(field => {
            if (!field.input.value.trim()) {
                field.input.classList.add("invalid");
                alert(field.message);
                isValid = false;
            } else {
                field.input.classList.remove("invalid");
            }
        });

        if (!isValid) {
            return;
        }

        const data = {
            email: email,
            username: username,
            password: password,
            phone: phone
        };

        fetch('http://localhost:8080/api/user/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Ошибка сети');
                }
                return response.json();
            })
            .then(data => {
                form.reset();
                alert('Вы успешно зарегистрировались');
            })
            .catch(error => {
                console.error('Ошибка сети:', error);
            });
    });
});




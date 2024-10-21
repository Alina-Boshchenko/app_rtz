document.addEventListener("DOMContentLoaded", () => {
  const togglePasswordButton = document.getElementById("toggle-password");
  const passwordInput = document.getElementById("password");

  togglePasswordButton.addEventListener("click", () => {
    const type =
      passwordInput.getAttribute("type") === "password" ? "text" : "password";
    passwordInput.setAttribute("type", type);
    togglePasswordButton.textContent =
      type === "password" ? "Показать" : "Скрыть";
  });

  const form = document.getElementById("signup-form");
  form.addEventListener("submit", (event) => {
    const inputs = form.querySelectorAll("input");
    let isValid = true;
    inputs.forEach((input) => {
      if (!input.value) {
        input.classList.add("invalid");
        isValid = false;
      } else {
        input.classList.remove("invalid");
      }
    });
    if (!isValid) {
      event.preventDefault();
    }
  });
});

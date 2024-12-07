
document.getElementById('logout-button').addEventListener('click', function(event) {
    event.preventDefault();

    fetch('http://localhost:8080/logout', {
        method: 'POST',
        credentials: 'include'
    })
        .then(response => {
            if (response.status === 200) {
                return response.text();
            } else {
                throw new Error('Ошибка при выходе из системы');
            }
        })
        .then(html => {
            document.open();
            document.write(html);
            document.close();
        })
        .catch(error => {
            console.error('Произошла ошибка:', error);
        });
});



document.getElementById('loginForm').addEventListener('submit', function (event) {

    event.preventDefault();


    var email = document.getElementById('emailInput').value;
    var password = document.getElementById('passwordInput').value;

    const credenciales = {
        correo: email,
        contrasenia: password
    }


    fetch('http://192.168.100.21:8081/api/user/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credenciales)
    })
        .then(response => {

            if (response.ok) {
                window.location.href = 'index.html';

            } else {
                throw new Error('Error al iniciar sesión');
            }
        })
        .then(data => {
            alert(data.content)
            console.log(data);
        })
        .catch(error => {

            console.error(error);
        });
});
fetch('http://192.168.100.21:8081/api/product/readTallas', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
})
    .then(response => response.json())
    .then(data => {
        const content = JSON.parse(data.content);
        const tallas = content.map(item => ({
            talla_us: item.talla_us,
            talla_mx: item.talla_mx
        }));
        const colores = ['Marrón', 'Negro', 'Blanco', 'Beige', 'Gris', 'Azul', 'Rojo', 'Verde', 'Amarillo', 'Naranja'];

        function agregarOpciones(select, opciones) {
            opciones.forEach(opcion => {
                const option = document.createElement('option');
                option.value = opcion.id_talla;
                option.textContent = opcion.talla_mx;
                select.appendChild(option);
            });
        }

        function agregarColores(select, opciones) {
            opciones.forEach(opcion => {
                const option = document.createElement('option');
                option.value = opcion;
                option.textContent = opcion;
                select.appendChild(option);
            });
        }

        const tallaSelect = document.querySelector('select[name="talla"]');
        const colorSelect = document.querySelector('select[name="color"]');
        agregarOpciones(tallaSelect, tallas);
        agregarColores(colorSelect, colores);
    })
    .catch(error => {
        alert(error);
        console.error('Error al enviar los datos:', error);
    });

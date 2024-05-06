//peticiones para consultar las  tallas
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
            id_talla: item.id_talla,
            talla_us: item.talla_us,
            talla_mx: item.talla_mx
        }));

        function agregarOpcionesTalla(select, opciones) {
            opciones.forEach(opcion => {
                const option = document.createElement('option');
                option.value = JSON.stringify(opcion);
                option.textContent = opcion.talla_mx;
                select.appendChild(option);
            });
        }
        const tallaSelect = document.querySelector('select[name="talla"]');
        agregarOpcionesTalla(tallaSelect, tallas);

    })
    .catch(error => {
        alert(error);
        console.error('Error al enviar los datos:', error);
    });



//peticiones para consultar las  categoria
fetch('http://192.168.100.21:8081/api/product/readCategorias', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
})
    .then(response => response.json())
    .then(data => {
        const content = JSON.parse(data.content);
        const categorias = content.map(item => ({
            id_categoria: item.id_categoria,
            nombre: item.nombre,
            id_categorias_hijas: item.id_categorias_hijas,
            id_categoria_padre: item.id_categoria_padre,
            id_productos: item.id_productos
        }));

        function agregarOpcionesCategoria(select, opciones) {
            opciones.forEach(opcion => {
                const option = document.createElement('option');
                option.value = JSON.stringify(opcion);
                option.textContent = opcion.nombre;
                select.appendChild(option);
            });
        }

        const categoriaSelect = document.querySelector('select[name="categoria"]');
        agregarOpcionesCategoria(categoriaSelect, categorias);

    })
    .catch(error => {
        alert(error);
        console.error('Error al enviar los datos:', error);
    });



// llenar campos de colores
const colores = ['Marrón', 'Negro', 'Blanco', 'Beige', 'Gris', 'Azul', 'Rojo', 'Verde', 'Amarillo', 'Naranja'];

const colorSelect = document.querySelector('select[name="color"]');

agregarCampos(colorSelect, colores);


// llenar campos de marca

const marcas = ['Lucchese', 'Botas Jusaino', "Ariat", "Cuadra", "Corral", "Los Altos Boots"];

const marcaSelect = document.querySelector('select[name="marca"]');

agregarCampos(marcaSelect, marcas);

function agregarCampos(select, opciones) {
    opciones.forEach(opcion => {
        const option = document.createElement('option');
        option.value = opcion;
        option.textContent = opcion;
        select.appendChild(option);
    });
}



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

//peticiones para consultar los estilo
fetch('http://192.168.100.21:8081/api/product/readEstilos', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
})
    .then(response => response.json())
    .then(data => {
        const content = JSON.parse(data.content);
        const estilos = content.map(item => ({
            id_estilo: item.id_estilo,
            nombre: item.nombre,
            id_productos: item.id_productos
        }));

        function agregarOpcionesEstilo(select, opciones) {
            opciones.forEach(opcion => {
                const option = document.createElement('option');
                option.value = JSON.stringify(opcion);
                option.textContent = opcion.nombre;
                select.appendChild(option);
            });
        }

        const estiloSelect = document.querySelector('select[name="estilo"]');
        agregarOpcionesEstilo(estiloSelect, estilos);

    })
    .catch(error => {
        alert(error);
        console.error('Error al enviar los datos:', error);
    });




// llenar campos de colores
const colores = ['Marrón', 'Negro', 'Blanco', 'Beige', 'Gris', 'Azul', 'Rojo', 'Verde', 'Amarillo', 'Naranja'];

const colorSelect = document.querySelector('select[name="color"]');

agregarCampos(colorSelect, colores);

// llenar material

const materiales = ['AVESTRUZ'];

const materialSelect = document.querySelector('select[name="material"]');

agregarCampos(materialSelect, materiales);

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

//Mostrar imagen
function mostrarImagen() {

    const input = document.getElementById('product-image-input');
    const img = document.getElementById('product-image');

    const file = input.files[0];
    const reader = new FileReader();

    reader.onload = function (e) {
        img.src = e.target.result;
    };

    reader.readAsDataURL(file);
}
// Lista para almacenar productos
let listaProductos = [];
function agregarProducto() {
    const tallaSelect = document.getElementById('talla-select');
    const cantidadInput = document.getElementById('cantidad-input');

    const tallaJson = tallaSelect.value;
    const talla = JSON.parse(tallaJson);
    const cantidad = parseInt(cantidadInput.value);

    if (talla && !isNaN(cantidad)) {
        // Verificar si la talla ya está en la lista
        const productoExistente = listaProductos.find(producto => {
            return producto.tallaDto.id_talla === talla.id_talla;
        });

        if (productoExistente) {
            if (productoExistente.cantidad + cantidad >= 0) {
                productoExistente.cantidad += cantidad;
                if (productoExistente.cantidad == 0) {
                    const index = listaProductos.findIndex(producto => producto === productoExistente);
                    if (index !== -1) {
                        listaProductos.splice(index, 1);
                    }
                }

            } else {
                alert("Especifica una cantidad válida.");
            }
        } else {
            // Si no está en la lista, agregar un nuevo producto
            if (cantidad >= 0) {
                const producto = {
                    id_producto_talla: null,
                    cantidad: cantidad,
                    tallaDto: talla,
                    productoDto: null
                };

                listaProductos.push(producto);
            } else {
                alert("Especifica una cantidad válida.");
            }
        }

        mostrarListaProductos();
    } else {
        alert("Por favor, selecciona una talla o ingrese una cantidad valida");
    }
}


function mostrarListaProductos() {
    const listaDiv = document.getElementById('lista-productos');
    listaDiv.innerHTML = '';

    listaProductos.forEach((producto, index) => {

        const productoDiv = document.createElement('div');
        productoDiv.textContent = `Talla: ${producto.tallaDto.talla_mx}, Cantidad: ${producto.cantidad}`;
        listaDiv.appendChild(productoDiv);

    });
}




//Guardar el producto 
function guardarProducto() {

    const colorSelect = document.getElementsByName('color')[0];
    const materialSelect = document.getElementsByName('material')[0];
    //  const categoriaSelect = document.querySelector('select[name="categoria"]');
    const categoriaSelect = document.getElementsByName('categoria')[0];
    const categoriaJson = categoriaSelect.value;
    const estiloSelect = document.querySelector('select[name="estilo"]');
    const estiloJson = estiloSelect.value;


    // Recolectar los datos del formulario
    const nombre = document.getElementsByName('Nombre')[0].value;
    const descripcion = document.getElementsByName('descripcion')[0].value;
    const marca = document.getElementsByName('marca')[0].value;
    const material = materialSelect.value;
    const color = colorSelect.value;
    const codigo = document.getElementsByName('CodigoBarras')[0].value;
    const precio = parseFloat(document.getElementsByName('Precio')[0].value);
    const categoria = JSON.parse(categoriaJson);

    const estilo = JSON.parse(estiloJson);

    const imagenInput = document.getElementById('product-image-input');
    const imagenFile = imagenInput.files[0];

    // Función para leer el contenido del archivo de imagen
    function leerImagen(file) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.onload = function (event) {
                resolve(event.target.result);
            };
            reader.onerror = function (error) {
                reject(error);
            };
            reader.readAsArrayBuffer(file);
        });
    }

    // Leer la imagen y crear el objeto de producto una vez que se complete la lectura
    leerImagen(imagenFile)
        .then(contenidoImagen => {
            const imagenDto = {
                contenido: Array.from(new Uint8Array(contenidoImagen)), // Convertir el ArrayBuffer a un array de bytes
                id_producto: null
            };

            // Crear el objeto de producto
            const productoDto = {
                nombre: nombre,
                descripcion: descripcion,
                marca: marca,
                material: material,
                color: color,
                codigo: codigo,
                precio: precio,
                categoriaDto: categoria,
                estiloDto: estilo,
                productoTallaDtos: listaProductos,
                imagenesDtos: { imagenDto } // Agregar el objeto de imagenDto al productoDto
            };

            console.log(productoDto.categoriaDto);


            // Crear el objeto de producto talla



            // Enviar los datos al servidor
            fetch('http://192.168.100.21:8081/api/product/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    productoDto: productoDto
                }),
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Error al guardar el producto');
                    }
                    return response.json();
                })
                .then(data => {

                    console.log('Producto guardado exitosamente:', data);

                })
                .catch(error => {
                    console.error('Error:', error);

                });

        });
}

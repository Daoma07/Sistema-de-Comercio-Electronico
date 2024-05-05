
const tallas = ['TALLA 1', 'TALLA 2', 'TALLA 3'];

// Función para agregar opciones a un select
function agregarOpciones(select, opciones) {
    opciones.forEach(opcion => {
        const option = document.createElement('option');
        option.value = opcion;
        option.textContent = opcion;
        select.appendChild(option);
    });
}

// Selecciona los elementos select y agrega opciones
document.addEventListener('DOMContentLoaded', function () {

    const tallaSelect = document.querySelector('select[name="Talla"]');

    agregarOpciones(tallaSelect, tallas);
});

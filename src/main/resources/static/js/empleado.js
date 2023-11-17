import {idRowCell,valueCell,textButtonCell} from './components/tableCell.js';

var empleados = [
    {
        id_empleado: 1,
        empleado_nombres: "Luis Gerardo",
        empleado_apellidos: "Bigoria Escobedo",
        empleado_dni:'72648563',
        empleado_email: "luisg@sua.com",
        empleado_usuario: 'Gera63',
        empleado_telefono:'914786254',
        fecha_contrato:'14/12/2009',
    },
    {
        id_empleado: 2,
        empleado_nombres: "Pedro",
        empleado_apellidos: "Jimenez Rojas",
        empleado_dni:'71698475',
        empleado_email: "projas@sua.com",
        empleado_usuario: 'PeterJ72',
        empleado_telefono:'912538784',
        fecha_contrato:'12/10/2014',
    },
    {
        id_empleado: 3,
        empleado_nombres: "Maria Jose",
        empleado_apellidos: "Hernandez Loyola",
        empleado_dni:'72545214',
        empleado_email: "mloyola@sua.com",
        empleado_usuario: 'MajoHL',
        empleado_telefono:'956248914',
        fecha_contrato:'17/03/2019',
    }
];

//Datos empleados
// const data= [{"id_empleado":1,"empleado_nombres":"Luis Gerardo","empleado_apellidos":"Bigoria Escobedo","empleado_email":"luisg@sua.com"},{"id_empleado":2,"empleado_nombres":"Pedro","empleado_apellidos":"Jimenez Rojas","empleado_email":"projas@sua.com"},{"id_empleado":3,"empleado_nombres":"Maria Jose","empleado_apellidos":"Hernandez Loyola","empleado_email":"mloyola@sua.com"}]

//console.log(JSON.parse(data))
// Crear elementos de la row de la tabla

let createEmpleadoTableRow = (objValues)=>{
    let tr = document.createElement('tr');
    tr.className = "bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600";
    let idRow = idRowCell(objValues.id_empleado);
    let tdNombre= valueCell(objValues.empleado_nombres);
    let tdApellidos = valueCell(objValues.empleado_apellidos);
    let tdDNI = valueCell(objValues.empleado_dni);
    let tdEmail = valueCell(objValues.empleado_email);
    let tdUserName = valueCell(objValues.empleado_usuario);
    let tdPhone = valueCell(objValues.empleado_telefono);
    let tdHiringDate = valueCell(objValues.fecha_contrato);

    let editButton =  textButtonCell("Editar",()=>{});
    let deleteButton =  textButtonCell("Eliminar",()=>{});
    tr.append(idRow, tdNombre, tdApellidos,tdDNI, tdEmail, tdUserName, tdPhone,tdHiringDate,editButton, deleteButton);
    return tr;
}

// Agregar tr al cuerpo de la tabla (tbody)
const empleadosJson=JSON.stringify(empleados);
const data = JSON.parse(empleadosJson);

data.forEach((empleado)=>{
    document.querySelector('#empleado_tbody').appendChild(createEmpleadoTableRow(empleado));
})

// Supongamos que tienes un formulario con el id "miFormulario"
const formulario = document.querySelector('#empleadoForm');


formulario.addEventListener('submit', function(event) {
    console.log('se hizo click')
    // Previene la acción por defecto del formulario
    event.preventDefault();

    // Crea un objeto FormData a partir del formulario
    let formData; 
    formData = new FormData(formulario);

    // Utiliza el método get para obtener el valor de un campo específico
    //let nombre = datos.get('nombre');
    for (let [clave, valor] of formData) {
        console.log(`${clave}: ${valor}`);
    }
    let saludo = 'hola'
    let array = saludo.split('')
    for (const letra of array) {
        console.log(letra)
    }
});
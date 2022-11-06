document.addEventListener("DOMContentLoaded", cargarPagina);
"uses strict";


function cargarPagina() {
    //let dato= 

    let consulta=[];
    let consultaAux={
        "nombre":"Martin Garcia",
        "dominio": "AA 234 BD"
        };
    agregar(consultaAux);    

    function agregar(dato){ 
        consulta.push(dato);
        console.log(dato.nombre);
    }

    function mostrar(){
        let i=0;
        while(i<consulta.length){
            console.log(consulta[i].dominio);
            i++;
        }
        console.log("El total de consultas es de: "+(consulta.length))
    }
    

    let formu = document.querySelector("#idFormulario");
    formu.addEventListener("submit", procesarFormulario);

    function procesarFormulario(event) {
        event.preventDefault();
        console.log(event.target);
        let nombre = document.querySelector("#idNombre");
        let valor = document.querySelector("#idValor");
        let dominio = document.querySelector("#idDominio");
        //let coti;
        if (selectPepe.value == "todo-riesgo") {
           let coti = (valor.value * 1) / 100;
        }
        else
            if (selectPepe.value == "terceros") {
               let coti = (valor.value * 0.5) / 100;
            }
        imprimirCotizacion(nombre.value, valor.value, dominio.value, selectPepe.value, coti);
        let elem;
        elem.nombre=nombre.value;
        elem.dominio=dominio.value;
        agregar(elem);
        limpiarCampos(nombre, valor, dominio);
    }

    function limpiarCampos(nom, val, dom) {
        nom.value = " ";
        val.value = " ";
        dom.value = " ";
    }

    function imprimirCotizacion(nom, val, dom, tipoSe, cotiza) {
        document.querySelector("#idNombreM").innerHTML = nom;
        document.querySelector("#idDominioM").innerHTML = dom;
        document.querySelector("#idValorM").innerHTML = val;
        document.querySelector("#idTipoM").innerHTML = tipoSe;
        document.querySelector("#idCotizacionM").innerHTML = cotiza;
    }

    let selectPepe = document.querySelector("#idTipo");
    selectPepe.addEventListener("change", function () {
        if (selectPepe.value == "terceros") {
            /*formu.classList.remove("colorForm");
            formu.classList.add("colorForm2");*/
            cambiarColor(formu, "colorForm", "colorForm2")
        }
        else
            if (selectPepe.value == "todo-riesgo") {
                /*formu.classList.remove("colorForm2");
                formu.classList.add("colorForm");*/
                cambiarColor(formu, "colorForm2", "colorForm")
            }
    });

    function cambiarColor(form, clase1, clase2) {
        formu.classList.remove(clase1);
        form.classList.add(clase2);
    }



    let inputs = document.querySelectorAll(".input");

    for (let i = 0; i < inputs.length; i++) {
        inputs[i].addEventListener("focus", imprimirDatos);
    }

    function imprimirDatos(event) {
        console.log(event.target.id);
        if (event.target.id = "idNombre") {

        }
    }
}





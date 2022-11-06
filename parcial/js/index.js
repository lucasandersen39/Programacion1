document.addEventListener("DOMContentLoaded",cargarPagina);
"uses strict";

function cargarPagina(){

    let formu=document.querySelector("#idFormulario");
    formu.addEventListener("submit",procesarFormulario);

    function procesarFormulario(event){
        event.preventDefault();
        console.log(event.target);
        let nombre=document.querySelector("#idNombre");
        let valor=document.querySelector("#idValor");
        let dominio=document.querySelector("#idDominio");
        let coti;
        if (selectPepe.value=="todo-riesgo"){
            coti=(valor.value*1)/100;
        }
        else
            if (selectPepe.value=="terceros"){
                coti=(valor.value*0.5)/100;
            }
        imprimirCotizacion(nombre.value,valor.value,dominio.value,selectPepe.value,coti);
        limpiarCampos(nombre,valor,dominio);
    }

    function limpiarCampos(nom,val,dom){
        nom.value=" ";
        val.value=" ";
        dom.value=" ";
    }

    function imprimirCotizacion(nom,val,dom,tipoSe,cotiza){
        document.querySelector("#idNombreM").innerHTML=nom;
        document.querySelector("#idDominioM").innerHTML=dom;
        document.querySelector("#idValorM").innerHTML=val;
        document.querySelector("#idTipoM").innerHTML=tipoSe;
        document.querySelector("#idCotizacionM").innerHTML=cotiza;
    }

    let selectPepe = document.querySelector("#idTipo");
    selectPepe.addEventListener("change",function(){
        if (selectPepe.value=="terceros"){
            /*formu.classList.remove("colorForm");
            formu.classList.add("colorForm2");*/
            cambiarColor(formu,"colorForm","colorForm2")
        }
        else
            if (selectPepe.value=="todo-riesgo"){
                /*formu.classList.remove("colorForm2");
                formu.classList.add("colorForm");*/
                cambiarColor(formu,"colorForm2","colorForm")
            }
    });
    
    function cambiarColor(form,clase1,clase2){
        formu.classList.remove(clase1);
        form.classList.add(clase2);
    }



    let inputs=document.querySelectorAll(".input");
    
    for (let i=0;i<inputs.length;i++){
        inputs[i].addEventListener("focus",imprimirDatos);
    }

    function imprimirDatos(event){
        console.log(event.target.id);
        if (event.target.id="idNombre"){
            
        }
    }
}





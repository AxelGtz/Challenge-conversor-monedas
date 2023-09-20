var valorIngresado  = document.getElementById("valorIngresado");
var botonConvertir = document.getElementById("botonConvertir");

const habilitarBoton = (val) => {
    if (val > 0) {
         botonConvertir.disabled = false;
    }
}
function valideKey(evt){
    var code = (evt.which) ? evt.which : evt.keyCode;
    if(code==8) { // backspace.
      return true;
    } else if(code>=48 && code<=57) { // is a number.
      return true;
    } else{ // other keys.
      return false;
    }
}
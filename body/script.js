const boton = document.getElementById("boton");
const nombre = document.getElementById("UserName");
const Contraseña = document.getElementById("Password");
const boton2 = document.getElementById("boton2");

function dirigir(e){
    e.preventDefault();
    if(nombre.value === "Admin" && Contraseña.value === "1234"){
        window.location.href = "pantalla.html";
    }else{
        alert("usuario o contraseña incorrecta ❌");
    }
}
function registrar(e){
    e.preventDefault();
    window.location.href = "registro.html";
}
boton.addEventListener("click", dirigir);
boton2.addEventListener("click", registrar)

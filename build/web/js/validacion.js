 function Verificar()
    {
        if(localStorage.getItem('correo')===null  ){
         location.href ="http://localhost:8084/EscuelaWeb/IniciarSesion.jsp";      
         localStorage.removeItem('correo');         
         localStorage.removeItem('clave'); 
         alert("DEBES  INICIAR SESSION");
     }
      
    }

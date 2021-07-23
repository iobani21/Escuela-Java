

 function cargar_pagina()
    {
     
        localStorage.removeItem('correo');
        localStorage.removeItem('clave');
        
    }
    
     function GuardarDat()
    {
        const correo = document.getElementById('correo').value;        
        const clave = document.getElementById('clave').value;
        localStorage.setItem('correo',correo);  
        localStorage.setItem('clave',clave); 
 
      
       
    }
    


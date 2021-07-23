<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Nuevo Maestro</title>
        <link rel="stylesheet" href="css/inserta_maestro.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
   <script type="text/javascript">
function valida(f) {
  var ok = true;
  var msg = "Debes escribir algo en los campos:\n";
  if(f.elements["Nmaestro"].value == "")
  {
    msg += "- nombre Vacio\n";
    ok = false;
  }
   if(f.elements["APP"].value == "")
  {
    msg += "- APP Vacio\n";
    ok = false;
  }
   if(f.elements["APM"].value == "")
  {
    msg += "- APM Vacio\n";
    ok = false;
  }
     if(f.elements["corr"].value == "")
  {
    msg += "- CORREO Vacio\n";
    ok = false;
  }
     if(f.elements["tel"].value == "")
  {
    msg += "- TELEFONO Vacio\n";
    ok = false;
  }
     if(f.elements["direccion"].value == "")
  {
    msg += "- Direccion Vacio\n";
    ok = false;
  }
     if(f.elements["rfc"].value == "")
  {
    msg += "- rfc Vacio\n";
    ok = false;
  }
     if(f.elements["clave"].value == "")
  {
    msg += "- clave Vacio\n";
    ok = false;
  }
 
 
 
 
 
 


  if(ok == false)
    alert(msg);
  return ok;
}
</script>
    </head>
    <body onload="Verificar()">
           <script src="js/validacion.js" language="javascript" type="text/javascript"></script> 
        
               <div class="foo">
  <span class="letter" data-letter="M">M</span>
  <span class="letter" data-letter="A">A</span>
  <span class="letter" data-letter="E">E</span>
  <span class="letter" data-letter="S">S</span>
  <span class="letter" data-letter="T">T</span> 
  <span class="letter" data-letter="R">R</span>
  <span class="letter" data-letter="O">O</span>
</div>
       
        <form name="form1" method="post" action="ControladorMaestro"  onsubmit="return valida(this)">
            <input type="hidden" name="idsalon" value="${IDSALON}">
            <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
            <input type="hidden" name="correo" value="${CORREO}">
            <input type="hidden" name="cla" value="${CLAVE}">
            <input type="hidden" name="idpuesto" value="${IDPUESTO}">          
            <input type="hidden" name="instruccion" value="insertarBBDD">
            <table align="center">
                <tr>
                    <td>Nombre: </td>
                    <td><label for="Nmaestro"></label>
                <input type="text" name="Nmaestro" id="Nmaestro"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Paterno: </td>
                    <td><label for="APP"></label>
                <input type="text" name="APP" id="APP"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Materno: </td>
                    <td><label for="APM"></label>
                <input type="text" name="APM" id="APM"></td>
                </tr>
               
                
          
                     <tr>
                    <td>Puesto: </td>    
                      <td><label for="idpu"></label>
                      <select class="styled-select" class="styled-select" name="idpu" id="idpuesto">
                
                   <option value="1">Catedratico</option>
                   <option value="2">Director</option>
                   <option value="3">Secretario(a)</option>
                    </select>
                      </td>
                       
            
                </tr>
                      
                <tr>
                <td>Correo Electronico: </td>
                <td><label for="corr"></label>
                <input type="text" name="corr" id="corr"></td>
                </tr>
         
            
                 <tr>
                    <td>Telefono: </td>
                    <td><label for="tel"></label>
                <input type="text" name="tel" id="tel"></td>
                </tr>
                
                  <tr>
                    <td>Direccion: </td>
                    <td><label for="direccion"></label>
                <input type="text" name="direccion" id="direccion"></td>
                </tr>
                 <tr>
                    <td>RFC: </td>
                    <td><label for="rfc"></label>
                <input type="text" name="rfc" id="rfc"></td>
                </tr>
                <tr>
                    <td>Clave: </td>
                    <td><label for="clave"></label>
                <input type="password" name="clave" id="clave"></td>
                </tr>
                <tr>
                    <td><input  type="submit" name="envio" id="envio" value="REGISTRAR" required > </td>
                </form>  
                <form class="form" name="form1" method="get" action="ControladorMaestro">
             <input type="hidden" name="instruccion" value="listar">
             <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idsalon" value="${IDSALON}">
             
             <td> <input class="boton" type="submit" name="envio" id="envio" value="Regresar"></td> 
             </form>
                </tr>
                
            
           
            </table>
               
    </body>
</html>


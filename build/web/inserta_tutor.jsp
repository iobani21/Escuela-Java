<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tutores </title>
        <link rel="stylesheet" href="css/inserta_tutor.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    <script type="text/javascript">
function valida(f) {
  var ok = true;
  var msg = "Debes escribir algo en los campos:\n";
  if(f.elements["Ntutor"].value == "")
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
    msg += "- Correo Vacio\n";
    ok = false;
  }
   if(f.elements["tel"].value == "")
  {
    msg += "- tel Vacio\n";
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
        <div align="center">
        
                   <div class="foo">
  <span class="letter" data-letter="R">R</span>
  <span class="letter" data-letter="E">E</span>
  <span class="letter" data-letter="G">G</span>
  <span class="letter" data-letter="I">I</span>
  <span class="letter" data-letter="S">S</span>
  <span class="letter" data-letter="T">T</span>
  <span class="letter" data-letter="R">R</span>
  <span class="letter" data-letter="A">A</span>
  <span class="letter" data-letter="R">R</span>  
</div>
        <form name="form1" method="get" action="ControladorTutor" onsubmit="return valida(this)">
            <input type="hidden" name="instruccion" value="insertarBBDD">
                    <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
                    <input type="hidden" name="idsalon" value="${IDSALON}">
                    <input type="hidden" name="cla" value="${CLAVE}">
            <table>
                <tr>
                    <td>Nombre: </td>
                    <td><label for="Ntutor"></label>
                <input type="text" name="Ntutor" id="Ntutor"></td>
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
                    <td>Parentesco: </td>    
                      <td><label for="idparentesco"></label>
                      <select class="styled-select"  name="idparentesco" id="idparentesco">
                
                   <option value="1">Padre</option>
                   <option value="2">Madre</option>
                   <option value="3">Hermano(a)</option>
                   <option value="4">Conocido</option>
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
                     <td><input type="submit" name="envio" id="envio" value="REGISTRAR"> </td>
                     </form>
             <form class="form" name="form3" method="get" action="ControladorTutor">
             <input type="hidden" name="instruccion" value="listar">
             <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idsalon" value="${IDSALON}">
             <td><input class="boton" type="submit" name="envio" id="envio" value="Regresar Lista Tutores"></td> 
               </form>
                </tr>
            
            </table>
                 </div>
    </body>
</html>


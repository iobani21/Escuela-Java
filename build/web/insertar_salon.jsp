

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salon</title>
        <link rel="stylesheet" href="css/inserta_salon.css" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
       <script type="text/javascript">
function valida(f) {
  var ok = true;
  var msg = "Debes escribir algo en los campos:\n";
  if(f.elements["Salon"].value == "")
  {
    msg += "- Salon Vacio\n";
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
        <h1 id="h1_salon">Registrar Nuevo Salon</h1>
        
         <form name="form1" method="post" action="ControladorSalon" onsubmit="return valida(this)">
            <input type="hidden" name="instruccion" value="insertarBBDD">
                <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
                    <input type="hidden" name="idsalon" value="${IDSALON}">
                    <input type="hidden" name="cla" value="${CLAVE}">
            <table align="center">
                <tr>
                    <td>Nombre Salon: </td>
                    <td><label for="Salon"></label>
                <input type="text" name="Salon" id="Salon"></td>
                </tr>
                
                <tr>
                    <td>Maestro: </td>    
                      <td><label for="idmaestro"></label>
                      <select class="styled-select" name="idm">
                  
                   <c:forEach var="temMaestro" items="${LISTAMAESTROS}">
                   <option value="${temMaestro.idmaestro}">${temMaestro.nombre} ${temMaestro.apellidopaterno}</option>
                   </c:forEach> 
                    </select>
                          
                      </td>
                       
            
                </tr>
                
                  <tr>
                    <td>Horario: </td>    
                      <td><label for="idhorario"></label>
                      <select class="styled-select" name="idhorario">
                   <option value="1">7:00 12:00 </option>
                   <option value="2">13:00 18:00 </option>
                    </select>
                          
                      </td>
                       
            
                </tr>
                
          
                   
                            
                
                   
             
                
                
                   
                
                 <tr>
                     <td><input type="submit" name="envio" id="envio" value="REGISTRAR"> </td>              
               
                </form>
                 
               
               
              <form class="form" name="form2" method="get" action="ControladorSalon">
              <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idsalon" value="${IDMAESTRO}">
             <input type="hidden" name="instruccion" value="listar">                 
             <td> <input type="submit" name="borrar" id="borrar" value="REGRESAR"> </td>
                </form>
                 </tr>
                    
</body>
</html>

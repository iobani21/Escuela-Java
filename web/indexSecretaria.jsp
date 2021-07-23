<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${MAESTRO.nombre}</title>    
          <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="css/indexmaestro.css?v=<?php echo(rand()); ?> "type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    </head>
      <body onload="Verificar()">
          <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
         <div class="menudropdown1">
             <br><br><ul>
 <li> Escuela
  <ul>
   <li>       
            <a href="https://www.google.com.mx/maps/place/Centenario+de+Ju%C3%A1rez/@19.1557602,-96.121844,17z/data=!3m1!4b1!4m5!3m4!1s0x85c3411838ca1f09:0x1e6cabc2ffa51974!8m2!3d19.1557602!4d-96.1196553" target="_blank">Ubicacion</a> </li>
  </ul>
 </li>
 <li> Ayuda 
   <ul>
   <li>  <a href="Manual/pdf.pdf" download>Descargar Manual</a> </li>
  </ul>
 </li>
 <li> ${MAESTRO.nombre} ${MAESTRO.apellidopaterno}
 <ul>
   <li>      
           <c:url var="linkTemp" value="ControladorMaestro">
               
                    <c:param name="instruccion" value="cargarperfil"></c:param>
                    <c:param name="idma" value="${MAESTRO.idmaestro}"></c:param>
                    <c:param name="idmaestro" value="${MAESTRO.idmaestro}"></c:param>
                    <c:param name="idpuesto" value="${MAESTRO.idpuesto}"></c:param>
                    <c:param name="correo" value="${MAESTRO.correoelectronico}"></c:param>
                    <c:param name="cla" value="${MAESTRO.clave}"></c:param> 
                </c:url>       
            <a href="${linkTemp}">Actualizar</a>  </li>
   <li> <a href="LogoutServelet">Cerrar Sesion</a> </li>
  </ul>
 </li>   
</ul>
</div>
        <table align="center">
            
            
            
            <tr>
                <br><br><br>
                <h1 id="h1_bienvenido">Bienvenido/a: </h1></p>
                    <h1 id="h1_bienvenido">${MAESTRO.nombre} ${MAESTRO.apellidopaterno} ${MAESTRO.apellidomaterno}</h1>
            </tr>
            
               
            <tr align="center">
                <td>   
                     <br><br><br> 
           <form name="form1" method="post" action="ControladorAlumnos">
            <input type="hidden" name="instruccion" value="listaAlumnos0">
            <input type="hidden" name="ids" value="999">
            <input type="hidden" name="idSalon" value="999">
            <input type="hidden" name="idpuesto" value="${MAESTRO.idpuesto}">
            <input type="hidden" name="idmaestro" value="${MAESTRO.idmaestro}">
            <input type="hidden" name="correo" value="${MAESTRO.correoelectronico}">
            <input type="hidden" name="cla" value="${MAESTRO.clave}">
            
            <input class="boton" type="submit" name="envio" id="envio" value="Ver Lista de Alumnos sin Salon"> 
           </form>
                </td>
            </tr>
            <tr><td>
            
        
                </td> 
            </tr> 
            <tr align="center"><td> 
            <form name="form2" method="get" action="ControladorTutor"> 
             <input type="hidden" name="instruccion" value="listar">
             <input type="hidden" name="idsalon" value="999">
            <input type="hidden" name="idpuesto" value="${MAESTRO.idpuesto}">
            <input type="hidden" name="idmaestro" value="${MAESTRO.idmaestro}">
            <input type="hidden" name="correo" value="${MAESTRO.correoelectronico}">
            <input type="hidden" name="cla" value="${MAESTRO.clave}">
            <br><br><input class="boton" type="submit" name="envio" id="envio" value="Lista de Tutores"> 
        </form>
                </td></tr>
            
            <tr align="center"><td>
         <form name="form3" method="get" action="ControladorMaestro">
                      <input type="hidden" name="idsalon" value="999">
            <input type="hidden" name="idpuesto" value="${MAESTRO.idpuesto}">
            <input type="hidden" name="idmaestro" value="${MAESTRO.idmaestro}">
            <input type="hidden" name="correo" value="${MAESTRO.correoelectronico}">
            <input type="hidden" name="cla" value="${MAESTRO.clave}">
             <input type="hidden" name="instruccion" value="listar">
             <br><br><input class="boton" type="submit" name="envio" id="envio" value="Lista de Personal"> 
        </form>
                </td></tr>
  
        </table>
             <br>
      
           
    </body>
</html>






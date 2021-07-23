<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tutores</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="css/lista_tutores_por_alumnos.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    </head>
   
      <body onload="Verificar()">
      <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
         <div class="foo">
            <span class="letter" data-letter="T">T</span>
            <span class="letter" data-letter="U">U</span>
            <span class="letter" data-letter="T">T</span>
            <span class="letter" data-letter="O">O</span>
            <span class="letter" data-letter="R">R</span>
            <span class="letter" data-letter="E">E</span>
            <span class="letter" data-letter="S">S</span>
</div>
         
        <table class="blueTable" align="center">
            <tr align="center">
                <td class="divtd">Nombre Alumno </td>
                <td class="divtd">Apellido Paterno </td>
                <td class="divtd">Aapellido Materno </td>
                <td class="divtd">Nombre Tutor </td>
                <td class="divtd">Apellido Paterno </td>
                <td class="divtd">Apellido Materno </td>
 
            </tr>
            <c:forEach var="temLista" items="${TA}">
                  <c:url var="linkTemp" value="ControladorAlumnos">
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idAlumnos" value="${temAlumno.idAlumnos}"></c:param>
                </c:url>
                 
                
                
                
            <tr align="center">
                
                <td> ${temLista.nombreA}</td>
                <td> ${temLista.appA}</td>
                 <td> ${temLista.apmA}</td>
                 <td> ${temLista.nombreT}</td>
                 <td> ${temLista.appT}</td>
                 <td> ${temLista.apmT}</td>
              
          
        
               
                
            </tr>
            </c:forEach>
        </table>
        
          <form name="form" method="post" action="ControladorSalon">
                    <input type="hidden" name="instruccion" value="CargarSalon">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="cla" value="${CLAVE}">
                        <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                         <input type="hidden" name="idSalon" value="${SALON}">
                    <td><input type="submit" name="envio" id="envio" value="Regresar a Lista"> </td>
            </form>   
            
 
         
           
        
    </body>
</html>
    
</html>

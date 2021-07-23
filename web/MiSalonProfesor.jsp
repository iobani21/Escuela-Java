<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi Salon</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="css/misalonprofesor.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    </head>
     <body onload="Verificar()">
            <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
        <br><br>
        <h1 id="h1_salon">El Grupo es : ${SALON.salon} </h1>
        <table align="center">
            <tr id="horario">
                  <c:set var = "horario" scope = "session" value = "${SALON.idhorario}"/>
                 <c:if test = "${horario == 1 }">
                     <td>Horario de 7:00 - 12:00</td
                </c:if>
                  <c:if test = "${horario == 2 }">
                     <td>Horario de 1:00 - 18:00</td
                </c:if>     
            </tr>
            
            
            <tr align="center">             
            <form name="form1" method="post" action="ControladorAlumnos">
                    <input type="hidden" name="instruccion" value="listarxsalon">
                    <input type="hidden" name="idSalon" value="${SALON.idsalon}">
                    <input type="hidden" name="ids" value="${SALON.idsalon}">
                    <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="cla" value="${CLAVE}">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
                    <td><br><br><br><input class="boton" type="submit" name="envio" id="envio" value="Lista de Mis Alumnos"><br><br>
                    </td>
            
            </form>   
              
            </tr>
                     
            <tr align="center">
                 <form name="form3" method="post" action="ControladorAlumnos">
                    <input type="hidden" name="instruccion" value="ListaTutoresXsalon">
                          <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="clave" value="${CLAVE}">
                    <input type="hidden" name="idSalon" value="${SALON.idsalon}">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
                    <td><input class="boton" type="submit" name="envio" id="envio" value="Ver Tutores de Alumnos"> <br><br></td>
            </form>  
                
            </tr>
                       <tr align="center">
              
           <form class="form" name="form2" method="post" action="ControladorSalon">
              <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="instruccion" value="MisSalones">
             
                 <td><input class="boton" type="submit" name="envio" id="envio" value="Lista de Mis Salones"> </td>
          
                 </form></tr>
            
                    
            
 
               
                
            
        </table>
          
         
    </body>
</html>

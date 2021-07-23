<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Salones</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="css/nuevo.css" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    </head>
   
    <body onload="Verificar()">
            <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
        <div class="foo">
            <span class="letter" data-letter="S">S</span>
            <span class="letter" data-letter="A">A</span>
            <span class="letter" data-letter="L">L</span>
            <span class="letter" data-letter="O">O</span>
            <span class="letter" data-letter="N">N</span>
            <span class="letter" data-letter="E">E</span>
            <span class="letter" data-letter="S">S</span>
</div>
        
        <div>
        <table align="center" class="blueTable">
            <tr class="letras">
                <td>  ID-SALON  </td>
                <td>  Salon </td>
                <td>  Horario   </td>
                <td>  Profesor  </td>
            </tr>
      
            <c:forEach  var="temSalon" items="${LISTASALON}">
                  <c:url var="linkTemp" value="ControladorSalon">
                    <c:param name="instruccion" value="CargarSalon"></c:param>
                    <c:param name="idSalon" value="${temSalon.idsalon}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
             
              
                
            <tr class="letras">
                
                <td> ${temSalon.idsalon}</td>
                <td> ${temSalon.salon}</td>
                 <td> ${temSalon.idhorario}</td>
                <td> ${temSalon.idprofesor}</td>
                <td> <a href="${linkTemp}">VerInformacionDelSalon</a></td>
               
            
            </tr>
            </c:forEach>
        </table>

        
        
        
          
            <form name="form3" method="post" action="ControladorMaestro">
                    <input type="hidden" name="instruccion" value="IniciarSesion">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="clave" value="${CLAVE}">
                    <input type="hidden" name="band" value="2">
                    <input class="boton" type="submit" name="envio" id="envio" value="Regresar a Menu"> 
                    
            </form>  
       </div>
    </body>
</html>

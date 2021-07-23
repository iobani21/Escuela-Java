
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Maestro</title>
        
        <link rel="stylesheet" href="css/actualizarmaestro.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
        
    </head>
     <body onload="Verificar()">
           <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
        <div align="center">
        <div class="foo">
  <span class="letter" data-letter="M">M</span>
  <span class="letter" data-letter="A">A</span>
  <span class="letter" data-letter="E">E</span>
  <span class="letter" data-letter="S">S</span>
  <span class="letter" data-letter="T">T</span> 
  <span class="letter" data-letter="R">R</span>
  <span class="letter" data-letter="O">O</span>
</div>
      
        <form name="form1" method="post" action="ControladorMaestro">
            <input type="hidden" name="instruccion" value="actualizarBBDD">
           
         
             
            <input type="hidden" name="idma" value="${MAESTRO.idmaestro}">
            <input type="hidden" name="corr" value="${MAESTRO.correoelectronico}">
            <input type="hidden" name="clave" value="${MAESTRO.clave}">
            
            
            <input type="hidden" name="idsalon" value="${IDSALON}">
            <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
            <input type="hidden" name="correo" value="${CORREO}">
            <input type="hidden" name="cla" value="${CLAVE}">
            <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             
             
            <table>
                <tr>
                    <td>Nombre(s): </td>
                    <td><label for="Nombre"></label>
                <input type="text" name="Nombre" id="Nombre" value="${MAESTRO.nombre}"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Paterno: </td>
                    <td><label for="APP"></label>
                <input type="text" name="APP" id="APP" value="${MAESTRO.apellidopaterno}"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Materno: </td>
                    <td><label for="APM"></label>
                <input type="text" name="APM" id="APM" value="${MAESTRO.apellidomaterno}"></td>
                </tr>
                 <tr>
                      <c:if test = "${IDPUESTO == 3}">
                       <input type="hidden" name="idpu" value="${MAESTRO.idpuesto}">
                      </c:if>   
                      <c:if test = "${IDPUESTO == 2}">  
                    <td>PUESTO : </td>
                     <td><label for="idpu"></label>
                      <select class="styled-select" class="styled-select" name="idpu" id="idpuesto">
                  <c:if test = "${MAESTRO.idpuesto == 1 }">          
                   <option value="1" cheked="true">Catedratico</option>
                   <option value="2">Director</option>
                   <option value="3">Secretario(a)</option>
                    </select>
                      </td>
                     </c:if>
                       <c:if test = "${MAESTRO.idpuesto == 2 }">   
                       <option value="2" cheked="true">Director</option>
                       <option value="1">Catedratico</option>
                   <option value="3">Secretario(a)</option>
                    </select>
                      </td>
                     </c:if>
                        <c:if test = "${MAESTRO.idpuesto == 3 }">   
                   <option value="3" cheked="true">Secretario(a)</option>  
                   <option value="1">Catedratico</option>
                   <option value="2">Director</option>
                   
                    </select>
                      </td>
                     </c:if>
                       </c:if>
               

                </select>
                
                    
                    
                    
                </tr>
                 <tr>
                    <td>RFC: </td>
                    <td><label for="rfc"></label>
                <input type="text" name="rfc" id="rfc" value="${MAESTRO.rfc}"></td>
                </tr>
                 <tr>
                    <td>Direccion: </td>
                    <td><label for="direccion"></label>
                <input type="text" name="direccion" id="direccion" value="${MAESTRO.direccion}"></td>
                </tr>
                 <tr>
                    <td>Telefono: </td>
                    <td><label for="tel"></label>
                <input type="text" name="tel" id="rfc" value="${MAESTRO.telefono}"></td>
                </tr>
               
         
                
             
                
                 <tr>
                   <td> <input class="boton" type="submit" name="envio" id="envio" value="Modificar"></td>    
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
                  
                  
                
                
                     
       
                
               
     </div>
            
    </body>
</html>
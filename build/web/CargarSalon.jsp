<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Salon</title>
        <link rel="stylesheet" href="css/cargarsalon.css?v=<?php echo(rand()); ?>" type="text/css">
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
        </div>
        
        <div align="center">        
            <form name="form1" method="post" action="ControladorSalon">
                <input type="hidden" name="instruccion" value="Modificar">
                <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                <input type="hidden" name="correo" value="${CORREO}">
                <input type="hidden" name="idmaestro" value="${IDM}">
                <input type="hidden" name="idsalon" value="${IDS}">
                <input type="hidden" name="cla" value="${CLAVE}">
                <input type="hidden" name="ids" value="${SALON.idsalon}">                   
                <table>
                    <tr>
                        <td>Nombre Salon: </td>
                        <td><label for="Salon"></label>
                            <input type="text" name="Salon" id="salon" value="${SALON.salon}"></td>
                    </tr>                  
                    <tr>
                        <td>Maestro: </td>    
                        <td><label for="idma"></label>
                        <select class="styled-select" name="idm">                  
                        <c:forEach var="temMaestro" items="${MAESTROS}">
                            <c:if test = "${temMaestro.idmaestro == SALON.idprofesor }">     
                            <option value="${temMaestro.idmaestro}" selected="selected">${temMaestro.nombre} ${temMaestro.apellidopaterno} </option>
                            </c:if>
                            <c:if test = "${temMaestro.idmaestro != SALON.idprofesor }">     
                            <option value="${temMaestro.idmaestro}">${temMaestro.nombre} ${temMaestro.apellidopaterno} </option>
                            </c:if>
                        </c:forEach> 
                        </select>                          
                        </td>
                    </tr>                                      
                 <tr>
                    <td>Horario: </td>                
                    <td><label for="idhorario"></label>
                        <select class="styled-select" name="idhorario">
                            <c:if test = "${SALON.idhorario == 1 }">         
                                <option value="1" checked="true">7:00-12:00</option> 
                                <option value="2">13:00 18:00</option> 
                            </c:if>                
                            <c:if test = "${SALON.idhorario == 2 }">         
                                <option value="2"  checked="true">13:00 18:00</option> 
                                <option value="1">7:00-12:00</option>
                            </c:if>
                        </select>
                 </tr>                             
                 <tr>
                    <br>
                    <td><input type="submit" name="envio" id="envio" value="Actualizar"> </td>
         </form>
                </tr>
            <td>
              <form class="form" name="form2" method="get" action="ControladorSalon">
                <input type="hidden" name="correo" value="${CORREO}">
                <input type="hidden" name="cla" value="${CLAVE}">
                <input type="hidden" name="idmaestro" value="${IDM}">
                <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                <input type="hidden" name="idsalon" value="${IDS}">
                <input type="hidden" name="instruccion" value="listar">
                <input class="boton" type="submit" name="envio" id="envio" value="Regresar"> 
              </form>
            </td>               
                </tr>               
                </div>
    </body>
</html>

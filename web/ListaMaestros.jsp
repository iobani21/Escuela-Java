<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
           <script>
            window.onload = function() {
  init();
  doSomethingElse();
};
</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal</title>
          <c:if test = "${BAND== 3 }">
             <script>
              function load() {
              alert("No se puede mostrar  matricula!");
              }
      window.onload = load;
    </script>
                 </c:if>
 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="css/listamaestros.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
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
  <span class="letter" data-letter="S">S</span>
</div>
         <div class="divtd">
     <form  name="form3" method="get" action="ControladorMaestro" align="center">
             <input type="hidden" name="instruccion" value="buscar">          
             <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idsalon" value="${IDSALON}">
              <td>Nombre: </td>
             <label for="nom"></label>
             <input type="text" name="nom" id="nom">
             <td>Apellido PAT: </td>
             <label for="app"></label>
             <input type="text" name="app" id="app">
             <td> Apellido MAT: </td>
             <label for="apm"></label>
             <input type="text" name="apm" id="apm">
             
             <input  type="submit" name="envio" id="envioo" value="Buscar"> 
             </form></div>
              <br>
              <br>
              
     <c:if test = "${BAND== 1 }">
                  
             <table class="blueTable">
            <tr align="center">
                <td class="divtd">  Nombre(s) </td>
                <td class="divtd">  Apellido Paterno </td>
                <td class="divtd">  Apellido Materno </td>
                <td class="divtd">  RFC </td>
                <td class="divtd">  Correo-Electronico </td>
                <td class="divtd">  Telefono </td>
                <td class="divtd">  Puesto </td>
            </tr>
                
                <c:if test = "${MAESTRO.idpuesto ==1 or MAESTRO.idpuesto ==3 or MAESTRO.idpuesto ==2 }">  
                  <c:url var="linkTemp" value="ControladorMaestro">
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idma" value="${MAESTRO.idmaestro}"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param> 
                </c:url>
                      <c:url var="linkTemp2" value="ControladorMaestro">
                    <c:param name="instruccion" value="eliminar"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                    <c:param name="idma" value="${MAESTRO.idmaestro}"></c:param>
                </c:url>
                  
                
           
                
            <tr align="center">
                
                <td class="divtd"> ${MAESTRO.nombre}</td>
                <td class="divtd"> ${MAESTRO.apellidopaterno}</td>
                <td class="divtd"> ${MAESTRO.apellidomaterno}</td>
                <td class="divtd"> ${MAESTRO.rfc}</td>
                <td class="divtd"> ${MAESTRO.correoelectronico}</td>
                <td class="divtd"> ${MAESTRO.telefono}</td>
                  
                <c:set var = "idpuesto" scope = "session" value = "${MAESTRO.idpuesto}"/>
                <c:if test = "${idpuesto == 1}">    
                <td class="divtd"> Catedratico</td>
                </c:if>
                  <c:if test = "${idpuesto == 2}">    
                 <td class="divtd"> Director</td>
                  </c:if>
                   <c:if test = "${idpuesto == 3}">    
                 <td class="divtd"> Secretaria</td>
                </c:if>
             
                 
                <c:if test = "${MAESTRO.idpuesto != 2}">  
                <td class="divtd"> <a href="${linkTemp}">ACTUALIZAR</a></td>
                 <c:if test = "${IDPUESTO == 2}">  
                    <td class="divtd"> <a href="${linkTemp2}">ELIMINAR</a></td>
                    </c:if>
                       </c:if>
                       <c:if test = "${MAESTRO.idpuesto == 2}">  
                <td class="divtd">BLOQUEADO</td>
                 <c:if test = "${IDPUESTO == 2}">  
                    <td class="divtd">BLOQUEADO</td>
                    </c:if>
                       </c:if>
            </tr>
                   </c:if> 

        </table>
         <br>
         <br>
            </c:if>
            
            
            
        <table class="blueTable">
            <tr align="center">
                <td class="divtd">  Nombre(s) </td>
                <td class="divtd">  Apellido Paterno </td>
                <td class="divtd">  Apellido Materno </td>
                <td class="divtd">  RFC </td>
                <td class="divtd">  Correo-Electronico </td>
                <td class="divtd">  Telefono </td>
                <td class="divtd">  Puesto </td>
            </tr>
                
            <c:forEach var="temMaestro" items="${LISTAMAESTROS}">
                <c:if test = "${temMaestro.idpuesto ==1 or temMaestro.idpuesto ==3 or temMaestro.idpuesto ==2 }">  
                  <c:url var="linkTemp" value="ControladorMaestro">
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idma" value="${temMaestro.idmaestro}"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param> 
                </c:url>
                      <c:url var="linkTemp2" value="ControladorMaestro">
                    <c:param name="instruccion" value="eliminar"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                    <c:param name="idma" value="${temMaestro.idmaestro}"></c:param>
                </c:url>
                  
                
           
                
            <tr align="center">
                
                <td class="divtd"> ${temMaestro.nombre}</td>
                <td class="divtd"> ${temMaestro.apellidopaterno}</td>
                <td class="divtd"> ${temMaestro.apellidomaterno}</td>
                <td class="divtd"> ${temMaestro.rfc}</td>
                <td class="divtd"> ${temMaestro.correoelectronico}</td>
                <td class="divtd"> ${temMaestro.telefono}</td>
                  
                <c:set var = "idpuesto" scope = "session" value = "${temMaestro.idpuesto}"/>
                <c:if test = "${idpuesto == 1}">    
                <td class="divtd"> Catedratico</td>
                </c:if>
                  <c:if test = "${idpuesto == 2}">    
                 <td class="divtd"> Director</td>
                  </c:if>
                   <c:if test = "${idpuesto == 3}">    
                 <td class="divtd"> Secretaria</td>
                </c:if>
             
                 
                <c:if test = "${temMaestro.idpuesto != 2}">  
                <td class="divtd"> <a href="${linkTemp}">ACTUALIZAR</a></td>
                 <c:if test = "${IDPUESTO == 2}">  
                    <td class="divtd"> <a href="${linkTemp2}">ELIMINAR</a></td>
                    </c:if>
                       </c:if>
                       <c:if test = "${temMaestro.idpuesto == 2}">  
                <td class="divtd">BLOQUEADO</td>
                 <c:if test = "${IDPUESTO == 2}">  
                    <td class="divtd">BLOQUEADO</td>
                    </c:if>
                       </c:if>
            </tr>
                   </c:if> 
            </c:forEach>
        </table>
       
        <br>
        <form name="form2" method="post" action="ControladorMaestro">
         <input type="hidden" name="instruccion" value="crear">
        <input type="hidden" name="idpuesto" value="${IDPUESTO}">
        <input type="hidden" name="idsalon" value="${IDSALON}">
        <input type="hidden" name="idmaestro" value="${IDMAESTRO}">        
        <input type="hidden" name="correo" value="${CORREO}">
        <input type="hidden" name="cla" value="${CLAVE}">             
        <td><input type="submit" name="envio" id="envio" value="REGISTRAR EMPLEADO">
        </form>
        
              
        
        <form name="form1" method="post" action="ControladorMaestro">
        <input type="hidden" name="instruccion" value="IniciarSesion">      
        <input type="hidden" name="correo" value="${CORREO}">
        <input type="hidden" name="band" value="2">
        <input type="hidden" name="clave" value="${CLAVE}">            
        <td><input type="submit" name="envio" id="envio" value="REGRESAR"> </td>
            </form>   
   
        
    </body>
</html>

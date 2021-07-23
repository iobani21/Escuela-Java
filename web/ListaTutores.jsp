
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
 <c:if test = "${BAND== 3 }">
             <script>
              function load() {
              alert("No se encontro matricula!");
              }
      window.onload = load;
    </script>
                 </c:if>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Tutores</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="css/listatutores.css?v=<?php echo(rand()); ?>" type="text/css">
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
    <div class="divtd">
             <form  name="form3" method="get" action="ControladorTutor" align="center">
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
              <br><br>
              
              <c:if test = "${BAND== 1 }">
                <table class="blueTable" align="center">
            <tr align="center">
                <td class="divtd">  Nombre  </td>
                <td class="divtd">  Apellido Paterno </td>
                <td class="divtd">  Apellido Materno </td>    
                <td class="divtd">  Correo-Electronico</td>
                <td class="divtd">  Telefono </td>
          
            </tr>
            
            <tr align="center">
                 <c:url var="linkTempTut" value="ControladorTutor">
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idTutor" value="${TUTOR.idtutor}"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                      <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                      <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                      <c:param name="correo" value="${CORREO}"></c:param>
                      <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
                
                  <c:url var="linkTempTut2" value="ControladorTutor">
                    <c:param name="instruccion" value="eliminar"></c:param>
                    <c:param name="idTutor" value="${TUTOR.idtutor}"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                      <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                      <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                      <c:param name="correo" value="${CORREO}"></c:param>
                      <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
                <td class="divtd"> ${TUTOR.nombre}</td>
                <td class="divtd"> ${TUTOR.app}</td>
                <td class="divtd"> ${TUTOR.apm}</td>
                <td class="divtd"> ${TUTOR.correo}</td>
                <td class="divtd"> ${TUTOR.telefono}</td>     
                <td class="divtd"> <a href="${linkTempTut}">ACTUALIZAR</a></td>
                <td class="divtd"> <a href="${linkTempTut2}">ELIMINAR</a></td>
            </tr>
                </table>
                <br>
                <br>
                
              </c:if>
              
              
        
        <table class="blueTable" align="center">
            <tr align="center">
                <td class="divtd">  Nombre  </td>
                <td class="divtd">  Apellido Paterno </td>
                <td class="divtd">  Apellido Materno </td>
    
                <td class="divtd">  Correo-Electronico   </td>
                <td class="divtd">  Telefono </td>
          
            </tr>
            <c:forEach var="temTutor" items="${LISTATUTORES}">
                 <c:if test = "${temTutor.idtutor!=0}">  
                  <c:url var="linkTemp" value="ControladorTutor">
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idTutor" value="${temTutor.idtutor}"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                      <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                      <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                      <c:param name="correo" value="${CORREO}"></c:param>
                      <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
                  
                  <c:url var="linkTemp2" value="ControladorTutor">
                    <c:param name="instruccion" value="eliminar"></c:param>
                    <c:param name="idTutor" value="${temTutor.idtutor}"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                      <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                      <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                      <c:param name="correo" value="${CORREO}"></c:param>
                      <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
                
                
                
                
            <tr align="center">
                
                <td class="divtd"> ${temTutor.nombre}</td>
                <td class="divtd"> ${temTutor.app}</td>
                <td class="divtd"> ${temTutor.apm}</td>
                <td class="divtd"> ${temTutor.correo}</td>
                <td class="divtd"> ${temTutor.telefono}</td>     
                <td class="divtd"> <a href="${linkTemp}">ACTUALIZAR</a></td>
                <td class="divtd"> <a href="${linkTemp2}">ELIMINAR</a></td>
            </tr>
                </c:if>
            </c:forEach>
        </table>
        <form name="form2" method="get" action="ControladorTutor"> 
            <input type="hidden" name="instruccion" value="abrirformulario">
                    <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
                    <input type="hidden" name="idsalon" value="${IDSALON}">
                    <input type="hidden" name="cla" value="${CLAVE}">
                    <input type="submit" name="envio" id="envio" value="Nuevo Tutor"> 
                    
            </form> 
              
      <c:if test = "${IDPUESTO == 3 or IDPUESTO==2}">  
        <form name="form1" method="post" action="ControladorMaestro">
        <input type="hidden" name="instruccion" value="IniciarSesion">
        <input type="hidden" name="correo" value="${CORREO}">
        <input type="hidden" name="clave" value="${CLAVE}">    
        <input type="hidden" name="band" value="2">        
        <td><input type="submit" name="envio" id="envio" value="Regresar a Menu"> </td>
            </form>   
    </c:if>
        
            
            
    </body>
</html>

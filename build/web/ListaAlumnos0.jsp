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
        <title>Alumnos Totales Sin Salon  </title>
            <c:if test = "${BAND== 3 }">
             <script>
                function load() {
                alert("No se encontro matricula!");
                }
                window.onload = load;
            </script>
           </c:if>
        <link rel="stylesheet" href="css/lista_alumnos_0.css" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    </head>
   
     <body onload="Verificar()">
         <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
        <div class="foo">    
        <span class="letter" data-letter="A">A</span>
        <span class="letter" data-letter="L">L</span>
        <span class="letter" data-letter="U">U</span>
        <span class="letter" data-letter="M">M</span>
        <span class="letter" data-letter="N">N</span>
        <span class="letter" data-letter="O">O</span>
        <span class="letter" data-letter="S">S</span>
        </div>
               
            <form  name="form3" method="get" action="ControladorAlumnos" align="center">
             <input type="hidden" name="instruccion" value="buscarAlumnoSN">          
             <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idsalon" value="${IDSALON}">
             <input type="hidden" name="ids" value="${IDS}">
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
            </form>
              <br>
              <br>
                 <c:if test = "${BAND== 1 }">
                    <c:url var="linkTemp" value="ControladorAlumnos">
                    <c:param name="instruccion" value="AgregarAlSalon"></c:param>
                    <c:param name="idAlumnos" value="${ALUMNO.idAlumnos}"></c:param>
                    <c:param name="idSalon" value="${IDSALON}"></c:param>
                    <c:param name="ids" value="${IDS}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
              
                    <c:url var="linkTemp2" value="ControladorAlumnos" >
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idAlumnos" value="${ALUMNO.idAlumnos}"></c:param>
                    <c:param name="idSalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                    
                    
                    
                </c:url>
                  
                    <c:url var="linkTemp3" value="ControladorAlumnos">
                    <c:param name="instruccion" value="eliminar"></c:param>
                    <c:param name="idSalon" value="${IDSALON}"></c:param>
                    <c:param name="ids" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                    <c:param name="idAlumnos" value="${ALUMNO.idAlumnos}"></c:param>
                    <c:param name="band" value="2"></c:param>
                </c:url>
                    
              <table class="blueTable" align="center">   
                <tr align="center">            
                <tr>       
                <td class="letras">  Nombre Alumno  </td>
                <td class="letras">  Apellido Paterno </td>
                <td class="letras">  Apellido Materno  </td>
                <td class="letras">  CURP   </td>            
                </tr>                         
                </tr>
                 <tr align="center">
                               
                    <td> ${ALUMNO.nombreAlumno}</td>
                    <td> ${ALUMNO.apellidopaternoAlumno}</td>
                    <td> ${ALUMNO.apellidomaternoAlumno}</td>
                    <td> ${ALUMNO.CURP}</td>                           
                    <c:if test = "${IDPUESTO == 3 }">
                        <td> <a href="${linkTemp2}">MODIFICAR</a></td> 
                        <td> <a href="${linkTemp3}">ELIMINAR</a></td> 
                    </c:if>
                    <c:set var = "idsalon" scope = "session" value = "${SALON}"/>                 
                    <c:if test = "${IDPUESTO==1 or IDPUESTO==2 }">
                        <td class="letras"> <a href="${linkTemp}">Agregar al Salon</a></td>
                    </c:if>
                </tr>
                 
              </table>
                <br>
                <br>
        </c:if>
        
        <table class="blueTable">
            <tr>       
                <td class="letras">  Nombre Alumno  </td>
                <td class="letras">  Apellido Paterno </td>
                <td class="letras">  Apellido Materno  </td>
                <td class="letras">  CURP   </td>            
            </tr>
            <c:forEach var="temAlumno" items="${LISTAALUMNOS}">
                <c:url var="linkTemp" value="ControladorAlumnos">
                    <c:param name="instruccion" value="AgregarAlSalon"></c:param>
                    <c:param name="idAlumnos" value="${temAlumno.idAlumnos}"></c:param>
                    <c:param name="idSalon" value="${IDSALON}"></c:param>
                    <c:param name="ids" value="${IDS}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
              
                    <c:url var="linkTemp2" value="ControladorAlumnos" >
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idAlumnos" value="${temAlumno.idAlumnos}"></c:param>
                    <c:param name="idSalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                    
                    
                    
                </c:url>
                  
                    <c:url var="linkTemp3" value="ControladorAlumnos">
                    <c:param name="instruccion" value="eliminar"></c:param>
                    <c:param name="idSalon" value="${IDSALON}"></c:param>
                    <c:param name="ids" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                    <c:param name="idAlumnos" value="${temAlumno.idAlumnos}"></c:param>
                    <c:param name="band" value="2"></c:param>
                    </c:url>
                    
               
                 
                
                
                
            <tr align="center">                             
                <td class="letras"> ${temAlumno.nombreAlumno}</td>
                <td class="letras"> ${temAlumno.apellidopaternoAlumno}</td>
                <td class="letras"> ${temAlumno.apellidomaternoAlumno}</td>
                <td class="letras"> ${temAlumno.CURP}</td>                                  
                <c:if test = "${IDPUESTO == 3 }">
                    <td> <a href="${linkTemp2}">MODIFICAR</a></td> 
                    <td> <a href="${linkTemp3}">ELIMINAR</a></td> 
                </c:if>
                 <c:set var = "idsalon" scope = "session" value = "${SALON}"/>                 
                 <c:if test = "${IDPUESTO==1 or IDPUESTO==2 }">
                    <td class="letras"> <a href="${linkTemp}">Agregar al Salon</a></td>
                 </c:if>             
            </tr>
        </c:forEach>
        </table>
         
       <c:if test = "${IDPUESTO == 3 }">
                <form  align="center"name="form1" method="get" action="ControladorTutor">
                   <input type="hidden" name="instruccion" value="listatutores">
                   <input type="hidden" name="correo" value="${CORREO}">
                   <input type="hidden" name="cla" value="${CLAVE}">
                   <input type="hidden" name="idmaestro" value="${IDMAESTRO}">       
                   <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                   <input type="hidden" name="idsalon" value="${IDSALON}">
                   <input type="hidden" name="band" value="2">
                   <br><input class="buttton" type="submit" name="envio" id="envio" value="NUEVO ALUMNO"> 
                </form>           
                <form  align="center" name="form1" method="post" action="ControladorMaestro">
                    <input type="hidden" name="instruccion" value="IniciarSesion">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="clave" value="${CLAVE}">
                    <input type="hidden" name="band" value="2">
                    <input type="submit" name="envio" id="envio" value="Regresar a Menu">     
                </form>   
          
       </c:if>
         
       <c:if test = "${IDPUESTO == 2 }">               
            <form  align="center"name="form1" method="get" action="ControladorTutor">
                <input type="hidden" name="instruccion" value="listatutores">
                <input type="hidden" name="correo" value="${CORREO}">
                <input type="hidden" name="cla" value="${CLAVE}">
                <input type="hidden" name="idmaestro" value="${IDMAESTRO}">       
                <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                <input type="hidden" name="idsalon" value="${IDSALON}">
                <input type="hidden" name="band" value="2">
                <br><input class="buttton" type="submit" name="envio" id="envio" value="NUEVO ALUMNO"> 
            </form>
                   
            <form align="center" name="form1" method="get" action="ControladorSalon">
                    <input type="hidden" name="instruccion" value="listar">
                    <input type="hidden" name="idsalon" value="${IDSALON}">
                    <input type="hidden" name="ids" value="${IDSALON}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="cla" value="${CLAVE}">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">       
                    <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                    <br><br><input type="submit" name="envio" id="envio" value="Regresar a Lista">
            </form>   
        </c:if>
              
                
            <c:if test = "${IDPUESTO == 1 }">         
                <form align="center" name="form1" method="get" action="ControladorAlumnos">
                    <input type="hidden" name="instruccion" value="listarxsalon">
                    <input type="hidden" name="idSalon" value="${IDSALON}">
                    <input type="hidden" name="ids" value="${IDSALON}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="cla" value="${CLAVE}">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">       
                    <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                    <br><br><input type="submit" name="envio" id="envio" value="Regresar a Lista">
                </form>   
            </c:if>         
    </body>
</html>

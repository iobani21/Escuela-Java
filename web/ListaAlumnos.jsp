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
        <title>Alumnos Totales</title>
             <c:if test = "${BAND== 3 }">
             <script>
                function load() {
                alert("No se encontro matricula!");
                }
                window.onload = load;
             </script>
             </c:if>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="css/listaalumnos.css?v=<?php echo(rand()); ?>" type="text/css">
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
           <div class="divtd">
           <form name="for" method="get" action="ControladorAlumnos" align="center">
             <input type="hidden" name="instruccion" value="Buscar">
             <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idsalon" value=${SALON}>
             <td>Matricula:</td>
             <label for="matricula"></label>
             <input type="text" name="matricula" id="matricula">
             <input type="submit" name="envio" id="envioo" value="Buscar">
             </form>
           </div>   
        <br>
        <br>
       
       
             <c:if test = "${BAND== 1 }">
                <c:url var="BlinkTemp" value="ControladorAlumnos">
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idAlumnos" value="${ALUMNO.idAlumnos}"></c:param>
                    <c:param name="idSalon" value="${SALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
                    <c:url var="BlinkTemp2" value="ControladorAlumnos">
                    <c:param name="instruccion" value="eliminar"></c:param>
                    <c:param name="idSalon" value="${SALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                    <c:param name="band" value="1"></c:param>
                    <c:param name="idAlumnos" value="${ALUMNO.idAlumnos}"></c:param>
                </c:url>
                
              <table class="blueTable" align="center">   
             <tr align="center">
            
            <td class="divtd">  Matricula  </td>
                <td class="divtd">  Nombre(s)  </td>
                <td class="divtd">  Apellido Paterno  </td>
                <td class="divtd">  Apellido Materno  </td>
                <td class="divtd">  CURP   </td>
                <td class="divtd">  Genero </td>
                <td class="divtd">  Nacionalidad</td>
                <td class="divtd">  Sangre</td>
                <td class="divtd">  Peso</td>
                <td class="divtd">  Estatura</td>
                <td class="divtd">  Documentos</td>
                <td class="divtd"> Direccion</td>
                <td class="divtd">  Nacimiento</td>
                <td class="divtd">  Salón</td> 
                         
                 </tr>
                 <tr align="center">
                
                <td> ${ALUMNO.idAlumnos}</td>
                <td> ${ALUMNO.nombreAlumno}</td>
                 <td> ${ALUMNO.apellidopaternoAlumno}</td>
                <td> ${ALUMNO.apellidomaternoAlumno}</td>
                <td> ${ALUMNO.CURP}</td>
                <td> ${ALUMNO.id_Genero}</td>
                 <c:if test = "${ALUMNO.id_Nacionalidad== 1 }">
                <td>MEXICANO</td>
                </c:if>
                <c:if test = "${ALUMNO.id_Nacionalidad== 2 }">
                <td>ESTADOUNIDENCE</td>
                </c:if>
                 <c:if test = "${ALUMNO.id_Tipo_de_Sangre== 1 }">
                <td>A+</td>
                </c:if>
                <c:if test = "${ALUMNO.id_Tipo_de_Sangre == 2 }">
                <td> A-</td>
                </c:if>
                <c:if test = "${ALUMNO.id_Tipo_de_Sangre == 3 }">
                <td> O+</td>
                </c:if>
                <c:if test = "${ALUMNO.id_Tipo_de_Sangre == 4 }">
                <td> O-</td>
                </c:if>
                <td> ${ALUMNO.peso}</td>
                <td> ${ALUMNO.estatura}</td>
                
                <c:if test = "${ALUMNO.id_Documentos_Entregados== 1 }">
                <td>Completado</td>
                </c:if>
                <c:if test = "${ALUMNO.id_Documentos_Entregados== 2 }">
                <td>Pendiente</td>
                </c:if>
                
                <td> ${ALUMNO.direccion}</td>
                <td> ${ALUMNO.nacimiento}</td>
                <td>${ALUMNO.idsalon}</td>
               
                <td> <a href="${BlinkTemp}">ACTUALIZAR</a></td>
                <td> <a href="${BlinkTemp2}">ELIMINAR</a></td>
                
            </tr>
                 
              </table>
                <br>
                <br>
        </c:if>
             <table class="blueTable" align="center">
            <tr align="center">
            
                
                <td class="divtd">  Matricula  </td>
                <td class="divtd">  Nombre(s)  </td>
                <td class="divtd">  Apellido Paterno  </td>
                <td class="divtd">  Apellido Materno  </td>
                <td class="divtd">  CURP   </td>
                <td class="divtd">  Genero </td>
                <td class="divtd">  Nacionalidad</td>
                <td class="divtd">  Sangre</td>
                <td class="divtd">  Peso</td>
                <td class="divtd">  Estatura</td>
                <td class="divtd">  Documentos</td>
                <td class="divtd"> Direccion</td>
                <td class="divtd">  Nacimiento</td>
                <td class="divtd">  Salón</td>
                
            </tr>
            
            <c:forEach var="temAlumno" items="${LISTAALUMNOS}">
                  <c:url var="linkTemp" value="ControladorAlumnos">
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idAlumnos" value="${temAlumno.idAlumnos}"></c:param>
                    <c:param name="idSalon" value="${SALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
                    <c:url var="linkTemp2" value="ControladorAlumnos">
                    <c:param name="instruccion" value="eliminar"></c:param>
                    <c:param name="idSalon" value="${SALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                    <c:param name="band" value="1"></c:param>
                    <c:param name="idAlumnos" value="${temAlumno.idAlumnos}"></c:param>
                </c:url>
                
                
                
            <tr align="center">
                
                <td> ${temAlumno.idAlumnos}</td>
                <td> ${temAlumno.nombreAlumno}</td>
                 <td> ${temAlumno.apellidopaternoAlumno}</td>
                <td> ${temAlumno.apellidomaternoAlumno}</td>
                <td> ${temAlumno.CURP}</td>
                <td> ${temAlumno.id_Genero}</td>
                 <c:if test = "${temAlumno.id_Nacionalidad== 1 }">
                <td>MEXICANO</td>
                </c:if>
                <c:if test = "${temAlumno.id_Nacionalidad== 2 }">
                <td>ESTADOUNIDENCE</td>
                </c:if>
                 <c:if test = "${temAlumno.id_Tipo_de_Sangre== 1 }">
                <td>A+</td>
                </c:if>
                <c:if test = "${temAlumno.id_Tipo_de_Sangre == 2 }">
                <td> A-</td>
                </c:if>
                <c:if test = "${temAlumno.id_Tipo_de_Sangre == 3 }">
                <td> O+</td>
                </c:if>
                <c:if test = "${temAlumno.id_Tipo_de_Sangre == 4 }">
                <td> O-</td>
                </c:if>
                <td> ${temAlumno.peso}</td>
                <td> ${temAlumno.estatura}</td>
                
                <c:if test = "${temAlumno.id_Documentos_Entregados== 1 }">
                <td>Completado</td>
                </c:if>
                <c:if test = "${temAlumno.id_Documentos_Entregados== 2 }">
                <td>Pendiente</td>
                </c:if>
                
                <td> ${temAlumno.direccion}</td>
                
             
                
              
          
                <td> ${temAlumno.nacimiento}</td>
                <td>${temAlumno.idsalon}</td>
               
                <td> <a href="${linkTemp}">ACTUALIZAR</a></td>
                <td> <a href="${linkTemp2}">ELIMINAR</a></td>
                
            </tr>
            </c:forEach>
        </table>
 
             <form name="form1" method="get" action="ControladorTutor">
            <input type="hidden" name="instruccion" value="listatutores">
                   <input type="hidden" name="idsalon" value="${SALON}">
                   <input type="hidden" name="correo" value="${CORREO}">
                   <input type="hidden" name="cla" value="${CLAVE}">
                   <input type="hidden" name="idmaestro" value="${IDMAESTRO}">       
                   <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                   <input type="hidden" name="band" value="1">
                   <td><br><input class="buttton" type="submit" name="envio" id="envio" value="Registrar Alumno"> 
             </form>
            
             <br>
         
                   
                    <form name="form3" method="post" action="ControladorMaestro">
                    <input type="hidden" name="instruccion" value="IniciarSesion">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="clave" value="${CLAVE}">
                    <input type="hidden" name="band" value="2">
                    <input type="submit" name="envio" id="envio" value="Regresar a Menú"> 
                    
                    </form>   
          
                
        
    </body>
</html>

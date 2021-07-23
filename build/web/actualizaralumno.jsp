
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Alumno</title>
        
        <link rel="stylesheet" href="css/actualizaralumno.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    </head>
    <body onload="Verificar()">
            <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
        <br>
        <h1 id="h1_act">Actualizar Información de Alumno </h1>
      
        <div align="center">
        
        <form name="form1" method="get" action="ControladorAlumnos">
            
            <input type="hidden" name="instruccion" value="actualizarBBDD">
            <input type="hidden" name="nacimiento" id="nacimiento" value="${AlumnoActualizar.nacimiento}">         
            <input type="hidden" name="ids" value="${AlumnoActualizar.idsalon}">      
            <input type="hidden" name="idAlumnos" id="idAlumnos" value="${AlumnoActualizar.idAlumnos}">
            <input type="hidden" type="text" name="idnivel" id="idnivel"  value="${AlumnoActualizar.id_Nivel}">
            <input type="hidden" type="text" name="idsalon" id="idsalon"  value="${AlumnoActualizar.idsalon}">          
           
            <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
            <input type="hidden" name="correo" value="${CORREO}">
            <input type="hidden" name="cla" value="${CLAVE}">
            <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                <input type="hidden" name="idSalon" value="${IDSALON}">
          
            
     
         
                   <table>                
                 <tr>
                    <td>Nombre: </td>
                    <td><label for="nombre"></label>
                <input type="text" name="nombre" id="nombre"  value="${AlumnoActualizar.nombreAlumno}"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Paterno: </td>
                    <td><label for="app"></label>
                <input type="text" name="app" id="app"  value="${AlumnoActualizar.apellidopaternoAlumno}"></td>
                </tr>
                
                
                 <tr>
                    <td>Apellido Materno: </td>
                    <td><label for="apm"></label>
                <input type="text" name="apm" id="apm"  value="${AlumnoActualizar.apellidomaternoAlumno}"></td>
                </tr>
                
                 <tr>
                    <td>CURP: </td>
                    <td><label for="curp"></label>
                <input type="text" name="curp" id="curp"  value="${AlumnoActualizar.CURP}"></td>
                </tr>
                
                 <c:set var = "genero" scope = "session" value = "${AlumnoActualizar.id_Genero}"/>
                 <c:if test = "${genero == 1 }">
                     <legend>GENERO:</legend>    
        
        <label>
            <input type="radio" name="gen" checked="true" value="1"> MASCULINO
        </label>
        <label>
            <input type="radio" name="gen" value="2"> FEMENINO
        </label>  
                     
               
                </c:if>
                   
                    <c:if test = "${genero == 2 }">
                   <legend>GENERO</legend>
        <label>
            <input type="radio" name="gen" value="1"> MASCULINO
        </label>
        <label>
            <input type="radio" name="gen" checked="true"  value="2"> FEMENINO
        </label>  
                     
               
                </c:if>
               
                 
                   
                 <tr>
                <td>Nacionalidad: </td>   
                 <c:set var = "Nac" scope = "session" value = "${AlumnoActualizar.id_Nacionalidad}"/>
                <td><label for="idNac"></label>
                    
                  
                    
                    <select class="styled-select" name="idNac">
                    <c:if test = "${Nac == 1 }">         
                <option value="1" checked="true">Mexico</option> 
                <option value="2">Estados Unidos</option> 
                    </c:if>
                
                 <c:if test = "${Nac == 2 }">         
                <option value="1" >Mexico</option> 
                <option value="2" cheked="true">Estados Unidos</option> 
                    </c:if>
               
               

                </select>
                        
                </tr>
                  <tr>
                    <td>Peso: </td>
                    <td><label for="peso"></label>
                <input type="text" name="peso" id="peso"  value="${AlumnoActualizar.peso}"></td>
                </tr>
                
                  <tr>
                    <td>Estatura: </td>
                    <td><label for="estatura"></label>
                <input type="text" name="estatura" id="estatura"  value="${AlumnoActualizar.estatura}"></td>
                </tr>
                
                <tr>
                    <td>Direccion: </td>
                    <td><label for="dir"></label>
                <input type="text" name="dir" id="dir"  value="${AlumnoActualizar.direccion}"></td>
                </tr>
                   
                 <tr>
                    <td>Tipo de Sangre: </td>
                    <td><label for="tsangre"></label>
                <input type="text" name="tsangre" id="tsangre"  value="${AlumnoActualizar.id_Tipo_de_Sangre}"></td>
                </tr>
                 <tr>
                    <td>Documentos entregados: </td>
                    <td><label for="doc"></label>
                <input type="text" name="doc" id="doc"  value="${AlumnoActualizar.id_Documentos_Entregados}"></td>
                </tr>
        
                  <tr>
                 
                    <td>Tutor: </td>    
                      <td><label for="tutor"></label>
                      <select class="styled-select" name="tutor">
                   <c:set var = "contador" scope = "session" value = "${1}"/>
                   <c:forEach var="temTutor" items="${TUTORES}">
                       <c:if test = "${AlumnoActualizar.id_Tutor != temTutor.idtutor }">                          
                   <option  value="${temTutor.idtutor}">${temTutor.nombre} ${temTutor.app}  </option>
                    <c:set var="contador" value="${contador + 1}" />
                     </c:if>
                    <c:if test = "${AlumnoActualizar.id_Tutor == temTutor.idtutor }">                          
                   <option  selected="true" value="${temTutor.idtutor}">${temTutor.nombre} ${temTutor.app}</option>
                    <c:set var="contador" value="${contador + 1}" />
                     </c:if>
                
                   </c:forEach> 
                    </select>
                      </td>
                       
           
                </tr>
                   </table> 
            
                     <td><input type="submit" name="envio" id="envio_1" value="ACTUALIZAR"> </td>
              
                    </form>  
           
     
                
                </div>
                   <div align="center">
                       
                  
                       <table>
                    <c:if test = "${IDPUESTO==3 }">
              
              
    
         
             <form name="form1" method="post" action="ControladorAlumnos">
            <input type="hidden" name="instruccion" value="listaAlumnos0">
            <input type="hidden" name="ids" value="999">
            <input type="hidden" name="idsalon" value="999">
            <input type="hidden" name="idpuesto" value="${IDPUESTO}">
            <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
            <input type="hidden" name="correo" value="${CORREO}">
            <input type="hidden" name="cla" value="${CLAVE}">
            
                    <td><input class="boton" type="submit" name="envio" id="envio" value="Regresar"> </td>
           </form>
          
         
                </c:if>
                        
                
                      <c:if test = "${IDPUESTO==2 }">
              
       
                  
            
           <form class="form" name="form1" method="get" action="ControladorAlumnos">
             <input type="hidden" name="instruccion" value="listar">
             <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idSalon" value="${IDSALON}">
          
             <td><input class="boton" type="submit" name="envio" id="envio" value="Regresar"> </td>
          
        </form>
          
         
                 
            
                </c:if>
                   
                   
               <c:if test = "${IDPUESTO==1 }">
                 <form  name="form1" method="post" action="ControladorAlumnos">
                    <input type="hidden" name="instruccion" value="listarxsalon">
                    <input type="hidden" name="idSalon" value="${IDSALON}">
                    <input type="hidden" name="ids" value="${IDSALON}">
                    <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="cla" value="${CLAVE}">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
                    
                    <td><input class="boton" type="submit" name="envio" id="envio" value="Regresar"> </td>
                   
            </form>  
                </c:if>
                    </table>
                       
                        </div>
    </body>
</html>

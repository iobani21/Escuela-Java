<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Alumnos</title>
           <script type="text/javascript">
function valida(f) {
  var ok = true;
  var msg = "Debes escribir algo en los campos:\n";
  if(f.elements["NAlumno"].value == "")
  {
    msg += "- nombre Vacio\n";
    ok = false;
  }
   if(f.elements["APP"].value == "")
  {
    msg += "- APP Vacio\n";
    ok = false;
  }
   if(f.elements["APM"].value == "")
  {
    msg += "- APM Vacio\n";
    ok = false;
  }
     if(f.elements["CURP"].value == "")
  {
    msg += "- CURP Vacio\n";
    ok = false;
  }

   if(f.elements["gen"].value == "")
  {
    msg += "- Genero Vacio\n";
    ok = false;
  }
    if(f.elements["Direccion"].value == "")
  {
    msg += "- Direccion Vacio\n";
    ok = false;
  }
     if(f.elements["Peso"].value == "")
  {
    msg += "- Peso Vacio\n";
    ok = false;
  }
     if(f.elements["Estatura"].value == "")
  {
    msg += "- Estatura Vacio\n";
    ok = false;
  }
  
    if(f.elements["fecha"].value == "")
  {
    msg += "- Fecha Vacio\n";
    ok = false;
  }

  if(ok == false)
    alert(msg);
  return ok;
}
</script>
        <link rel="stylesheet" href="css/insertaalumno.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    </head>
    
 <body onload="Verificar()">
      <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
        <div align="center">
        
            <div class="foo">
  <span class="letter" data-letter="R">R</span>
  <span class="letter" data-letter="E">E</span>
  <span class="letter" data-letter="G">G</span>
  <span class="letter" data-letter="I">I</span>
  <span class="letter" data-letter="S">S</span>
  <span class="letter" data-letter="T">T</span>
  <span class="letter" data-letter="R">R</span>
  <span class="letter" data-letter="A">A</span>
  <span class="letter" data-letter="R">R</span>  
</div>
        
        <form name="form1" method="post" action="ControladorAlumnos" onsubmit="return valida(this)">
            <input type="hidden" name="instruccion" value="insertarBBDD">
            <input type="hidden" name="idSalon" value="${IDSALON}">
            <input type="hidden" name="correo" value="${CORREO}">
            <input type="hidden" name="cla" value="${CLAVE}">
            <input type="hidden" name="idmaestro" value="${IDMAESTRO}">       
            <input type="hidden" name="idpuesto" value="${IDPUESTO}">
            <c:if test = "${BAND== 2 }">
            <input type="hidden" name="ids" value="0">   
            <input type="hidden" name="band" value="2">   
            </c:if>
            
            <table>
                <tr>
                    <td>Nombre(s) Alumno: </td>
                    <td><label for="NAlumno"></label>
                <input type="text" name="NAlumno" id="NAlumno"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Paterno: </td>
                    <td><label for="APP"></label>
                <input type="text" name="APP" id="APP"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Materno: </td>
                    <td><label for="APM"></label>
                <input type="text" name="APM" id="APM"></td>
                </tr>
                
                 <tr>
                    <td>CURP: </td>
                    <td><label for="CURP"></label>
                <input type="text" name="CURP" id="CURP"></td>
                </tr>
                
                <tr>
                 <td>Genero: </td>
                 <td><label for="gen"></label>
        <label>
            <input type="radio" name="gen" value="1"> MASCULINO
        </label>
        <label>
            <input type="radio" name="gen" value="2"> FEMENINO
        </label>
            </tr>
                  <tr>
                    <td>Direccion: </td>
                    <td><label for="direccion"></label>
                <input type="text" name="Direccion" id="Direccion"></td>
                </tr>
                
                 <tr>
                <td>Nacionalidad: </td>    
                <td><label for="Nacionalidad"></label>
                <select class="styled-select" name="Nacionalidad">
                <option value="1">Mexico</option> 
                <option value="2">Estados Unidos</option> 

                </select>
                </tr>
                      
                <tr>
                    <td>Tutor: </td>    
                      <td><label for="Tutor"></label>
                      <select class="styled-select" name="Tutor">
                   <c:set var = "contador" scope = "session" value = "${1}"/>
                   <c:forEach var="temTutor" items="${LISTATUTORES}">
                   <option value="${temTutor.idtutor}">${temTutor.nombre} ${temTutor.app}</option>
                    <c:set var="contador" value="${contador + 1}" />
                   </c:forEach> 
                    </select>
                      </td>
                       
            
                </tr>
                                  
                    <tr>
                    
                    <td>Tipo de Sangre: </td>    
                      <td><label for="TSangre"></label>
                      <select class="styled-select" name="TSangre" id="idparentesco">
                
                   <option value="1">A+</option>
                   <option value="2">A-</option>
                   <option value="3">O+</option>
                   <option value="4">O-</option>
                    </select>
                      </td>
                       
            
                </tr>
                
                 <tr>
                    <td>Peso: </td>
                    <td><label for="Peso"></label>
                <input type="text" name="Peso" id="Peso" class="styled-select"></td>
                </tr>
                
                 <tr>
                    <td>Estatura: </td>
                    <td><label for="Estatura"></label>
                <input type="text" name="Estatura" id="Estatura" class="styled-select"></td>
                </tr>
                
            
                
                 <tr>
                 
                     <td>Documentos: </td>    
                 
                <td><label for="Documentos"></label>
                <select class="styled-select" name="Documentos">
                <option value="1">Entregados</option> 
                <option value="2">Pendiente</option> 

                </select>
                </tr>
                
             
       
                
                <tr>
                    <td>Fecha de Nacimiento: </td>
                    <td><label for="fecha"></label>
                <input type="date" name="fecha" id="fecha" class="styled-select"></td>
                </tr>
            
                
            
                <c:if test = "${BAND== 1 }">
                    
             
                   <tr>
                    <td>Salon: </td>    
                      <td><label for="ids"></label>
                      <select class="styled-select" name="ids">
         
                       
                              
                               
                   <c:forEach var="temSalon" items="${SALONES}">
                   <option value="${temSalon.idsalon}">${temSalon.salon}</option>
                    <c:set var="contador" value="${contador + 1}" />
                   </c:forEach> 
                    </select>
                      </td>
                      <input type="hidden" name="band" value="1">   
                       </c:if>   
            
                </tr>
                 <tr>
                  
                     <td><input type="submit" name="envio" id="envio" value="REGISTRAR"> </td>               
                </form>
                   <c:if test = "${IDPUESTO== 2 }">
                       
       
             <form class="form" name="form1" method="get" action="ControladorAlumnos">
             <input type="hidden" name="instruccion" value="listar">
             <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idSalon" value="${IDSALON}">
          
             <td><input class="boton" type="submit" name="envio" id="envio_1" value="Regresar a lista de Alumnos"> </td>
             
        </form>
                         </c:if>
                   
                        <c:if test = "${IDPUESTO== 3 }">
                       
       
            <form name="form1" method="post" action="ControladorAlumnos">
            <input type="hidden" name="instruccion" value="listaAlumnos0">
            <input type="hidden" name="ids" value="${IDSALON}">
            <input type="hidden" name="idsalon" value="${IDSALON}">
            <input type="hidden" name="idpuesto" value="${IDPUESTO}">
            <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
            <input type="hidden" name="correo" value="${CORREO}">
            <input type="hidden" name="cla" value="${CLAVE}">
          
             <td><input class="boton" type="submit" name="envio" id="envio_1" value="Regresar"> </td>
             
        </form>
                         </c:if>
        </tr>
            </table>
                
                   
                   
                   
                   <div id="div_final">
                   
                  <c:url var="linkTemp" value="ControladorAlumnos">
                    <c:param name="instruccion" value="listar"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
                   
               
                       
                   <c:url var="linkTemp2" value="ControladorTutor">
                    <c:param name="instruccion" value="abrirformulario"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>           
                       
                   
                       
                       
                 <h1><a href="${linkTemp2}">SI EL TUTOR NO SE ENCUENTRA PUEDES DARLO DE ALTA AQUI!</a></h1>
                
                  
                  </div>
    
        </div>
        
        </body>
</html>

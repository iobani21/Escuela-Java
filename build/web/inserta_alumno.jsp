<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
     if(f.elements["tel"].value == "")
  {
    msg += "- TELEFONO Vacio\n";
    ok = false;
  }
     if(f.elements["gen"].value == "")
  {
    msg += "- Genero Vacio\n";
    ok = false;
  }
 
 
 
 
 
 
 


  if(ok == false)
    alert(msg);
  return ok;
}
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumnos</title>
    </head>
    <body onload="Verificar()">
            <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
        <h1>Nuevo Alumno </h1>
        <form name="form1" method="post" action="ControladorAlumnos" onsubmit="return valida(this)">
            <input type="hidden" name="instruccion" value="insertarBBDD">
            <input type="hidden" name="idSalon" value="${IDSALON}">
            <input type="hidden" name="correo" value="${CORREO}">
            <input type="hidden" name="cla" value="${CLAVE}">
            <input type="hidden" name="idmaestro" value="${IDMAESTRO}">       
            <input type="hidden" name="idpuesto" value="${IDPUESTO}">
            <table>
                <tr>
                    <td>Nombre Alumno</td>
                    <td><label for="NAlumno"></label>
                <input type="text" name="NAlumno" id="NAlumno"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Paterno</td>
                    <td><label for="APP"></label>
                <input type="text" name="APP" id="APP"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Materno</td>
                    <td><label for="APM"></label>
                <input type="text" name="APM" id="APM"></td>
                </tr>
                
                 <tr>
                    <td>CURP</td>
                    <td><label for="CURP"></label>
                <input type="text" name="CURP" id="CURP"></td>
                </tr>
                
                <tr>
                 <td>Genero</td>
                 <td><label for="gen"></label>
        <label>
            <input type="radio" name="gen" value="1"> MASCULINO
        </label>
        <label>
            <input type="radio" name="gen" value="2"> FEMENINO
        </label>
            </tr>
                  <tr>
                    <td>Direccion</td>
                    <td><label for="direccion"></label>
                <input type="text" name="Direccion" id="Direccion"></td>
                </tr>
                
                 <tr>
                <td>Nacionalidad</td>    
                <td><label for="Nacionalidad"></label>
                <select name="Nacionalidad">
                <option value="1">Mexico</option> 
                <option value="2">Estados Unidos</option> 

                </select>
                </tr>
                      
                <tr>
                    <td>Tutor</td>    
                      <td><label for="Tutor"></label>
                      <select name="Tutor">
                   <c:set var = "contador" scope = "session" value = "${1}"/>
                   <c:forEach var="temTutor" items="${LISTATUTORES}">
                   <option value="${contador}">${temTutor.nombre} ${temTutor.app}</option>
                    <c:set var="contador" value="${contador + 1}" />
                   </c:forEach> 
                    </select>
                      </td>
                       
            
                </tr>
                    
                
                     <tr>
                    <td>Tipo de Sangre</td>    
                      <td><label for="TSangre"></label>
                      <select name="TSangre" id="idparentesco">
                
                   <option value="1">A+</option>
                   <option value="2">A-</option>
                   <option value="3">O+</option>
                   <option value="4">O-</option>
                    </select>
                      </td>
                       
            
                </tr>
                
        
                
                 <tr>
                    <td>Peso</td>
                    <td><label for="Peso"></label>
                <input type="text" name="Peso" id="Peso"></td>
                </tr>
                
                 <tr>
                    <td>Estatura</td>
                    <td><label for="Estatura"></label>
                <input type="text" name="Estatura" id="Estatura"></td>
                </tr>
                
                 <tr>
                    <td>Documentos_ID</td>
                    <td><label for="Documentos"></label>
                <input type="text" name="Documentos" id="Documentos"></td>
                </tr>
                
             
       
                
                <tr>
                    <td>Fecha</td>
                    <td><label for="fecha"></label>
                <input type="text" name="fecha" id="fecha"></td>
                </tr>
                
                
                <tr>
                    <td>GRUPO/SALON</td>
                
              
                    <td><label for="ids"></label>
                <input type="text" name="ids" id="ids"></td>  
                 </tr>
                
                 <tr>
                     <td><input type="submit" name="envio" id="envio" value="Enviar"> </td>
                     
                        
                </tr>
               
            </table>
                 </form>
                    <form class="form" name="form1" method="get" action="ControladorAlumnos">
             <input type="hidden" name="instruccion" value="listar">
             <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idsalon" value="${IDSALON}">
          
             <td><input class="boton" type="submit" name="envio" id="envio_1" value="Regresar"> </td>
             
        </form>
                   <c:url var="linkTemp" value="ControladorAlumnos">
                    <c:param name="instruccion" value="listar"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url>
                   
                   <c:url var="linkTemp2" value="ControladorTutor">
                    <c:param name="instruccion" value="listar"></c:param>
                    <c:param name="idsalon" value="${IDSALON}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                </c:url> 
          
                     <h1><a href="${linkTemp}">SI EL TUTOR NO SE ENCUENTRA PUEDES DARLO DE ALTA AQUI!</a></h1>
               
    </body>
</html>

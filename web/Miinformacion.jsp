<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maestros</title>
        <link rel="stylesheet" href="css/miinformacion.css" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
        
    </head>
    
    <body onload="Verificar()">
            <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
        <h1 id="h1_act">Actualizar Informacion</h1>
        <form name="form1" method="post" action="ControladorMaestro">
            <input type="hidden" name="instruccion" value="actualizarBBDD">
            <input type="hidden" name="idMaestro" value="${MAESTRO.idmaestro}">
           
            <div align="center">
            <table align="center">
                <tr>
                    <td>Nombre: </td>
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
                <td>Puesto: </td>   
                 <c:set var = "idpu" scope = "session" value = "${MAESTRO.idpuesto}"/>
                <label for="iDpuesto"></label>
                <td> <select class="styled-select" name="iDpuesto">
                    <c:if test = "${idpu == 1 }">         
                <option value="1" checked="true">MAESTRO</option> 
                <option value="2">DIRECTOR</option>
                <option value="3">SECRETARIA(O)</option>
                    </c:if>
                
                 <c:if test = "${idpu == 2 }">         
                <option value="1" >MAESTRO</option> 
                <option value="2" cheked="true">DIRECTOR</option> 
                <option value="3" >SECRETARIA(O)</option> 
                    </c:if>
                
                 <c:if test = "${idpu == 3 }">         
                <option value="1" >MAESTRO</option> 
                <option value="2">DIRECTOR</option> 
                <option value="3" cheked="true">SECRETARIA(O)</option> 
                    </c:if>
               
               

                </select>
                </td>
                    </tr>
                
                
                
                <tr>
                    <td>Correo Electronico: </td>
                    <td><label for="correo"></label>
                <input type="text" name="correo" id="correo" value="${MAESTRO.correoelectronico}"></td>
                </tr>
                   
                 <tr>
                    <td>Telefono: </td>
                    <td><label for="tel"></label>
                <input type="text" name="tel" id="tel" value="${MAESTRO.telefono}"></td>
                </tr>
                
                
                <tr>
                    <td>Contraseña: </td>
                    <td><label for="Clave"></label>
                <input type="text" name="Clave" id="Clave" value="${MAESTRO.clave}"></td>
                </tr>
                
                 <tr>
                     <td><input type="submit" name="envio" id="envio" value="REGISTRAR"> </td>
                     <td><input type="submit" name="borrar" id="borrar" value="LIMPIAR"> </td>
               
                </tr>
                </form>
           
                    </table>
                
                                
            
    <tr>
        
            <form name="form2" method="post" action="ControladorMaestro">
                    <input type="hidden" name="instruccion" value="IniciarSesion">
                    <input type="hidden" name="correo" value="${MAESTRO.correoelectronico}">
                    <input type="hidden" name="clave" value="${MAESTRO.clave}">
                    <td><input type="submit" name="envio" id="envio_regresar" value="REGRESAR"></td>
            </form>   
    </tr>
                    
           </div> 
    </body>
</html>
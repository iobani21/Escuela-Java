
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tutores</title>
        <link rel="stylesheet" href="css/actualizartutor.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    </head>
    
    <body>
        
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
        
        <div align="center">
        
        <form name="form1" method="get" action="ControladorTutor">
            <input type="hidden" name="instruccion" value="actualizarBBDD">
             <input type="hidden" name="idTutor" value="${TUTOR.idtutor}">
             <input type="hidden" name="idParentesco" value="${TUTOR.idparentesco}">
        
            <input type="hidden" name="idsalon" value="${IDSALON}">
            <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
            <input type="hidden" name="correo" value="${CORREO}">
            <input type="hidden" name="cla" value="${CLAVE}">
            <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             
             
            <table>
                <tr>
                    <td>Nombre: </td>
                    <td><label for="Ntutor"></label>
                <input type="text" name="Ntutor" id="Ntutor" value="${TUTOR.nombre}"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Paterno: </td>
                    <td><label for="APP"></label>
                <input type="text" name="APP" id="APP" value="${TUTOR.app}"></td>
                </tr>
                
                 <tr>
                    <td>Apellido Materno: </td>
                    <td><label for="APM"></label>
                <input type="text" name="APM" id="APM" value="${TUTOR.apm}"></td>
                </tr>
               
            
                
           
                            
                
                   
                 <tr>
                    <td>Correo Electronico: </td>
                    <td><label for="corr"></label>
                <input type="text" name="corr" id="corr" value="${TUTOR.correo}"></td>
                </tr>
                
                
                   
                 <tr>
                    <td>Telefono: </td>
                    <td><label for="tel"></label>
                <input type="text" name="tel" id="tel" value="${TUTOR.telefono}"></td>
                </tr>
                   </table>
         
                <table>
                    <td><input type="submit" name="envio" id="envio" value="ACTUALIZAR"></td> 
                     
                </table>
            
             
                
                 
        </form>  
        
                <form>
                    
           
                   <form name="form2" method="get" action="ControladorTutor"> 
                    <input type="hidden" name="instruccion" value="listar">
                    <input type="hidden" name="idsalon" value="${IDSALON}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="cla" value="${CLAVE}">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">       
                    <input type="hidden" name="idpuesto" value="${IDPUESTO}">
                    <table>
                    <input type="submit" name="envio" id="envio_regresar" value="REGRESAR">
                    </table>
                    </form>
            </table> 
        </div>  
    </body>
</html>


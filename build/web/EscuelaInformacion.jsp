

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion</title>
        <link rel="stylesheet" href="css/escuelainformacion.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
    </head>
       <body onload="Verificar()">
            <script src="js/validacion.js" language="javascript" type="text/javascript"></script>
            <div class="foo">
                <span class="letter" data-letter="I">I</span>
                <span class="letter" data-letter="N">N</span>
                <span class="letter" data-letter="F">F</span>
                <span class="letter" data-letter="O">O</span>
                <span class="letter" data-letter="R">R</span>
                <span class="letter" data-letter="M">M</span>
                <span class="letter" data-letter="A">A</span>
                <span class="letter" data-letter="C">C</span>
                <span class="letter" data-letter="I">I</span>
                <span class="letter" data-letter="O">O</span>
                <span class="letter" data-letter="N">N</span>
            </div>
            <form name="form3" method="post" action="ControladorMaestro">
                <input type="hidden" name="instruccion" value="IniciarSesion">
                <input type="hidden" name="correo" value="${CORREO}">
                <input type="hidden" name="clave" value="${CLAVE}">                    
                <div align="center">
                    <input class="boton" type="submit" name="envio" id="envio" value="Regresar a Menú"> 
                </div>
            </form> 
        </body>
</html>

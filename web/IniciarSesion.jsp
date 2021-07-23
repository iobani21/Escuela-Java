<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Centenario de Juárez</title>
        <link rel="stylesheet" href="css/iniciarsesion.css?v=<?php echo(rand()); ?>" type="text/css">
        <link rel="icon" href="images/favicon_web.png" type="icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="js/IniciarSesion.js" language="javascript" type="text/javascript"></script>
        <script>            
            function nobackbutton(){    
                window.location.hash="no-back-button";
                window.location.hash="Again-No-back-button"; //chrome
                window.onhashchange=function(){window.location.hash="no-back-button";};}
        </script>
    </head>

     <body onload="cargar_pagina()">
         <c:if test = "${ERROR== 1 }">
            <script>            
            alert("USUARIO/CONTRASEÑA INCORRECTAS");
            </script>   
         </c:if>        
        <div class="contenedor">            
            <div class="foo">
            <span class="letter" data-letter="B">B</span>
            <span class="letter" data-letter="I">I</span>
            <span class="letter" data-letter="E">E</span>
            <span class="letter" data-letter="N">N</span>
            <span class="letter" data-letter="V">V</span>
            <span class="letter" data-letter="E">E</span>
            <span class="letter" data-letter="N">N</span>
            <span class="letter" data-letter="I">I</span>
            <span class="letter" data-letter="D">D</span>
            <span class="letter" data-letter="O">O</span>
            </div>
            
            <div class="form-box">                
                <div class="button-box">
                    <div id="elegir"></div>
                    <button type="button" class="toggle-btn" onclick="login()">Iniciar Sesión</button>
                    <button type="button" class="toggle-btn" onclick="informacion()">Información</button>                    
                </div>
                <img id="imagen" src="images/imagen_logotipo.png">                
                <form method="post" action="ControladorMaestro" id="login" class="input-group" >                    
                    <input type="hidden" name="instruccion" value="IniciarSesion">
                    <input type="hidden" name="band" value="1">
                        <tr>
                            <input type="text" class="input-field" id="correo" placeholder="Correo Electronico" name="correo">
                        </tr>                     
                        <tr>
                            <input type="password" class="input-field" id="clave" placeholder="Contraseña" name="clave"><br><br><br>
                        </tr>
                   
                        <tr>
                            <button type="submit" class="submit-btn" id="envio" name="envio" onclick="GuardarDat()">Acceder</button>
                        </tr>
                </form>                
                <form id="informacion" class="input-group">
                    <div align="center" id="div_info">
                        Sistema Web Desarrollado por:<br>
                        Iobani Peña & Omar Gomez.<br>
                        Version Beta.
                    </div>
                </form>
             <footer id="footer_"><br><br><br>Copyright © Todos los derechos reservados</footer>  
            </div>            
        </div>
    </body>
    
    <script>
        var x = document.getElementById("login");
        var y = document.getElementById("informacion"); 
        var z = document.getElementById("elegir");  

          function login(){
               x.style.left = "50px";
               y.style.left = "450px";
               z.style.left = "0px";
          }

          function informacion(){
               x.style.left = "-400px";
               y.style.left = "50px";
               z.style.left = "120px";
          }
    </script>
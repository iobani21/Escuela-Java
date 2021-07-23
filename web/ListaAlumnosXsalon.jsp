<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
 <script>
    window.onload = function() {
    init();
    doSomethingElse();
    };
</script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumnos por Salon</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"> 
        <link rel="icon" href="images/favicon_web.png" type="icon">
        <link rel="stylesheet" href="css/lista_alumnos_por_salon.css?v=<?php echo(rand()); ?>" type="text/css">    
     <c:if test = "${BAND== 3 }">
        <script>
            function load() {
            alert("No se encontro Alumno!");
            }
            window.onload = load;
        </script>
    </c:if>
    
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
             <input type="hidden" name="instruccion" value="Buscarlistarxsalon">          
             <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idSalon" value="${IDSALON}">
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
                <c:url var="linkTemp" value="ControladorAlumnos" >
                      <c:param name="instruccion" value="cargar"></c:param>
                      <c:param name="idAlumnos" value="${ALUMNO.idAlumnos}"></c:param>
                      <c:param name="idSalon" value="${IDSALON}"></c:param>
                      <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                      <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                      <c:param name="correo" value="${CORREO}"></c:param>
                      <c:param name="cla" value="${CLAVE}"></c:param>     
                </c:url>
                <c:url var="linkTemp2" value="ControladorAlumnos">
                    <c:param name="instruccion" value="QuitarDelSalon"></c:param>
                    <c:param name="idAlumnos" value="${ALUMNO.idAlumnos}"></c:param>
                    <c:param name="idSalon" value="${IDSALON}"></c:param>
                    <c:param name="ids" value="${IDS}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
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
             
                 <c:if test = "${IDPUESTO==1 }">
                 <td class="letras"> <a href="${linkTemp}">MODIFICAR</a></td>   
                 </c:if>             
                <td class="letras"> <a href="${linkTemp2}">QUITAR DEL SALON</a></td>  
            </tr>                 
            </table>
                <br>
                <br>
        </c:if>
        
        
        <table class="blueTable" >
            <tr>      
             <td class="letras">  Nombre Alumno  </td>
             <td class="letras">  Apellido Paterno   </td>
             <td class="letras">  Apellido Materno</td>         
            </tr>
            <c:forEach var="temAlumno" items="${LISTAALUMNOS}">
                    <c:url var="linkTemp" value="ControladorAlumnos" >
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="idAlumnos" value="${temAlumno.idAlumnos}"></c:param>
                      <c:param name="idSalon" value="${IDSALON}"></c:param>
                      <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                      <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                      <c:param name="correo" value="${CORREO}"></c:param>
                      <c:param name="cla" value="${CLAVE}"></c:param>
                    
                    
                    
                </c:url>
                    <c:url var="linkTemp2" value="ControladorAlumnos">
                    <c:param name="instruccion" value="QuitarDelSalon"></c:param>
                    <c:param name="idAlumnos" value="${temAlumno.idAlumnos}"></c:param>
                    <c:param name="idSalon" value="${IDSALON}"></c:param>
                    <c:param name="ids" value="${IDS}"></c:param>
                    <c:param name="idmaestro" value="${IDMAESTRO}"></c:param>
                    <c:param name="idpuesto" value="${IDPUESTO}"></c:param>
                    <c:param name="correo" value="${CORREO}"></c:param>
                    <c:param name="cla" value="${CLAVE}"></c:param>
                    </c:url>
                  
            
                
                
                
            <tr>            
                <td class="letras"> ${temAlumno.nombreAlumno}</td>
                <td class="letras"> ${temAlumno.apellidopaternoAlumno}</td>
                <td class="letras"> ${temAlumno.apellidomaternoAlumno}</td>              
                <c:if test = "${IDPUESTO==1 }">
                 <td class="letras"> <a href="${linkTemp}">MODIFICAR</a></td>   
                </c:if>         
                <td class="letras"> <a href="${linkTemp2}">QUITAR DEL SALON</a></td>  
            </tr>
        </c:forEach>
       </table>
                <table    
    <tr>
          
        <tr>
 
            <form name="form1" method="post" action="ControladorAlumnos">
            <input type="hidden" name="instruccion" value="listaAlumnos0">
            <input type="hidden" name="idSalon" value="${IDSALON}">
             <input type="hidden" name="ids" value="${IDS}">
            <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
            <input type="hidden" name="correo" value="${CORREO}">
            <input type="hidden" name="cla" value="${CLAVE}">
            <input type="hidden" name="idpuesto" value="${IDPUESTO}">
            <input class="boton"  type="submit" name="envio" id="envio" value="Agregar Alumno"> <br>
           </form>
        </tr> 
        
              <c:if test = "${IDSALON == IDS  }">
           <tr>
           <form name="form" method="get" action="ControladorSalon">
                    <input type="hidden" name="instruccion" value="CargarSalon">
                    <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
                    <input type="hidden" name="correo" value="${CORREO}">
                    <input type="hidden" name="cla" value="${CLAVE}">
                    <input type="hidden" name="idSalon" value="${IDSALON}">
                    <input type="hidden" name="idpuesto" value="${IDPUESTO}">
            <input class="boton" type="submit" name="envio" id="envio" value="Regresar a Lista">       
            </form>   
                    
                                        
                    
                    
           </tr>   </c:if>
              <c:if test = "${IDSALON != IDS  }">
           <tr>
          
           <form name="form13" method="get" action="ControladorSalon">
              <input type="hidden" name="correo" value="${CORREO}">
             <input type="hidden" name="cla" value="${CLAVE}">
             <input type="hidden" name="idmaestro" value="${IDMAESTRO}">
             <input type="hidden" name="idpuesto" value="${IDPUESTO}">
             <input type="hidden" name="idsalon" value="${IDS}">
             <input type="hidden" name="instruccion" value="listar">
             <input class="boton" type="submit" name="envio" id="envio" value="Lista de Salones"> 
             </form>
            
            </tr>   </c:if>
        </table>
    </body>
</html>


package Servelets_class;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "ControladorSalon", urlPatterns = {"/ControladorSalon"})
public class ControladorSalon extends HttpServlet {
   private static final long serialVersionUID=1L;

        private ModeloSalon modeloSalon;
        private ModeloMaestro modeloMaestro;
        private ModeloAlumnos modeloAlumnos;
        @Resource(name="jdbc/Alumnos")
        private DataSource miPool;

    @Override
    public void init() throws ServletException {
              super.init(); 
        try{
        modeloSalon=new ModeloSalon(miPool);
        modeloMaestro=new ModeloMaestro(miPool);
        modeloAlumnos=new ModeloAlumnos(miPool);
        }catch(Exception e){
            throw new ServletException(e);
        }
    }
    
   
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        
        // leer el parametro de la url 
        String elComando=request.getParameter("instruccion");
        //si no se envia un parametro listar productos
        if(elComando==null)
        {
            elComando="listar";
        }
        //redirigir el flujo al metodo adecuado
       
        switch (elComando){
              case "CargarSalon":    
             try {
          
                CargarSalon(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
               break;
            
            case "listar":    
               obtenerSalon(request, response);
               break;
          case "cargar":
        {
            try {
                cargarSalon(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
                break;
          case "Eliminar":
                try {
                CerrarSalon(request,response);
            } catch (Exception e) {
                  e.printStackTrace();
            }
                break;
        
        
        }
       
    }
    
    
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        
        // leer el parametro de la url 
        String elComando=request.getParameter("instruccion");
        
        //redirigir el flujo al metodo adecuado
       
        switch (elComando){
            
             case "MisSalones":    
               MisSalones(request, response);
               break;
               
            case "CargarSalon":    
             try {
          
                CargarSalon(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
               break;
               case "insertarBBDD":
                 CrearSalon(request,response);
                break;
                   
               case "Modificar":
                   try {
                ActualizarSalon(request,response);
            } catch (Exception e) {
                  e.printStackTrace();
            }
           
                break;
            default:
        {
            try {
                CargarSalon(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ControladorSalon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
       
    }
    
         private void CargarSalon(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
        //Leer el codigo rticulo que viene del listado
           int idsalon=Integer.parseInt(request.getParameter("idSalon"));
           int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));   
           int idpuesto=Integer.parseInt(request.getParameter("idpuesto")); 
           String correo=request.getParameter("correo");
           String clave=request.getParameter("cla");
           

           //Enviar c artiuclo a modelo
        Salon salon=modeloSalon.cargarsalon(idsalon);
        if(salon.getSalon()==null)
        {
            salon.setIdsalon(999);
        }
       
        //colocar atributo  correspondiente al CArticulo
        request.setAttribute("CORREO",correo);
        request.setAttribute("CLAVE",clave);
        request.setAttribute("IDMAESTRO",idmaestro);
          request.setAttribute("IDPUESTO",idpuesto);
         request.setAttribute("SALON",salon);
         
        //enviar producto al formulario de actualizar(jsp)
        RequestDispatcher dispatcher=request.getRequestDispatcher("/MiSalonProfesor.jsp");
        dispatcher.forward(request, response);
    
    }

         
          private void cargarSalon(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
        //Leer el codigo rticulo que viene del listado
   
           int idsalon=Integer.parseInt(request.getParameter("idsalon")); 
           int idpuesto=Integer.parseInt(request.getParameter("idpuesto")); 
           int ids=Integer.parseInt(request.getParameter("ids")); 
           String correo=request.getParameter("correo");
           int idm=Integer.parseInt(request.getParameter("idm")); 
           String clave=request.getParameter("cla");
           
          
           //Enviar c artiuclo a modelo
        Salon salon=modeloSalon.cargarsalon(idsalon);
        List<Maestro> maestros;
        maestros=modeloMaestro.getMaestros();
        //colocar atributo  correspondiente al CArticulo
        request.setAttribute("CORREO",correo);
        request.setAttribute("CLAVE",clave);
        request.setAttribute("IDPUESTO",idpuesto);
        request.setAttribute("IDM",idm);
        request.setAttribute("IDS",ids);
              
         request.setAttribute("IDMAESTRO",idsalon);
         request.setAttribute("SALON",salon);
         request.setAttribute("MAESTROS",maestros);
         
        //enviar producto al formulario de actualizar(jsp)
        RequestDispatcher dispatcher=request.getRequestDispatcher("/CargarSalon.jsp");
        dispatcher.forward(request, response);
    
    }
         
         
    private void obtenerSalon(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
            int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));   
            int idsalon=Integer.parseInt(request.getParameter("idsalon"));
           int idpuesto=Integer.parseInt(request.getParameter("idpuesto")); 
           String correo=request.getParameter("correo");
           String clave=request.getParameter("cla");
        List<SalonString> salon;
        try{
        salon=modeloSalon.getSalonString();
 
        //agregar lista de productos al request
        request.setAttribute("LISTASALON", salon); 
        request.setAttribute("CORREO",correo);
        request.setAttribute("CLAVE",clave);
        request.setAttribute("IDMAESTRO",idmaestro);
        request.setAttribute("IDPUESTO",idpuesto);
        request.setAttribute("IDSALON",idsalon);
    //enviar ese request a la pagina jsp
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/buscarsalones.jsp");
       
        miDispatcher.forward(request, response);
        
       
          
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
    
    private void MisSalones(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
            int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));   
           int idpuesto=Integer.parseInt(request.getParameter("idpuesto")); 
           String correo=request.getParameter("correo");
           String clave=request.getParameter("cla");
        List<SalonString> salon;
        try{
        salon=modeloSalon.getMisSalones(idmaestro);
 
        //agregar lista de productos al request
        request.setAttribute("LISTASALON", salon); 
        request.setAttribute("CORREO",correo);
        request.setAttribute("CLAVE",clave);
        request.setAttribute("IDMAESTRO",idmaestro);
        request.setAttribute("IDPUESTO",idpuesto);
        
    //enviar ese request a la pagina jsp
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/MisSalonesProfesor.jsp");
       
        miDispatcher.forward(request, response);
        
       
          
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
   
   
 
       
     private void CrearSalon(HttpServletRequest request, HttpServletResponse response) {
      //leer la informacion dle producto
      
      String salon=request.getParameter("Salon");
      int idmaestro=Integer.parseInt(request.getParameter("idm"));    
      int idhorario=Integer.parseInt(request.getParameter("idhorario"));   

      
       //Crear un objeto de tipo Producto
      
      Salon NuevoSalon=new Salon(idhorario,idmaestro,salon);
      
      //Enviar el objeto al modelo y insertar en la BBDD
      modeloSalon.agregarSalon(NuevoSalon);
      
      //listar la tabla
      
      obtenerSalon(request,response);

        
    }
     
     
       private void CerrarSalon(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
        //capturar el codigo articulo
        int idsalon=Integer.parseInt(request.getParameter("ids")); 
        //bborrar producto de la BD
       // modeloSalon.EliminarSalon(idsalon);
        modeloAlumnos.CerrarSalon(idsalon);
        
        //Listar de nuevo 
          obtenerSalon(request,response);
                   
    }
   

       
       
           private void ActualizarSalon(HttpServletRequest request, HttpServletResponse response) throws Exception{
      //leer los datos
       String salon=request.getParameter("Salon");
       int idm=Integer.parseInt(request.getParameter("idm"));
       int idhorario=Integer.parseInt(request.getParameter("idhorario"));
        int ids=Integer.parseInt(request.getParameter("ids"));
      
      
     
   
      //crear objeto tipo producto
     
       Salon SalonActualizado=new Salon(ids,idhorario,idm,salon);
      //Actualizar la BBDD 
     
       modeloSalon.actualizarSalon(SalonActualizado);
      //Listar la informacion actualizada
      
          obtenerSalon(request,response);
    }

   
}

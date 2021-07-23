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
import java.sql.SQLException;
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

@WebServlet(name = "ControladorTutor", urlPatterns = {"/ControladorTutor"})
public class ControladorTutor extends HttpServlet {
   private static final long serialVersionUID=1L;

        private ModeloTutor modeloTutor;
          private ModeloSalon modeloSalon;
          private ModeloAlumnos modeloAlumno;
        @Resource(name="jdbc/Alumnos")
        private DataSource miPool;

    @Override
    public void init() throws ServletException {
              super.init(); 
        try{
        modeloTutor=new ModeloTutor(miPool);
        modeloSalon=new ModeloSalon(miPool);
        modeloAlumno=new ModeloAlumnos(miPool);
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
               case "listar":    
               obtenerTutores(request, response);
               break;
                case "buscar":    
        {
            try {
                BuscarTutor(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorTutor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               break;
               case "insertarBBDD":
               insertarTutor(request,response);
               break;
               case "listatutores":
               obtenerTutores(request,response,elComando);
               break;
                  case "abrirformulario":
                 {
            try {
                abrir(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
               break;
                case "cargar":
        {
            try {
                cargarTutor(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
                break;    
                
                  case "actualizarBBDD":
        
           
            try {
                actualizarTutor(request,response);
            } catch (Exception e) {
                
                e.printStackTrace();
            
            }
            break;
            case "eliminar":
        {
            try {
                EliminarTutor(request,response);
            } catch (Exception ex) {
                Logger.getLogger(ControladorTutor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               break;
         default:
               obtenerTutores(request, response);
        }
       
             }

    private void obtenerTutores(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
  
        List<Tutor> tutores;
        try{
        tutores=modeloTutor.getTutores();
          int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
        
        //agregar lista de productos al request
        request.setAttribute("LISTATUTORES", tutores); 
        request.setAttribute("IDSALON", idsalon); 
        request.setAttribute("IDMAESTRO", idmaestro); 
        request.setAttribute("CORREO", correo);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("IDPUESTO", idpuesto); 
        request.setAttribute("BAND", 2); 
        
        //enviar ese request a la pagina jsp
     
       
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaTutores.jsp");
        miDispatcher.forward(request, response);
        
     
            
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
    
    
       private void abrir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //obtener la lista de productos desde el modelo
  
      
    
          int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
        
        //agregar lista de productos al request

        request.setAttribute("IDSALON", idsalon); 
        request.setAttribute("IDMAESTRO", idmaestro); 
        request.setAttribute("CORREO", correo);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("IDPUESTO", idpuesto); 
        
        //enviar ese request a la pagina jsp
     
       
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/inserta_tutor.jsp");
        miDispatcher.forward(request, response);
        
     
            
      
     
    }
    
        private void obtenerTutores(HttpServletRequest request, HttpServletResponse response,String comando) {
 //obtener la lista de productos desde el modelo
  
        List<Tutor> tutores;
        List<SalonString> salones;
        try{
        tutores=modeloTutor.getTutores();
        salones=modeloSalon.getSalonString();
        String salon=request.getParameter("salon");
          int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
          int band=Integer.parseInt(request.getParameter("band"));
 
        //agregar lista de productos al request
              request.setAttribute("SALONES", salones);
        request.setAttribute("SALON", salon);
        request.setAttribute("LISTATUTORES", tutores); 
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);  
        if(band==1)
        {
          request.setAttribute("BAND", 1);  
        }
        else
        {
            if(band==2)
            {
            request.setAttribute("BAND", 2);  
            }
        }
        //enviar ese request a la pagina jsp
     
       
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/insertaalumno.jsp");
        miDispatcher.forward(request, response);
        
     
            
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
    
    
    
    
    
    
       private void insertarTutor(HttpServletRequest request, HttpServletResponse response) {
      //leer la informacion dle producto
      
      String NomAlumno=request.getParameter("Ntutor");
      String APaterno=request.getParameter("APP");
      String AMaterno=request.getParameter("APM");
      int idparentesco=Integer.parseInt(request.getParameter("idparentesco"));    
      String correo=request.getParameter("corr");
      String telefono=request.getParameter("tel");

      
       //Crear un objeto de tipo Producto
      
      Tutor NuevoTutor=new Tutor(NomAlumno,APaterno,AMaterno,idparentesco,correo,telefono);
      
      //Enviar el objeto al modelo y insertar en la BBDD
      modeloTutor.agregarTutor(NuevoTutor);
      
      //listar la tabla
      
      obtenerTutores(request,response);

        
    }
    
    
    
    
       
        private void cargarTutor(HttpServletRequest request, HttpServletResponse response) throws Exception{
      
        //Leer el codigo rticulo que viene del listado
        String idTutor=request.getParameter("idTutor");
           
         int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
        //Enviar c artiuclo a modelo
        Tutor tutor=modeloTutor.getTutor(idTutor);
   
        //colocar atributo  correspondiente al CArticulo
        request.setAttribute("TUTOR",tutor);
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);  
        //enviar producto al formulario de actualizar(jsp)
        RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizartutor.jsp");
        dispatcher.forward(request, response);
    
    }
        
        
         private void actualizarTutor(HttpServletRequest request, HttpServletResponse response) throws Exception{
      //leer los datos
           
      
         int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
      

       int idtutor=Integer.parseInt(request.getParameter("idTutor"));
       int idparentesco=Integer.parseInt(request.getParameter("idParentesco"));
       String nombre=request.getParameter("Ntutor");
       String app=request.getParameter("APP");
       String apm=request.getParameter("APM");
       String corr=request.getParameter("corr");
       String telefono=request.getParameter("tel");
      //crear objeto tipo producto
    
       Tutor TutorActualizado=new Tutor(idtutor,nombre,app,apm,idparentesco,corr,telefono);
      //Actualizar la BBDD 
     
       modeloTutor.actualizarTutor(TutorActualizado);
      //Listar la informacion actualizada
        obtenerTutores(request, response);
    }
     
     
  private void BuscarTutor(HttpServletRequest request, HttpServletResponse response) throws SQLException {
 //obtener la lista de productos desde el modelo
         String nom=request.getParameter("nom");
         String app=request.getParameter("app");
         String apm=request.getParameter("apm");
         Tutor tutor=modeloTutor.getTutor(nom,app,apm);
        List<Tutor> tutores;
        try{
        tutores=modeloTutor.getTutores();
          int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
        
        //agregar lista de productos al request
        request.setAttribute("TUTOR", tutor); 
        request.setAttribute("LISTATUTORES", tutores); 
        request.setAttribute("IDSALON", idsalon); 
        request.setAttribute("IDMAESTRO", idmaestro); 
        request.setAttribute("CORREO", correo);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("IDPUESTO", idpuesto); 
        if(tutor!=null)
        {
        request.setAttribute("BAND", 1);
        }
        else
        {
        request.setAttribute("BAND", 3);  
        }
        
        //enviar ese request a la pagina jsp
     
       
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaTutores.jsp");
        miDispatcher.forward(request, response);
        
     
            
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
  
  
  
        private void EliminarTutor(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
        

          int tutor=Integer.parseInt(request.getParameter("idTutor"));     
          modeloAlumno.CambiarTutor(tutor);
          modeloTutor.EliminarTutor(tutor);
         obtenerTutores(request, response);
        }
    
       

   


   
}

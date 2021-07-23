
package Servelets_class;

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

@WebServlet(name = "ControladorAlumnos", urlPatterns = {"/ControladorAlumnos"})
public class ControladorAlumnos extends HttpServlet {
   private static final long serialVersionUID=1L;

        private ModeloAlumnos modeloAlumnos;
        private ModeloTutor modeloTutor;
        @Resource(name="jdbc/Alumnos")
        private DataSource miPool;

    @Override
    public void init() throws ServletException {
              super.init(); 
        try{
        modeloAlumnos=new ModeloAlumnos(miPool);
        modeloTutor=new ModeloTutor(miPool);
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
               obtenerAlumnos(request, response);
               break;
            case "insertarBBDD":
        
                agregarAlumno(request,response);
                break;
            default:
            obtenerAlumnos(request, response);
            break;
            case "listarxsalon":
                listarxsalon(request,response);
                break;
            case "Buscarlistarxsalon":
        {
            try {
                Buscarlistarxsalon(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
               case "cargar":
        {
            try {
                cargarAlumnos(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
                break;    
                
                 case "actualizarBBDD":
        {
         
            try {
                actualizarAlumno(request,response);
            } catch (Exception e) {
                  e.printStackTrace();
            }
            break;
        }
               case "eliminar":
                try {
                eliminarAlumno(request,response);
            } catch (Exception e) {
                  e.printStackTrace();
            }
                break;
       
                 case "QuitarDelSalon": 
             
        {
            try {
                QuitarDelsalon(request,response);
            } catch (Exception ex) {
                Logger.getLogger(ControladorAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
                    break;
                 case "AgregarAlSalon": 
             
        {
            try {
                AgregarAlSalon(request,response);
            } catch (Exception ex) {
                Logger.getLogger(ControladorAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
                    break;
                     case "Buscar":    
                    BuscarAlumno(request, response);
                    break;
                     case "buscarAlumnoSN":
        {
            try {
                BAlumnos0(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                     break;
        }
        
       
    }
    
    
    
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
             
        // leer el parametro de la url 
        String elComando=request.getParameter("instruccion");
        System.out.println(elComando);
        //si no se envia un parametro listar productos
   
        //redirigir el flujo al metodo adecuado
       
        switch (elComando){
            case "insertarBBDD":
                agregarAlumno(request,response);
                break;
                case "listarxsalon":
                listarxsalon(request,response);
                break; 
                case "ListaTutoresXsalon":
                    listaTutoresXsalon(request,response);
                    break;
                case  "listaAlumnos0":
                   Alumnos0(request,response);
               break;
               
      
        
        }
       
    }
    
    
     private void listaTutoresXsalon(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
         
          int idsalon=Integer.parseInt(request.getParameter("idSalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
           String correo=request.getParameter("correo");
           String clave=request.getParameter("clave");
       int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
        List<TutorxAlumno> TA;
        try{
        TA=modeloAlumnos.getAlumnosTutoresxsalon(idsalon);
 
        //agregar lista de productos al request
          request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("TA", TA); 
        request.setAttribute("SALON",idsalon);
        request.setAttribute("IDMAESTRO",idmaestro); 
        //enviar ese request a la pagina jsp
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaTutoresxAlumnos.jsp");
       
        miDispatcher.forward(request, response);
        
       
          
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
    
    
    
    
    

    private void obtenerAlumnos(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
  
        List<AlumnosString> alumnos;
        try{
        alumnos=modeloAlumnos.getAlumnos();
         int idsalon=Integer.parseInt(request.getParameter("idSalon"));
         int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
         int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
        String correo=request.getParameter("correo");
        String clave=request.getParameter("cla"); 
      
        //agregar lista de productos al request
        request.setAttribute("LISTAALUMNOS", alumnos); 
        request.setAttribute("SALON", idsalon); 
        request.setAttribute("IDMAESTRO", idmaestro); 
        request.setAttribute("CORREO", correo);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("BAND", 0);
        //enviar ese request a la pagina jsp
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaAlumnos.jsp");
       
        miDispatcher.forward(request, response);
        
       
          
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
    
       private void Alumnos0(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
  
        List<Alumnos> alumnos;
        try{
          int idsalon=Integer.parseInt(request.getParameter("idSalon"));
          int ids=Integer.parseInt(request.getParameter("ids"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
        String correo=request.getParameter("correo");
        String clave=request.getParameter("cla"); 
     
        alumnos=modeloAlumnos.getAlumnosxsalon(idsalon,0);
 
        //agregar lista de productos al request
        request.setAttribute("LISTAALUMNOS", alumnos); 
        request.setAttribute("IDSALON", idsalon); 
          request.setAttribute("IDS", ids); 
        request.setAttribute("IDMAESTRO", idmaestro); 
        request.setAttribute("CORREO", correo);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("IDPUESTO", idpuesto);
        //enviar ese request a la pagina jsp
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaAlumnos0.jsp");
       
        miDispatcher.forward(request, response);
        
       
          
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
    
     private void BAlumnos0(HttpServletRequest request, HttpServletResponse response) throws SQLException {
 //obtener la lista de productos desde el modelo
    
       String nom=request.getParameter("nom");
       String app=request.getParameter("app");
       String apm=request.getParameter("apm");
    
       Alumnos alumno=modeloAlumnos.getAlumno(nom,app,apm,0);
       List<Alumnos> alumnos;
        try{
          int idsalon=Integer.parseInt(request.getParameter("idsalon")); 
          int ids=Integer.parseInt(request.getParameter("ids"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
        String correo=request.getParameter("correo");
        String clave=request.getParameter("cla"); 
     
        alumnos=modeloAlumnos.getAlumnosxsalon(idsalon,0);
 
        //agregar lista de productos al request
        request.setAttribute("ALUMNO", alumno); 
        request.setAttribute("LISTAALUMNOS", alumnos); 
        request.setAttribute("IDSALON", idsalon); 
          request.setAttribute("IDS", ids); 
        request.setAttribute("IDMAESTRO", idmaestro); 
        request.setAttribute("CORREO", correo);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("IDPUESTO", idpuesto);
        //enviar ese request a la pagina jsp
         if(alumno!=null)
        {
        request.setAttribute("BAND", 1);
        }
        else
        {
        request.setAttribute("BAND", 3);  
        }
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaAlumnos0.jsp");
       
        miDispatcher.forward(request, response);
        
       
          
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
    
    
    
       private void listarxsalon(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
       
          int idsalon=Integer.parseInt(request.getParameter("idSalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          int ids=Integer.parseInt(request.getParameter("ids"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");

            List<AlumnosString> alumnos;
        try{
        alumnos=modeloAlumnos.getAlumnosxsalon(idsalon);
       
       
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("IDS", ids);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("LISTAALUMNOS", alumnos);    
              
          
      
          

      
  

   
          

       
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaAlumnosXsalon.jsp");
       
        miDispatcher.forward(request, response);
        
       
          
      
        }catch (Exception e){
        //agregar lista de productos al request
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
   
          
        //enviar ese request a la pagina jsp
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/IniciarSesion.jsp");
            
            
         e.printStackTrace();
        }    
    
    }
    
    


 
       private void agregarAlumno(HttpServletRequest request, HttpServletResponse response) {
      //leer la informacion dle producto
      
      String NomAlumno=request.getParameter("NAlumno");
      String APaterno=request.getParameter("APP");
      String AMaterno=request.getParameter("APM");
      String CURP=request.getParameter("CURP");
      int Gen=Integer.parseInt(request.getParameter("gen"));
      int Nacionalidad=Integer.parseInt(request.getParameter("Nacionalidad"));
      int TSangre=Integer.parseInt(request.getParameter("TSangre"));
      double Peso=Double.parseDouble(request.getParameter("Peso"));
      double Estatura=Double.parseDouble(request.getParameter("Estatura"));
      int id_Documentos=Integer.parseInt(request.getParameter("Documentos"));
       String Direccion=request.getParameter("Direccion");
      int id_Nivel=Integer.parseInt(request.getParameter("ids"));
      int id_Tutor=Integer.parseInt(request.getParameter("Tutor"));
      SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
      Date Fecha=null;
      
      try{
          Fecha=formatoFecha.parse(request.getParameter("fecha"));
      }catch (ParseException e){
          e.printStackTrace();
      }
       int idsalon=Integer.parseInt(request.getParameter("ids"));
       int band=Integer.parseInt(request.getParameter("band"));
       //Crear un objeto de tipo Producto
      
      Alumnos NuevoAlumno=new Alumnos(NomAlumno,APaterno,AMaterno,CURP,Gen,Nacionalidad,TSangre,Peso,Estatura,
      id_Documentos,Direccion,id_Nivel,id_Tutor,Fecha,idsalon);
  
      //Enviar el objeto al modelo y insertar en la BBDD
      modeloAlumnos.agregarAlumno(NuevoAlumno);
      
      //listar la tabla
      if(band==1)
      {
      obtenerAlumnos(request,response);     
      }
      else
      {
      if(band==2)
      {       
      Alumnos0(request,response);   
      }
      }
     

        
    }

   
    private void cargarAlumnos(HttpServletRequest request, HttpServletResponse response) throws Exception{
       List<Tutor> tutores;
        tutores=modeloTutor.getTutores();
        //Leer el codigo rticulo que viene del listado
        String idAlumno=request.getParameter("idAlumnos");
          int idsalon=Integer.parseInt(request.getParameter("idSalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
        //Enviar c artiuclo a modelo
        Alumnos alumno=modeloAlumnos.getAlumno(idAlumno);
   
        //colocar atributo  correspondiente al CArticulo
        
           request.setAttribute("IDSALON", idsalon);
            request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("TUTORES", tutores); 
        request.setAttribute("AlumnoActualizar",alumno);
        //enviar producto al formulario de actualizar(jsp)
        RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizaralumno.jsp");
        dispatcher.forward(request, response);
    
    }
    
    
    
    
     private void actualizarAlumno(HttpServletRequest request, HttpServletResponse response) throws Exception{
      //leer los datos
      
          //int idsalon=Integer.parseInt(request.getParameter("idSalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
      
      
      
      int idalumno=Integer.parseInt(request.getParameter("idAlumnos"));
      String nombre=request.getParameter("nombre");
      String app=request.getParameter("app");
      String apm=request.getParameter("apm");
      String curp=request.getParameter("curp"); 
      int genero=Integer.parseInt(request.getParameter("gen"));
      int idnac=Integer.parseInt(request.getParameter("idNac"));
      int tsangre=Integer.parseInt(request.getParameter("tsangre"));
      double peso=Double.parseDouble(request.getParameter("peso"));
      double estatura=Double.parseDouble(request.getParameter("estatura"));           
      int doc=Integer.parseInt(request.getParameter("doc"));
       String dir=request.getParameter("dir");
       int idnivel=Integer.parseInt(request.getParameter("idnivel"));
       int iDsalon=Integer.parseInt(request.getParameter("ids"));      
       int idtutor=Integer.parseInt(request.getParameter("tutor"));
  
       SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
      Date Fecha=null;
      
      try{
          Fecha=formatoFecha.parse(request.getParameter("nacimiento"));
      }catch (ParseException e){
          e.printStackTrace();
      }
      
      
      
     
   
      //crear objeto tipo producto
     
       Alumnos AlumnoActualizado=new Alumnos(idalumno,nombre,app,apm,curp,genero,idnac,tsangre,peso,estatura,doc,dir,idnivel,idtutor,Fecha,iDsalon);
      //Actualizar la BBDD 
     
       modeloAlumnos.actualizarAlumno(AlumnoActualizado);
      //Listar la informacion actualizada
      
           if(idpuesto==1)
           {
               listarxsalon(request,response);
           
           }
           
           else
           {
                 if(idpuesto==3)
           {
               Alumnos0(request,response);
           }
                 else
                     
                 {
                      if(idpuesto==2)
           {
               obtenerAlumnos(request,response);
           }  
                 }
           }
       
        
   
    }
     
     
        private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
        //capturar el codigo articulo
           
          int band=Integer.parseInt(request.getParameter("band"));
          String idAlumno=request.getParameter("idAlumnos");
        //bborrar producto de la BD
          modeloAlumnos.eliminarAlumno(idAlumno);
        //Listar de nuevo 
          if(band==1)
          {
          obtenerAlumnos(request,response);      
          }
          else
          {
              if(band==2)
              {
               Alumnos0(request,response);   
              }
          }
        
                   
    }


  
        
        private void QuitarDelsalon(HttpServletRequest request, HttpServletResponse response) throws Exception {
      //leer los datos
        
            int idalumno=Integer.parseInt(request.getParameter("idAlumnos"));
            int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
           String correo=request.getParameter("correo");
           String clave=request.getParameter("cla");
      //crear objeto tipo producto
     
       
      //Actualizar la BBDD 
     
       modeloAlumnos.QuitarDelSalon(idalumno,0);
      listarxsalon(request,response);
      
    }
        
              private void AgregarAlSalon(HttpServletRequest request, HttpServletResponse response) throws Exception {
      //leer los datos
        
            int idalumno=Integer.parseInt(request.getParameter("idAlumnos"));
            int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
            int idsalon=Integer.parseInt(request.getParameter("idSalon"));
            String correo=request.getParameter("correo");
            String clave=request.getParameter("cla");
    
       
      //Actualizar la BBDD 
     
       modeloAlumnos.QuitarDelSalon(idalumno,idsalon);
      listarxsalon(request,response);
      
    }
              
               private void BuscarAlumno(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
        String idAlumno=request.getParameter("matricula");
        Alumnos alumno=modeloAlumnos.getAlumno(idAlumno);
        List<AlumnosString> alumnos;
        try{
        alumnos=modeloAlumnos.getAlumnos();
         int idsalon=Integer.parseInt(request.getParameter("idsalon"));
         int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
         int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
        String correo=request.getParameter("correo");
        String clave=request.getParameter("cla"); 
      
        //agregar lista de productos al request
        request.setAttribute("LISTAALUMNOS", alumnos); 
        request.setAttribute("SALON", idsalon); 
        request.setAttribute("IDMAESTRO", idmaestro); 
        request.setAttribute("CORREO", correo);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("ALUMNO", alumno);
        if(alumno!=null)
        {
        request.setAttribute("BAND", 1);
        }
        else
        {
        request.setAttribute("BAND", 3);  
        }
//enviar ese request a la pagina jsp
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaAlumnos.jsp");
       
        miDispatcher.forward(request, response);
        
       
          
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
               
        private void Buscarlistarxsalon(HttpServletRequest request, HttpServletResponse response) throws SQLException {
 //obtener la lista de productos desde el modelo
       
          int idsalon=Integer.parseInt(request.getParameter("idSalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          int ids=Integer.parseInt(request.getParameter("ids"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");

       String nom=request.getParameter("nom");
       String app=request.getParameter("app");
       String apm=request.getParameter("apm");
        Alumnos alumno=modeloAlumnos.getAlumno(nom,app,apm,idsalon);
          
          List<AlumnosString> alumnos;
        try{
        alumnos=modeloAlumnos.getAlumnosxsalon(idsalon);
       
       
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("IDS", ids);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("LISTAALUMNOS", alumnos);    
        request.setAttribute("ALUMNO", alumno);          
              
            
        if(alumno!=null)
        {
        request.setAttribute("BAND", 1);
        }
        else
        {
        request.setAttribute("BAND", 3);  
        }
               
        //agregar lista de productos al request

   
          
        //enviar ese request a la pagina jsp
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaAlumnosXsalon.jsp");
       
        miDispatcher.forward(request, response);
        
       
          
      
        }catch (Exception e){
        //agregar lista de productos al request
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
   
          
        //enviar ese request a la pagina jsp
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/IniciarSesion.jsp");
            
            
         e.printStackTrace();
        }    
    
    }
             
               
        
        
}

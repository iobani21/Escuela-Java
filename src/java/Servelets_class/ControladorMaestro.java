
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
import java.security.MessageDigest;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.apache.tomcat.util.codec.binary.Base64;

@WebServlet(name = "ControladorMaestro", urlPatterns = {"/ControladorMaestro"})
public class ControladorMaestro extends HttpServlet {
   private static final long serialVersionUID=1L;
        private ModeloSalon modeloSalon;
        private ModeloMaestro modeloMaestro;
        @Resource(name="jdbc/Alumnos")
        private DataSource miPool;
        
  
    @Override
    public void init() throws ServletException {
              super.init(); 
        try{
        modeloMaestro=new ModeloMaestro(miPool);
       modeloSalon=new ModeloSalon(miPool);
        }catch(Exception e){
            throw new ServletException(e);
        }
    }
    
    
     
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        
        String elComando=request.getParameter("instruccion");
    
        if(elComando==null)
        {
            elComando="listar";
        }
        //redirigir el flujo al metodo adecuado
       
        switch (elComando){
       
               
                case "insertarBBDD":
               insertarMaestro(request,response);
               break;
               
                case "IniciarSesion":
                    try {
            
                iniciarSesion(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
                break;
             
                case "Miinformacion":
                      try {
                  Miinformacion(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
                  
                    break;
                    
                      case "actualizarBBDD":
                  
                      {
          
            try {
             
                actualizarProfesor(request,response);
            } catch (Exception e) {
                  e.printStackTrace();
            }
            break;
        }   
                       case "actualizarinf":
                  
                      {
          
            try {
             
                actualizarinf(request,response);
            } catch (Exception e) {
                  e.printStackTrace();
            }
            break;
        }   
                      case "crear":
                          crear(request,response);
                          break;
                          
                          
                           case "ListaMaestros":
                          ListaMaestros(request,response);
                          break;
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
           
           case "Perfil":
                      try {
                  Miinformacion(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
                  
                    break;   
               case "listar":    
               obtenerMaestros(request, response);
               break;
                case "buscar":    
        {
            try {
                BuscarMaestro(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMaestro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               break;
                  case "inf":    
               inf(request, response);
               break;
                    
        case "cargar":       
        
            try {
            
                cargarMaestro(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
        
                break; 
                
                
                case "cargarperfil":       
        
            try {
            
                cargarperfil(request,response);
            } catch (Exception e) {
               e.printStackTrace();
            }
        
                break; 
        case "eliminar":
                try {
                eliminarMaestro(request,response);
            } catch (Exception e) {
                  e.printStackTrace();
            }
                break;
        
        }
        

    }
    
        private void obtenerMaestros(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
  
        List<Maestro> maestros;
        try{
        maestros=modeloMaestro.getMaestros();
          int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
        
        
        //agregar lista de productos al request
        request.setAttribute("LISTAMAESTROS", maestros); 
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
        request.setAttribute("BAND", 2);
        //enviar ese request a la pagina jsp
     
       
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaMaestros.jsp");
        miDispatcher.forward(request, response);
       
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
        
         private void ListaMaestros(HttpServletRequest request, HttpServletResponse response) {
 //obtener la lista de productos desde el modelo
  
        List<Maestro> maestros;
        try{
        maestros=modeloMaestro.getListaMaestros();
          int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
        
        
        //agregar lista de productos al request
        request.setAttribute("LISTAMAESTROS", maestros); 
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
        //enviar ese request a la pagina jsp
     
       
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/insertar_salon.jsp");
        miDispatcher.forward(request, response);
       
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }
        
        
        
        private void insertarMaestro(HttpServletRequest request, HttpServletResponse response) {
      //leer la informacion dle producto
      String secretKey="ProyectoWeb";
      String NomAlumno=request.getParameter("Nmaestro");
      String APaterno=request.getParameter("APP");
      String AMaterno=request.getParameter("APM");
      int idpu=Integer.parseInt(request.getParameter("idpu")); 
      String rfc=request.getParameter("rfc");
      String dir=request.getParameter("direccion");
      String correo=request.getParameter("corr");
      String telefono=request.getParameter("tel");
      String clave=request.getParameter("clave");
      
       //Crear un objeto de tipo Producto
        String cadenaEncriptada=ecnode(secretKey,clave);
      Maestro NuevoMaestro=new Maestro(NomAlumno,APaterno,AMaterno,idpu,rfc,dir,correo,telefono,cadenaEncriptada);
      
      //Enviar el objeto al modelo y insertar en la BBDD
      modeloMaestro.agregarMaestro(NuevoMaestro);
      
      //listar la tabla
      
      obtenerMaestros(request,response);

        
    }
        
         private void cargarMaestro(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
        //Leer el codigo rticulo que viene del listado
        String idma=request.getParameter("idma");
        int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
        //Enviar c artiuclo a modelo
        Maestro maestro=modeloMaestro.getMaestro(idma);

        //colocar atributo  correspondiente al CArticulo
        request.setAttribute("MAESTRO",maestro);
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
        //enviar producto al formulario de actualizar(jsp)
        RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarmaestro.jsp");
        dispatcher.forward(request, response);
    
    }
         
          private void cargarperfil(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
        //Leer el codigo rticulo que viene del listado
        String idma=request.getParameter("idma");
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
          
        //Enviar c artiuclo a modelo
        Maestro maestro=modeloMaestro.getMaestro(idma);
        
      
        request.setAttribute("MAESTRO",maestro);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
        
        RequestDispatcher dispatcher=request.getRequestDispatcher("/MiinformacionEditar.jsp");
        dispatcher.forward(request, response);
    
    }
         
         
              private void Miinformacion(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
        //Leer el codigo rticulo que viene del listado
        
        String idmaestro=request.getParameter("idmaestro");
        String nombre=request.getParameter("nom");
        String clave=request.getParameter("cla");
        //Enviar c artiuclo a modelo
        Maestro maestro=modeloMaestro.getMaestro(idmaestro);

  
        request.setAttribute("MAESTRO",maestro);
        request.setAttribute("NOMBRE",nombre);
        request.setAttribute("CLAVE",clave);
        //enviar producto al formulario de actualizar(jsp)
        RequestDispatcher dispatcher=request.getRequestDispatcher("/Miinformacion.jsp");
        dispatcher.forward(request, response);
    
    }
         
            private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
                 
       int band=Integer.parseInt(request.getParameter("band"));
         if(band==1)
         {
        //Leer el codigo rticulo que viene del listado
        
        String correo=request.getParameter("correo");
        String clave=request.getParameter("clave");
        
       
        //Enviar c artiuclo a modelo
        Maestro maestro=modeloMaestro.getValidarMaestro(correo,clave);
     
        //colocar atributo  correspondiente al CArticulo
        
        //HttpSession session=request.getSession();  
        //session.setAttribute("MAESTRO",maestro); 
        
        
      
        request.setAttribute("MAESTRO", maestro);
        //enviar producto al formulario de actualizar(jsp)
      
        if(maestro.getIdpuesto()==1)//MAESTROS
        {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/indexMaestro.jsp");
        dispatcher.forward(request, response);      
        }
        
         if(maestro.getIdpuesto()==2)//DIRECCION
        {
             
        RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);      
        }
         
          if(maestro.getIdpuesto()==3)//SECRATARIA
        {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/indexSecretaria.jsp");
        dispatcher.forward(request, response);      
        }
        
        if(maestro.getIdpuesto()==0)
        {
         request.setAttribute("ERROR",1);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/IniciarSesion.jsp");
        dispatcher.forward(request, response);          
        }
           
       }
         else
         {
               if(band==2)
         {
        //Leer el codigo rticulo que viene del listado
        String secretKey="ProyectoWeb";
        String correo=request.getParameter("correo");
        String clave=request.getParameter("clave");
        String cadenaDesEncriptada=decnode(secretKey,clave);  
       
        //Enviar c artiuclo a modelo
        Maestro maestro=modeloMaestro.getValidarMaestro(correo,cadenaDesEncriptada);
     
        //colocar atributo  correspondiente al CArticulo
        
        //HttpSession session=request.getSession();  
        //session.setAttribute("MAESTRO",maestro); 
        
        
      
        request.setAttribute("MAESTRO", maestro);
        //enviar producto al formulario de actualizar(jsp)
      
        if(maestro.getIdpuesto()==1)//MAESTROS
        {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/indexMaestro.jsp");
        dispatcher.forward(request, response);      
        }
        
         if(maestro.getIdpuesto()==2)//DIRECCION
        {
             
        RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);      
        }
         
          if(maestro.getIdpuesto()==3)//SECRATARIA
        {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/indexSecretaria.jsp");
        dispatcher.forward(request, response);      
        }
        
        if(maestro.getIdpuesto()==0)
        {
         request.setAttribute("ERROR",1);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/IniciarSesion.jsp");
        dispatcher.forward(request, response);   
            
        }
           
       } 
         }
                
                
        
    
    }
    
 
            private void actualizarProfesor(HttpServletRequest request, HttpServletResponse response) throws Exception{
      //leer los datos

      int idma=Integer.parseInt(request.getParameter("idma"));
      String nombre=request.getParameter("Nombre");
      String app=request.getParameter("APP");
       
      String apm=request.getParameter("APM");
      String rfc=request.getParameter("rfc"); 
      String direccion=request.getParameter("direccion"); 
          
      int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
       int idpu=Integer.parseInt(request.getParameter("idpu"));
       String corr=request.getParameter("corr"); 
       String tel=request.getParameter("tel"); 
       String clave=request.getParameter("clave");
           
       String secretKey="ProyectoWeb";    
       String cadenaEncriptada=ecnode(secretKey,clave);
  

      //crear objeto tipo producto
     
       Maestro MaestroActualizado=new Maestro(idma,nombre,app,apm,idpu,rfc,direccion,corr,tel,cadenaEncriptada);
      //Actualizar la BBDD 
     
       modeloMaestro.actualizarMaestro(MaestroActualizado);
      //Listar la informacion actualizada
           obtenerMaestros(request,response);
      
    
       

    }
            
            private void actualizarinf(HttpServletRequest request, HttpServletResponse response) throws Exception{
      //leer los datos

      int idma=Integer.parseInt(request.getParameter("idma"));
      String nombre=request.getParameter("Nombre");
      String app=request.getParameter("APP");   
      String apm=request.getParameter("APM");
      String rfc=request.getParameter("rfc"); 
      String direccion=request.getParameter("direccion"); 
          
      int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
       int idpu=Integer.parseInt(request.getParameter("idpu"));
       String corr=request.getParameter("correo"); 
       String tel=request.getParameter("tel"); 
       String clave=request.getParameter("clave");   
       String secretKey="ProyectoWeb";    
       String cadenaEncriptada=ecnode(secretKey,clave);
     
      //crear objeto tipo producto
     
       Maestro MaestroActualizado=new Maestro(idma,nombre,app,apm,idpu,rfc,direccion,corr,tel,cadenaEncriptada);
      //Actualizar la BBDD 
     
       modeloMaestro.actualizarMaestro(MaestroActualizado);
      //Listar la informacion actualizada
           iniciarSesion(request,response);
      
  
      
    
       

    }

    private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
              
          
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
        
          RequestDispatcher miDispatcher=request.getRequestDispatcher("/inserta_maestro.jsp");
        miDispatcher.forward(request, response);
        
    }
    
    
      private void inf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
              
          
       
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
        
          RequestDispatcher miDispatcher=request.getRequestDispatcher("/EscuelaInformacion.jsp");
        miDispatcher.forward(request, response);
        
    }
      
      
        private void eliminarMaestro(HttpServletRequest request, HttpServletResponse response) throws Exception{
     
        
          String idmaestro=request.getParameter("idma");
          int idma=Integer.parseInt(request.getParameter("idma"));     
          modeloSalon.QuitarMaestro(idma);
          modeloMaestro.eliminarMaestro(idmaestro);          
          obtenerMaestros(request,response);
                   
    }
        
        
         public String  ecnode(String secretKey,String cadena){
     String encriptacion = "";
     try{
         MessageDigest md5 =MessageDigest.getInstance("MD5");
         byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
         byte[] BytesKey =Arrays.copyOf(llavePassword, 24);
         SecretKey key = new SecretKeySpec(BytesKey,"DESede");
         Cipher cifrado = Cipher.getInstance("DESede");
         cifrado.init(Cipher.ENCRYPT_MODE, key);
         
         byte[] plainTextBytes =cadena.getBytes("utf-8");
         byte[]  buf = cifrado.doFinal(plainTextBytes);
         byte[] base64Bytes =Base64.encodeBase64(buf);
         encriptacion= new String(base64Bytes);
     }catch(Exception ex){
         System.out.println("Error de encriptado");
     }
     return encriptacion;
    }

    public String decnode (String secretKey,String cadenaEncriptada){
       String desencriptacion = "";   
    
       try{
           byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
           MessageDigest md5=MessageDigest.getInstance("MD5");
           byte[] digestOfPassword =md5.digest(secretKey.getBytes("utf-8"));
           byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
           SecretKey key= new SecretKeySpec(keyBytes,"DESede");
           Cipher decipher = Cipher.getInstance("DESede");
           decipher.init(Cipher.DECRYPT_MODE,key);
           byte[] plainText = decipher.doFinal(message);
           desencriptacion = new String(plainText,"UTF-8");
       
       }catch(Exception ex){
         System.out.println("Error de encriptado");
     }       
       return desencriptacion;
    }
       
       
    
  private void BuscarMaestro(HttpServletRequest request, HttpServletResponse response) throws SQLException {
 //obtener la lista de productos desde el modelo
     String nom=request.getParameter("nom");
     String app=request.getParameter("app");
     String apm=request.getParameter("apm");
      Maestro maestro=modeloMaestro.getMaestro(nom,app,apm);

        List<Maestro> maestros;
        try{
        maestros=modeloMaestro.getMaestros();
          int idsalon=Integer.parseInt(request.getParameter("idsalon"));
          int idmaestro=Integer.parseInt(request.getParameter("idmaestro"));
          int idpuesto=Integer.parseInt(request.getParameter("idpuesto"));
          String correo=request.getParameter("correo");
          String clave=request.getParameter("cla");
        
        
        //agregar lista de productos al request
        request.setAttribute("LISTAMAESTROS", maestros); 
        request.setAttribute("IDSALON", idsalon);
        request.setAttribute("IDPUESTO", idpuesto);
        request.setAttribute("CORREO", correo);
        request.setAttribute("IDMAESTRO", idmaestro);
        request.setAttribute("CLAVE", clave);
         request.setAttribute("MAESTRO", maestro); 
          if(maestro!=null)
        {
        request.setAttribute("BAND", 1);
        }
        else
        {
        request.setAttribute("BAND", 3);  
        }
        //enviar ese request a la pagina jsp
     
       
        RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaMaestros.jsp");
        miDispatcher.forward(request, response);
       
      
        }catch (Exception e){
            
         e.printStackTrace();
        }    
    
    }      

}
    
    
 
        
        
        
     
        
        
        

 
       
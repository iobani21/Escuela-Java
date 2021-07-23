
package Servelets_class;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.sql.DataSource;
import org.apache.tomcat.util.codec.binary.Base64;


public class ModeloMaestro {

private  DataSource origenDatos; 
public ModeloMaestro(DataSource origenDatos){
    this.origenDatos=origenDatos;
    
}

public   Maestro getMaestro(String idmaestro) throws SQLException {
          
     Maestro elMaestro=null;
     Connection miConexion=null;
     PreparedStatement miStatement=null;
     ResultSet miResultset=null;
     String idMaestro=idmaestro;

    
     try{
    //establecer la bbdd
     miConexion=origenDatos.getConnection();
     
     
     //crear sql que busque elproducto
     
     String sql="SELECT * FROM maestros WHERE idmaestro=?";
     //crear consulta
     miStatement=miConexion.prepareStatement(sql);
     //establecer los parametros
     miStatement.setString(1, idMaestro);
     //ejecutar consultar
     miResultset=miStatement.executeQuery();
      
     //obtener datos de respuesta
     if(miResultset.next())
       {
       
         int iDmaestro=miResultset.getInt(1);
        String nombre=miResultset.getString(2);
        String apellidopaterno=miResultset.getString(3);
        String apellidomaterno=miResultset.getString(4);
        int idpuesto=miResultset.getInt(5);
        String rfc=miResultset.getString(6);
        String direccion=miResultset.getString(7);
        String correoelectronico=miResultset.getString(8);
        String telefono=miResultset.getString(9);
        String clave=miResultset.getString(10);
        
         String secretKey="ProyectoWeb";
         String cadenaDesEncriptada=decnode(secretKey,clave);  
        elMaestro=new Maestro(iDmaestro,nombre,apellidopaterno,apellidomaterno,idpuesto,rfc,direccion,correoelectronico,telefono,cadenaDesEncriptada);
       
 
     }else{
         throw new Exception("Error al encontrar el maestro");
         
     }
     
     
     }catch (Exception e){
       System.err.println("Got an exception!jjjjjjjjjjjjjjjjj");
      System.err.println(e.getMessage());
     }
          miConexion.close();
         miStatement.close();
         miResultset.close();
     return elMaestro;
    }





public   Maestro getValidarMaestro(String correo,String cla) throws SQLException{
     Maestro elMaestro=new Maestro(0,null,null,null,0,null,null,null,null,null);
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT * FROM maestros";
    miStatement=miConexion.createStatement();
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
        
          String secretKey="ProyectoWeb";
          String cadenaDesEncriptada=decnode(secretKey,miResultset.getString(10));  
         if(cadenaDesEncriptada.equals(cla) && correo.equals(miResultset.getString(8)))
         {
        int idmaestro=miResultset.getInt(1);
        String nombre=miResultset.getString(2);
        String apellidopaterno=miResultset.getString(3);
        String apellidomaterno=miResultset.getString(4);
        int idpuesto=miResultset.getInt(5);
        String rfc=miResultset.getString(6);
        String direccion=miResultset.getString(7);
        String correoelectronico=miResultset.getString(8);
        String telefono=miResultset.getString(9);
        String clave=miResultset.getString(10); 
        Maestro temMaestro=new Maestro(idmaestro,nombre,apellidopaterno,apellidomaterno,idpuesto,rfc,direccion,correoelectronico,telefono,clave);
     miConexion.close();
     miStatement.close();
     miResultset.close();  
     return temMaestro;
         }
    }

miConexion.close();
     miStatement.close();
     miResultset.close();
 return elMaestro;   
}




public List<Maestro> getMaestros() throws Exception {
    List<Maestro> Maestros =new ArrayList<>();
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT * FROM maestros";
    miStatement=miConexion.createStatement();
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
        int idmaestro=miResultset.getInt(1);
        String nombre=miResultset.getString(2);
        String apellidopaterno=miResultset.getString(3);
        String apellidomaterno=miResultset.getString(4);
        int idpuesto=miResultset.getInt(5);
        String rfc=miResultset.getString(6);
        String direccion=miResultset.getString(7);
        String correoelectronico=miResultset.getString(8);
        String telefono=miResultset.getString(9);
        String clave=miResultset.getString(10);

        Maestro temMaestro=new Maestro(idmaestro,nombre,apellidopaterno,apellidomaterno,idpuesto,rfc,direccion,correoelectronico,telefono,clave);
        Maestros.add(temMaestro);
    }
     miConexion.close();
     miStatement.close();
     miResultset.close();

 return Maestros;   
}

void agregarMaestro(Maestro nuevoMaestro) {
       //obtener la conexion
       
       Connection miConexion=null;
       PreparedStatement miStatement=null;
       //crear la instruccion sql
       try{
           miConexion=origenDatos.getConnection();
       
       //sql
      //NOTAespecificar todos los campos 
       String sql="INSERT INTO maestros(nombre,apellidopaterno,apellidomaterno,idpuesto,rfc,direccion,correoelectronico,telefono,clave)"
               + "VALUES(?,?,?,?,?,?,?,?,?)";
      
       miStatement=miConexion.prepareStatement(sql);
       //establecer los parametros

        miStatement.setString(1,nuevoMaestro.getNombre());
        miStatement.setString(2,nuevoMaestro.apellidopaterno);
        miStatement.setString(3,nuevoMaestro.getApellidomaterno());
        miStatement.setInt(4,nuevoMaestro.getIdpuesto());
        miStatement.setString(5,nuevoMaestro.getRfc());
        miStatement.setString(6,nuevoMaestro.getDireccion());
        miStatement.setString(7,nuevoMaestro.getCorreoelectronico());
        miStatement.setString(8,nuevoMaestro.getTelefono());
        miStatement.setString(9,nuevoMaestro.getClave());
       //ejecutar la instruccion sql
       miStatement.execute();
       miConexion.close();
       miStatement.close();
       
       
       }catch(Exception e ){
        System.err.println("Got an exception");
      System.err.println(e.getMessage());
       }
       
    }

 void actualizarMaestro(Maestro MaestroActualizado) throws Exception{
      //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
      

      //crear sentencia SQL
       
      miConexion=origenDatos.getConnection();
      
      //consulta preparada
      
     
      String sql="UPDATE maestros SET nombre=?,apellidopaterno=?,apellidomaterno=?,idpuesto=?,rfc=?,direccion=?,correoelectronico=?,telefono=?,clave=?"+
              " WHERE idmaestro=?";
              miStatement=miConexion.prepareStatement(sql);
      //establecer los parametros
      
       miStatement.setInt(10, MaestroActualizado.getIdmaestro());
      miStatement.setString(1, MaestroActualizado.getNombre());
      miStatement.setString(2, MaestroActualizado.getApellidopaterno());
      miStatement.setString(3, MaestroActualizado.getApellidomaterno());
      miStatement.setInt(4, MaestroActualizado.getIdpuesto());
      miStatement.setString(5, MaestroActualizado.getRfc());
       miStatement.setString(6, MaestroActualizado.getDireccion());
        miStatement.setString(7, MaestroActualizado.getCorreoelectronico());
         miStatement.setString(8, MaestroActualizado.getTelefono());
          miStatement.setString(9, MaestroActualizado.getClave());
                      
      
     
     

      //ejecutar la instrucccionsqp
      miStatement.execute();
  
       
          miConexion.close();
         miStatement.close();
       
      }


 public List<Maestro> getListaMaestros() throws Exception {
    List<Maestro> Maestros =new ArrayList<>();
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT * FROM maestros  Where maestros.idpuesto=1";
    miStatement=miConexion.createStatement();
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
        int idmaestro=miResultset.getInt(1);
        String nombre=miResultset.getString(2);
        String apellidopaterno=miResultset.getString(3);
        String apellidomaterno=miResultset.getString(4);
        int idpuesto=miResultset.getInt(5);
        String rfc=miResultset.getString(6);
        String direccion=miResultset.getString(7);
        String correoelectronico=miResultset.getString(8);
        String telefono=miResultset.getString(9);
        String clave=miResultset.getString(10);

        Maestro temMaestro=new Maestro(idmaestro,nombre,apellidopaterno,apellidomaterno,idpuesto,rfc,direccion,correoelectronico,telefono,clave);
        Maestros.add(temMaestro);
    }
     miConexion.close();
     miStatement.close();
     miResultset.close();

 return Maestros;   
}
 
 
      void eliminarMaestro(String idmaestro ) throws Exception{
      
        //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
         miConexion=origenDatos.getConnection();
        //crear la instruccion sql
        String sql="DELETE FROM  maestros WHERE idmaestro=?";
        //preparar la consulta
          miStatement=miConexion.prepareStatement(sql);
        //establecer parametros del ?
         miStatement.setString(1, idmaestro);
        //ejecutar sentencia sql
        miStatement.execute();
        
         miConexion.close();
         miStatement.close();
     
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
     
       
       public   Maestro getMaestro(String nom , String app, String apm) throws SQLException {
          
     Maestro elMaestro=null;
     Connection miConexion=null;
     PreparedStatement miStatement=null;
     ResultSet miResultset=null;
     

    
     try{
    //establecer la bbdd
     miConexion=origenDatos.getConnection();
     
     
     //crear sql que busque elproducto
     
     String sql="SELECT * FROM maestros WHERE nombre=? and apellidopaterno=? and apellidomaterno=?";
     //crear consulta
     miStatement=miConexion.prepareStatement(sql);
     //establecer los parametros
     miStatement.setString(1, nom);
     miStatement.setString(2, app);
     miStatement.setString(3, apm);
     //ejecutar consultar
     miResultset=miStatement.executeQuery();
      
     //obtener datos de respuesta
     if(miResultset.next())
       {
       
         int iDmaestro=miResultset.getInt(1);
        String nombre=miResultset.getString(2);
        String apellidopaterno=miResultset.getString(3);
        String apellidomaterno=miResultset.getString(4);
        int idpuesto=miResultset.getInt(5);
        String rfc=miResultset.getString(6);
        String direccion=miResultset.getString(7);
        String correoelectronico=miResultset.getString(8);
        String telefono=miResultset.getString(9);
        String clave=miResultset.getString(10);
        
         String secretKey="ProyectoWeb";
         String cadenaDesEncriptada=decnode(secretKey,clave);  
        elMaestro=new Maestro(iDmaestro,nombre,apellidopaterno,apellidomaterno,idpuesto,rfc,direccion,correoelectronico,telefono,cadenaDesEncriptada);
     
     }else{
         throw new Exception("Error al encontrar el maestro");
         
     }
     
     
     }catch (Exception e){
       System.err.println("Got an exception!");
      System.err.println(e.getMessage());
     }
    
         miConexion.close();
         miStatement.close();
         miResultset.close();
     return elMaestro;
    }

 
}

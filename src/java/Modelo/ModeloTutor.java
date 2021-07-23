
package Servelets_class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;


public class ModeloTutor {

private  DataSource origenDatos; 
public ModeloTutor(DataSource origenDatos){
    this.origenDatos=origenDatos;
    
}

public List<Tutor> getTutores() throws Exception {
    List<Tutor> tutores =new ArrayList<>();
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT * FROM tutor";
    miStatement=miConexion.createStatement();
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
        int idtutor=miResultset.getInt(1);
        String nombretutor=miResultset.getString(2);
        String apellidopaterno=miResultset.getString(3);
        String apellidomaterno=miResultset.getString(4);
        int idparentesco=miResultset.getInt(5);
        String correoelectronico=miResultset.getString(6);
        String telefono=miResultset.getString(7);
      

        Tutor temTutor=new Tutor(idtutor,nombretutor,apellidopaterno,apellidomaterno,idparentesco,correoelectronico,telefono);
        tutores.add(temTutor);
    }
     miConexion.close();
     miStatement.close();
     miResultset.close();
 return tutores;   
}


void agregarTutor(Tutor nuevoTutor) {
       //obtener la conexion
  
       Connection miConexion=null;
       PreparedStatement miStatement=null;
       //crear la instruccion sql
       try{
           miConexion=origenDatos.getConnection();
       
       //sql
      //NOTAespecificar todos los campos 
       String sql="INSERT INTO tutor(nombre,apellidopaterno,apellidomaterno,idparentesco,correoelectronico,telefono)"
               + "VALUES(?,?,?,?,?,?)";
      
       miStatement=miConexion.prepareStatement(sql);
       //establecer los parametros

        miStatement.setString(1,nuevoTutor.getNombre());
        miStatement.setString(2,nuevoTutor.getApp());
        miStatement.setString(3,nuevoTutor.getApp());
        miStatement.setInt(4,nuevoTutor.getIdparentesco());
        miStatement.setString(5,nuevoTutor.getCorreo());
        miStatement.setString(6,nuevoTutor.getTelefono());
       //ejecutar la instruccion sql
       miStatement.execute();
        miConexion.close();
         miStatement.close();
       
       
       }catch(Exception e ){
        System.err.println("Got an exception!jjjjjjjjjjjjjjjjj");
      System.err.println(e.getMessage());
       }
       
    }

public   Tutor getTutor(String idtutor) {
          
     Tutor elTutor=null;
     Connection miConexion=null;
     PreparedStatement miStatement=null;
     ResultSet miResultset=null;
     String idTutor=idtutor;

    
     try{
    //establecer la bbdd
     miConexion=origenDatos.getConnection();
     
     
     //crear sql que busque elproducto
     
     String sql="SELECT * FROM tutor WHERE idtutor=?";
     //crear consulta
     miStatement=miConexion.prepareStatement(sql);
     //establecer los parametros
     miStatement.setString(1, idTutor);
     //ejecutar consultar
     miResultset=miStatement.executeQuery();
     
     //obtener datos de respuesta
     if(miResultset.next())
       {
         
        int iDTutor=miResultset.getInt(1);
        String nombre=miResultset.getString(2);
        String apellidopaterno=miResultset.getString(3);
        String apellidomaterno=miResultset.getString(4);
        int parentesco=miResultset.getInt(5);  
        String correo=miResultset.getString(6);
        String telefono=miResultset.getString(7);
      
      
   
        elTutor=new Tutor(iDTutor,nombre,apellidopaterno,apellidomaterno,parentesco,correo,telefono);
          
         miConexion.close();
         miStatement.close();
         miResultset.close();
     }else{
         throw new Exception("Error al encontrar el tutor");
         
     }
     
     
     }catch (Exception e){
       System.err.println("Got an exception!jjjjjjjjjjjjjjjjj");
      System.err.println(e.getMessage());
     }
     return elTutor;
    }




public   Tutor getTutor(String nom,String app, String apm) throws SQLException {
          
     Tutor elTutor=null;
     Connection miConexion=null;
     PreparedStatement miStatement=null;
     ResultSet miResultset=null;
     

    
     try{
    //establecer la bbdd
     miConexion=origenDatos.getConnection();
     
     
     //crear sql que busque elproducto
     
     String sql="SELECT * FROM tutor WHERE nombre=? and apellidopaterno=? and apellidomaterno=?";
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
         
        int iDTutor=miResultset.getInt(1);
        String nombre=miResultset.getString(2);
        String apellidopaterno=miResultset.getString(3);
        String apellidomaterno=miResultset.getString(4);
        int parentesco=miResultset.getInt(5);  
        String correo=miResultset.getString(6);
        String telefono=miResultset.getString(7);
      
      
   
        elTutor=new Tutor(iDTutor,nombre,apellidopaterno,apellidomaterno,parentesco,correo,telefono);
          
 
     }else{
         throw new Exception("Error al encontrar el tutor");
         
     }
     
     
     }catch (Exception e){
       System.err.println("Got an exception!");
      System.err.println(e.getMessage());
     }
     
         miConexion.close();
         miStatement.close();
         miResultset.close();
         return elTutor;
    }


void actualizarTutor(Tutor TutorActualizado) throws Exception{
      //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
      

      //crear sentencia SQL
       
      miConexion=origenDatos.getConnection();
      
      //consulta preparada
      
      
      String sql="UPDATE tutor SET nombre=?, apellidopaterno=?, apellidomaterno=?, "+
              "idparentesco=?, correoelectronico=?, telefono=? WHERE idtutor=? ";
              
              miStatement=miConexion.prepareStatement(sql);
      //establecer los parametros
      
       miStatement.setInt(7, TutorActualizado.getIdtutor());
      miStatement.setString(1, TutorActualizado.getNombre());
      miStatement.setString(2, TutorActualizado.getApp());
      miStatement.setString(3, TutorActualizado.getApm());
      miStatement.setInt(4, TutorActualizado.getIdparentesco());
      miStatement.setString(5, TutorActualizado.getCorreo());
     miStatement.setString(6, TutorActualizado.getTelefono());

      //ejecutar la instrucccionsqp
      miStatement.execute();
  
       
          miConexion.close();
         miStatement.close();
       
      }
      


 
      void EliminarTutor(int  idtutor ) throws Exception{
      
        //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
         miConexion=origenDatos.getConnection();
        //crear la instruccion sql
        String sql="DELETE FROM  tutor WHERE idtutor=?";
        //preparar la consulta
          miStatement=miConexion.prepareStatement(sql);
        //establecer parametros del ?
         miStatement.setInt(1, idtutor);
        //ejecutar sentencia sql
        miStatement.execute();
        
         miConexion.close();
         miStatement.close();
     
    }



 
    }

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


public class ModeloSalon {

private  DataSource origenDatos; 
public ModeloSalon(DataSource origenDatos){
    this.origenDatos=origenDatos;
    
}

public List<SalonString> getSalonString() throws Exception {
    List<SalonString> salon =new ArrayList<>();
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT idsalon,horario,nombre,salon FROM SALON INNER JOIN horario ON SALON.id_horario=horario.idhorario INNER JOIN maestros ON SALON.id_profesor=maestros.idmaestro";
    miStatement=miConexion.createStatement();
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
        int idsalon=miResultset.getInt(1);
        String idhorario=miResultset.getString(2);
        String idprofesor=miResultset.getString(3);
        String Salon=miResultset.getString(4);
       
        SalonString temSalon=new SalonString(idsalon,idhorario,idprofesor,Salon);
        
        salon.add(temSalon);
    }
     miConexion.close();
     miStatement.close();
     miResultset.close();
 return salon;   
 
 
 
}

public List<SalonString> getMisSalones(int idp) throws Exception {
    List<SalonString> salon =new ArrayList<>();
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT idsalon,horario,nombre,salon FROM SALON INNER JOIN horario ON SALON.id_horario=horario.idhorario INNER JOIN maestros ON SALON.id_profesor=maestros.idmaestro WHERE id_profesor="+idp;
    miStatement=miConexion.createStatement();
   
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
        int idsalon=miResultset.getInt(1);
        String idhorario=miResultset.getString(2);
        String idprofesor=miResultset.getString(3);
        String Salon=miResultset.getString(4);
       
        SalonString temSalon=new SalonString(idsalon,idhorario,idprofesor,Salon);
        salon.add(temSalon);
    }
     miConexion.close();
     miStatement.close();
     miResultset.close();
 return salon;   
 
 
 
}




public   Salon CargarSalon(int idmaestro) throws SQLException {
          
     Salon elSalon=null;
     Connection miConexion=null;
     PreparedStatement miStatement=null;
     ResultSet miResultset=null;
     int  iDMaestro=idmaestro;
    
    
     try{
    //establecer la bbdd
     miConexion=origenDatos.getConnection();
     
     
     //crear sql que busque elproducto
     
     String sql="SELECT * FROM salon WHERE id_profesor=?";
     //crear consulta
     miStatement=miConexion.prepareStatement(sql);
     //establecer los parametros
     miStatement.setInt(1, iDMaestro);
   

     //ejecutar consultar
     miResultset=miStatement.executeQuery();
      
     //obtener datos de respuesta
     if(miResultset.next())
       {
        int idsalon=miResultset.getInt(1);
        int idhorario=miResultset.getInt(2);
        int idprofesor=miResultset.getInt(3);
        String Salon=miResultset.getString(4);
       

        elSalon=new Salon(idsalon,idhorario,idprofesor,Salon);
       
   
     }else{
         throw new Exception("Error al encontrar el  Salon ");
      
    
     }
     
     
     }catch (Exception e){
       System.err.println("Got an exception!");
       System.err.println(e.getMessage());
       elSalon=new  Salon();
           miConexion.close();
         miStatement.close();
         miResultset.close();
       return elSalon;
     }

            miConexion.close();
         miStatement.close();
         miResultset.close();   
     return elSalon;
    }


public   Salon cargarsalon(int iDs) throws SQLException {
          
     Salon elSalon=null;
     Connection miConexion=null;
     PreparedStatement miStatement=null;
     ResultSet miResultset=null;
     int  ids=iDs;
    

     try{
    //establecer la bbdd
     miConexion=origenDatos.getConnection();
     
     
     //crear sql que busque elproducto
     
     String sql="SELECT * FROM salon WHERE idSalon=?";
     //crear consulta
     miStatement=miConexion.prepareStatement(sql);
     //establecer los parametros
     miStatement.setInt(1, ids);
   

     //ejecutar consultar
     miResultset=miStatement.executeQuery();
      
     //obtener datos de respuesta
     if(miResultset.next())
       {
        int idsalon=miResultset.getInt(1);
        int idhorario=miResultset.getInt(2);
        int idprofesor=miResultset.getInt(3);
        String Salon=miResultset.getString(4);
       

        elSalon=new Salon(idsalon,idhorario,idprofesor,Salon);
       
   
     }else{
         throw new Exception("Error al encontrar el  Salon ");
      
    
     }
     
     
     }catch (Exception e){
       System.err.println("Got an exception!");
       System.err.println(e.getMessage());
       elSalon=new  Salon();
           miConexion.close();
         miStatement.close();
         miResultset.close();
       return elSalon;
     }

            miConexion.close();
         miStatement.close();
         miResultset.close();   
     return elSalon;
    }

void agregarSalon(Salon nuevoSalon) {
       //obtener la conexion
       Connection miConexion=null;
       PreparedStatement miStatement=null;
       //crear la instruccion sql
       try{
           miConexion=origenDatos.getConnection();
       
       //sql
      //NOTAespecificar todos los campos 
       String sql="INSERT INTO salon(id_horario,id_profesor,Salon)"
               + "VALUES(?,?,?)";
      
       miStatement=miConexion.prepareStatement(sql);
       //establecer los parametros

           miStatement.setInt(1,nuevoSalon.getIdhorario());
            miStatement.setInt(2,nuevoSalon.getIdprofesor());
           miStatement.setString(3,nuevoSalon.getSalon());
  
   

      
       //ejecutar la instruccion sql
       miStatement.execute();
       
        miConexion.close();
        miStatement.close();
       
       
       }catch(Exception e ){
        System.err.println("Got an exception!");
      System.err.println(e.getMessage());
       }
       
       
    }

 void EliminarSalon(int  idsalon) throws Exception{
      
        //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
         miConexion=origenDatos.getConnection();
        //crear la instruccion sql
        String sql="DELETE FROM salon WHERE idSalon=?";
        //preparar la consulta
          miStatement=miConexion.prepareStatement(sql);
        //establecer parametros del ?
         miStatement.setInt(1, idsalon);
        //ejecutar sentencia sql
        miStatement.execute();
        
         miConexion.close();
         miStatement.close();
     
    }
 
 
 void actualizarSalon(Salon SalonActualizado) throws Exception{
      //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
      

      //crear sentencia SQL
       
      miConexion=origenDatos.getConnection();
      
      //consulta preparada
      
      
      String sql="UPDATE salon SET id_horario=?, id_profesor=?, salon=? WHERE idSalon=? ";
              
       miStatement=miConexion.prepareStatement(sql);
      //establecer los parametros
      
       miStatement.setInt(4, SalonActualizado.getIdsalon());
       miStatement.setInt(1, SalonActualizado.getIdhorario());
       miStatement.setInt(2, SalonActualizado.getIdprofesor());
       miStatement.setString(3, SalonActualizado.getSalon());
    
    

      //ejecutar la instrucccionsqp
      miStatement.execute();
  
       
          miConexion.close();
         miStatement.close();
       
      }
 
 void QuitarMaestro(int idmaestro) throws Exception{
      //establecer conexion
       
      Connection miConexion=null;
      PreparedStatement miStatement=null;
      

      //crear sentencia SQL
       
      miConexion=origenDatos.getConnection();
      
      //consulta preparad
      
      String sql="UPDATE salon SET  id_profesor=? WHERE id_profesor=? ";
              
      miStatement=miConexion.prepareStatement(sql);
      //establecer los parametros
       miStatement.setInt(1, 0);
       miStatement.setInt(2, idmaestro);
    

    
    

      //ejecutar la instrucccionsqp
      miStatement.execute();
      miConexion.close();
      miStatement.close();
       
      }
 
 
 
 


   


    }




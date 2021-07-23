
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


public class ModeloAlumnos {

private  DataSource origenDatos; 
public ModeloAlumnos(DataSource origenDatos){
    this.origenDatos=origenDatos;
    
}

public List<AlumnosString> getAlumnos() throws Exception {
    List<AlumnosString> alumnos =new ArrayList<>();
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT idAlumnos,nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,Genero,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel,id_Tutor,nacimiento,Salon"+
            " FROM ALUMNOS INNER JOIN genero ON ALUMNOS.id_Genero=genero.id_genero INNER JOIN salon ON alumnos.idsalon=salon.idSalon";
    miStatement=miConexion.createStatement();
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
        int idAlumnos=miResultset.getInt(1);
        String nombreAlumno=miResultset.getString(2);
        String apellidopaternoAlumno=miResultset.getString(3);
        String apellidomaternoAlumno=miResultset.getString(4);
        String CURP=miResultset.getString(5);
        String Genero=miResultset.getString(6);
        int id_Nacionalidad=miResultset.getInt(7);
        int id_Tipo_de_Sangre=miResultset.getInt(8);
        double peso=miResultset.getDouble(9);
        double estatura=miResultset.getDouble(10);
        int id_Documentos_Entregados=miResultset.getInt(11);
        String Direccion=miResultset.getString(12);
        int id_Nivel=miResultset.getInt(13);
        int id_Tutor=miResultset.getInt(14);
         Date  nacimiento=miResultset.getDate(15);
          String idsalon=miResultset.getString(16);

        AlumnosString temAlumno=new AlumnosString(idAlumnos,nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,Genero
                                      ,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel
                                      ,id_Tutor,nacimiento,idsalon);
        alumnos.add(temAlumno);
       
    }
    
         miConexion.close();
         miStatement.close();
         miResultset.close();
 return alumnos;   
}


public List<TutorxAlumno> getAlumnosTutoresxsalon(int iDSalon) throws Exception {
    List<TutorxAlumno> TA =new ArrayList<>();
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT ALUMNOS.nombreAlumno,ALUMNOS.apellidopaternoAlumno,ALUMNOS.apellidomaternoAlumno,tutor.nombre,tutor.apellidopaterno,tutor.apellidomaterno,tutor.idtutor"+
            " FROM ALUMNOS   INNER JOIN tutor ON ALUMNOS.id_Tutor=tutor.idtutor  WHERE ALUMNOS.idsalon="+iDSalon;
          
    miStatement=miConexion.createStatement();
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
       
        String nombreAlumno=miResultset.getString(1);
        String apellidopaternoAlumno=miResultset.getString(2);
        String apellidomaternoAlumno=miResultset.getString(3);
        
        String nombretutor=miResultset.getString(4);
        String apellidopaternotutor=miResultset.getString(5);
        String apellidomaternotutor=miResultset.getString(6);
      
        int idtutor=miResultset.getInt(7);
      
      
   
        TutorxAlumno ta=new TutorxAlumno(nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,nombretutor,apellidopaternotutor,apellidomaternotutor,idtutor);
        TA.add(ta);
      
    }
       miConexion.close();
       miStatement.close();
       miResultset.close();
 return TA;   
}



public List<AlumnosString> getAlumnosxsalon(int iDSalon) throws Exception {
    List<AlumnosString> alumnos =new ArrayList<>();
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT idAlumnos,nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,id_genero,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel,id_Tutor,nacimiento,Salon"+
            " FROM ALUMNOS INNER JOIN salon ON ALUMNOS.idsalon=salon.idSalon where salon.idSalon="+iDSalon;
    miStatement=miConexion.createStatement();
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
        int idAlumnos=miResultset.getInt(1);
        String nombreAlumno=miResultset.getString(2);
        String apellidopaternoAlumno=miResultset.getString(3);
        String apellidomaternoAlumno=miResultset.getString(4);
        String CURP=miResultset.getString(5);
        String Genero=miResultset.getString(6);
        int id_Nacionalidad=miResultset.getInt(7);
        int id_Tipo_de_Sangre=miResultset.getInt(8);
        double peso=miResultset.getDouble(9);
        double estatura=miResultset.getDouble(10);
        int id_Documentos_Entregados=miResultset.getInt(11);
        String Direccion=miResultset.getString(12);
        int id_Nivel=miResultset.getInt(13);
        int id_Tutor=miResultset.getInt(14);
         Date  nacimiento=miResultset.getDate(15);
          String idsalon=miResultset.getString(16);
      
   
        AlumnosString temAlumno=new AlumnosString(idAlumnos,nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,Genero
                                      ,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel
                                      ,id_Tutor,nacimiento,idsalon);
        alumnos.add(temAlumno);
      
    }
       miConexion.close();
       miStatement.close();
       miResultset.close();
 return alumnos;   
}


public List<Alumnos> getAlumnosxsalon(int iDSalon ,int x) throws Exception {
    List<Alumnos> alumnos =new ArrayList<>();
    Connection miConexion=null;
    Statement miStatement=null;
    ResultSet miResultset=null;
    //----Establecer la conexion ------
    miConexion=origenDatos.getConnection();
    //----sentencia sqp------
    String instruccionSql="SELECT idAlumnos,nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,id_genero,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel,id_Tutor,nacimiento,idsalon"+
            " FROM ALUMNOS  where idsalon="+x;
    miStatement=miConexion.createStatement();
    //----ejecutar sql------
    miResultset=miStatement.executeQuery(instruccionSql);
    //recorrer resulset
    while(miResultset.next()){
        int idAlumnos=miResultset.getInt(1);
        String nombreAlumno=miResultset.getString(2);
        String apellidopaternoAlumno=miResultset.getString(3);
        String apellidomaternoAlumno=miResultset.getString(4);
        String CURP=miResultset.getString(5);
        int Genero=miResultset.getInt(6);
        int id_Nacionalidad=miResultset.getInt(7);
        int id_Tipo_de_Sangre=miResultset.getInt(8);
        double peso=miResultset.getDouble(9);
        double estatura=miResultset.getDouble(10);
        int id_Documentos_Entregados=miResultset.getInt(11);
        String Direccion=miResultset.getString(12);
        int id_Nivel=miResultset.getInt(13);
        int id_Tutor=miResultset.getInt(14);
         Date  nacimiento=miResultset.getDate(15);
         int  idsalon=miResultset.getInt(16);
      
   
        Alumnos temAlumno=new Alumnos(idAlumnos,nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,Genero
                                      ,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel
                                      ,id_Tutor,nacimiento,idsalon);
        alumnos.add(temAlumno);
      
    }
       miConexion.close();
       miStatement.close();
       miResultset.close();
 return alumnos;   
}



void agregarAlumno(Alumnos nuevoAlumno) {
       //obtener la conexion
       Connection miConexion=null;
       PreparedStatement miStatement=null;
       //crear la instruccion sql
       try{
           miConexion=origenDatos.getConnection();
       
       //sql
      //NOTAespecificar todos los campos 
       String sql="INSERT INTO alumnos(nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,id_Genero,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel,id_Tutor,nacimiento,idsalon)"
               + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
       miStatement=miConexion.prepareStatement(sql);
       //establecer los parametros

        miStatement.setString(1,nuevoAlumno.getNombreAlumno());
        miStatement.setString(2,nuevoAlumno.getApellidopaternoAlumno());
        miStatement.setString(3,nuevoAlumno.getApellidomaternoAlumno());
        miStatement.setString(4,nuevoAlumno.getCURP());
        miStatement.setInt(5,nuevoAlumno.getId_Genero());
        miStatement.setInt(6,nuevoAlumno.getId_Nacionalidad());
        miStatement.setInt(7,nuevoAlumno.getId_Tipo_de_Sangre());
        miStatement.setDouble(8,nuevoAlumno.getPeso());
        miStatement.setDouble(9,nuevoAlumno.getEstatura());
        miStatement.setInt(10,nuevoAlumno.getId_Documentos_Entregados());
        miStatement.setString(11,nuevoAlumno.getDireccion());
        miStatement.setInt(12,nuevoAlumno.getId_Nivel());
        miStatement.setInt(13,nuevoAlumno.getId_Tutor());
   
       java.util.Date utilDate=nuevoAlumno.getNacimiento();
       java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
       miStatement.setDate(14,fechaConvertida);
         miStatement.setInt(15,nuevoAlumno.getIdsalon());
      
       //ejecutar la instruccion sql
       miStatement.execute();
       
         miConexion.close();
         miStatement.close();
         
       
       
       }catch(Exception e ){
        System.err.println("Got an exception!jjjjjjjjjjjjjjjjj");
      System.err.println(e.getMessage());
       }
       
    }



    public   Alumnos getAlumno(String iDAlumno) {
        
     Alumnos elAlumno=null;
     Connection miConexion=null;
     PreparedStatement miStatement=null;
     ResultSet miResultset=null;
     String idalumno=iDAlumno;
 
    
     try{
    //establecer la bbdd
     miConexion=origenDatos.getConnection();
     
     
     //crear sql que busque elproducto
     
     String sql="SELECT * FROM ALUMNOS WHERE idAlumnos=?";
     //crear consulta
     miStatement=miConexion.prepareStatement(sql);
     //establecer los parametros
     miStatement.setString(1, idalumno);
     //ejecutar consultar
     miResultset=miStatement.executeQuery();
     
     //obtener datos de respuesta
     if(miResultset.next())
       {
         
        int idAlumnos=miResultset.getInt(1);
        String nombreAlumno=miResultset.getString(2);
        String apellidopaternoAlumno=miResultset.getString(3);
        String apellidomaternoAlumno=miResultset.getString(4);
        String CURP=miResultset.getString(5);
        int Genero=miResultset.getInt(6);
        int id_Nacionalidad=miResultset.getInt(7);
        int id_Tipo_de_Sangre=miResultset.getInt(8);
        double peso=miResultset.getDouble(9);
        double estatura=miResultset.getDouble(10);
        int id_Documentos_Entregados=miResultset.getInt(11);
        String Direccion=miResultset.getString(12);
        int id_Nivel=miResultset.getInt(13);
        int id_Tutor=miResultset.getInt(14);
         Date  nacimiento=miResultset.getDate(15);
        int idsalon=miResultset.getInt(16);
      
   
        elAlumno=new Alumnos(idAlumnos,nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,Genero
                                      ,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel
                                      ,id_Tutor,nacimiento,idsalon);
          
         miConexion.close();
         miStatement.close();
         miResultset.close();
     }else{
         throw new Exception("Error al encontrar el producto");
     }
     
     
     }catch (Exception e){
       System.err.println("Got an exception!jjjjjjjjjjjjjjjjj");
      System.err.println(e.getMessage());
     }
     return elAlumno;
    }
     public   Alumnos getAlumno(String nom,String app, String apm) throws SQLException {
        
     Alumnos elAlumno=null;
     Connection miConexion=null;
     PreparedStatement miStatement=null;
     ResultSet miResultset=null;
     
 
    
     try{
    //establecer la bbdd
     miConexion=origenDatos.getConnection();
     
     
     //crear sql que busque elproducto
     
     String sql="SELECT * FROM ALUMNOS WHERE nombreAlumno=? and apellidopaternoAlumno=? and apellidomaternoAlumno=?";
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
         
        int idAlumnos=miResultset.getInt(1);
        String nombreAlumno=miResultset.getString(2);
        String apellidopaternoAlumno=miResultset.getString(3);
        String apellidomaternoAlumno=miResultset.getString(4);
        String CURP=miResultset.getString(5);
        int Genero=miResultset.getInt(6);
        int id_Nacionalidad=miResultset.getInt(7);
        int id_Tipo_de_Sangre=miResultset.getInt(8);
        double peso=miResultset.getDouble(9);
        double estatura=miResultset.getDouble(10);
        int id_Documentos_Entregados=miResultset.getInt(11);
        String Direccion=miResultset.getString(12);
        int id_Nivel=miResultset.getInt(13);
        int id_Tutor=miResultset.getInt(14);
         Date  nacimiento=miResultset.getDate(15);
        int idsalon=miResultset.getInt(16);
      
   
        elAlumno=new Alumnos(idAlumnos,nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,Genero
                                      ,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel
                                      ,id_Tutor,nacimiento,idsalon);
          
      
     }else{
         throw new Exception("Error al encontrar el producto");
     }
     
     
     }catch (Exception e){
       System.err.println("Got an exception!jjjjjjjjjjjjjjjjj");
      System.err.println(e.getMessage());
     }
        miConexion.close();
         miStatement.close();
         miResultset.close();
     return elAlumno;
    }
    public   Alumnos getAlumno(String nom,String app, String apm , int ids) throws SQLException {
        
     Alumnos elAlumno=null;
     Connection miConexion=null;
     PreparedStatement miStatement=null;
     ResultSet miResultset=null;
     
 
    
     try{
    //establecer la bbdd
     miConexion=origenDatos.getConnection();
     
     
     //crear sql que busque elproducto
     
     String sql="SELECT * FROM ALUMNOS WHERE nombreAlumno=? and apellidopaternoAlumno=? and apellidomaternoAlumno=?  and idsalon=?";
     //crear consulta
     miStatement=miConexion.prepareStatement(sql);
     //establecer los parametros
     miStatement.setString(1, nom);
     miStatement.setString(2, app);     
     miStatement.setString(3, apm);
     miStatement.setInt(4, ids);
     //ejecutar consultar
     miResultset=miStatement.executeQuery();
     
     //obtener datos de respuesta
     if(miResultset.next())
       {
         
        int idAlumnos=miResultset.getInt(1);
        String nombreAlumno=miResultset.getString(2);
        String apellidopaternoAlumno=miResultset.getString(3);
        String apellidomaternoAlumno=miResultset.getString(4);
        String CURP=miResultset.getString(5);
        int Genero=miResultset.getInt(6);
        int id_Nacionalidad=miResultset.getInt(7);
        int id_Tipo_de_Sangre=miResultset.getInt(8);
        double peso=miResultset.getDouble(9);
        double estatura=miResultset.getDouble(10);
        int id_Documentos_Entregados=miResultset.getInt(11);
        String Direccion=miResultset.getString(12);
        int id_Nivel=miResultset.getInt(13);
        int id_Tutor=miResultset.getInt(14);
         Date  nacimiento=miResultset.getDate(15);
        int idsalon=miResultset.getInt(16);
      
   
        elAlumno=new Alumnos(idAlumnos,nombreAlumno,apellidopaternoAlumno,apellidomaternoAlumno,CURP,Genero
                                      ,id_Nacionalidad,id_Tipo_de_Sangre,peso,estatura,id_Documentos_Entregados,Direccion,id_Nivel
                                      ,id_Tutor,nacimiento,idsalon);
          
      
     }else{
         throw new Exception("Error al encontrar el producto");
     }
     
     
     }catch (Exception e){
       System.err.println("Got an exception!jjjjjjjjjjjjjjjjj");
      System.err.println(e.getMessage());
     }
        miConexion.close();
         miStatement.close();
         miResultset.close();
     return elAlumno;
    }
    
    
      void actualizarAlumno(Alumnos AlumnoActualizado) throws Exception{
      //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
      

      //crear sentencia SQL
       
      miConexion=origenDatos.getConnection();
      
      //consulta preparada
      
      
      String sql="UPDATE Alumnos SET nombreAlumno=?, apellidopaternoAlumno=?, apellidomaternoAlumno=?, "+
              "CURP=?,id_Genero=?,id_Nacionalidad=?,id_Tipo_de_Sangre=?,peso=?,estatura=?,id_Documentos_Entregados=?, "+
              "Direccion=?,id_Nivel=?,id_Tutor=?,nacimiento=?,idsalon=? WHERE idAlumnos=?";
              miStatement=miConexion.prepareStatement(sql);
      //establecer los parametros
      
       miStatement.setInt(16, AlumnoActualizado.getIdAlumnos());
      miStatement.setString(1, AlumnoActualizado.getNombreAlumno());
      miStatement.setString(2, AlumnoActualizado.getApellidopaternoAlumno());
      miStatement.setString(3, AlumnoActualizado.getApellidomaternoAlumno());
      miStatement.setString(4, AlumnoActualizado.getCURP());
      miStatement.setInt(5, AlumnoActualizado.getId_Genero());
      miStatement.setInt(6, AlumnoActualizado.getId_Nacionalidad());
      miStatement.setInt(7, AlumnoActualizado.getId_Tipo_de_Sangre());
      miStatement.setDouble(8, AlumnoActualizado.getPeso());
      miStatement.setDouble(9, AlumnoActualizado.getEstatura());
      miStatement.setInt(10, AlumnoActualizado.getId_Documentos_Entregados());
      miStatement.setString(11, AlumnoActualizado.getDireccion());
      miStatement.setInt(12, AlumnoActualizado.getId_Nivel());
      miStatement.setInt(13, AlumnoActualizado.getId_Tutor());
                      
      
      java.util.Date utilDate=AlumnoActualizado.getNacimiento();
      java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
      
      miStatement.setDate(14,fechaConvertida);
      miStatement.setInt(15, AlumnoActualizado.getIdsalon());
     

      //ejecutar la instrucccionsqp
      miStatement.execute();
  
       
          miConexion.close();
         miStatement.close();
       
      }
      
        void QuitarDelSalon(int iDalumno , int x) throws Exception{
      //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
      
     
      //crear sentencia SQL
       
      miConexion=origenDatos.getConnection();
      
      //consulta preparada
      
      
      String sql="UPDATE Alumnos SET idsalon=? WHERE idAlumnos=?";
              miStatement=miConexion.prepareStatement(sql);
      //establecer los parametros
      
      
      miStatement.setInt(1,x);
      miStatement.setInt(2, iDalumno);

      //ejecutar la instrucccionsqp
      miStatement.execute();
  
       
          miConexion.close();
         miStatement.close();
       
      }
    
      
      
      void eliminarAlumno(String idAlumno) throws Exception{
      
        //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
         miConexion=origenDatos.getConnection();
        //crear la instruccion sql
        String sql="DELETE FROM alumnos WHERE idAlumnos=?";
        //preparar la consulta
          miStatement=miConexion.prepareStatement(sql);
        //establecer parametros del ?
         miStatement.setString(1, idAlumno);
        //ejecutar sentencia sql
        miStatement.execute();
        
         miConexion.close();
         miStatement.close();
     
    }



   void CerrarSalon(int idsalon ) throws Exception{
      //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
      
     
      //crear sentencia SQL
       
      miConexion=origenDatos.getConnection();
      
      //consulta preparada
      
      
      String sql="UPDATE Alumnos SET idsalon=? WHERE idsalon=?";
              miStatement=miConexion.prepareStatement(sql);
      //establecer los parametros
      
      
      miStatement.setInt(1,0);
      miStatement.setInt(2, idsalon);

      //ejecutar la instrucccionsqp
      miStatement.execute();
  
       
          miConexion.close();
         miStatement.close();
       
      }  

    void CambiarTutor(int idtutor ) throws Exception{
      //establecer conexion
      Connection miConexion=null;
      PreparedStatement miStatement=null;
      
     
      //crear sentencia SQL
       
      miConexion=origenDatos.getConnection();
      
      //consulta preparada
      
      
      String sql="UPDATE Alumnos SET id_Tutor=? WHERE id_Tutor=?";
              miStatement=miConexion.prepareStatement(sql);
      //establecer los parametros
      
      
      miStatement.setInt(1,0);
      miStatement.setInt(2, idtutor);
      
      //ejecutar la instrucccionsqp
      miStatement.execute();
  
       
          miConexion.close();
         miStatement.close();
       
      }
    }



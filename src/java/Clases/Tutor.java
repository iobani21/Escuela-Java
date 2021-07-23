
package Servelets_class;

public class Tutor {
    private int idtutor;
    private String nombre;
    private String app;
    private String apm;
    private int idparentesco;
    private String correo;
    private String telefono;
    
    
    
    public Tutor(int idtutor,String nombre,String app,String apm,int idparentesco,String correo,String telefono){
        this.idtutor=idtutor;
        this.nombre=nombre;
        this.app=app;
        this.apm=apm;
        this.idparentesco=idparentesco;
        this.correo=correo;
        this.telefono=telefono;
    }
    
      public Tutor(String nombre,String app,String apm,int idparentesco,String correo,String telefono){
        this.nombre=nombre;
        this.app=app;
        this.apm=apm;
        this.idparentesco=idparentesco;
        this.correo=correo;
        this.telefono=telefono;
    }
      
           @Override
    public String toString() {
        return "Tutor [" + "idtutor=" + idtutor + ", nombre=" + nombre + ", apellidopaterno=" + app + 
        ", apellidomaterno=" + apm +",idparentesco="+idparentesco+",correoelectronico="+correo+",telefono="+telefono +']';
    }

    public int getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(int idtutor) {
        this.idtutor = idtutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public int getIdparentesco() {
        return idparentesco;
    }

    public void setIdparentesco(int idparentesco) {
        this.idparentesco = idparentesco;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
      
      
}

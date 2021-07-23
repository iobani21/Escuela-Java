package Servelets_class;


public class Maestro {
    
    
    int idmaestro;
    String nombre;
    String apellidopaterno;
    String apellidomaterno;
    int idpuesto;
    String rfc;
    String direccion;
    String correoelectronico;
    String telefono;
    String clave;
    
     @Override
    public String toString() {
        return "Maestro [" + "idmaestro=" + idmaestro + ", nombre=" + nombre + ", apellidopaterno=" + apellidopaterno + 
        ", apellidomaterno=" + apellidomaterno + ", idpuesto=" + idpuesto + ", rfc=" + rfc + ", direccion=" + direccion + 
         ",correoelectronico"  + correoelectronico + ",telefono"+telefono+",clave"+clave+']';
    }
    
    
     public Maestro(int idmaestro,String nombre,String apellidopaterno,String apellidomaterno,int idpuesto,String rfc,String direccion,String correoelectronico,String telefono,String clave )
    {
        
   

       this.idmaestro=idmaestro;
       this.nombre=nombre;
       this.apellidopaterno=apellidopaterno;
       this.apellidomaterno=apellidomaterno;
       this.idpuesto=idpuesto;
       this.direccion=direccion;
       this.rfc=rfc;
       this.correoelectronico=correoelectronico;
       this.telefono=telefono;
       this.clave=clave;
    }
     
      public Maestro(String nombre,String apellidopaterno,String apellidomaterno,int idpuesto,String rfc,String direccion,String correoelectronico,String telefono,String clave )
    {
        
       this.nombre=nombre;
       this.apellidopaterno=apellidopaterno;
       this.apellidomaterno=apellidomaterno;
       this.idpuesto=idpuesto;
       this.direccion=direccion;
       this.rfc=rfc;
       this.correoelectronico=correoelectronico;
       this.telefono=telefono;
       this.clave=clave;
    }
      
       public Maestro()
    {
        
       this.nombre=null;
       this.apellidopaterno=null;
       this.apellidomaterno=null;
       this.idpuesto=0;
       this.direccion=null;
       this.rfc=null;
       this.correoelectronico=null;
       this.telefono=null;
       this.clave=null;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdmaestro() {
        return idmaestro;
    }

    public void setIdmaestro(int idmaestro) {
        this.idmaestro = idmaestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public int getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(int idpuesto) {
        this.idpuesto = idpuesto;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     
}

package Servelets_class;


import java.util.Date;


public class AlumnosString {
    
    public AlumnosString(int idAlumnos,String nombreAlumno,String apellidopaternoAlumno,String apellidomaternoAlumno,String CURP,String id_Genero,int id_Nacionalidad,int id_Tipo_de_Sangre,double peso,double estatura,int id_Documentos_Entregados,String Direccion,int id_Nivel,int id_Tutor,Date nacimiento,String idsalon )
    {
       this.idAlumnos=idAlumnos;
       this.nombreAlumno=nombreAlumno;
       this.apellidopaternoAlumno=apellidopaternoAlumno;
       this.apellidomaternoAlumno=apellidomaternoAlumno;
       this.CURP=CURP;
       this.id_Genero=id_Genero;
       this.id_Nacionalidad=id_Nacionalidad;
       this.id_Tipo_de_Sangre=id_Tipo_de_Sangre;
       this.peso=peso;
       this.estatura=estatura;
       this.id_Documentos_Entregados=id_Documentos_Entregados;
       this.Direccion=Direccion;
      this.id_Nivel=id_Nivel;
      this.id_Tutor=id_Tutor;
      this.nacimiento=nacimiento;
      this.idsalon=idsalon;
     
    }
    
    public AlumnosString(String nombreAlumno,String apellidopaternoAlumno,String apellidomaternoAlumno,String CURP,String id_Genero,int id_Nacionalidad,int id_Tipo_de_Sangre,double peso,double estatura,int id_Documentos_Entregados,String Direccion,int id_Nivel,int id_Tutor,Date nacimiento,String idsalon )
    {
       
       this.nombreAlumno=nombreAlumno;
       this.apellidopaternoAlumno=apellidopaternoAlumno;
       this.apellidomaternoAlumno=apellidomaternoAlumno;
       this.CURP=CURP;
       this.id_Genero=id_Genero;
       this.id_Nacionalidad=id_Nacionalidad;
       this.id_Tipo_de_Sangre=id_Tipo_de_Sangre;
       this.peso=peso;
       this.estatura=estatura;
       this.id_Documentos_Entregados=id_Documentos_Entregados;
       this.Direccion=Direccion;
      this.id_Nivel=id_Nivel;
      this.id_Tutor=id_Tutor;
      this.nacimiento=nacimiento;
      this.idsalon=idsalon;
    }
    
        @Override
    public String toString() {
        return "Alumnos [" + "idAlumnos=" + idAlumnos + ", nombreAlumno=" + nombreAlumno + ", apellidopaternoAlumno=" + apellidopaternoAlumno + 
        ", apellidomaternoAlumno=" + apellidomaternoAlumno + ", CURP=" + CURP + ", id_Genero=" + id_Genero + ", id_Nacionalidad=" + id_Nacionalidad + 
         ",id_Tipo_de_Sangre"  + id_Tipo_de_Sangre + ",peso"+peso+",estatura="+estatura+",id_Documentos_Entregados="+id_Documentos_Entregados+",Direccion"+Direccion+",id_Nivel"+id_Nivel+",id_Tutor"+id_Tutor + "nacimiento"+nacimiento+"idsalon"+idsalon+']';
    }
   
    private int idAlumnos;
    private String nombreAlumno;
    private String apellidopaternoAlumno;
    private String apellidomaternoAlumno;
    private String CURP;
    private String id_Genero;
    private int id_Nacionalidad;
    private int id_Tipo_de_Sangre;
    private double peso;
    private double estatura;
    private int id_Documentos_Entregados;
    private String Direccion;
    private int id_Nivel;
    private int id_Tutor;
    private Date nacimiento;
    private String idsalon;

    public String getIdsalon() {
        return idsalon;
    }

    public void setIdsalon(String idsalon) {
        this.idsalon = idsalon;
    }
    
    
    
    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }


    public int getIdAlumnos() {
        return idAlumnos;
    }

    public void setIdAlumnos(int idAlumnos) {
        this.idAlumnos = idAlumnos;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidopaternoAlumno() {
        return apellidopaternoAlumno;
    }

    public void setApellidopaternoAlumno(String apellidopaternoAlumno) {
        this.apellidopaternoAlumno = apellidopaternoAlumno;
    }

    public String getApellidomaternoAlumno() {
        return apellidomaternoAlumno;
    }

    public void setApellidomaternoAlumno(String apellidomaternoAlumno) {
        this.apellidomaternoAlumno = apellidomaternoAlumno;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getId_Genero() {
        return id_Genero;
    }

    public void setId_Genero(String id_Genero) {
        this.id_Genero = id_Genero;
    }

    public int getId_Nacionalidad() {
        return id_Nacionalidad;
    }

    public void setId_Nacionalidad(int id_Nacionalidad) {
        this.id_Nacionalidad = id_Nacionalidad;
    }

    public int getId_Tipo_de_Sangre() {
        return id_Tipo_de_Sangre;
    }

    public void setId_Tipo_de_Sangre(int id_Tipo_de_Sangre) {
        this.id_Tipo_de_Sangre = id_Tipo_de_Sangre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public int getId_Documentos_Entregados() {
        return id_Documentos_Entregados;
    }

    public void setId_Documentos_Entregados(int id_Documentos_Entregados) {
        this.id_Documentos_Entregados = id_Documentos_Entregados;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getId_Nivel() {
        return id_Nivel;
    }

    public void setId_Nivel(int id_Nivel) {
        this.id_Nivel = id_Nivel;
    }

    public int getId_Tutor() {
        return id_Tutor;
    }

    public void setId_Tutor(int id_Tutor) {
        this.id_Tutor = id_Tutor;
    }

   
    
    
    
    

    
    
    
    
    
}

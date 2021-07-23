package Servelets_class;

public class Salon {
    
    public Salon(int idsalon,int idhorario,int idprofesor,String salon){
        this.idsalon=idsalon;
        this.idhorario=idhorario;
        this.idprofesor=idprofesor;
        this.salon=salon;
    }
      public Salon(){
        this.idsalon=0;
        this.idhorario=0;
        this.idprofesor=0;
        this.salon=null;
    }
    
      public Salon(int idhorario,int idprofesor,String salon){
   
        this.idhorario=idhorario;
        this.idprofesor=idprofesor;
        this.salon=salon;
    }
      
       @Override
    public String toString() {
        return "Salon [" + "idsalon=" + idsalon + ", idhorario=" + idhorario + ", idprofesor=" + idprofesor + 
        ", salon=" + salon +']';
    }
    
    
    private int idsalon;
    private int idhorario;
    private int idprofesor;
    private String salon;

    public int getIdsalon() {
        return idsalon;
    }

    public void setIdsalon(int idsalon) {
        this.idsalon = idsalon;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
    
    
}

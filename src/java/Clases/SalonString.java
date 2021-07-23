/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_class;

public class SalonString {
    
    public SalonString(int idsalon,String idhorario,String idprofesor,String salon){
        this.idsalon=idsalon;
        this.idhorario=idhorario;
        this.idprofesor=idprofesor;
        this.salon=salon;
    }
    
      public SalonString(String idhorario,String idprofesor,String salon){
   
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
    private String idhorario;
    private String idprofesor;
    private String salon;

    public int getIdsalon() {
        return idsalon;
    }

    public void setIdsalon(int idsalon) {
        this.idsalon = idsalon;
    }

    public String getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(String idhorario) {
        this.idhorario = idhorario;
    }

    public String getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(String idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
    
    
}

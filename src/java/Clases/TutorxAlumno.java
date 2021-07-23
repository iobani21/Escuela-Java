
package Servelets_class;
public class TutorxAlumno {
  String nombreA;
  String appA;
  String apmA;

  String nombreT;
  String appT;
  String apmT;

  int idtutor;

  
  
  public TutorxAlumno(String na,String appA,String apmA,String nt,String appT,String apmT, int idtutor)
  {
      this.nombreA=na;
      this.appA=appA;
      this.apmA=apmA;
      this.nombreT=nt;
      this.appT=appT;
      this.apmT=apmT;
      this.idtutor=idtutor;
  }
  
   @Override
    public String toString() {
        return "TutorxAlumno [" + "nombreA=" + nombreA + ", appA=" + appA + ", apmA=" + apmA + 
        ", nombreT=" + nombreT + ", appT=" + appT + ", apmT=" + apmT + ", idtutor=" + idtutor +']';
    }
  
  
    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getAppA() {
        return appA;
    }

    public void setAppA(String appA) {
        this.appA = appA;
    }

    public String getApmA() {
        return apmA;
    }

    public void setApmA(String apmA) {
        this.apmA = apmA;
    }

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }

    public String getAppT() {
        return appT;
    }

    public void setAppT(String appT) {
        this.appT = appT;
    }

    public String getApmT() {
        return apmT;
    }

    public void setApmT(String apmT) {
        this.apmT = apmT;
    }

    public int getIdtutor() {
        return idtutor;
    }

    public void setIdtutor(int idtutor) {
        this.idtutor = idtutor;
    }

  
}

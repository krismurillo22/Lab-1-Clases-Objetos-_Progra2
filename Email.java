package Email;

public class Email {
    private String guardarEmail;
    private String asunto;
    private String contenido;
    private boolean Leido;
    public Email(String guardarEmail, String asunto, String contenido) {
        this.guardarEmail = guardarEmail;
        this.asunto = asunto;
        this.contenido = contenido;
        Leido=false;
    }
    public String getGuardarEmail() {
        return guardarEmail;
    }
    public String getAsunto() {
        return asunto;
    }
    public String getContenido() {
        return contenido;
    }
  
    public boolean marcarLeido() {
        return Leido;
    }
    public void print() {
        System.out.println( "De: "+guardarEmail+" Asunto: "+asunto+" Contenido "+contenido+"\n ");
    }

}
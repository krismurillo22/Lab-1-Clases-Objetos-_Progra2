/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1_programacion1;

/**
 *
 * @author User
 */
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
    public boolean isLeido() {
        return Leido;
    }    
    public void marcarLeido() {
        this.Leido = true;
    }
    public void print() {
        System.out.println("De: "+guardarEmail+" Asunto: "+asunto+" Contenido "+contenido+"\n "+Leido);
        
    }

  
}

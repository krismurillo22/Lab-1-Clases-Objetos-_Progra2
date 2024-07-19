package lab1_programacion1;
public class EmailAccount {
    // A
    private String direccion;
    private String password;
    private String nombre;
    private Email[] inbox;
    // B
    public EmailAccount(String direccion, String password, String nombre) {
        this.direccion = direccion;
        this.password = password;
        this.nombre= nombre;
        this.inbox = new Email[50]; 
    }
    
    public EmailAccount(){
        inbox = new Email[50]; 
    }
    // C
    public String getDireccion() {
        return direccion;
    }
    public String getPassword() {
        return password;
    }
    public String getNombre() {
        return nombre;
    }
    //D
    public EmailAccount buscar(EmailAccount[] accounts, String direccion, String password){
        for (EmailAccount cuenta : accounts) {
            if (cuenta.getDireccion().equals(direccion) && cuenta.getPassword().equals(password)) {
                return cuenta;
            }
        }
        return null;
    }
    
    public boolean recibirEmail(Email em) {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] == null) {
                inbox[i] = em;
                return true;
            }
        }
        return false;
    }
    // E
   public void printInbox() {
    System.out.println("Cuenta: " + direccion + "\nNombre: " + nombre);
    int correosRecibidos = 0;

    for (int contador = 0; contador < inbox.length; contador++) {
        if (inbox[contador] != null) {
            correosRecibidos++;
            System.out.println((contador + 1) + " - " + inbox[contador].getGuardarEmail() + " - " + inbox[contador].getAsunto() + " - " +
                    (inbox[contador].marcarLeido() ? "LEIDO" : "SIN LEER"));
        }
    }

    int correosSinLeer = CorreosSinLeer();
    System.out.println("\nCorreos SIN LEER: " + correosSinLeer + "\nTOTAL email recibidos: " + correosRecibidos);
}
    // F
    public void leerEmail(int pos) {
        if (pos>0&&pos<=inbox.length) {
            int index=pos-1;
            if (inbox[index]!=null) {
                System.out.println("Contenido del correo:\n" + inbox[index].getContenido());
                inbox[index].marcarLeido();
            } else {
                System.out.println("Correo No Existe");
            }
        }
    }
    // G
    public void borrarLeidos() {
        for (int contador=0;contador<inbox.length;contador++) {
            if (inbox[contador]!=null && inbox[contador].marcarLeido()) {
                inbox[contador]=null;
            }
        }
    }
    public Email[] getInbox() {
    return inbox;
}
    // Funcion para los correos sin leer
    public int CorreosSinLeer() {
    int count = 0;
        for (Email email : inbox) {
            if (email!=null&&!email.marcarLeido()) {
                count++;
            }
        }
        return count;
}
}
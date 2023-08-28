
    package modelo;
    
    public class Empleados {
    private int id;
    private String nombre;
    private String apellido;
    private String gmail;
    private String puesto;

    public Empleados(int id, String nombre, String apellido, String gmail, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.gmail = gmail;
        this.puesto = puesto;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    
}

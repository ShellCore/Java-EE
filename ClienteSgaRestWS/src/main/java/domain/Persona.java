package domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {
    
    private int id;
    private String nombre;
    private String paterno;
    private String materno;
    private String email;
    private String telefono;

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

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona {"
                + "Id: " + id
                + ", Nombre: " + nombre
                + ", Ap. Paterno: " + paterno
                + ", Ap. Materno: " + materno
                + ", Email: " + email
                + ", Teléfono: " + telefono
                + "}";
    }
}

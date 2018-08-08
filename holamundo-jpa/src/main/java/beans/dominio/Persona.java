package beans.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")

public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idPersona;

    
    @Column(nullable = false, length = 45)
    private String nombre;
    
    @Column(name = "paterno", nullable = false, length = 45)
    private String apePaterno;
    
    @Column(name="materno", nullable = false, length = 45)
    private String apeMaterno;
    
    @Column(nullable = false, length = 45)
    private String email;
    
    @Column(length = 45)
    private String telefono;

    public Persona() {
    }
    
    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apePaterno, String apeMaterno, String email, String telefono) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.email = email;
        this.telefono = telefono;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
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
                + "Id: " + idPersona
                + ", Nombre: " + nombre
                + ", Apellido Paterno: " + apePaterno
                + ", Apellido Materno: " + apeMaterno
                + ", Correo electrónico: " + email
                + ", Teléfono: " + telefono
                + "}";
    }
}

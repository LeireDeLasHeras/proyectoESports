package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS", schema = "EQDAW02", catalog = "")
public class Usuario {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "usuarios_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_USUARIO", nullable = false, precision = 0)
    private int idUsuario;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "CONTRASENA", nullable = true, length = 50)
    private String contrasena;
    @Basic
    @Column(name = "ROL", nullable = true, length = 50)
    private String rol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(byte idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (idUsuario != usuario.idUsuario) return false;
        if (nombre != null ? !nombre.equals(usuario.nombre) : usuario.nombre != null) return false;
        if (contrasena != null ? !contrasena.equals(usuario.contrasena) : usuario.contrasena != null) return false;
        if (rol != null ? !rol.equals(usuario.rol) : usuario.rol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idUsuario;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        return result;
    }
}

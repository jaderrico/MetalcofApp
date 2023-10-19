package co.edu.sena.metalcofapp.modelos;

public class Cliente {
    private int documeto;
    private String nombre;
    private String direccion;
    private String ciudad;
    private int telefono;
    private String contraseña;

    public Cliente(int documeto, String nombre, String direccion, String ciudad, int telefono, String contraseña) {
        this.documeto = documeto;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public int getDocumeto() {
        return documeto;
    }

    public void setDocumeto(int documeto) {
        this.documeto = documeto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

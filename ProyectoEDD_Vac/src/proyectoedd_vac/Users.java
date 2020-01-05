/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoedd_vac;

public class Users {
    String nombre;
    String apellido;
    String carnet;
    String password;

    public Users(String nombre, String apellido, String carnet, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet = carnet;
        this.password = password;
    }
    public Users(){
        this.nombre = null;
        this.apellido = null;
        this.carnet = null;
        this.password = null;
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

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}

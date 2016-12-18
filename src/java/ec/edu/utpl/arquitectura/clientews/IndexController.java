/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.arquitectura.clientews;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "index")
@SessionScoped
public class IndexController implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/holamundoWS/hello.wsdl")
    private Hello_Service service;

    private String nombre;
    private int nacimiento;
    private String mensaje;

    private String usuario;
    private String pass;

    public String ejecutar() {
        Hello port = service.getHelloPort();
        String sms = port.saludo(nombre);
        int edad = port.edad(nacimiento);

        setMensaje(sms + " edad: " + edad);

        return "";
    }

    public String mover() {
        
        Hello port = service.getHelloPort();
        
        String us=encriptacion.Encriptar(usuario);
        String ps=encriptacion.Encriptar(pass);
        
        System.out.println("usuario encriptado: " + us +" clave encriptada: "+ps);
        String sms = port.login(us, ps);
        
        if (sms.equals("correcto")) {
            return "cliente";

        } else {
            return "index";
        }

    }
    
   
    public String cerrar_sesion(){
        
    return "index";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}

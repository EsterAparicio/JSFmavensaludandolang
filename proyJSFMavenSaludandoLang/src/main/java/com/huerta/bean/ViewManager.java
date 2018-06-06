package com.huerta.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.huerta.model.Saludo;

@ManagedBean(name="obj")
@ViewScoped
public class ViewManager implements Serializable{
  private String nombre;
  private String respuesta;
  private int numSaludo;
  private boolean deboMostrar;
  private List<Saludo> listes;
  private List<Saludo> listen;
  private List<Saludo> listfr;
  private List<Saludo> todos = null;

  public ViewManager() {
    numSaludo = 0;
    respuesta = "";
    deboMostrar = false;
    listes = new ArrayList<Saludo>();
    listfr = new ArrayList<Saludo>();
    listen = new ArrayList<Saludo>();
  }
  public List<Saludo> getTodos() {
    return todos;
  }

  public boolean getDeboMostrar() {
     return deboMostrar;
  }
  public String getNombre() {
    return nombre;
  }

  public String getRespuesta() {
    return respuesta;
  }

  public void setNumSaludo(int valor) {
    this.numSaludo = valor;
  }
  
  public int getNumSaludo() {
    return numSaludo;
  }

  public void setRespuesta(String resp) {
    this.respuesta = resp;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void doListener(ActionEvent ac) {
    System.out.println("*** " + this.nombre + " ****");
  }
  
  public String cambiar() {
    return "index5";
  }
  public void doMostrar() {
    deboMostrar = true;
    todos = new ArrayList<Saludo>();
    todos.addAll(listes);
    todos.addAll(listen);
    todos.addAll(listfr);
  }
  public void doSomeThing(String lang) {
    deboMostrar = false;
    String veces = " veces";
    String veces_en = " times";
    this.numSaludo++;
    if(lang.equals("es")) {
      this.respuesta = "Hola " +  this.nombre + " ... he saludado " + this.numSaludo;
      listes.add(new Saludo(this.nombre,"es"));
    }
    if(lang.equals("en")) {
      this.respuesta = "Hi " +  this.nombre + " ... I greeted " + this.numSaludo + " times";
      listen.add(new Saludo(this.nombre,"en"));
    }
    if(lang.equals("fr")) {
      this.respuesta = "Salut " +  this.nombre + " ... j'ai salué " + this.numSaludo + " fois";
      listfr.add(new Saludo(this.nombre,"fr"));
    }
    if(numSaludo > 1 && lang.equals("es")){
      this.respuesta = this.respuesta + " veces";
    }
    if(numSaludo == 1 && lang.equals("es")){
      this.respuesta = this.respuesta + " vez";
    }
    this.nombre="";
  }     
  /*public void doSomeThing(String lang) {
    System.out.println("**PPPP* " + this.nombre + " **PPP**");
    this.lang = lang;
    this.numSaludo++;
    this.respuestaes = "Hola " +  this.nombre + " ... he saludado ";
    this.respuestaen = "Hello " + this.nombre + " ... I've greeted ";
    this.respuestafr = "Bonjour " + this.nombre + "... j'ai salué ";

    switch(lang) {
      case "es":
        if(numSaludo == 1){
        this.respuesta = this.respuestaes +  " una vez.";
      } else {
        this.respuesta = this.respuestaes +  this.numSaludo + " veces";
      }
      break;

      case "en":
        if(numSaludo == 1){
        this.respuesta = this.respuestaen +  " one time.";
      } else {
        this.respuesta = this.respuestaen +  this.numSaludo + " times";
      }
      break;

      case "fr":
        if(numSaludo == 1){
        this.respuesta = this.respuestafr +  " une fois.";
      } else {
        this.respuesta = this.respuestafr +  this.numSaludo + " fois";
      }
      break;
    }

    this.nombre="";
    System.out.println("**PPPP* " + this.lang + " **PPP**");
    System.out.println(this.respuesta);
    System.out.println(this.mostrar);

    //¿Cómo guardamos el nombre? Debemos guardarlo en un array luego recorrerlo 
    //para mostrarlo en la tabla de la vista. 


    //return "null";
         
        InputStream in = null;
        try {
            in = new FileInputStream("passwd5.txt");
            OutputStream out = new FileOutputStream(new File("out.txt"));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
  }

  public void saveName(){
    
    //foreach en el que names se recorra incluyendo los nuevos nombres después de los anteriores. 
  }

  public boolean changeShow(){
    this.mostrar = true;
    return mostrar;
  }

  public boolean hideShow(){
    this.mostrar = false;
    return mostrar;
  }

  public boolean getMostrar(){
    return mostrar;
  }

  public void edit(String name){

  }*/
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;



/**
 *@Descripcion: clase NodeUser con sus getters y setters
 * @author catalina
 * @version: 15/10/2023
 */
public class NodeUser {
    
   private String username; 
   private NodeUser pNext; 
   private ListRelaciones relaciones; 
   
   
/**
 * @Descripcion: constructor de la clase NodeUser
 * @author: Catalina Matheus
 * @param username 
 * @version: 15/10/2023
 */
    public NodeUser(String username) {
        this.username = username; 
        this.pNext = null; 
        this.relaciones = new ListRelaciones(); 
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public NodeUser getpNext() {
        return pNext;
    }

    public void setpNext(NodeUser pNext) {
        this.pNext = pNext;
    }

    public ListRelaciones getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(ListRelaciones relaciones) {
        this.relaciones = relaciones;
    }

    

}

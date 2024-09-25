/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *@Descripcion: clase NodeRelaciones con sus getters y setters
 * @author Juan Martin
 * @version: 16/10/2023
 */
public class NodeRelaciones {
    
    private String relaciones;
    private NodeRelaciones pNext;

    public NodeRelaciones(String relaciones) {
        this.relaciones = relaciones;
        this.pNext = null; 
    }
    
    
    
    

    public String getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(String relaciones) {
        this.relaciones = relaciones;
    }

    public NodeRelaciones getpNext() {
        return pNext;
    }

    public void setpNext(NodeRelaciones pNext) {
        this.pNext = pNext;
    }
    
    
}

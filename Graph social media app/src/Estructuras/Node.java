/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * @Descripcion: clase Nodo con su constructor y getters and setters
 * @author Catalina Matheus
 * @param <T> 
 * @version: 14/10/2023
 */
public class Node<T> {

    private T data; 
    private Node pNext; 

    public Node(T data) {
        this.data = data;
        this.pNext = null; 
    }
  
    

    public Node() {
        this.data = null; 
        this.pNext = null; 
        
    }
    
    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the pNext
     */
    public Node getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Node pNext) {
        this.pNext = pNext;
    }

    
    
}

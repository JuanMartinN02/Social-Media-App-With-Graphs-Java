/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * @Descripcion: clase pila con sus metodos mas importantes y sus getters y
 * setters
 * @version: 16/10/2023
 * @author Catalina Matheus
 */
public class Stack<T> {

    private StackNode pCima;
    private int size;

    /**
     * @Descripcion: constructor de la clase Stack
     * @version: 16/10/2023
     * @author: Catalina Matheus
     */
    public Stack() {
        this.pCima = null;
        this.size = 0;
    }

    /**
     * @Descripcion: función que revisa si la pila está vacía
     * @version: 16/10/2023
     * @return
     * @author: Catalina Matheus
     */
    public boolean isEmpty() {
        return pCima == null;

    }
/**
 * @Descripcion: función que inserta en la pila 
 * @param data 
 * @version: 16/10/2023
 * @author: Catalina Matheus 
 */
    public void push(T data) {
        StackNode pAux = new StackNode(data);
        if (this.isEmpty()) {
            this.pCima = pAux;
        } else {
            pAux.setpNext(pCima);
            pCima = pAux;
        }
        size++;
    }

    /**
     * @Descripcion: Elimina el primer nodo del comienzo de la pila 
     * @version: 16/10/2023
     * @author: Catalina Matheus 
     */
    public void pop(){
        if (!this.isEmpty()){
            pCima = pCima.getpNext();
            size --;
        } 
       }
    
    
    /**
     * @Descripcion: funcion que retorna el elemento que se elimino de la pila 
     * @version: 16/10/2023
     * @author: Catalina Matheus 
     * @return 
     */
    public StackNode getPop(){
          if (!this.isEmpty()){
              StackNode pAux;
              pAux = pCima;
              size --;
              pCima = pCima.getpNext();
              return pAux;
          }
          return null;
       }
    
    /**
     * @Descripcion: metodo que imprime por consola la pila
     * @version: 24/10/2023
     * @author: Catalina Matheus
     */
     public void print() {// si lo quieres hacer como un string tienes que pasarle el string como parametro; 
        if (this.isEmpty()) {// pto de quiebre
            System.out.println("//");
        } else {
            StackNode aux = this.getPop();
            System.out.println(aux.getData());
            this.print();
            this.push((T) aux.getData());
        }
    }
    /**
     * @return the pCima
     */
    public StackNode getpCima() {
        return pCima;
    }

    /**
     * @param pCima the pCima to set
     */
    public void setpCima(StackNode pCima) {
        this.pCima = pCima;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

}

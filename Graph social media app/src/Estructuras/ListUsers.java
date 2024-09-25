/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * @Descripcion: clase ListUsers con sus getters y setters
 * @author Catalina Matheus
 * @version: 15/10/2023
 */
public class ListUsers {

    private NodeUser pFirst;
    private NodeUser pLast;
    private int size;

    /**
     * @Descripcion: constructor de la clase ListUsers
     * @author: Catalina Matheus
     * @version: 15/10/2023
     */
    public ListUsers() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;

    }

    /**
     * @Descripcion: funcion que retorna si la lista está vacía
     * @return boolean
     * @author: Catalina Matheus
     * @version: 15/10/2023
     */
    public boolean isEmpty() {
        return this.pFirst == null;
    }

    /**
     * @Descripcion: funcion que vacia la lista
     * @author: Catalina Matheus
     * @version: 17/10/2023
     */
    public void vaciar() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;

    }

    /**
     * @Descripcion: método que agrega al final de la lista
     * @param username
     * @author: Catalina Matheus
     * @version: 15/10/2023
     */

    public void appendLast(String username) {
        NodeUser node = new NodeUser(username);
        if (this.isEmpty()) {
            this.pFirst = node;
            this.pLast = node;
            this.size++;
        } else {
            NodeUser aux = this.pLast;
            aux.setpNext(node);
            this.pLast = node;
            this.size++;
        }

    }

    /**
     * @Descripcion: método que elimina el primer nodo de la lista 
     * @author: Catalina Matheus 
     * @version:17/10/2023
     */
    public void deleteFirst() {
        if (!this.isEmpty()) {
            if (this.size == 1) {
                this.vaciar();
            }else{
               this.pFirst = this.pFirst.getpNext(); 
               this.size --; 
            }
        }
    }
    
    /**
     * @Descripcion: método que elimina el ultimo nodo de la lista 
     * @author: Catalina Matheus 
     * @version: 17/10/2023
     */
    public void deleteLast(){
        if(!this.isEmpty()){
            if(this.size == 1){
                this.vaciar(); 
            }else{
                NodeUser aux = this.pFirst; 
                while(aux.getpNext() != this.pLast){
                    
                    aux = aux.getpNext(); 
                }
                aux.setpNext(null);
                this.pLast = aux; 
                this.size --; 
                
            }
        }
    }

    /** 
     * @Descripcion: metodo que elimina el usuario pasado por parametro de la lista 
     * @param username 
     * @author: Catalina Matheus 
     * @version: 17/10/2023
     */
    public void deleteUser(String username){
        if(!this.isEmpty()){
            NodeUser aux = this.pFirst; 
            if(aux.getUsername().equals(username)){
                this.deleteFirst(); 
            }else if(this.pFirst.getUsername().equals(username)){
                this.deleteLast(); 
            }else{
                if(this.usernameExists(username)){
                    NodeUser aux2 = this.pFirst.getpNext(); 
                    while(aux2 != null){
                        if(aux2.getUsername().equals(username)){
                            NodeUser aux3 = aux2.getpNext(); 
                            aux.setpNext(aux3);
                            this.size --; 
                            
                        }aux2 = aux2.getpNext(); 
                        aux = aux.getpNext(); 
                    }
                }
            }
        }
        
    }
    
    
    /**
     * @Descripcion: funcion que retorna un booleano que indica si el string pasado por parametro esta en la lista 
     * @param username
     * @return boolean
     * @author: Catalina Matheus 
     * @version: 17/10/2023
     */
    public boolean usernameExists(String username){
        boolean existe = false; 
        if(this.isEmpty()){
            return existe; 
        }else{
            if(this.pFirst.getUsername().equals(username) || this.pLast.getUsername().equals(username)){
                existe = true; 
                return existe; 
            }else{
                NodeUser aux = this.pFirst; 
                while(aux!= null){
                    if(aux.getUsername().equals(username)){
                        existe = true; 
                        return existe; 
                    }
                    aux = aux.getpNext(); 
                }
            }
        }return existe; 
    }
    /**
     * @return the pFirst
     */
    public NodeUser getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodeUser pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public NodeUser getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(NodeUser pLast) {
        this.pLast = pLast;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * @Descripcion: clase ListRelaciones
 * @author Juan Martin
 * @version: 16/10/2023
 */
public class ListRelaciones {

    private NodeRelaciones pFirst;
    private NodeRelaciones pLast;
    private int size;

    /**
     * @Descripcion: Constructor ListRelaciones
     * @author Juan Martin
     * @version: 16/10/2023
     */
    public ListRelaciones() {
        pFirst = null;
        pLast = null;
        size = 0;
    }

    /**
     * @Descripcion: Funciones ListRelaciones
     * @author Juan Martin
     * @version: 16/10/2023
     */
    public boolean isEmpty() {
        return this.pFirst == null;
    }

    /**
     * @Descripcion: método que agrega al final de la lista 
     * @author: Juan Martin y Catalina Matheus 
     * @param relaciones 
     * @version 22/10/2023
     */
    public void appendLast(String relaciones) {
        NodeRelaciones node = new NodeRelaciones(relaciones);
        if (isEmpty()) {
            this.pFirst = node;
            this.pLast = node;
            this.size++;
        } else if(!this.isEmpty() && !this.itExists(relaciones)) {
            pLast.setpNext(node);
            pLast = node;
            this.size++;
        }
    }

    
    public boolean itExists(String relacion){
        boolean existe = false; 
        if(this.isEmpty()){
            return existe;  
        }else{
            NodeRelaciones aux = this.pFirst; 
            while(aux!= null){
                if(aux.getRelaciones().replace(" ", "").equals(relacion.replace(" ", ""))){
                    existe = true; 
                    return existe; 
                }
                aux = aux.getpNext(); 
            }
            return existe; 
        }
    }
    /**
     * @Descripcion: metodo que imprime las relaciones del nodo
     * @author: Juan Martin
     * @version: 16/10/2023
     */
    public void print() {
        String mostrar = "";

        if (isEmpty()) {
            System.out.println("Vacia!");
        } else {
            NodeRelaciones aux = pFirst;

            while (aux != null) {
                mostrar += aux.getRelaciones();
                aux = aux.getpNext();
            }
            System.out.println(mostrar);
        }
    }

    /**
     * @Descripcion: metodo que vacia la lista de relaciones
     * @author: Catalina Matheus
     * @version: 17/10/2023
     */
    public void vaciar() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * @Descripcion: metodo que elimina al comienzo de la lista
     * @author: Catalina Matheus
     * @version: 17/10/2023
     */
    public void deleteStart() {
        if (!this.isEmpty()) {
            if (this.size == 1) {

                this.vaciar();
            } else {
                this.pFirst = this.pFirst.getpNext();
                this.size--;
            }
        }
    }

    /**
     * @Descripcion: metodo que elimina el ultimo nodo de la lista
     * @author: Catalina Matheus
     * @version: 17/10/2023
     */
    public void deleteEnd() {
        if (!this.isEmpty()) {
            if (this.size == 1) {
                this.vaciar();
            } else {
                NodeRelaciones aux = this.pFirst;
                while (aux.getpNext() != this.pLast) {
                    aux = aux.getpNext();
                }
                aux.setpNext(null);
                this.pLast = aux;
                this.size--;
            }
        }
    }

    /**
     * @Descripcion: metodo que eliminar la relacion con el usuario que se paso
     * por parametro
     * @param username
     * @author: Catalina Matheus
     * @version: 17/10/2023
     */
    public void deleteRelacion(String username) {
        boolean existe = this.relacionExiste(username);
        if (existe) {
            if (this.pFirst.getRelaciones().replace(" ", "").equals(username.replace(" ", ""))) {
                this.deleteStart();
            } else if (this.pLast.getRelaciones().replace(" ", "").equals(username.replace(" ", ""))) {
                this.deleteEnd();
            } else {
                NodeRelaciones aux = this.pFirst;
                NodeRelaciones aux2 = this.pFirst.getpNext();
                while (aux != null) {
                    if (aux2.getRelaciones().replace(" ", "").equals(username.replace(" ", ""))) {
                        NodeRelaciones aux3 = aux2.getpNext();
                        aux.setpNext(aux3);
                        this.size--;
                    }

                    aux = aux.getpNext();
                    aux2 = aux2.getpNext();
                }

            }
        }

    }

    /**
     * @Descripcion: funcion que retorna si el usuario existe en la lista de
     * relaciones o no
     * @param username
     * @return
     * @author: Catalina Matheus
     * @version: 17/10/2023
     */
    public boolean relacionExiste(String username) {
        boolean existe = false;
        if (this.isEmpty()) {
            return existe;
        } else {
            NodeRelaciones aux = this.pFirst;
            while (aux != null) {
                if (aux.getRelaciones().replace(" ", "").equals(username.replace(" ", ""))) {
                    existe = true;
                    return existe;
                }
                aux = aux.getpNext();
            }
        }

        return existe;

    }

    /**
     * @Descripcion: ListRelaciones Getters y setters
     * @author Juan Martin
     * @version: 16/10/2023
     */
    public NodeRelaciones getpFirst() {
        return pFirst;
    }

    public void setpFirst(NodeRelaciones pFirst) {
        this.pFirst = pFirst;
    }

    public NodeRelaciones getpLast() {
        return pLast;
    }

    public void setpLast(NodeRelaciones pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

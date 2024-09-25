/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

import Estructuras.Stack;

/**
 *@Descripcion: clase con los atributos del DFS
 * @author Catalina Matheus
 * @version 26/10/2023
 */
public class ODFS {
    
    private Stack pila; 
    private boolean[] visited; 
    private String[] usernames; 

    /**
     * @return the pila
     */
    public Stack getPila() {
        return pila;
    }

    /**
     * @param pila the pila to set
     */
    public void setPila(Stack pila) {
        this.pila = pila;
    }

    /**
     * @return the visited
     */
    public boolean[] getVisited() {
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    /**
     * @return the usernames
     */
    public String[] getUsernames() {
        return usernames;
    }

    /**
     * @param usernames the usernames to set
     */
    public void setUsernames(String[] usernames) {
        this.usernames = usernames;
    }
    
    
    
    
}

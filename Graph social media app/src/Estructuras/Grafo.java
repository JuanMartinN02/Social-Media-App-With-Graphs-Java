/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * @Nombre: Grafo
 * @author Catalina Matheus Descripcion: clase grafo con sus getters and setters
 * @version: 15/10/2023
 *
 */
public class Grafo {

    private ListUsers users;
    private int V;

    public Grafo() {
        this.users = new ListUsers();
    }
    
    
   

    /**
     * @Descripcion: método que vacía el grafo
     * @author: Catalina Matheus
     * @version: 16/10/2023
     */
    public void emptyGraph() {
        this.users.setpFirst(null);
        this.users.setpLast(null);
        this.users.setSize(0);
    }

    /**
     * @Descripcion: función que indica si el grafo está vacío
     * @author: Catalina Matheus
     * @version: 16/10/2023
     * @return
     */
    public boolean isGraphEmpty() {
        return this.users.getpFirst() == null;
    }

    public void dfs(int v, boolean visited[]) {
        visited[v] = true;
        int n;
        
        
        
        
    }
    
    public Grafo getTranspose(){
        Grafo g = new Grafo();
        NodeUser aux = this.users.getpFirst();
        while(aux!= null){
            g.users.appendLast(aux.getUsername());
            aux = aux.getpNext(); 
        }
         aux = this.users.getpFirst();// grafo principal
         NodeUser aux3 = g.getUsers().getpFirst(); // nuevo grafo
        for (int v = 0; v < this.users.getSize(); v++) {
            NodeRelaciones aux2 = aux.getRelaciones().getpFirst();// relacion en el grafo principal
            NodeUser aux4 = this.users.getpFirst();
            while(aux2 != null){
                System.out.println(aux4.getUsername().replace(" ", ""));
                System.out.println(aux3.getUsername());
                boolean iguales = aux4.getUsername().replace(" ", "").equals(aux3.getUsername()); 
                System.out.println(iguales);
                System.out.println("");
                if((aux4.getUsername().replace(" ", "")).equals(aux3.getUsername().replace(" ", ""))){
                    aux3.getRelaciones().appendLast(aux.getUsername());
                    
                }
                aux2 = aux2.getpNext(); 
                aux4 = aux4.getpNext();
            }
            aux = aux.getpNext();
            aux3 = aux3.getpNext(); 
            
        }return g; 
    }
    

    /**
     * @return the users
     */
    public ListUsers getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(ListUsers users) {
        this.users = users;
    }

}

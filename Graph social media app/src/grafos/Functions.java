/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

import Estructuras.Grafo;
import Estructuras.List;
import Estructuras.Node;
import Estructuras.NodeRelaciones;
import Estructuras.NodeUser;
import Estructuras.Stack;
import Estructuras.StackNode;
import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 * @Descripcion: clase functions donde esta la funcion para mostrar el grafo
 * @author Catalina Matheus
 * @version: 22/10/2023
 */
public class Functions {

    App app = App.getInstance();

    /**
     * @Descripcion: método que muestra el grafo
     * @author: Catalina Matheus
     * @version: 22/10/2023
     */
    public void showGraph() {
        Graph g = new SingleGraph("Grafo");
        // agregamos primero los nodos
        NodeUser aux = app.getGraph().getUsers().getpFirst();

        while (aux != null) {
            g.addNode(aux.getUsername().replace(" ", "")).setAttribute("ui.label", aux.getUsername().replace(" ", ""));
            aux = aux.getpNext();
        }

        // ahora agregamos las relaciones: 
        NodeUser auxOrigen = app.getGraph().getUsers().getpFirst();
        while (auxOrigen != null) {
            NodeRelaciones auxRelacion = auxOrigen.getRelaciones().getpFirst();

            while (auxRelacion != null) {
                g.addEdge(auxOrigen.getUsername().replace(" ", "") + auxRelacion.getRelaciones().replace(" ", ""), auxOrigen.getUsername().replace(" ", ""), auxRelacion.getRelaciones().replace(" ", ""), true);
                auxRelacion = auxRelacion.getpNext();
            }
            auxOrigen = auxOrigen.getpNext();
        }
        // falggggg
        g.setAttribute("ui.antialias");
        g.setAttribute("ui.stylesheet", "node{\n" + "size: 100px, 30px;\n fill-color: #add8e6;\n } edge{\n text-background-mode: plain; \n}");
        System.setProperty("org.graphstream.ui", "swing");

        Viewer viewer = g.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

    }

    /**
     * @Descripcion: método que muestra el grafo de los nodos fuertemente conectados
     * @author: Reinaldo Reyes, Juan Martin
     * @throws IOException
     * @version: 25/10/2023
     */
    public void showSCC() throws IOException {
        Graph g = new SingleGraph("Grafo");
        // agregamos primero los nodos
        NodeUser aux = app.getGraph().getUsers().getpFirst();

        while (aux != null) {
            g.addNode(aux.getUsername().replace(" ", "")).setAttribute("ui.label", aux.getUsername().replace(" ", ""));
            aux = aux.getpNext();
        }

        // ahora agregamos las relaciones: 
        NodeUser auxOrigen = app.getGraph().getUsers().getpFirst();
        while (auxOrigen != null) {
            NodeRelaciones auxRelacion = auxOrigen.getRelaciones().getpFirst();

            while (auxRelacion != null) {
                g.addEdge(auxOrigen.getUsername().replace(" ", "") + auxRelacion.getRelaciones().replace(" ", ""), auxOrigen.getUsername().replace(" ", ""), auxRelacion.getRelaciones().replace(" ", ""), true);
                auxRelacion = auxRelacion.getpNext();
            }
            auxOrigen = auxOrigen.getpNext();
        }

        g.setAttribute("ui.antialias");
        String palabra = this.Kosaraju(); // Utiliza la funcion de Kosaraju
        List<String> lista = this.Acomodarnot(palabra); // utilaza una funcion para crear una lista del string
        List<List<String>> lista_big = this.Acomodar(palabra);// utilaza una funcion para crear una lista de lista del string
        Node<List> outer_aux = lista_big.getpFirst();
        List<String> inner_list = outer_aux.getData();

        String color;
        
        int contador = 0;
        String[] colores= {"#968e8a","#1783bd","#11899c","#119c60","#adbd1e","#bd8b1e","#bd461e","#7a1b17","#803473","#7d3d4f","#679cbf","#9dd466","#d62424","#7f1ec9","#7b8244"}; // lista de colores para usar
        color = colores[contador];
        
        this.color(g, lista, color); // se le asigna un color a la lista de nodos no fuertemente conectado
        
        inner_list.print();
        while (true) {
            contador ++;
            color = colores[contador];
            this.color(g, inner_list,color);// se le asigna un color a cada una de las listas de nodos fuertemente conectado
            
            if (outer_aux.getpNext() != null) {
                outer_aux = outer_aux.getpNext();
                inner_list = outer_aux.getData();
            }else{
            break;
            }
        }

        System.setProperty(
                "org.graphstream.ui", "swing");

        Viewer viewer = g.display();

        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

    }
     /**
     * @Descripcion: método que le coloca un color a los nodos que esten fuertemente conectados
     * @param g
     * @param lista
     * @param color
     * @author: Reinaldo Reyes
     * @version: 25/10/2023
     */
    public void color(Graph g, List lista, String color) {
        if (!lista.isEmpty()) {
            org.graphstream.graph.Node nodeA;
            Node auxlist = lista.getpFirst();
            NodeUser auxcolor = app.getGraph().getUsers().getpFirst();
            while (true) {
                String data = "fill-color: n; size: 100, 30px;";
                data = data.replace("n", color.replace(" ", ""));
                if (auxcolor.getUsername().equals(auxlist.getData())) {
                    nodeA = g.getNode(auxcolor.getUsername());

                    nodeA.setAttribute("ui.style", data); // Establecer
                    if (auxlist.getpNext() != null) {
                        auxlist = auxlist.getpNext();
                        auxcolor = app.getGraph().getUsers().getpFirst();
                    }else{
                        
                    break;
                    }
                }
                
                auxcolor = auxcolor.getpNext();
                
            }
        }
    }
    

    /**
     * @Descripcion: metodo que realiza la busqueda en profundidad
     * @param graph
     * @author: Catalina Matheus
     * @version:24/10/2023
     */
    public ODFS DFS() {

        // creamos arreglo de usuarios: 
        String[] usernameArray = new String[app.getGraph().getUsers().getSize()];
        NodeUser aux = app.getGraph().getUsers().getpFirst();
        System.out.println("ESTE ES EL GRAFO QUE SALE EN ");
        app.printGraph();
        for (int i = 0; i < app.getGraph().getUsers().getSize(); i++) {
            if(aux != null){
            usernameArray[i] = aux.getUsername();
            aux = aux.getpNext();
            }}

        // creamos arreglo de booleanos (todo empieza en false)
        boolean[] visited = new boolean[app.getGraph().getUsers().getSize()];

        Stack pila = new Stack(); // donde voy a poner los usuarios cuando ya no hay ningun lugar mas para recorrer
        Stack pilaVisitados = new Stack(); // para ir metiendo los nodos mientras los visito 

        //empezamos con el primero en la lista: 
        String userToCheck = app.getGraph().getUsers().getpFirst().getUsername();
        visited[0] = true;
        pilaVisitados.push(userToCheck);
        System.out.println("EMPEZAMOS A VISITAR!!!!!");
        System.out.println("VISITADO: " + usernameArray[0]);
        while (!pilaVisitados.isEmpty()) {
            String userPila = (String) pilaVisitados.getpCima().getData();
            NodeUser nodeUserToCheck = this.getNode(userPila, app.getGraph());
            boolean encontrado = false;
            if (!nodeUserToCheck.getRelaciones().isEmpty()) {
                NodeRelaciones aux1 = nodeUserToCheck.getRelaciones().getpFirst();
                for (int i = 0; i < nodeUserToCheck.getRelaciones().getSize(); i++) {
                    if (!this.wasVisited(usernameArray, visited, aux1.getRelaciones())) {
                        encontrado = true;
                        this.markVisited(aux1.getRelaciones(), visited, usernameArray);// se marca como visitado
                        pilaVisitados.push(aux1.getRelaciones()); // lo metemos en la pila
                        System.out.println("VISITADO: " + pilaVisitados.getpCima().getData());
                        break;
                    }
                    aux1 = aux1.getpNext();
                }
            }
            System.out.println("LA PILA DEL DFS: ");
            pilaVisitados.print();
            System.out.println("EL VALOR DE ENCONTRADO: " + encontrado);
            if (!encontrado) {
                StackNode p = pilaVisitados.getPop();
                pila.push(p.getData().toString().replace(" ", ""));
            }

        }
        while(!pilaVisitados.isEmpty()){
            StackNode p = pilaVisitados.getPop(); 
            pila.push(p.getData()); 
        }
        pila.print();
        ODFS ret = new ODFS(); 
        ret.setPila(pila);
        ret.setUsernames(usernameArray);
        ret.setVisited(visited);
        return ret; 
    }
    
    /**
     * @Descripcion: funcion que termina de visitar los nodos a los que no se les puede llegar a traves de otros 
     * @return 
     * @author: Catalina Matheus 
     * @version: 26/10/2023
     */
    public Stack complementoDFS(){
        ODFS dfs = this.DFS(); 
        String[] usernameArray = dfs.getUsernames(); 
        boolean[] visited = dfs.getVisited(); 
        Stack pila = dfs.getPila(); 
        if(!this.done(visited)){
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    pila.push(usernameArray[i]);
                }
                
            }
        }
        return pila; 
    }

    /**
     * @Descripcion: algoritmo Kosaraju
     * @throws IOException
     * @version: 25/10/2023
     * @author: Catalina Matheus
     */
    public String Kosaraju() throws IOException {
        
        Stack pila = this.complementoDFS(); // esta es la pila que necesitamos para el algoritmo
        app.invertirGraph();
        Grafo grafoInvertido = app.getT();

        String devolver = this.extraKosaraju(pila, grafoInvertido);

        return devolver;
    }

    /**
     * @Descripcion: funcion que hace el DFS del grafo invertido
     * @param pila
     * @param grafoInvertido
     * @version: 25/10/2023
     * @author: Catalina Matheus
     */
    public String extraKosaraju(Stack pila, Grafo grafoInvertido) {

        Stack visitados = new Stack();// donde voy a guardar el username que tengo que revisar 
        String strongComponents = "";// se separa por salto de linea los diferentes subgrafos y por ',' los usuarios
        String[] usernameArray = new String[grafoInvertido.getUsers().getSize()];// donde vamos a tener el orden de los usernames
        // primero se llena el array: 
        NodeUser aux1 = grafoInvertido.getUsers().getpFirst();
        for (int i = 0; i < grafoInvertido.getUsers().getSize(); i++) {
            usernameArray[i] = aux1.getUsername();
            aux1 = aux1.getpNext();
        }

        boolean[] visited = new boolean[grafoInvertido.getUsers().getSize()];// donde marcaremos si fue visitado o no (todos empiezan en falso)
        while (!pila.isEmpty()) {
            StackNode aux;
            if (visitados.isEmpty()) {
                aux = pila.getPop(); //agarramos el primero de la pila, con este es que empieza el recorrido!
                visitados.push(aux.getData());// meto en la pila de visitados 
                this.markVisited((String) aux.getData(), visited, usernameArray);// lo marco visitado 
                strongComponents += aux.getData() + ","; // se agrega al string 

            } else {
                aux = visitados.getpCima(); //agarramos el primero de la pila, con este es que empieza el recorrido!
                this.markVisited((String) aux.getData(), visited, usernameArray);// lo marco visitado 
                strongComponents += aux.getData() + ","; // se agrega al string 

            }
            // ahora tengo que revisar las relaciones: 
            aux = visitados.getPop(); // SACO DE LA PILA
            System.out.println(aux.getData());
            NodeUser nodeUserToCheck = this.getNode(((String) aux.getData()).replace(" ", ""), grafoInvertido); // el nodo usuario que estoy revisando
            boolean encontrado = false;
            if (!nodeUserToCheck.getRelaciones().isEmpty()) {
                NodeRelaciones aux2 = nodeUserToCheck.getRelaciones().getpFirst();
                for (int i = 0; i < nodeUserToCheck.getRelaciones().getSize(); i++) {
                    if (!this.wasVisited(usernameArray, visited, aux2.getRelaciones())) {
                        visitados.push(aux2.getRelaciones());// metemos en la pila 
                        encontrado = true;
                        break;
                    }
                    aux2 = aux2.getpNext();
                }

            }
            if (!encontrado) {
                strongComponents += "\n";
                boolean pop = false;
                StackNode aux3;
                while (!pop && !pila.isEmpty()) {
                    aux3 = pila.getpCima();

                    if (!this.wasVisited(usernameArray, visited, (String) aux3.getData())) { // si ese todavia no ha sido visitado lo dejo ahi 
                        pop = true;
                    } else {
                        pila.pop();
                    }

                }

            }

        }
        System.out.println("COMPONENTES FUERTEMENTE CONECTADOS: ");

        return strongComponents;
    }

    /**
     * @Descripcion: funcion que acomoda un string en listas de listas
     * @param componentes
     * @version: 26/10/2023
     * @author: Reinaldo Reyes
     */
    public List Acomodar(String componentes) {
        String[] lines = componentes.replace(" ", "").split("\n");// Dividir la cadena original en  un array utilizando "\n" como separador
        List<List<String>> result = new List<List<String>>();
        for (int i = 0; i < lines.length; i++) {

            // Dividir cada línea por comas
            String[] elements = lines[i].split(",");

            List<String> innerList = new List<String>();

            for (int j = 0; j < elements.length; j++) {
                innerList.appendLast(elements[j]);

            }
            if (innerList.getSize() - 1 != 1) {
                result.appendLast(innerList);

            }
        }
        return result;
    }

    /**
     * @Descripcion: funcion que acomoda un string en listas 
     * @param componentes
     * @version: 26/10/2023
     * @author: Reinaldo Reyes, Juan Martin
     */
    public List Acomodarnot(String componentes) {
        String[] lines = componentes.replace(" ", "").split("\n");// Dividir la cadena original en  un array utilizando "\n" como separador
        List<String> result = new List<String>();

        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
            // Dividir cada línea por comas
            String[] elements = lines[i].split(",");
            List<String> notScc = new List<String>();
            for (int j = 0; j < elements.length; j++) {
                notScc.appendLast(elements[j]);
            }
            if (notScc.getSize() - 1 == 1) {
                result.appendLast(notScc.getpFirst().getData().toString().replace(" ", ""));

            }
        }

        return result;
    }

    

    /**
     * @Descripcion: funcion que revisa si el usuario ya fue visitado o no
     * @param usernameArray
     * @param visited
     * @param username
     * @return
     * @author: Catalina Matheus
     * @version: 24/10/2023
     */
    public boolean wasVisited(String[] usernameArray, boolean[] visited, String username) {
        int contador = 0;
        for (int i = 0; i < usernameArray.length; i++) {
            if (usernameArray[i].replace(" ", "").equals(username.replace(" ", ""))) {
                contador = i;
                break;
            }
        }
        return visited[contador];

    }

    /**
     * @Descripcion: revisa si todos los nodos del grafo fueron visitados
     * @param visited
     * @return
     * @author: Catalina Matheus
     * @version: 24/10/2023
     */
    public boolean done(boolean[] visited) {
        boolean result = true;
        for (int i = 0; i < visited.length; i++) {
            result = result & visited[i];

        }
        return result;
    }

    /**
     * @Descripcion: busca el nodo en el grafo dado el usuario
     * @param username
     * @param graph
     * @return
     * @author: Catalina Matheus
     * @version: 24/10/2023
     */
    public NodeUser getNode(String username, Grafo graph) {
        NodeUser nodito = graph.getUsers().getpFirst();
        while (nodito != null) {
            if (nodito.getUsername().replace(" ", "").equals(username.replace(" ", ""))) {
                return nodito;
            }
            nodito = nodito.getpNext();
        }
        return nodito;

    }

    /**
     * @Descripcion: marca el usuario como visitado dado el usuario, el arreglo
     * de booleanos y el arreglo de usuarios
     * @param username
     * @param visited
     * @param usernameArray
     * @author: Catalina Matheus
     * @version: 24/10/2023
     */
    public void markVisited(String username, boolean[] visited, String[] usernameArray) {
        for (int i = 0; i < usernameArray.length; i++) {
            if (usernameArray[i].replace(" ", "").equals(username.replace(" ", ""))) {
                visited[i] = true;
                break;
            }
        }
    }

}

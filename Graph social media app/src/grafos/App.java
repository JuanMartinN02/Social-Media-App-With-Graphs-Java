/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

import Estructuras.Grafo;
import Estructuras.NodeRelaciones;
import Estructuras.NodeUser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @Nombre: App
 * @Descripcion: clase app que tiene diseño singleton para solo crear 1
 * instancia de la clase app
 * @author Catalina
 * @version 14/10/2023
 */
public class App {

    private Grafo graph;
    private Grafo T;

    private static App app;

    /**
     * @Descripcion: constructor de la clase App (se crea la instancia de la
     * clase Grafo)
     * @author: Catalina Matheus
     * @version: 15/10/2023
     */
    private App() {
        this.graph = new Grafo();
        this.T = new Grafo();
    }

    /**
     * @Nombre: getInstance
     * @Descripcion: retorna la unica instancia de app que hay y si no existe la
     * crea
     * @author: Catalina Matheus
     * @version 14/10/2023
     * @return: app
     */
    public static synchronized App getInstance() {
        if (getApp() == null) {
            setApp(new App());
        }
        return getApp();
    }

    /**
     * @Descripcion: metodo que verifica si el archivo dado es un txt con el
     * path que se pase por parametro
     * @param path
     * @author: Reinaldo Reyes
     * @version: 16/10/2023
     */
    public boolean validTxt(String nombreArchivo) {
        if (nombreArchivo.toLowerCase().endsWith(".txt")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @Descripcion: metodo que verifica si el txt dado cumple con la estructura
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @author: Catalina Matheus
     * @version: 16/10/2023
     */
    public boolean VerifyArchive(String path) throws FileNotFoundException, IOException {
        String line;
        boolean contieneUsuarios = false;
        boolean contieneRelaciones = false;
        boolean contieneIlegal = true; // para cualquier linea que no tenga "usuarios, relaciones o un "@"
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (line.contains("usuarios")) {
                    contieneUsuarios = true;
                }
                if (line.contains("relaciones")) {
                    contieneRelaciones = true;
                }
                if (!contieneUsuarios && !contieneRelaciones && !line.contains("@")) {
                    contieneIlegal = false;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! El txt que montó no tiene la estructura permitida.");
        }
        return contieneUsuarios && contieneRelaciones && contieneIlegal;

    }

    /**
     * @Descripcion: metodo que crea un nuevo txt y le añade nuevos usuarios y
     * nuevas relaciones
     * @param path, user, relaciones
     * @author: Reinaldo Reyes
     * @version: 17/10/2023
     */
    public void Addtxt(String path, String user, String[] relaciones) {
        try {
            FileWriter fw = new FileWriter("src//Txt//Usuarioscopy.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            bw.write(line);
            int limite = 0;
            while ((line = br.readLine()) != null) {
                bw.write("\n" + line);

                if (limite == 0) {
                    bw.write("\n" + "@" + user);
                    limite++;
                }
                if (line.equals("relaciones")) {
                    for (int i = 0; i < relaciones.length; i++) {
                        bw.write("\n" + "@" + user + ", " + relaciones[i]);
                    }
                }
            }
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");

        }

    }

    /**
     * @Descripcion: metodo que crea un nuevo txt y le añade nuevas relaciones
     * al nuevo usuario
     * @param path, user, relaciones
     * @author: Reinaldo Reyes
     * @version: 19/10/2023
     */
    public void Addtxtr(String path, String user, String[] relaciones) {
        try {
            FileWriter fw = new FileWriter("src//Txt//Usuarioscopy.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            bw.write(line);
            while ((line = br.readLine()) != null) {
                bw.write("\n" + line);
                if (line.equals("relaciones")) {
                    for (int i = 0; i < relaciones.length; i++) {
                        bw.write("\n" + relaciones[i] + ", " + "@" + user);
                    }
                }
            }
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");

        }

    }

    /**
     * @Descripcion: metodo que crea un nuevo txt y le añade nuevos usuarios y
     * nuevas relaciones
     * @param path, user
     * @author: Reinaldo Reyes
     * @version: 23/10/2023
     */
    public void Addusertxt(String path, String user) {
        try {
            FileWriter fw = new FileWriter("src//Txt//Usuarioscopy.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            bw.write(line);
            int limite = 0;
            while ((line = br.readLine()) != null) {
                bw.write("\n" + line);

                if (limite == 0) {
                    bw.write("\n" + user);
                    limite++;
                }
            }
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");

        }

    }

    /**
     * @Descripcion: metodo que crea un nuevo txt y le añade una relacion al
     * nuevo usuario
     * @param path, user, re_user
     * @author: Reinaldo Reyes
     * @version: 23/10/2023
     */
    public void Addrelaciontxt(String path, String user, String re_user) {
        try {
            FileWriter fw = new FileWriter("src//Txt//Usuarioscopy.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            bw.write(line);
            while ((line = br.readLine()) != null) {
                bw.write("\n" + line);
                if (line.equals("relaciones")) {
                    bw.write("\n" + re_user + ", " + user);
                }
            }
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");

        }

    }

    /**
     * @Descripcion: metodo que crea un nuevo txt y le añade nuevas relaciones
     * al nuevo usuario
     * @param path, user, relaciones
     * @author: Reinaldo Reyes
     * @version: 19/10/2023
     */
    public void Eliminatetxt(String user) {
        try {
            String relacionesString = "";
            FileWriter fw = new FileWriter("src//Txt//Usuarioscopy.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            FileReader fr = new FileReader("src//Txt//Usuarios1.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            bw.write(line);
            while ((line = br.readLine()) != null) {
                if (!line.equals(user)) {
                    bw.write("\n" + line);
                    if (line.equals("relaciones")) {
                        break;
                    }
                }
            }
            System.out.println("");
            while ((line = br.readLine()) != null) {
                if (line.startsWith("@")) {
                    if (line.contains(",")) {
                       line.replace(" ", "");
                        relacionesString += line + "\n";
                    }
                }
            }

            String[] lines = relacionesString.split("\n");
            for (int i = 0; i < lines.length; i++) {
                String[] lectura = lines[i].split(",");
                if (!lectura[0].equals(user) && !lectura[1].replace(" ", "").equals(user)) {
                    bw.write("\n" + lectura[0] + "," + lectura[1]);
                }
            }
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error pppp");

        }

    }

    /**
     * @Descripcion: metodo que remplaza un txt por la version actualizada del
     * mismo
     * @param path, pathcopy
     * @author: Reinaldo Reyes
     * @version: 17/10/2023
     */
    public void copyTxt(String path, String pathcopy) {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            FileReader fr = new FileReader(pathcopy);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            bw.write(line);
            while ((line = br.readLine()) != null) {
                bw.write("\n" + line);
            }
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");

        }

    }

    /**
     * @Descripcion: metodo que lee el txt con el path que se pase por parametro
     * @param path
     * @author: Catalina Matheus
     * @version: 15/10/2023
     */
    // falta validar el txt!!
    // y vaciar cuando se quiera colocar otro txt!
    public void leerTxt(String path) throws IOException {
        String relacionesString = "";
        if (!this.graph.isGraphEmpty()) {// vaciamos primero el grafo para meter la nueva información 
            this.getGraph().emptyGraph();
        }
        if (validTxt(path) && this.VerifyArchive(path)) {
            try {
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("@")) {
                        if (line.contains(",")) {
                            line.replace(" ", "");
                            relacionesString += line + "\n";
                        } else {
                            getGraph().getUsers().appendLast(line);
                        }
                    }
                }

                if (!relacionesString.equals("")) {
                    String[] lines = relacionesString.split("\n");
                    for (int i = 0; i < lines.length; i++) {
                        String[] lectura = lines[i].split(",");
                        this.insertRelation(lectura[0], lectura[1]);
                    }
                }
                JOptionPane.showMessageDialog(null, "Se logró leer el txt con éxito!");
                this.printGraph();
                this.app.copyTxt("src//Txt//Usuarios1.txt", path);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error! No se logró leer el txt.");
            }
        } else if (!validTxt(path)) {
            JOptionPane.showMessageDialog(null, "Error! El archivo dado no es un .txt");
        } else if (!this.VerifyArchive(path)) {
            JOptionPane.showMessageDialog(null, "Error! El archivo que colocó no tiene el formato permitido.");
        }
    }

    /**
     * @Descripcion: metodo que lee el txt con el path que se pase por parametro
     * @param path
     * @author: Catalina Matheus
     * @version: 15/10/2023
     */
    public void leerTxteliminado(String path) throws IOException {
        String relacionesString = "";
        if (!this.graph.isGraphEmpty()) {// vaciamos primero el grafo para meter la nueva información 
            this.getGraph().emptyGraph();
        }
        if (validTxt(path) && this.VerifyArchive(path)) {
            try {
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("@")) {
                        if (line.contains(",")) {
                            line.replace(" ", "");
                            relacionesString += line + "\n";
                        } else {
                            getGraph().getUsers().appendLast(line);
                        }
                    }
                }

                if (!relacionesString.equals("")) {
                    String[] lines = relacionesString.split("\n");
                    for (int i = 0; i < lines.length; i++) {
                        String[] lectura = lines[i].split(",");
                        this.insertRelation(lectura[0], lectura[1]);
                    }
                }

                this.app.copyTxt("src//Txt//Usuarios1.txt", path);
            } catch (Exception e) {

            }

        }
    }

    /**
     * @Descripcion: método que inserta en la lista "Relaciones" del nodo origen
     * el string destino
     * @param origen
     * @param destino
     * @author: Catalina Matheus
     * @version: 15/10/2023
     */
    public void insertRelation(String origen, String destino) {
        NodeUser aux = getGraph().getUsers().getpFirst();
        while (aux != null) {
            if (aux.getUsername().equals(origen)) {
                aux.getRelaciones().appendLast(destino);
                break;
            }
            aux = aux.getpNext();
        }

    }

    /**
     * @Descripcion: metodo que elimina las relaciones de los nodos con el
     * username ingresado por parametro
     * @param username
     * @author: Catalina Matheus
     * @version: 17/10/2023
     */
    public void eliminateRelations(String username) {
        NodeUser aux = this.graph.getUsers().getpFirst();
        while (aux != null) {
            aux.getRelaciones().deleteRelacion(username);
            aux = aux.getpNext();
        }
    }

    /**
     * @Descripcion: función hace un grafo con las relaciones invertidas
     * @author: Catalina Matheus, Reinaldo Reyes, Juan Martin
     * @version: 18/10/2023
     * @return
     */
    public void invertirGraph() throws IOException {
        String relacionesString = "";
        if (!this.T.isGraphEmpty()) {// vaciamos primero el grafo para meter la nueva información 
            this.getT().emptyGraph();
        }
        if (validTxt("src//Txt//Usuarios1.txt") && this.VerifyArchive("src//Txt//Usuarios1.txt")) {
            try {
                FileReader fr = new FileReader("src//Txt//Usuarios1.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("@")) {
                        if (line.contains(",")) {
                            line.replace(" ", "");
                            relacionesString += line + "\n";
                        } else {
                            getT().getUsers().appendLast(line);
                        }
                    }
                }

                if (!relacionesString.equals("")) {
                    String[] lines = relacionesString.split("\n");
                    for (int i = 0; i < lines.length; i++) {
                        String[] lectura = lines[i].split(",");

                        this.insertRelationT(lectura[1].replace(" ", ""), lectura[0].replace(" ", ""));
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error! No se logró leer el txt.");
            }
        } else if (!validTxt("src//Txt//Usuarios1.txt")) {
            JOptionPane.showMessageDialog(null, "Error! El archivo dado no es un .txt");
        } else if (!this.VerifyArchive("src//Txt//Usuarios1.txt")) {
            JOptionPane.showMessageDialog(null, "Error! El archivo que colocó no tiene el formato permitido.");
        }

    }

    /**
     * @Descripcion: método que inserta en la lista "Relaciones" del nodo origen
     * el string destino
     * @param origen
     * @param destino
     * @author: Catalina Matheus
     * @version: 18 /10/2023
     */
    public void insertRelationT(String origen, String destino) {
        NodeUser aux = getT().getUsers().getpFirst();
        while (aux != null) {
            if (aux.getUsername().equals(origen)) {
                aux.getRelaciones().appendLast(destino);
                break;
            }
            aux = aux.getpNext();
        }

    }

    /**
     * @Descripcion: metodo que imprime lo que se encuentra en la estructura
     * grafo (para revisar que la información se este guardando correctamente)
     * @author: Catalina Matheus
     * @version: 15/10/2023
     */
    public void printGraph() {
        String usernames = "";
        String relaciones = "";
        NodeUser aux = getGraph().getUsers().getpFirst();
        while (aux != null) {
            usernames += aux.getUsername() + "->";
            if (!aux.getRelaciones().isEmpty()) {
                relaciones += "Relaciones de: " + aux.getUsername() + "\n";
                NodeRelaciones aux2 = aux.getRelaciones().getpFirst();
                while (aux2 != null) {
                    relaciones += aux2.getRelaciones() + "->";
                    aux2 = aux2.getpNext();
                }
                relaciones += "//\n";

            }
            aux = aux.getpNext();
        }
        usernames += "//";
        System.out.println("USUARIOS: ");
        System.out.println(usernames);
        System.out.println("RELACIONES: ");
        System.out.println(relaciones);
    }

    /**
     * @Descripcion: metodo que imprime lo que se encuentra en la estructura
     * grafo (para revisar que la información se este guardando correctamente)
     * @author: Catalina Matheus
     * @version: 18/10/2023
     */
    public void printGraphT() {
        String usernames = "";
        String relaciones = "";
        NodeUser aux = getT().getUsers().getpFirst();
        while (aux != null) {
            usernames += aux.getUsername() + "->";
            if (!aux.getRelaciones().isEmpty()) {
                relaciones += "Relaciones de: " + aux.getUsername() + "\n";
                NodeRelaciones aux2 = aux.getRelaciones().getpFirst();
                while (aux2 != null) {
                    relaciones += aux2.getRelaciones() + "->";
                    aux2 = aux2.getpNext();
                }
                relaciones += "//\n";

            }
            aux = aux.getpNext();
        }
        usernames += "//";
        System.out.println("USUARIOS: ");
        System.out.println(usernames);
        System.out.println("RELACIONES: ");
        System.out.println(relaciones);
    }

    /**
     * @return the graph
     */
    public Grafo getGraph() {
        return graph;
    }

    /**
     * @param graph the graph to set
     */
    public void setGraph(Grafo graph) {
        this.graph = graph;
    }

    /**
     * @return the app
     */
    public static App getApp() {
        return app;
    }

    /**
     * @param aApp the app to set
     */
    public static void setApp(App aApp) {
        app = aApp;
    }

    public Grafo getT() {
        return T;
    }

    public void setT(Grafo T) {
        this.T = T;
    }

}

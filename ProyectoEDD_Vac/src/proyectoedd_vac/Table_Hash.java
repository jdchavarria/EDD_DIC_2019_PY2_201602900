
package proyectoedd_vac;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/**
 *
 * @author IKAROS
 */
public class Table_Hash {
    static Users[] users = new Users[37];
    public static int Size_Prime;
    public static int Mod;
    public static int Elements;

    public Table_Hash() throws NoSuchAlgorithmException {
        Size_Prime = 37;
        Mod = Size_Prime - 1;
        Elements = 0;
        //users = new Users[Size_Prime];
        Arrays.fill(users, null);
        //this.Add_Vector("admin", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918", Users);
    }

    public void Add(String name, String apellido, String carnet, String pass) throws NoSuchAlgorithmException {
        //System.out.println("llego a addd");
        String newpass = Encrypting(pass);
        Add_Vector(name, apellido, carnet, newpass, users);

        if (Percentage_Used() >= 75) {
            users = Array_Increase();
        }
    }

    public void Add_Vector(String name, String apellido, String carnet, String pass, Users[] Array) throws NoSuchAlgorithmException {
        int Index = Function_Hash(carnet);              //Index of Array for User
        if (users[Index] == null) {
            System.out.println("llego a addd111");
            Users usua = new Users(name, apellido, carnet, pass);
            users[Index] = usua;//new Users(name, apellido, carnet, pass);
             //System.out.println("llego a addd");
            Elements++;
        } else {
            int Squared = Index * Index;
            if (Squared > users.length) {
                for (int i = 0; i < users.length; i++) {
                    if (users[i] == null) {
                        users[i] = new Users(name, apellido, carnet, pass);
                        Elements++;
                        break;
                    }
                }
            } else {
                if (users[Squared] == null) {
                    users[Squared] = new Users(name, apellido, carnet, pass);
                    Elements++;
                } else {
                    for (int i = 0; i < users.length; i++) {
                        if (users[i] == null) {
                            users[i] = new Users(name, apellido, carnet, pass);
                            Elements++;
                            break;
                        }
                    }
                }
            }
        }
        
        for(int k=0;k<users.length;k++){
            if(users[k]==null){
                
            }else{
                System.out.println(users[k].carnet);
            }
            
        }
    }

    public Users[] Array_Increase() throws NoSuchAlgorithmException {
        Size_Prime = Next_Number_Prime();           //Get Next Number Prime
        Users[] Aux = new Users[Size_Prime];      //Initial Array Aux with size of Number Prime
        Arrays.fill(Aux, null);                     //Fill Array Aux 
        Mod = Size_Prime - 1;                         //Change Mod for Hash Function
        Elements = 0;

        Users current_user;

        for (Object User : users) {
            if (User != null) {
                current_user = (Users) User;
                Add_Vector(current_user.getNombre(), current_user.getApellido(), current_user.getCarnet(), current_user.getPassword(), Aux);
            }
        }
        return Aux;
    }

    public int Function_Hash(String user) {
        int Hash = 0;
        for (int i = 0; i < user.length(); i++) {
            char Caracter = user.charAt(i);
            Hash = (int) Caracter + Hash;
        }
        Hash = Hash % Mod;              //Index of Array for User
        return Hash;
    }
    
    public int IndexUser(String user){
        for(int i = 0; i<users.length; i++){
            if(users[i]!=null){
                Users current_user = (Users) users[i];
                if(current_user.getNombre().equals(user)){
                    return i;
                }
            }
        }
        return -1;
    }

    public int Next_Number_Prime() {
        int New_Prime = Size_Prime + 1; //New_Prime takes the value of size_prime + 1
        int contador = 0;
        while (true) {
            for (int i = 1; i <= New_Prime; i++) {
                if (New_Prime % i == 0) {
                    contador++;
                }
            }
            if (contador == 2) {
                contador = 0;
                break;
            } else {
                New_Prime++;
                contador = 0;
            }
        }
        return New_Prime;
    }

    public boolean Search(String user, String passed) throws NoSuchAlgorithmException {
        String pass = Encrypting(passed);
        int search_index = Function_Hash(user);
        boolean Verification = false;
        Users current_user;
        if (this.users[search_index] != null) {
            current_user = (Users) this.users[search_index];
            if (current_user.getCarnet().equals(user) && current_user.getPassword().equals(pass)) {
                Verification = true;
            } else {
                search_index = search_index * search_index;
                if (search_index > this.users.length) {
                    Verification = false;
                } else {
                    current_user = (Users) this.users[search_index];
                    if (current_user.getCarnet().equals(user) && current_user.getPassword().equals(pass)) {
                        Verification = true;
                    } else {
                        for (int i = 0; i < this.users.length; i++) {
                            current_user = (Users) users[i];
                            if (current_user.getCarnet().equals(user) && current_user.getPassword().equals(pass)) {
                                Verification = true;
                                break;
                            } else {
                                Verification = false;
                            }
                        }
                    }
                }
            }
        } else {
            Verification = false;
        }
        return Verification;
    }

    private int Percentage_Used() {
        return (Elements * 100) / Size_Prime;
    }

    public void DeleteFile(String path) {
        File archivo = new File(path);
        archivo.delete();
    }

    public void GenerateImage(int n) {
        final String rutaDot = "C:\\Program Files (x86)\\Graphviz2.26.3\\bin\\dot.exe";
        String rutaImagen = "Hash" + n + ".png";
        String rutatxt = "Hash.txt";
        String parametroT = "-Tpng";
        String parametroO = "-o";

       int cont = 0;
        FileWriter archivo = null;
        PrintWriter pw = null;

        try {
            archivo = new FileWriter(rutatxt);
            pw = new PrintWriter(archivo);
            pw.println("digraph G {");
            pw.println("rankdir = LR");
            pw.println("node[shape=plaintext]");
            pw.println("a[label=<<TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"1\">");

            for (int i = 0; i < this.users.length; i++) {
                if (this.users[i] != null) {
                    Users temp = (Users) this.users[i];
                    pw.println("<TR>");
                    pw.println("<TD BGCOLOR=\"#F6DDCC\">" + i + ")</TD>");
                    pw.println("<TD BGCOLOR=\"#F6DDCC\">Username: " + temp.getNombre() + "\\n Password: " + "</TD>");
                    pw.println("</TR>");

                } else {
                    cont++;
                    System.out.println("esta vacio"+cont);
                    pw.println("<TR>");
                    pw.println("<TD BGCOLOR=\"#F6DDCC\">" + i + ")</TD>");
                    pw.println("</TR>");
                }
            }

            pw.println("</TABLE>>]");
            pw.println("b [style=filled, fillcolor=seashell2, label=\"Percentaje Used: "+Percentage_Used()+"%\\n No. Users: "+this.Elements+"\"]");
            pw.println("}");
            archivo.close();

            // Creates rutaImagen of Structure
            try {
                String[] cmd = new String[5];
                cmd[0] = rutaDot;
                cmd[1] = parametroT;
                cmd[2] = rutatxt;
                cmd[3] = parametroO;
                cmd[4] = rutaImagen;

                Runtime rt = Runtime.getRuntime();
                rt.exec(cmd);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("ERROR en archivo: " + e.toString());
        }
    }
    
    public void Print_Table() {
        int count = 0;
        System.out.println("Percentage Used: " + Percentage_Used() + "%");
        System.out.println("Elements in Table: " + this.Elements);
        for (Object User : this.users) {
            if (User != null) {
                System.out.println("Hash[" + count + "] " + User.toString());
            }
            count++;
        }
    }

    public boolean Validate_user(String user) {
        boolean validation = false;
        Users current_user;
        for (Object User : this.users) {
            if (User != null) {
                current_user = (Users) User;
                if (current_user.getCarnet().equals(user)) {
                    validation = true;
                    break;
                }
            }
        }
        return validation;
    }

    public String Encrypting(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = null;
        md = MessageDigest.getInstance("SHA-256");
        md.update(pass.getBytes());
        byte[] mb = md.digest();
        StringBuilder sb = new StringBuilder();

        for (byte b : mb) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

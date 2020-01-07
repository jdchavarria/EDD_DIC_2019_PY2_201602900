
package proyectoedd_vac;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author IKAROS
 */
public class Temporal {
    public static Users []arreglo;// = new Users[37];
    public static Users []tem = new Users[37];
    public static int count = 0;
    public static int i= 0;
    public static int elementos;
    public Temporal(){ 
        arreglo = new Users[37];
        /*for(int i=0;i<arreglo.length;i++){
            arreglo[i] = new Users("1","1","1","1");
        }*/
    }
    public void add(String name, String ape, String car, String pass){
        String nueva_pass = encriptar(pass);
        int index = funcionHash(car);
        int nuevo=0;
        if (arreglo[index] ==null) {
            arreglo[index] = new Users(name, ape, car, nueva_pass);
           
        } else {
            for(int i=0;i<car.length();i++){
                char Caracter = car.charAt(i);
                nuevo = (int)Caracter+nuevo;
            }
            int Squared = nuevo % (7+1);
            if (Squared > arreglo.length) {
                for (int i = 0; i < arreglo.length; i++) {
                    if (arreglo[i]==null) {
                        arreglo[i] = new Users(name, ape, car, nueva_pass);
                        break;
                    }
                }
            } else {
                if (arreglo[Squared] == null) {
                    arreglo[Squared] = new Users(name, ape, car, nueva_pass);
                    //Elements++;
                } else {
                    for (int i = 0; i < arreglo.length; i++) {
                        if (arreglo[i] == null) {
                            arreglo[i] = new Users(name, ape, car, nueva_pass);
                            //Elements++;
                            break;
                        }
                    }
                }
            }
        }
        int cont =0;
        for(int g=0;g<arreglo.length;g++){
            cont++;
            if(arreglo[g]!=null){
                tem[g] = arreglo[g];
                elementos++;
                System.out.println("elemento en:" +arreglo[g].carnet+"contador: "+cont);
            }else{
                System.out.println("vacio"+"contador: "+cont);
            }
            
        }
    }
    
    public int funcionHash(String carnet){
        int Hash = 0;
        for (int i = 0; i < carnet.length(); i++) {
            char Caracter = carnet.charAt(i);
            Hash = (int) Caracter + Hash;
        }
        Hash = Hash % arreglo.length;              //Index of Array for User
        return Hash;
           
    }
    public boolean verificar(String verificar, String clave){
        boolean des=false;
        System.out.println(verificar);
        //System.out.println(verificar+"conta es: "+clave);
        for(int i =0; i < tem.length; i++){
            System.out.println(i);
            if(tem[i]!=null){
                //System.out.println(tem[i].carnet);
                if(tem[i].getCarnet().equals(verificar)&& tem[i].getPassword().equals(clave)){
                    des = true;
                     break;
                }else{
                //System.out.println("el incorrecto es:"+arreglo[i].getUser());
                    des = false;
                }
            }else{
                System.out.println("vacio");
             //break;
            }
        }
        return des;
    }
    public String encriptar(String pass){
       MessageDigest md = null;
       try{
           md = MessageDigest.getInstance("SHA-256");
           
       }catch(NoSuchAlgorithmException e){
           e.printStackTrace();
           return null;
       }
       byte[] hash = md.digest(pass.getBytes());
       StringBuffer sb = new StringBuffer();
       for(byte b : hash){
           sb.append(String.format("%02x", b));
       }
       return sb.toString();
   }
    
    public void reco(){
        int cont=0;
        for(int i=0;i<tem.length;i++){
            cont++;
            if(tem[i]==null){
                System.out.println("esta vacio"+cont);
                
            }else{
                System.out.println(tem[i].carnet+"contador"+cont);
            }
        }
    }
    public void graphiz(int n){
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

            for (int i = 0; i < this.tem.length; i++) {
                if (this.tem[i] != null) {
                    Users temp = (Users) this.tem[i];
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
            pw.println("b [style=filled, fillcolor=seashell2, label=\"Percentaje Used: "+elementos+"%\\n No. Users: "+elementos+"\"]");
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
}

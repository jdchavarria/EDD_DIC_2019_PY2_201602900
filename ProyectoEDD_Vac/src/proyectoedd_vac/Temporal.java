
package proyectoedd_vac;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author IKAROS
 */
public class Temporal {
    public static Users []arreglo;// = new Users[37];
    public static int count = 0;
    public static int i= 0;
    public Temporal(){ 
        arreglo = new Users[37];
        Arrays.fill(arreglo, "1");
        //Arrays.fill(arreglo,"-1");
    }
    public void add(String name, String ape, String car, String pass){
        String nueva_pass = encriptar(pass);
        int index = funcionHash(car);
        int nuevo=0;
        if (arreglo[index].equals("1")) {
            arreglo[index] = new Users(name, ape, car, nueva_pass);
           
        } else {
            for(int i=0;i<car.length();i++){
                char Caracter = car.charAt(i);
                nuevo = (int)Caracter+nuevo;
            }
            int Squared = nuevo % (7+1);
            if (Squared > arreglo.length) {
                for (int i = 0; i < arreglo.length; i++) {
                    if (arreglo[i] == null) {
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
        //System.out.println(verificar+"conta es: "+clave);
        for(int i =0; i < arreglo.length; i++){
            if(arreglo[i]!=null){
                //System.out.println(arreglo[i].getPassword()+"usua"+arreglo[i].getUser());
                if(arreglo[i].getCarnet().equals(verificar)&& arreglo[i].getPassword().equals(clave)){
                des = true;
                break;
            }else{
                //System.out.println("el incorrecto es:"+arreglo[i].getUser());
                des = false;
            }
            }else{
             break;
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
        //for(int i=0;i<arreglo.length;i++){
           // if(arreglo[i]!=null){
                System.out.println(arreglo[5].carnet);
           // }else{
             //   System.out.println("esta vacio");
            //}
       // }
    }
}


package proyectoedd_vac;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import  static proyectoedd_vac.LearningAVL.primero;
/**
 *
 * @author IKAROS
 */
public class Avl {
    public Node root;
 
    public static class Node {
        private int key;
        private int balance;
        private int height;
        private Node left;
        private Node right;
        private Node parent;
        private static int correlativo=1;
        private final int id;
        Node(int key, Node parent) {
            this.key = key;
            this.parent = parent;
            this.id=correlativo++;
        }
        public void graficar(String path){
        FileWriter fichero=null;
        PrintWriter escritor;
        try{
            fichero=new FileWriter("aux_grafico.dot");
            escritor=new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        }catch(Exception e){
            System.out.println("Error al escribir el archivo auxiliar");
        }finally{
            try{
                if(null!=fichero){
                  fichero.close();  
                }
            }catch(Exception e){
               System.out.println("Error al cerrar el archivo auxiliar");
            }
        }
        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o "+path+" aux_grafico.dot");
            //Thread.sleep(500);
        }catch(Exception ex){
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
            
        }
    }
    public String getCodigoGraphviz(){
        return "digraph grafica{\n"+
                "rankdir=TB;\n"+
                "node [shape=record,style=filled,fillcolor=seashell];\n"+
                primero+"\n"+
                getCodigoInterno()+
                "}\n";
    }
     public String getCodigoInterno(){
        String etiqueta;
        String junto;
        if(left==null && right==null){
            junto = key+"fe: "+balance;
            etiqueta="nodo"+id+"[label=\""+junto+"\"];\n";
        }else{
            junto = key+"fe: "+balance;
            etiqueta="nodo"+id+"[label=\"<C0>|"+junto+"|<C1>\"];\n";
        }
        if(left!=null){
            etiqueta=etiqueta+left.getCodigoInterno()+
                    "nodo"+id+":C0->nodo"+left.id+"\n";
        }
        if(right!=null){
            etiqueta=etiqueta+right.getCodigoInterno()+
                    "nodo"+id+":C1->nodo"+right.id+"\n";
        }
        return etiqueta;
    }
    
    }
 
    public boolean insert(int key) {
        if (root == null) {
            root = new Node(key, null);
            return true;
        }
 
        Node n = root;
        while (true) {
            if (n.key == key)
                return false;
 
            Node parent = n;
 
            boolean goLeft = n.key > key;
            n = goLeft ? n.left : n.right;
 
            if (n == null) {
                if (goLeft) {
                    parent.left = new Node(key, parent);
                } else {
                    parent.right = new Node(key, parent);
                }
                rebalance(parent);
                break;
            }
        }
        return true;
    }
 
    private void delete(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent == null) {
                root = null;
            } else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                rebalance(parent);
            }
            return;
        }
 
        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) child = child.right;
            node.key = child.key;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) child = child.left;
            node.key = child.key;
            delete(child);
        }
    }
 
    public void delete(int delKey) {
        if(root==null){
            System.out.println("vacio");
        }
        if (root == null)
            return;
 
        Node child = root;
        while (child != null) {
            Node node = child;
            child = delKey >= node.key ? node.right : node.left;
            if (delKey == node.key) {
                delete(node);
                return;
            }
        }
    }
 
    private void rebalance(Node n) {
        setBalance(n);
 
        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right))
                n = rotateRight(n);
            else
                n = rotateLeftThenRight(n);
 
        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left))
                n = rotateLeft(n);
            else
                n = rotateRightThenLeft(n);
        }
 
        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }
 
    private Node rotateLeft(Node a) {
 
        Node b = a.right;
        b.parent = a.parent;
 
        a.right = b.left;
 
        if (a.right != null)
            a.right.parent = a;
 
        b.left = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
    private Node rotateRight(Node a) {
 
        Node b = a.left;
        b.parent = a.parent;
 
        a.left = b.right;
 
        if (a.left != null)
            a.left.parent = a;
 
        b.right = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }
 
    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }
 
    private int height(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }
 
    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }
 
    public void printBalance() {
        printBalance(root);
    }
 
    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.balance);
            printBalance(n.right);
        }
    }
 
    private void reheight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }
    public void preOrder(Node root){
        if(root==null){
           return ;
        }
        else{
            System.out.print(root.key+"->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
   
   
    
    /*public static void main(String[] args) {
        AVL tree = new AVL();
        
        //System.out.println("Inserting values 1 to 10");
        /*for (int i = 1; i < 10; i++){
            tree.insert(i);
        }*/
        
        //tree.insert(0);
        //tree.insert(1);
        //tree.insert(2);
        //tree.insert(3);
        //tree.insert(4);
        //tree.insert(5);
        //tree.insert(3);
        //tree.delete(3);
        //System.out.print("Printing balance: ");
        //tree.printBalance();
       // System.out.println();
        //tree.preOrder(tree.root);
     //   tree.root.graficar("ImagenArbolAVL.jpg");
      
   // } */ 
}

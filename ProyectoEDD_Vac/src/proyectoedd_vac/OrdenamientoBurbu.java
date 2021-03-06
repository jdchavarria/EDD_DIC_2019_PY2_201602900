/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoedd_vac;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UnsupportedLookAndFeelException;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author IKAROS
 */
public class OrdenamientoBurbu extends javax.swing.JFrame implements Runnable {
public static ArrayList<Integer> datos = new ArrayList<Integer>();
public static int [] dat;
public static int [] dat2;
public static String eleccion ="";
public static int cuenta=0;
Thread t;
Thread t2;
Thread t3;
    /** Creates new form Ordenamientos */
    public OrdenamientoBurbu() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_burbu = new javax.swing.JButton();
        txt_ruta = new javax.swing.JTextField();
        btn_auto = new javax.swing.JButton();
        btn_manual = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        imagen = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_burbu.setBackground(new java.awt.Color(51, 51, 255));
        btn_burbu.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        btn_burbu.setText("Burbuja");
        btn_burbu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_burbuActionPerformed(evt);
            }
        });

        btn_auto.setBackground(new java.awt.Color(51, 51, 255));
        btn_auto.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        btn_auto.setText("Automatico");
        btn_auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_autoActionPerformed(evt);
            }
        });

        btn_manual.setBackground(new java.awt.Color(51, 51, 255));
        btn_manual.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        btn_manual.setText("Manual");
        btn_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manualActionPerformed(evt);
            }
        });

        btn_next.setBackground(new java.awt.Color(51, 51, 255));
        btn_next.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        btn_next.setText("Next");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        imagen.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(imagen);

        btn_back.setBackground(new java.awt.Color(51, 51, 255));
        btn_back.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        btn_back.setText("<--Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btn_next)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_manual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_burbu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_auto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(txt_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_burbu)
                            .addComponent(txt_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_back)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btn_auto)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_manual)
                            .addComponent(btn_next))
                        .addContainerGap(291, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_burbuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_burbuActionPerformed
        try {
            String ruta=" ";
            JFileChooser jf =  new JFileChooser();
            jf.showOpenDialog(this);
            File archivo = jf.getSelectedFile();
            if(archivo!=null){
            txt_ruta.setText(archivo.getAbsolutePath());
            ruta=txt_ruta.getText();
            }
            Lectura(ruta);
        }catch(IOException ex){
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_burbuActionPerformed

    private void btn_autoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_autoActionPerformed
        eleccion = "automatica";
        dat = new int[datos.size()];
        for(int i=0;i<datos.size();i++){
            dat[i]=datos.get(i);
        }
         t = new Thread(this, "hilo 1");
         t.start();
        
    }//GEN-LAST:event_btn_autoActionPerformed

    private void btn_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manualActionPerformed
        eleccion = "manual";
        /*for(int j=0;j<dat.length;j++){
            dat[j]=0;
        }*/
        dat = new int[datos.size()];
        for(int i=0;i<datos.size();i++){
            dat[i]=datos.get(i);
        }
        t2 = new Thread(this,"hilo2");
        t2.start();
    }//GEN-LAST:event_btn_manualActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        eleccion = "siguiente";
        t3 = new Thread(this,"hilo 3");
        t3.start();
        
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Menu me = new Menu();
        me.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    public void Lectura(String path) throws IOException{
         JsonParser parser = new JsonParser();
         FileReader fr = new FileReader(path);
         JsonElement datos = parser.parse(fr);
         lectJson(datos);
         txt_ruta.setText(" ");
     }
     
     public void lectJson(JsonElement elemento){
         int numeros;
         String paso;
         if(elemento.isJsonObject()){
            System.out.println("es objeto");
            JsonObject obj  = elemento.getAsJsonObject();
            java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
            java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter =  entradas.iterator();
            while(iter.hasNext()){
                java.util.Map.Entry<String,JsonElement> entrada = iter.next();
                System.out.println("clave: "+entrada.getKey());
                
                System.out.println("valor: ");
                lectJson(entrada.getValue());
            }
            
         }else
         if(elemento.isJsonArray()){
             JsonArray array = elemento.getAsJsonArray();
             System.out.println("array "+array.size());
             java.util.Iterator<JsonElement> iter = array.iterator();
             while(iter.hasNext()){
                 JsonElement entrada = iter.next();
                 lectJson(entrada);
             }
         }else if(elemento.isJsonPrimitive()){
             System.out.println("es pri");
             JsonPrimitive valor = elemento.getAsJsonPrimitive();
             if(valor.isBoolean()){
                 System.out.println("es boo"+valor.getAsBoolean());
             }else if(valor.isNumber()){
                 //System.out.println("es num "+ valor.getAsNumber());
                 paso = valor.getAsNumber().toString();
                 numeros = Integer.parseInt(paso);
                 datos.add(numeros);
             }else if(valor.isString()){
                 //nombre = valor.getAsString();
                // System.out.print("es texto "+valor.getAsString());
             }
         }else if(elemento.isJsonNull()){
             System.out.println("es null");
         }else{
             System.out.println("es otra cosa");
         }
     }
     
     public void run(){
        int aux,aux2;
        int contador = 0;
        int contador2=0;
        if(eleccion.equals("automatica")){
        for(int i=0;i<(dat.length-1);i++){
            for(int j=0;j<(dat.length-1);j++){
                if(dat[j]>dat[j+1]){
                    try {
                        aux = dat[j];
                        dat[j] = dat[j+1];
                        dat[j+1] = aux;
                        Graficar("ImagenBurbuja"+contador+".jpg");
                        Thread.sleep(2000);
                        imagen.setIcon(new ImageIcon("ImagenBurbuja"+contador+".jpg"));
                        imagen.repaint();
                        contador++;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(OrdenamientoBurbu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }
        }else if(eleccion.equals("manual")){
            System.out.println("no deberia");
            for(int i=0;i<(dat.length-1);i++){
            for(int j=0;j<(dat.length-1);j++){
                if(dat[j]>dat[j+1]){
                    try {
                        aux2 = dat[j];
                        dat[j] = dat[j+1];
                        dat[j+1] = aux2;
                        Thread.sleep(2000);
                        Graficar("ImagenBurbujaMa"+contador2+".jpg");
                        contador2++;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(OrdenamientoBurbu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }
        }else if(eleccion.equals("siguiente")){
            imagen.setIcon(new ImageIcon("ImagenBurbujaMa"+cuenta+".jpg"));
            imagen.repaint();
            cuenta++;
        }
        
    }
         
    
    
    public void recorrer(){
        
        int aux;
        for(int i=0;i<(dat.length-1);i++){
            for(int j=0;j<(dat.length-1);j++){
                if(dat[j]>dat[j+1]){
                    aux = dat[j];
                    dat[j] = dat[j+1];
                    dat[j+1] = aux;
                }
            }
        }
        
        for(int k=0;k<dat.length; k++)
        {
            System.out.print(dat[k]+"\n");
        }
    }
    
    
    public void Graficar(String path){
        FileWriter fichero=null;
        PrintWriter escritor;
        try{
            fichero=new FileWriter("burbuja.dot");
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
            rt.exec("dot -Tjpg -o "+path+" burbuja.dot");
            //Thread.sleep(500);
        }catch(Exception ex){
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
            
        }
    }
    
    
     public String getCodigoGraphviz(){
        return "digraph burbuja{\n"+
                "rankdir=LR;\n"+
                getCodigoInterno()+
                "}\n";
    } 
     public String getCodigoInterno(){
         String etiqueta="Array[shape=record,label=\"{";
         String arrastre="";
        //Array[shape=record, label="{a|b|c}"]
        for(int i=0;i<dat.length;i++){
            if((i+1)>(dat.length-1)){
                arrastre += dat[i];
            }else{
                arrastre += dat[i]+"|";
            }
        }
        return etiqueta+arrastre+"}\"]";
     }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdenamientoBurbu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenamientoBurbu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenamientoBurbu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenamientoBurbu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdenamientoBurbu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_auto;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_burbu;
    private javax.swing.JButton btn_manual;
    private javax.swing.JButton btn_next;
    private javax.swing.JLabel imagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_ruta;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoedd_vac;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import  static proyectoedd_vac.Avl.inor;
import  static proyectoedd_vac.Avl.post;
import  static proyectoedd_vac.Avl.pre;
/**
 *
 * @author IKAROS
 */
public class LearningReco extends javax.swing.JFrame implements Runnable{
Avl av = new Avl();
ArrayList<Integer> copia_inor = new ArrayList<Integer>();
ArrayList<Integer> copia_pre = new ArrayList<Integer>();
ArrayList<Integer> copia_post = new ArrayList<Integer>();
public static String eleccion="";
public static String operacion = "";
public static int cuenta= 0,cuenta2 =0, cuenta3=0;
Thread t;
Thread t2;
Thread t3;
Thread t4;
Thread t5;
Thread t6;
Thread t7;
Thread t8;
Thread t9;


    /**
     * Creates new form LearningReco
     */
    public LearningReco() {
        initComponents();
        imagen.setIcon(new ImageIcon("ImagenArbolAVl.jpg"));
        imagen.repaint();
        info_inor.setText("Inorden= Izquierda-raiz-derecha");
        info_pre.setText("Preorden= Raiz-izquerda-derecha");
        info_post.setText("Postorden= Izquieda-derecha-raiz");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ino_auto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ino_manual = new javax.swing.JButton();
        ino_next = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pre_auto = new javax.swing.JButton();
        pre_manual = new javax.swing.JButton();
        pre_next = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        post_auto = new javax.swing.JButton();
        post_manual = new javax.swing.JButton();
        post_next = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        imagen = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        info_inor = new javax.swing.JLabel();
        info_pre = new javax.swing.JLabel();
        info_post = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ino_auto.setBackground(new java.awt.Color(51, 51, 255));
        ino_auto.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        ino_auto.setText("Automatico");
        ino_auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ino_autoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel1.setText("Inorden");

        ino_manual.setBackground(new java.awt.Color(51, 51, 255));
        ino_manual.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        ino_manual.setText("Manual");
        ino_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ino_manualActionPerformed(evt);
            }
        });

        ino_next.setBackground(new java.awt.Color(51, 51, 255));
        ino_next.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        ino_next.setText("Next-->");
        ino_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ino_nextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel2.setText("Preorden");

        pre_auto.setBackground(new java.awt.Color(51, 51, 255));
        pre_auto.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        pre_auto.setText("Automatico");
        pre_auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pre_autoActionPerformed(evt);
            }
        });

        pre_manual.setBackground(new java.awt.Color(51, 51, 255));
        pre_manual.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        pre_manual.setText("Manual");
        pre_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pre_manualActionPerformed(evt);
            }
        });

        pre_next.setBackground(new java.awt.Color(51, 51, 255));
        pre_next.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        pre_next.setText("Next-->");
        pre_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pre_nextActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel3.setText("Postorden");

        post_auto.setBackground(new java.awt.Color(51, 51, 255));
        post_auto.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        post_auto.setText("Automatico");
        post_auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                post_autoActionPerformed(evt);
            }
        });

        post_manual.setBackground(new java.awt.Color(51, 51, 255));
        post_manual.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        post_manual.setText("Manual");
        post_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                post_manualActionPerformed(evt);
            }
        });

        post_next.setBackground(new java.awt.Color(51, 51, 255));
        post_next.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        post_next.setText("Next-->");
        post_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                post_nextActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(imagen);

        btn_back.setBackground(new java.awt.Color(51, 51, 255));
        btn_back.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        btn_back.setText("<--Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jLabel4);

        info_inor.setText("jLabel5");

        info_pre.setText("jLabel5");

        info_post.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ino_manual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ino_next))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ino_auto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pre_auto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pre_manual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pre_next))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(post_auto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(post_manual, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(post_next)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(info_post)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(149, 149, 149)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info_inor)
                    .addComponent(info_pre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_back))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ino_auto)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ino_manual)
                            .addComponent(ino_next))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(pre_auto)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pre_manual)
                            .addComponent(pre_next))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(post_auto)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(post_manual)
                            .addComponent(post_next))
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info_inor)
                .addGap(7, 7, 7)
                .addComponent(info_pre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info_post)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pre_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pre_nextActionPerformed
        eleccion = "preorden";
        operacion = "siguiente";
        t6 = new Thread(this,"hilo6");
        t6.start();
    }//GEN-LAST:event_pre_nextActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Menu me = new Menu();
        me.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    private void ino_autoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ino_autoActionPerformed
        eleccion = "inorden";
        operacion = "automatico";
        t = new Thread(this,"hilo1");
        t.start();
    }//GEN-LAST:event_ino_autoActionPerformed

    private void ino_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ino_manualActionPerformed
        eleccion = "inorden";
        operacion = "manual";
        t2 = new Thread(this,"hilo2");
        t2.start();
    }//GEN-LAST:event_ino_manualActionPerformed

    private void ino_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ino_nextActionPerformed
        eleccion = "inorden";
        operacion = "siguiente";
        t3 = new Thread(this, "hilo3");
        t3.start();
    }//GEN-LAST:event_ino_nextActionPerformed

    private void pre_autoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pre_autoActionPerformed
        eleccion = "preorden";
        operacion = "automatico";
        t4 = new Thread(this,"hilo4");
        t4.start();
    }//GEN-LAST:event_pre_autoActionPerformed

    private void pre_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pre_manualActionPerformed
        eleccion = "preorden";
        operacion = "manual";
        t5 = new Thread(this,"hilo5");
        t5.start();
    }//GEN-LAST:event_pre_manualActionPerformed

    private void post_autoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_post_autoActionPerformed
        eleccion = "postorden";
        operacion = "automatico";
        t7 = new Thread(this,"hilo7");
        t7.start();
    }//GEN-LAST:event_post_autoActionPerformed

    private void post_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_post_manualActionPerformed
        eleccion = "postorden";
        operacion = "manual";
        t8 = new Thread(this,"hilo8");
        t8.start();
    }//GEN-LAST:event_post_manualActionPerformed

    private void post_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_post_nextActionPerformed
        eleccion = "postorden";
        operacion = "siguiente";
        t9 = new Thread(this,"hilo9");
        t9.start();
    }//GEN-LAST:event_post_nextActionPerformed

    public void Grafica_inor(String path){
       FileWriter fichero=null;
        PrintWriter escritor;
        try{
            fichero=new FileWriter("Inorden.dot");
            escritor=new PrintWriter(fichero);
            escritor.print(Obtener_inor());
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
            rt.exec("dot -Tjpg -o "+path+" Inorden.dot");
            //Thread.sleep(500);
        }catch(Exception ex){
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
            
        }
    }
    public String Obtener_inor(){
         return "digraph inorden{\n"+
                "rankdir=LR;\n"+
                getInorden()+
                "}\n";
    }
    public String getInorden(){
         String etiqueta="Array[shape=record,label=\"{";
         String arrastre="";
        //Array[shape=record, label="{a|b|c}"]
        for(int i=0;i<copia_inor.size();i++){
            if((i+1)>(copia_inor.size()-1)){
                arrastre += copia_inor.get(i);
            }else{
                arrastre += copia_inor.get(i)+"|";
            }
        }
        return etiqueta+arrastre+"}\"]";
    }
    public void run(){
        if(eleccion.equals("inorden")){
            if(operacion.equals("automatico")){
                for(int i=0;i<inor.size();i++){
                    try {
                        copia_inor.add(inor.get(i));
                        Grafica_inor("ImagenInorden"+i+".jpg");
                        Thread.sleep(2000);
                        jLabel4.setIcon(new ImageIcon("ImagenInorden"+i+".jpg"));
                        jLabel4.repaint();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LearningReco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else if(operacion.equals("manual")){
                copia_inor.clear();
                for(int i=0;i<inor.size();i++){
                    try {
                        copia_inor.add(inor.get(i));
                        Thread.sleep(1500);
                        Grafica_inor("ImagenInordenMa"+i+".jpg");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LearningReco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }else if(operacion.equals("siguiente")){
                jLabel4.setIcon(new ImageIcon("ImagenInordenMa"+cuenta+".jpg"));
                jLabel4.repaint();
                cuenta++;
            }
        }else if(eleccion.equals("preorden")){
            if(operacion.equals("automatico")){
                 for(int i=0;i<pre.size();i++){
                    try {
                        copia_pre.add(pre.get(i));
                        Grafica_pre("ImagenPreorden"+i+".jpg");
                        Thread.sleep(2000);
                        jLabel4.setIcon(new ImageIcon("ImagenPreorden"+i+".jpg"));
                        jLabel4.repaint();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LearningReco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else if(operacion.equals("manual")){
                copia_pre.clear();
                for(int i=0;i<pre.size();i++){
                    try {
                        copia_pre.add(pre.get(i));
                        Thread.sleep(1500);
                        Grafica_pre("ImagenPreordenMa"+i+".jpg");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LearningReco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }else if(operacion.equals("siguiente")){
                System.out.println("llego");
                jLabel4.setIcon(new ImageIcon("ImagenPreordenMa"+cuenta2+".jpg"));
                jLabel4.repaint();
                cuenta2++;
            }
        }else if(eleccion.equals("postorden")){
           
            if(operacion.equals("automatico")){
                for(int i=0;i<post.size();i++){
                    try {
                        copia_post.add(post.get(i));
                        Grafica_post("ImagenPostorden"+i+".jpg");
                        Thread.sleep(2000);
                        jLabel4.setIcon(new ImageIcon("ImagenPostorden"+i+".jpg"));
                        jLabel4.repaint();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LearningReco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else if(operacion.equals("manual")){
                System.out.println("llego1111");
                copia_post.clear();
                for(int i=0;i<post.size();i++){
                    try {
                        copia_post.add(post.get(i));
                        Thread.sleep(1500);
                        Grafica_post("ImagenPostordenMa"+i+".jpg");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LearningReco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }else if(operacion.equals("siguiente")){
                System.out.println("llego2222");
                jLabel4.setIcon(new ImageIcon("ImagenPostordenMa"+cuenta3+".jpg"));
                jLabel4.repaint();
                cuenta3++;
            }
        }
       
    }
    public void Grafica_pre(String path){
        FileWriter fichero=null;
        PrintWriter escritor;
        try{
            fichero=new FileWriter("Preorden.dot");
            escritor=new PrintWriter(fichero);
            escritor.print(Obtener_pre());
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
            rt.exec("dot -Tjpg -o "+path+" Preorden.dot");
            //Thread.sleep(500);
        }catch(Exception ex){
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
            
        }
    }
    public String Obtener_pre(){
        return "digraph preorden{\n"+
                "rankdir=LR;\n"+
                getPreorden()+
                "}\n";
    }
    public String getPreorden(){
        String etiqueta="Array[shape=record,label=\"{";
         String arrastre="";
        //Array[shape=record, label="{a|b|c}"]
        for(int i=0;i<copia_pre.size();i++){
            if((i+1)>(copia_pre.size()-1)){
                arrastre += copia_pre.get(i);
            }else{
                arrastre += copia_pre.get(i)+"|";
            }
        }
        return etiqueta+arrastre+"}\"]";
    }
    public void Grafica_post(String path){
        FileWriter fichero=null;
        PrintWriter escritor;
        try{
            fichero=new FileWriter("Postorden.dot");
            escritor=new PrintWriter(fichero);
            escritor.print(Obtener_post());
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
            rt.exec("dot -Tjpg -o "+path+" Postorden.dot");
            //Thread.sleep(500);
        }catch(Exception ex){
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
            
        }
    }
    public String Obtener_post(){
        return "digraph postorden{\n"+
                "rankdir=LR;\n"+
                getPostorden()+
                "}\n";
    }
    public String getPostorden(){
        String etiqueta="Array[shape=record,label=\"{";
         String arrastre="";
        //Array[shape=record, label="{a|b|c}"]
        for(int i=0;i<copia_post.size();i++){
            if((i+1)>(copia_post.size()-1)){
                arrastre += copia_post.get(i);
            }else{
                arrastre += copia_post.get(i)+"|";
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
            java.util.logging.Logger.getLogger(LearningReco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LearningReco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LearningReco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LearningReco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LearningReco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel info_inor;
    private javax.swing.JLabel info_post;
    private javax.swing.JLabel info_pre;
    private javax.swing.JButton ino_auto;
    private javax.swing.JButton ino_manual;
    private javax.swing.JButton ino_next;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton post_auto;
    private javax.swing.JButton post_manual;
    private javax.swing.JButton post_next;
    private javax.swing.JButton pre_auto;
    private javax.swing.JButton pre_manual;
    private javax.swing.JButton pre_next;
    // End of variables declaration//GEN-END:variables
}

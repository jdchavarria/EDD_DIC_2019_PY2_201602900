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
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map.Entry;

/**
 *
 * @author IKAROS
 */
public class Admin extends javax.swing.JFrame {
String nombre, apellido, carnet, pass;
ArrayList<Users> creado = new ArrayList<Users>();
ArrayList <Users>vec =  new ArrayList<Users>();
Users[]Rep;
Users [] noRep;
ArrayList<Users> malcontra = new ArrayList<Users>();
Temporal tm = new Temporal();
    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
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
        btn_carga = new javax.swing.JButton();
        txt_ruta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_repe = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_cortos = new javax.swing.JTextArea();
        btn_back = new javax.swing.JButton();
        btn_report = new javax.swing.JButton();
        lbl_ad = new javax.swing.JLabel();
        btn_pr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_carga.setBackground(new java.awt.Color(51, 51, 255));
        btn_carga.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        btn_carga.setText("Cargar");
        btn_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargaActionPerformed(evt);
            }
        });

        txt_repe.setColumns(20);
        txt_repe.setRows(5);
        jScrollPane1.setViewportView(txt_repe);

        txt_cortos.setColumns(20);
        txt_cortos.setRows(5);
        jScrollPane2.setViewportView(txt_cortos);

        btn_back.setBackground(new java.awt.Color(51, 51, 255));
        btn_back.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        btn_back.setText("<--Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_report.setBackground(new java.awt.Color(51, 51, 255));
        btn_report.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        btn_report.setText("Reporte");
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });

        lbl_ad.setText("jLabel1");

        btn_pr.setText("jButton1");
        btn_pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_carga)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addComponent(lbl_ad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_report)
                            .addComponent(btn_back))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_pr)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txt_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_back)
                            .addComponent(lbl_ad))))
                .addGap(33, 33, 33)
                .addComponent(btn_carga)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_report)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_pr)
                        .addGap(141, 141, 141))))
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

    private void btn_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargaActionPerformed
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
    }//GEN-LAST:event_btn_cargaActionPerformed

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
        reco();
    }//GEN-LAST:event_btn_reportActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Login log = new Login();
        log.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_prActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prActionPerformed
        tm.reco();
    }//GEN-LAST:event_btn_prActionPerformed
    
     public void Lectura(String path) throws IOException{
         JsonParser parser = new JsonParser();
         FileReader fr = new FileReader(path);
         JsonElement datos = parser.parse(fr);
         lectJson(datos);
     }
     
     public void lectJson(JsonElement elemento){
         if(elemento.isJsonObject()){
            System.out.println("es objeto");
            JsonObject obj  = elemento.getAsJsonObject();
            java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
            java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter =  entradas.iterator();
            while(iter.hasNext()){
                java.util.Map.Entry<String,JsonElement> entrada = iter.next();
                System.out.println("clave: "+entrada.getKey());
                if(entrada.getKey().equals("Nombre")){
                    name(entrada.getValue());
                }else if(entrada.getKey().equals("Apellido")){
                    ape(entrada.getValue());
                }else if(entrada.getKey().equals("Carnet")){
                    car(entrada.getValue());
                }else if(entrada.getKey().equals("Password")){
                    passw(entrada.getValue());
                }
                //System.out.println("valor: ");
                //lectJson(entrada.getValue());
            }
            Users usu = new Users();
            usu.setNombre(nombre);
            usu.setApellido(apellido);
            usu.setCarnet(carnet);
            usu.setPassword(pass);
            creado.add(usu);
         }else
         if(elemento.isJsonArray()){
             JsonArray array = elemento.getAsJsonArray();
             System.out.println("array "+array.size());
             java.util.Iterator<JsonElement> iter = array.iterator();
             while(iter.hasNext()){
                 JsonElement entrada = iter.next();
                 lectJson(entrada);
             }
         }/*else if(elemento.isJsonPrimitive()){
             System.out.println("es pri");
             JsonPrimitive valor = elemento.getAsJsonPrimitive();
             if(valor.isBoolean()){
                 System.out.println("es boo"+valor.getAsBoolean());
             }else if(valor.isNumber()){
                 System.out.println("es num "+ valor.getAsNumber());
             }else if(valor.isString()){
                 //nombre = valor.getAsString();
                // System.out.print("es texto "+valor.getAsString());
             }
         }*/else if(elemento.isJsonNull()){
             System.out.println("es null");
         }else{
             System.out.println("es otra cosa");
         }
    
     }
     
     public void name(JsonElement elemento){
         JsonPrimitive valor = elemento.getAsJsonPrimitive();
         nombre = valor.getAsString();
         System.out.println(nombre);
     }
     public void ape(JsonElement elemento){
         JsonPrimitive valor = elemento.getAsJsonPrimitive();
         apellido = valor.getAsString();
         System.out.println(apellido);
     }
     public void car(JsonElement elemento){
         JsonPrimitive valor = elemento.getAsJsonPrimitive();
         carnet = valor.getAsString();
         System.out.println(carnet);
     }
     public void passw(JsonElement elemento){
         JsonPrimitive valor = elemento.getAsJsonPrimitive();
         pass = valor.getAsString();
         System.out.println(pass);
     }
     
     public void reco(){
         for(int i=0;i<creado.size();i++){
             System.out.println(creado.get(i).nombre);
         }
         
    try {
        verificarRep();
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
     }
    boolean Ver(String  usua){
        for(int i=0;i<noRep.length;i++){
            if(noRep[i]==null){
                
            }else{
                if(noRep[i].carnet.equals(usua)){
                return false;
            }
            }
            
        }
        return true;
    }
     
     public void verificarRep() throws NoSuchAlgorithmException{
        Table_Hash hash = new Table_Hash();
        //Temporal tm = new Temporal();
        int as = 0;
        String userIncorrectos="";
        String inco = "";
        Rep=new Users[creado.size()]; //verificacion es un arrayList que almacena lo de la carga masiva
        for(int i=0;i<Rep.length;i++){
            Rep[i] = creado.get(i);
        }

        noRep=new Users[Rep.length];
        for(int i=0;i<Rep.length;i++){
            int count=0;
            for(int j=0;j<Rep.length;j++){
            if(Rep[i].carnet.equals(Rep[j].carnet)){
                count++;  
                if(Ver(Rep[i].carnet)){
                    noRep[i]=Rep[i];
              //System.out.println(noRep[i]+" No se repiten");
                }
            }  
        }
            System.out.println(i);
        if(noRep[i]!=null){
            System.out.println(noRep[i].carnet+" Se repite: "+count);
            if(count>1){
                userIncorrectos += userIncorrectos+"El usuario "+noRep[i].carnet+" ya existia"+"\n";
                txt_repe.setText(userIncorrectos);
            }
          
         }
         if(count==1){//Solo va a almacenar los usuarios que esten solo una vez
              System.out.println(noRep[i].carnet+" Este elemento solo se repite una vez");
              Users usu1 = new Users();
              usu1.setNombre(noRep[i].nombre);
              usu1.setApellido(noRep[i].apellido);
              usu1.setCarnet(noRep[i].carnet);
              usu1.setPassword(noRep[i].password);
              vec.add(usu1);//Solo ingresan usuarios no repetidos
     }
     
  }
        for(int i=0;i<vec.size();i++){
            if(vec.get(i).password.length()>8){
                tm.add(vec.get(i).nombre.replace(" ", ""), vec.get(i).apellido.replace(" ", ""),vec.get(i).carnet.replace(" ","" ),vec.get(i).password.replace(" ", ""));
            }else if(vec.get(i).password.length()<8){
               // malcontra.add(vec.get(i));
               inco += inco+"el usuario: "+vec.get(i).carnet+" no cuenta con el minimo de caracteres"+"\n";
               //System.out.println(vec.get(i).user);
            }
            
            
        }
        //System.out.println(inco);
        //txt_carac.setText(inco);
        /*for(int j=0; j<malcontra.size();j++){
            txt_carac.setText(malcontra.get(j).user);
        }*/
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_carga;
    private javax.swing.JButton btn_pr;
    private javax.swing.JButton btn_report;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_ad;
    private javax.swing.JTextArea txt_cortos;
    private javax.swing.JTextArea txt_repe;
    private javax.swing.JTextField txt_ruta;
    // End of variables declaration//GEN-END:variables
}

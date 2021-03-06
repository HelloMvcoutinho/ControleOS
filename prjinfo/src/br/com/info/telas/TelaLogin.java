/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.info.telas;
import java.sql.*;
import br.com.info.dal.ModuloConexao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author marcioc
 */
public class TelaLogin extends javax.swing.JFrame {
    //usando a variavel conexao do DAL
    Connection conexao = null;
    //criando variáveis especiais para conexão com o BD
    //Prepared Statemenr e ResultSet são frameworks do pacote java.sql
    //e servem para preparar e executar as instruções SQL
    PreparedStatement pst= null;
    ResultSet rs = null;

//criando o metodo logar teste Github   
public void logar(){
    String sql="select * from tb_usuarios where login=? and senha=?";
    try {
        //as linhas abaixo preparam a consulta ao banco em função do
        //que foi digitado nas caixas de texto. O ? e substituido pelo 
        //conteúdo das variáveis
        pst = conexao.prepareStatement(sql);
        pst.setString(1,txtUsuario.getText());
        //pst.setString(2,txtSenha.getText()); está depreciado
        //Exemplo "String strPass = new String(jPassword1.getPassword()).trim();"
        String strPass = new String(txtSenha.getPassword());
        pst.setString(2,strPass);
        
        
        //a linha abaixo executa a query
        rs = pst.executeQuery();
        
        //se existir usuário e senha correspondente
        if(rs.next()){
            //a linha abaoxp obtem o conteudo do campo perfil da tabela tb_usuarios 
            String perfil=rs.getString(6);
            //System.out.println(perfil);
            //a linha abaixo exibe o conteudo do campo da tabela
            //a estrutura abaixo faz o tratamento do perfil do usuario
            if (perfil.equals("admin")){
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaPrincipal.MenRel.setEnabled(true);
                TelaPrincipal.MenCadUsu.setEnabled(true);//libera o acesso ao menu cadastrar usuário
                TelaPrincipal.lblUsuario.setText(rs.getString(2));//escreve o nome do usuário na tela
                TelaPrincipal.lblUsuario.setForeground(Color.red);//pinta o nome do usuário vermelho
                this.dispose();//fecha a tela de login
                conexao.close();//fecha a conexão com o BD
            }else{
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaPrincipal.lblUsuario.setText(rs.getString(2)); 
                this.dispose();//fecha a tela de login
                conexao.close();//fecha a conexão com o BD
            }
        }else{
            JOptionPane.showMessageDialog(null,"Usuário e/ou senha inválido(s)","Alerta",JOptionPane.ERROR_MESSAGE);
        }
        
                
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
    }
}
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        //estabelecendo a conexao com o banco sempre neste ponto
        conexao = ModuloConexao.conector();
        //a linha abaixo server de apoio ao status da conexao
        //System.out.println(conexao);
        if (conexao!= null){
          lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info/icones/dbok.png")));  
        }else{
          lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info/icones/dberror.png"))); 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Info Login");
        setResizable(false);

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });

        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info/icones/dberror.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogin)
                    .addComponent(lblStatus))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(364, 182));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // chama o método logar com o clique o botão
        logar();
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        // chama o método logar com o Enter
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            logar();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        // chama o método logar com o Enter
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            logar();
        }
    }//GEN-LAST:event_btnLoginKeyPressed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.info.telas;

/**
 *
 * @author marcioc
 */
import java.sql.*;
import br.com.info.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    //usando a variavel conexao do DAL
    //criando variáveis especiais para conexão com o BD
    //Prepared Statemenr e ResultSet são frameworks do pacote java.sql
    //e servem para preparar e executar as instruções SQL
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    //método para consultar usuários
    private void consultar() {
        String sql = "select * from tb_usuarios where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtUsuNom.setText(rs.getString(2));
                txtUsuFon.setText(rs.getString(3));
                txtUsuLog.setText(rs.getString(4));
                txtUsuSen.setText(rs.getString(5));
                //a linha abaixo se referencia ao combobox
                cboPer.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                //as linhas abaixo limpa os campos
                txtUsuNom.setText(null);
                txtUsuFon.setText(null);
                txtUsuLog.setText(null);
                txtUsuSen.setText(null);
                //cboPer.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    //método para adicionar usuários
    private void adicionar() {
        String sql = "insert into tb_usuarios(iduser,usuario,fone,login,senha,perfil) values(?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            pst.setString(2, txtUsuNom.getText());
            pst.setString(3, txtUsuFon.getText());
            pst.setString(4, txtUsuLog.getText());
            pst.setString(5, txtUsuSen.getText());
            pst.setString(6, cboPer.getSelectedItem().toString());
            //validação dos campos obrigatorios
            if((txtUsuId.getText().isEmpty())||(txtUsuNom.getText().isEmpty())||(txtUsuLog.getText().isEmpty())||(txtUsuSen.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                //a linha abaixo atualiza a tabela usuario com os dados do formulario
                //a estrutura abaixo é usada para confirmas a inserção dos dados na tabela
                //pst.executeUpdate();
                int adicionado = pst.executeUpdate();
                //a linha abaixo ser de apoio ao entendimento da lógica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adcionaddo com sucesso");
                    //as linhas abaixo limpa os campos
                    txtUsuId.setText(null);
                    txtUsuNom.setText(null);
                    txtUsuFon.setText(null);
                    txtUsuLog.setText(null);
                    txtUsuSen.setText(null);
                    //cboPer.setSelectedItem(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        txtUsuNom = new javax.swing.JTextField();
        txtUsuLog = new javax.swing.JTextField();
        txtUsuFon = new javax.swing.JTextField();
        txtUsuSen = new javax.swing.JTextField();
        cboPer = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnUsuAdic = new javax.swing.JButton();
        btnUsuLoc = new javax.swing.JButton();
        btnUsuAlt = new javax.swing.JButton();
        btnUsuExc = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(671, 486));

        jLabel1.setText("*Id");

        jLabel2.setText("*Nome");

        jLabel3.setText("*Login");

        jLabel4.setText("Fone");

        jLabel5.setText("*Perfil");

        txtUsuSen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuSenActionPerformed(evt);
            }
        });

        cboPer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        jLabel6.setText("*Senha");

        btnUsuAdic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info/icones/create.png"))); // NOI18N
        btnUsuAdic.setToolTipText("Adicionar");
        btnUsuAdic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuAdic.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuAdic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuAdicActionPerformed(evt);
            }
        });

        btnUsuLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info/icones/read.png"))); // NOI18N
        btnUsuLoc.setToolTipText("Consultar");
        btnUsuLoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuLoc.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuLocActionPerformed(evt);
            }
        });

        btnUsuAlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info/icones/update.png"))); // NOI18N
        btnUsuAlt.setToolTipText("Alterar");
        btnUsuAlt.setPreferredSize(new java.awt.Dimension(80, 80));

        btnUsuExc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info/icones/delete.png"))); // NOI18N
        btnUsuExc.setToolTipText("Excluir");
        btnUsuExc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuExc.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel7.setText("* Campo obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuLog, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtUsuNom)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUsuAdic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUsuLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btnUsuAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(322, 322, 322)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(txtUsuSen, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboPer, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuFon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUsuExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuFon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsuSen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnUsuAdic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        setBounds(0, 0, 671, 474);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuSenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuSenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuSenActionPerformed

    private void btnUsuLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuLocActionPerformed
        // chamando o método consultar
        consultar();
    }//GEN-LAST:event_btnUsuLocActionPerformed

    private void btnUsuAdicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuAdicActionPerformed
        // chamando o método adicionar 
        adicionar();
    }//GEN-LAST:event_btnUsuAdicActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuAdic;
    private javax.swing.JButton btnUsuAlt;
    private javax.swing.JButton btnUsuExc;
    private javax.swing.JButton btnUsuLoc;
    private javax.swing.JComboBox<String> cboPer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUsuFon;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuLog;
    private javax.swing.JTextField txtUsuNom;
    private javax.swing.JTextField txtUsuSen;
    // End of variables declaration//GEN-END:variables
}

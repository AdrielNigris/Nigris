package Jogo;

import dao.PerguntaDao;
import java.util.List;
import javax.smartcardio.Card;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import Jogo.Cadastrar;
import Jogo.Cartas;
import modelo.Jogador;
import modelo.ManipularImagem;
import modelo.Pergunta;
import modelo.jogoCompleto;

public class Jogando extends javax.swing.JFrame {

    private Jogador jogador;
    private Integer nivel;
    private Double premio;
    private Double agora;
    private jogoCompleto completo;
    private Double e;
    private Double t;
    private Integer confirmar;
    private static Integer tirar;

    public static Integer getTirar() {
        return tirar;
    }

    public static void setTirar(Integer tirar) {
        Jogando.tirar = tirar;
    }

   
        
    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    List<Pergunta> perguntas;//perguntas do jogo
    Pergunta perguntaatual;//que esta sendo exibida
    // jogoCompleto completo;
   
    ButtonGroup bg1;

    public Jogando() {
        initComponents();
        tirar = 0;
        bg1 = new ButtonGroup();
        bg1.add(lblOpção1);
        bg1.add(lblOpção2);
        bg1.add(lblOpção3);
        bg1.add(lblOpção4);
        confirmar = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        cartasbtn = new javax.swing.JButton();
        pular = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        errar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        parar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        acertar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPergunta1 = new javax.swing.JLabel();
        lblOpção1 = new javax.swing.JRadioButton();
        lblOpção2 = new javax.swing.JRadioButton();
        lblOpção3 = new javax.swing.JRadioButton();
        lblOpção4 = new javax.swing.JRadioButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Parar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cartasbtn.setBackground(new java.awt.Color(0, 204, 255));
        cartasbtn.setForeground(new java.awt.Color(255, 255, 255));
        cartasbtn.setText("Cartas");
        cartasbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartasbtnActionPerformed(evt);
            }
        });

        pular.setBackground(new java.awt.Color(0, 204, 255));
        pular.setForeground(new java.awt.Color(255, 255, 255));
        pular.setText("Pular");
        pular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pularActionPerformed(evt);
            }
        });

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/IMG_20150506_213455.jpg"))); // NOI18N

        btnConfirmar.setBackground(new java.awt.Color(51, 255, 0));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("   ");
        lblNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNomeMouseClicked(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        errar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        errar.setForeground(new java.awt.Color(255, 255, 255));
        errar.setText("0");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Errar");

        parar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        parar.setForeground(new java.awt.Color(255, 255, 255));
        parar.setText("1");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Parar");

        acertar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        acertar.setForeground(new java.awt.Color(255, 255, 255));
        acertar.setText("2");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Acertar");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(errar)
                        .addGap(92, 92, 92)
                        .addComponent(parar)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(acertar)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(27, 27, 27))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(errar)
                    .addComponent(parar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acertar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        lblPergunta1.setFont(new java.awt.Font("Estrangelo Edessa", 3, 18)); // NOI18N
        lblPergunta1.setForeground(new java.awt.Color(255, 255, 255));
        lblPergunta1.setText("Pergunta");

        lblOpção1.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        lblOpção1.setForeground(new java.awt.Color(255, 255, 255));
        lblOpção1.setText("Opção 01");
        lblOpção1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblOpção1ActionPerformed(evt);
            }
        });

        lblOpção2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        lblOpção2.setForeground(new java.awt.Color(255, 255, 255));
        lblOpção2.setText("Opção 02");

        lblOpção3.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        lblOpção3.setForeground(new java.awt.Color(255, 255, 255));
        lblOpção3.setText("Opção 03");

        lblOpção4.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        lblOpção4.setForeground(new java.awt.Color(255, 255, 255));
        lblOpção4.setText("Opção 04");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPergunta1)
                    .addComponent(lblOpção1)
                    .addComponent(lblOpção2)
                    .addComponent(lblOpção3)
                    .addComponent(lblOpção4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartasbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(53, 53, 53)
                        .addComponent(btnConfirmar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFoto)
                        .addGap(61, 61, 61))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNome)
                .addGap(176, 176, 176))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblPergunta1)
                        .addGap(54, 54, 54)
                        .addComponent(lblOpção1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOpção2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOpção3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOpção4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pular)
                            .addComponent(cartasbtn)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirmar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

     
    private void lblOpção1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblOpção1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOpção1ActionPerformed

    private void pularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pularActionPerformed
    
         perguntas.remove(0);
         if (perguntas.size() == 0 && nivel == 1) {
            PerguntaDao dao = new PerguntaDao();
            perguntas = dao.listarNivel2();
            nivel = 2;
            premio = 5000.00;
        }
        if (perguntas.size() == 0 && nivel == 2) {
            //completo.setGanhos(t);
            Fim tela = new Fim();
           // tela.setCompleto(completo);
            tela.setVisible(true);
            this.setVisible(false);
        } else {

            perguntaatual = perguntas.get(0);
            lblPergunta1.setText(perguntaatual.getEnunciado());
            lblOpção1.setText(perguntaatual.getA());
            lblOpção2.setText(perguntaatual.getB());
            lblOpção3.setText(perguntaatual.getC());
            lblOpção4.setText(perguntaatual.getD());
        pular.setEnabled(false);
        }

        
    }//GEN-LAST:event_pularActionPerformed
     
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
          
        if (tirar== 1) {
            
            if (perguntaatual.getCerta().equals("A")) {
                lblOpção2.setEnabled(false);
               
            } else if (perguntaatual.getCerta().equals("B")) {
                lblOpção1.setEnabled(false);
                
               
            } else if (perguntaatual.getCerta().equals("C")) {
                lblOpção4.setEnabled(false);
                
               
            } else if (perguntaatual.getCerta().equals("D")) {
                lblOpção3.setEnabled(false);
               
              
            }

        } else if (tirar == 2) {
            if (perguntaatual.getCerta().equals("A")) {
                lblOpção2.setEnabled(false);
                lblOpção3.setEnabled(false);
                
            } else if (perguntaatual.getCerta().equals("B")) {
                lblOpção1.setEnabled(false);
                lblOpção3.setEnabled(false);
                
            } else if (perguntaatual.getCerta().equals("C")) {
                lblOpção4.setEnabled(false);
                lblOpção2.setEnabled(false);
                
            } else if (perguntaatual.getCerta().equals("D")) {
                lblOpção3.setEnabled(false);
                lblOpção1.setEnabled(false);
                
            }

        } else if (tirar == 3) {
            if (perguntaatual.getCerta().equals("A")) {
                lblOpção2.setEnabled(false);
                lblOpção3.setEnabled(false);
                lblOpção4.setEnabled(false);
                
            } else if (perguntaatual.getCerta().equals("B")) {
                lblOpção1.setEnabled(false);
                lblOpção3.setEnabled(false);
                lblOpção4.setEnabled(false);
                
            } else if (perguntaatual.getCerta().equals("C")) {
                lblOpção4.setEnabled(false);
                lblOpção2.setEnabled(false);
                lblOpção1.setEnabled(false);
                
            } else if (perguntaatual.getCerta().equals("D")) {
                lblOpção3.setEnabled(false);
                lblOpção2.setEnabled(false);
                lblOpção1.setEnabled(false);
                
            }
           
        }else {
                   
            lblOpção1.setEnabled(true);
            lblOpção2.setEnabled(true);
            lblOpção3.setEnabled(true);
            lblOpção4.setEnabled(true);
                
            }
         tirar = 0;
       
        
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar ++;
        Double acertou = 0.0;
        if (lblOpção1.isSelected() == true && perguntaatual.getCerta().equals("A")) {
            JOptionPane.showMessageDialog(rootPane, "acertou");
            acertou = premio;

        } else if (lblOpção2.isSelected() == true && perguntaatual.getCerta().equals("B")) {
            JOptionPane.showMessageDialog(rootPane, "acertou");
            acertou = premio;

        } else if (lblOpção3.isSelected() == true && perguntaatual.getCerta().equals("C")) {
            JOptionPane.showMessageDialog(rootPane, "acertou");
            acertou = premio;

        } else if (lblOpção4.isSelected() == true && perguntaatual.getCerta().equals("D")) {
            JOptionPane.showMessageDialog(rootPane, "acertou");
            acertou = premio;
        } else {
            JOptionPane.showMessageDialog(rootPane, "errou");
            completo.setGanhos(e);
            Fim tela = new Fim();
            tela.setCompleto(completo);
            tela.setVisible(true);
            this.setVisible(false);
        }

        agora = completo.getGanhos() + acertou;
        completo.setGanhos(agora);

        perguntas.remove(0);// elimina a pergunta que esta sendo exibida

        if (confirmar == 3 && nivel == 1) {
            PerguntaDao dao = new PerguntaDao();
            perguntas = dao.listarNivel2();
            nivel = 2;
            premio = 5000.00;
            confirmar = 0;
        }
        if (perguntas.size() == 0 && nivel == 2) {
            completo.setGanhos(t);
            Fim tela = new Fim();
            tela.setCompleto(completo);
            tela.setVisible(true);
            this.setVisible(false);
        } else {

            perguntaatual = perguntas.get(0);
            lblPergunta1.setText(perguntaatual.getEnunciado());
            lblOpção1.setText(perguntaatual.getA());
            lblOpção2.setText(perguntaatual.getB());
            lblOpção3.setText(perguntaatual.getC());
            lblOpção4.setText(perguntaatual.getD());
        //desmarcar as alternativas

            e = agora / 2;
            errar.setText(e.toString());
            parar.setText(agora.toString());

            t = premio + agora;
            acertar.setText(t.toString());

            bg1.clearSelection();
        }


        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void lblNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNomeMouseClicked
    lblNome.setText(jogador.getLogin());
    }//GEN-LAST:event_lblNomeMouseClicked

    private void cartasbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartasbtnActionPerformed
        Cartas tela = new Cartas();
        tela.setVisible(true);
        cartasbtn.setEnabled(false);
    }//GEN-LAST:event_cartasbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Fim tela = new Fim();
        tela.setCompleto(completo);
        tela.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        completo = new jogoCompleto();
        completo.setJogador(jogador);

        lblNome.setText(jogador.getLogin());
        //buscar as perguntas do niivel 1 
        ManipularImagem.exibiImagemLabel(jogador.getImagem(), lblFoto);
        
        PerguntaDao dao = new PerguntaDao();
        premio = 2500.00;
        perguntas = dao.listarNivel1();
        nivel = 1;
        // colocar a primeira que aparece no perguntaatual
        perguntaatual = perguntas.get(0);//primeira pergunta da lista embaralhado
        lblPergunta1.setText(perguntaatual.getEnunciado());
        lblOpção1.setText(perguntaatual.getA());
        lblOpção2.setText(perguntaatual.getB());
        lblOpção3.setText(perguntaatual.getC());
        lblOpção4.setText(perguntaatual.getD());

        errar.setText("0");
        parar.setText("0");
        acertar.setText(premio.toString());

    }//GEN-LAST:event_formWindowOpened

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        
    }//GEN-LAST:event_jPanel1FocusGained

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
            java.util.logging.Logger.getLogger(Jogando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jogando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jogando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jogando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jogando().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acertar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton cartasbtn;
    private javax.swing.JLabel errar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNome;
    private javax.swing.JRadioButton lblOpção1;
    private javax.swing.JRadioButton lblOpção2;
    private javax.swing.JRadioButton lblOpção3;
    private javax.swing.JRadioButton lblOpção4;
    private javax.swing.JLabel lblPergunta1;
    private javax.swing.JLabel parar;
    private javax.swing.JButton pular;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jogador
     */
}
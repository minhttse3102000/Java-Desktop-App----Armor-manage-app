/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.ArmorDTO;
import Server.ArmorInterface;
import Server.ArmorServer;
import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minhv
 */
public class Mainframe extends javax.swing.JFrame {

    ArmorInterface menu;
    ArrayList<ArmorDTO> armorList;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    boolean find=false;
        
    public Mainframe() {
        initComponents();
        this.setLocation(450, 148);
        this.setResizable(false);
        this.setTitle("Armor Client");
        armorList=new ArrayList();
        
    }
    void getArmorTable(){
        Vector data = new Vector();
        Vector header = new Vector();
        header.add("ID");
        header.add("Classification");
        header.add("TimeOfCreate");
        header.add("Defense");
        for (ArmorDTO armorDTO : armorList) {
            Vector row = new Vector();
            row.add(armorDTO.getArmorId());
            row.add(armorDTO.getClassification());
            row.add(formatter.format(armorDTO.getTimeOfCreate()));
            row.add(armorDTO.getDefense());
       
            data.add(row);
        }
        
        DefaultTableModel model = (DefaultTableModel) armorTable.getModel();
        model.setDataVector(data, header);

        armorTable.setRowSelectionInterval(0, 0);
        armorTableMouseClicked(null);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        armorTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        getAllButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        armorIDTextField = new javax.swing.JTextField();
        classficationTextField = new javax.swing.JTextField();
        timeTextField = new javax.swing.JTextField();
        defenseTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        findButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        statusTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        armorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Classification", "TimeOfCreate", "Defense"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        armorTable.getTableHeader().setReorderingAllowed(false);
        armorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                armorTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(armorTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setText("     Armor Client");
        jLabel1.setToolTipText("");

        getAllButton.setText("Get all");
        getAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Armor's detail:");

        jLabel7.setText("Description:");

        timeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeTextFieldActionPerformed(evt);
            }
        });

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane2.setViewportView(descriptionTextArea);

        jLabel3.setText("Armor ID:");

        jLabel4.setText("Classfication:");

        jLabel5.setText("TimeOfCreate:");

        findButton.setText("Find By ArmorID");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Defense:");

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Status:");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        statusTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusTextFieldActionPerformed(evt);
            }
        });

        addButton.setText("Add new");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(timeTextField)
                                            .addComponent(classficationTextField)
                                            .addComponent(armorIDTextField)
                                            .addComponent(defenseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createButton)
                                .addGap(18, 18, 18)
                                .addComponent(updateButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeButton)
                                .addGap(42, 42, 42))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(defenseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(armorIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(findButton))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(classficationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(35, 35, 35)
                                .addComponent(jLabel6)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel7)))
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(createButton)
                    .addComponent(updateButton)
                    .addComponent(removeButton))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(getAllButton)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(getAllButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void timeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeTextFieldActionPerformed

    private void getAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllButtonActionPerformed
        // TODO add your handling code here:
        try {
            menu= (ArmorInterface) Naming.lookup("rmi://127.0.0.1:1233//now");
            if(menu != null) {
                armorList= (ArrayList) menu.findAllArmor();
                getArmorTable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_getAllButtonActionPerformed

    private void statusTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusTextFieldActionPerformed

    private void armorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_armorTableMouseClicked
        // TODO add your handling code here:
        if (menu != null) {
            int index = armorTable.getSelectedRow();
            if (index >= 0) {
                armorIDTextField.setText(armorList.get(index).getArmorId());
                classficationTextField.setText(armorList.get(index).getClassification());
                timeTextField.setText("" + formatter.format(armorList.get(index).getTimeOfCreate()));
                defenseTextField.setText("" + armorList.get(index).getDefense());
                descriptionTextArea.setText(armorList.get(index).getDescription());
                statusTextField.setText(armorList.get(index).getStatus());
                
                armorIDTextField.setEnabled(false);
                classficationTextField.setEnabled(true);              
                timeTextField.setEnabled(true);
                defenseTextField.setEnabled(true);
                descriptionTextArea.setEnabled(true);
                statusTextField.setEnabled(true);
                findButton.setText("Find By ArmorID");
                find=false;
            }
        }
    }//GEN-LAST:event_armorTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if (menu != null) {
            armorIDTextField.setText("");
            classficationTextField.setText("");
            timeTextField.setText("");
//            Date date = java.util.Calendar.getInstance().getTime();
//
//            timeTextField.setText("" + formatter.format(date));
            defenseTextField.setText("");
            descriptionTextArea.setText("");
            statusTextField.setText("");

            armorIDTextField.setEnabled(true);
            timeTextField.setEnabled(false);
            armorIDTextField.requestFocus(true);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        if (menu!=null) {
            boolean checkCode = true;
            for (ArmorDTO armorDTO : armorList) {
                if (armorIDTextField.getText().toUpperCase().equals(armorDTO.getArmorId())) {
                    checkCode = false;
                }
            }
            if (armorIDTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ArmorID is not empty!");
                armorIDTextField.requestFocus(true);
            } else if (armorIDTextField.getText().length() > 10 || !armorIDTextField.getText().matches("[^@$#]*")) {
                JOptionPane.showMessageDialog(null, "ArmorID format is not valid!(Not @,S,# and length<10)");
                armorIDTextField.requestFocus(true);
            } else if (checkCode == false) {
                JOptionPane.showMessageDialog(null, "ArmorID is duplicated!");
                armorIDTextField.requestFocus(true);
            } else if (classficationTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Classfication is not empty!");
                classficationTextField.requestFocus(true);
            } else if (classficationTextField.getText().length() > 30) {
                JOptionPane.showMessageDialog(null, "Classfication length is so long(>30)!");
                classficationTextField.requestFocus(true);
            } else if (defenseTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Defense is not empty!");
                defenseTextField.requestFocus(true);
            } else if (!defenseTextField.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Defense is integer more than 0!");
                defenseTextField.requestFocus(true);
            } else if (Integer.parseInt(defenseTextField.getText()) <=0) {
                JOptionPane.showMessageDialog(null, "Defense is integer more than 0!");
                defenseTextField.requestFocus(true);
            }  else if (descriptionTextArea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Description is not empty!");
                descriptionTextArea.requestFocus(true);
            } else if (descriptionTextArea.getText().length() > 300) {
                JOptionPane.showMessageDialog(null, "Description length is so long(>300)!");
                descriptionTextArea.requestFocus(true);
            } else if (statusTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Status is not empty!");
                statusTextField.requestFocus(true);
            } else {
                Date date = java.util.Calendar.getInstance().getTime();
                timeTextField.setText("" + formatter.format(date));
                Date date1;
                ArmorDTO dto = new ArmorDTO(armorIDTextField.getText(), classficationTextField.getText(), descriptionTextArea.getText(),
                        statusTextField.getText(), date1 = new Date(timeTextField.getText()), Integer.parseInt(defenseTextField.getText()));
                try {
                    menu.createArmor(dto);
                    getAllButtonActionPerformed(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_createButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        if (menu != null) {
            int index = armorTable.getSelectedRow();
            if (index >= 0) {
                if (classficationTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Classfication is not empty!");
                    classficationTextField.requestFocus(true);
                } else if (classficationTextField.getText().length() > 30) {
                    JOptionPane.showMessageDialog(null, "Classfication length is so long(>30)!");
                    classficationTextField.requestFocus(true);
                } else if (timeTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "TimeOfCreate is not empty!");
                    defenseTextField.requestFocus(true);
                } else if (defenseTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Defense is not empty!");
                    defenseTextField.requestFocus(true);
                } else if (!defenseTextField.getText().matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Defense is integer more than 0!");
                    defenseTextField.requestFocus(true);
                } else if (Integer.parseInt(defenseTextField.getText()) <= 0) {
                    JOptionPane.showMessageDialog(null, "Defense is integer more than 0!");
                    defenseTextField.requestFocus(true);
                } else if (descriptionTextArea.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Description is not empty!");
                    descriptionTextArea.requestFocus(true);
                } else if (descriptionTextArea.getText().length() > 300) {
                    JOptionPane.showMessageDialog(null, "Description length is so long(>300)!");
                    descriptionTextArea.requestFocus(true);
                } else if (statusTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Status is not empty!");
                    statusTextField.requestFocus(true);
                } else {
                    ArmorDTO dto = new ArmorDTO();
                    dto.setArmorId(armorList.get(index).getArmorId());
                    dto.setClassification(classficationTextField.getText());
                    Date date;           
                    dto.setTimeOfCreate(date=new Date(timeTextField.getText()));
                    dto.setDefense(Integer.parseInt(defenseTextField.getText()));
                    dto.setDescription(descriptionTextArea.getText());
                    dto.setStatus(statusTextField.getText());
                    try {
                        
                        menu.updateArmor(dto);
                        getAllButtonActionPerformed(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        if (menu != null) {
            int index = armorTable.getSelectedRow();
            if (index >= 0) {
                int option = JOptionPane.showConfirmDialog(null, "Do oyou want to remove this row ?", "Remove", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        menu.removeArmor(armorIDTextField.getText());
                        getAllButtonActionPerformed(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        // TODO add your handling code here
        if (menu != null) {
            if (find == false) {
                armorIDTextField.setEnabled(true);
                armorIDTextField.requestFocus(true);
                classficationTextField.setEnabled(false);
                timeTextField.setEnabled(false);
                defenseTextField.setEnabled(false);
                descriptionTextArea.setEnabled(false);
                statusTextField.setEnabled(false);
                findButton.setText("Find");

                armorIDTextField.setText("");
                classficationTextField.setText("");
                timeTextField.setText("");
                defenseTextField.setText("");
                descriptionTextArea.setText("");
                statusTextField.setText("");
                find = true;
            } else {
                if (armorIDTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ArmorID is not empty!");
                    armorIDTextField.requestFocus(true);
                } else {
                    try {
                        ArmorDTO armor=menu.findByArmorID(armorIDTextField.getText());
                        if(armor==null){
                            JOptionPane.showMessageDialog(null, "Not found this armor!");
                            armorIDTextField.requestFocus(true);
                        }else{
                            for(int i=0;i<armorTable.getRowCount();i++){
                                if(armor.getArmorId().equals(armorTable.getValueAt(i, 0))){
                                    armorTable.setRowSelectionInterval(i, i);
                                }
                            }
                            classficationTextField.setText(armor.getClassification());
                            timeTextField.setText(formatter.format(armor.getTimeOfCreate()));
                            defenseTextField.setText(""+armor.getDefense());
                            descriptionTextArea.setText(armor.getDescription());
                            statusTextField.setText(armor.getStatus());
                     
                            armorIDTextField.setEnabled(false);
                            classficationTextField.setEnabled(true);
                            timeTextField.setEnabled(true);
                            defenseTextField.setEnabled(true);
                            descriptionTextArea.setEnabled(true);
                            statusTextField.setEnabled(true);
                            findButton.setText("Find By ArmorID");
                            find = false;
                     
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_findButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField armorIDTextField;
    private javax.swing.JTable armorTable;
    private javax.swing.JTextField classficationTextField;
    private javax.swing.JButton createButton;
    private javax.swing.JTextField defenseTextField;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JButton findButton;
    private javax.swing.JButton getAllButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField statusTextField;
    private javax.swing.JTextField timeTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}

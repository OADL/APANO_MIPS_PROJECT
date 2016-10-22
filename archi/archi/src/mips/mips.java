
package mips;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class mips extends javax.swing.JFrame  {

    public mips() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegList1 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        ALUResultbox = new javax.swing.JInternalFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DataMemorybox = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        InstList2 = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        textArea1 = new java.awt.TextArea();
        Registers = new javax.swing.JButton();
        ALUResult = new javax.swing.JButton();
        DataMemory = new javax.swing.JButton();
        Instructions = new javax.swing.JButton();
        NEXT = new javax.swing.JButton();
        PC = new javax.swing.JTextField();
        Jump = new javax.swing.JTextField();
        Mux1 = new javax.swing.JTextField();
        Mux3 = new javax.swing.JTextField();
        Mux4 = new javax.swing.JTextField();
        RegDst = new javax.swing.JTextField();
        RegWrite = new javax.swing.JTextField();
        Branch = new javax.swing.JTextField();
        MemRead = new javax.swing.JTextField();
        MemReg = new javax.swing.JTextField();
        ALUop = new javax.swing.JTextField();
        MemWrite = new javax.swing.JTextField();
        ALUsrc = new javax.swing.JTextField();
        GreenRegisters = new javax.swing.JLabel();
        RedRegisters = new javax.swing.JLabel();
        GreenALU = new javax.swing.JLabel();
        RedALU = new javax.swing.JLabel();
        GreenAdd = new javax.swing.JLabel();
        RedAdd = new javax.swing.JLabel();
        GreenInstMem = new javax.swing.JLabel();
        RedInstMem = new javax.swing.JLabel();
        GreenSignExtend = new javax.swing.JLabel();
        RedSignExtend = new javax.swing.JLabel();
        GreenShiftLeft = new javax.swing.JLabel();
        RedShiftLeft = new javax.swing.JLabel();
        GreenDataMem = new javax.swing.JLabel();
        RedDataMem = new javax.swing.JLabel();
        GreenAdd2 = new javax.swing.JLabel();
        GreenShiftLeft2 = new javax.swing.JLabel();
        RedShiftLeft2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(945, 580));
        setResizable(false);
        getContentPane().setLayout(null);

        RegList1.setClosable(true);
        RegList1.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        RegList1.setNormalBounds(new java.awt.Rectangle(30, 10, 260, 450));
        RegList1.setPreferredSize(new java.awt.Dimension(468, 450));
        RegList1.setVisible(false);

        jScrollPane2.setMinimumSize(new java.awt.Dimension(57, 34));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"$ZERO", arrRegs.reg[0]},
                {"$at", arrRegs.reg[1]},
                {"$vo", arrRegs.reg[2]},
                {"$v1", arrRegs.reg[3]},
                {"$a0", arrRegs.reg[4]},
                {"$a1", arrRegs.reg[5]},
                {"$a2", arrRegs.reg[6]},
                {"$a3", arrRegs.reg[7]},
                {"$t0", arrRegs.reg[8]},
                {"$t1", arrRegs.reg[9]},
                {"$t2", arrRegs.reg[10]},
                {"$t3", arrRegs.reg[11]},
                {"$t4", arrRegs.reg[12]},
                {"$t5", arrRegs.reg[13]},
                {"$t6", arrRegs.reg[14]},
                {"$t7", arrRegs.reg[15]},
                {"$s0", arrRegs.reg[16]},
                {"$s1", arrRegs.reg[17]},
                {"$s2", arrRegs.reg[18]},
                {"$s3", arrRegs.reg[19]},
                {"$s4", arrRegs.reg[20]},
                {"$s5", arrRegs.reg[21]},
                {"$s6", arrRegs.reg[22]},
                {"$s7", arrRegs.reg[23]},
                {"$t8", arrRegs.reg[24]},
                {"$t9", arrRegs.reg[25]},
                {"$k0", arrRegs.reg[26]},
                {"$k1", arrRegs.reg[27]},
                {"$gp", arrRegs.reg[28]},
                {"$sp", arrRegs.reg[29]},
                {"$fp", arrRegs.reg[30]},
                {"$ra", arrRegs.reg[31]}
            },
            new String [] {
                "Register", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.updateUI();
        jTable2.setMinimumSize(new java.awt.Dimension(57, 34));
        jTable2.setOpaque(false);
        jScrollPane2.setViewportView(jTable2);

        RegList1.getContentPane().add(jScrollPane2, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(RegList1);
        RegList1.setBounds(30, 10, 260, 450);

        ALUResultbox.setClosable(true);
        ALUResultbox.setVisible(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "RS", "Operation", "RT", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout ALUResultboxLayout = new javax.swing.GroupLayout(ALUResultbox.getContentPane());
        ALUResultbox.getContentPane().setLayout(ALUResultboxLayout);
        ALUResultboxLayout.setHorizontalGroup(
            ALUResultboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALUResultboxLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ALUResultboxLayout.setVerticalGroup(
            ALUResultboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(ALUResultbox);
        ALUResultbox.setBounds(670, 120, 260, 65);

        DataMemorybox.setClosable(true);
        DataMemorybox.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        DataMemorybox.setVisible(false);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Instruction", "Destination Address", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout DataMemoryboxLayout = new javax.swing.GroupLayout(DataMemorybox.getContentPane());
        DataMemorybox.getContentPane().setLayout(DataMemoryboxLayout);
        DataMemoryboxLayout.setHorizontalGroup(
            DataMemoryboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataMemoryboxLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DataMemoryboxLayout.setVerticalGroup(
            DataMemoryboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataMemoryboxLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(DataMemorybox);
        DataMemorybox.setBounds(660, 250, 240, 70);

        InstList2.setClosable(true);
        InstList2.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        InstList2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InstList2.setVisible(false);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Address", "Instruction"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout InstList2Layout = new javax.swing.GroupLayout(InstList2.getContentPane());
        InstList2.getContentPane().setLayout(InstList2Layout);
        InstList2Layout.setHorizontalGroup(
            InstList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        InstList2Layout.setVerticalGroup(
            InstList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(InstList2);
        InstList2.setBounds(30, 280, 260, 140);

        textArea1.setBackground(new java.awt.Color(224, 243, 245));
        textArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textArea1.setEditable(false);
        textArea1.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        textArea1.setText("--START--");
        getContentPane().add(textArea1);
        textArea1.setBounds(10, 400, 200, 140);

        Registers.setText("+");
        Registers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistersActionPerformed(evt);
            }
        });
        getContentPane().add(Registers);
        Registers.setBounds(490, 380, 20, 20);

        ALUResult.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ALUResult.setText("+");
        ALUResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALUResultActionPerformed(evt);
            }
        });
        getContentPane().add(ALUResult);
        ALUResult.setBounds(610, 360, 20, 20);

        DataMemory.setText("+");
        DataMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataMemoryActionPerformed(evt);
            }
        });
        getContentPane().add(DataMemory);
        DataMemory.setBounds(730, 330, 20, 20);

        Instructions.setText("+");
        Instructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionsActionPerformed(evt);
            }
        });
        getContentPane().add(Instructions);
        Instructions.setBounds(180, 300, 20, 20);

        NEXT.setBackground(new java.awt.Color(198, 253, 255));
        NEXT.setText("NEXT");
        NEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEXTActionPerformed(evt);
            }
        });
        getContentPane().add(NEXT);
        NEXT.setBounds(250, 480, 73, 23);

        PC.setEditable(false);
        PC.setText("    PC");
        PC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCActionPerformed(evt);
            }
        });
        getContentPane().add(PC);
        PC.setBounds(50, 350, 50, 20);

        Jump.setEditable(false);
        Jump.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Jump.setText("J");
        Jump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumpActionPerformed(evt);
            }
        });
        getContentPane().add(Jump);
        Jump.setBounds(860, 40, 20, 20);

        Mux1.setEditable(false);
        Mux1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mux1.setText("M1");
        getContentPane().add(Mux1);
        Mux1.setBounds(900, 130, 20, 20);

        Mux3.setEditable(false);
        Mux3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mux3.setText("M3");
        getContentPane().add(Mux3);
        Mux3.setBounds(900, 150, 20, 20);

        Mux4.setEditable(false);
        Mux4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mux4.setText("M4");
        getContentPane().add(Mux4);
        Mux4.setBounds(790, 150, 20, 20);

        RegDst.setEditable(false);
        RegDst.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegDst.setText("RD");
        RegDst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegDstActionPerformed(evt);
            }
        });
        getContentPane().add(RegDst);
        RegDst.setBounds(350, 400, 20, 20);
        RegDst.getAccessibleContext().setAccessibleName("");
        RegDst.getAccessibleContext().setAccessibleDescription("");

        RegWrite.setEditable(false);
        RegWrite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegWrite.setText("RW");
        getContentPane().add(RegWrite);
        RegWrite.setBounds(500, 260, 20, 20);

        Branch.setEditable(false);
        Branch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Branch.setText("BR");
        getContentPane().add(Branch);
        Branch.setBounds(470, 170, 20, 20);

        MemRead.setEditable(false);
        MemRead.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MemRead.setText("MR");
        getContentPane().add(MemRead);
        MemRead.setBounds(500, 190, 20, 20);

        MemReg.setEditable(false);
        MemReg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MemReg.setText("MT");
        MemReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemRegActionPerformed(evt);
            }
        });
        getContentPane().add(MemReg);
        MemReg.setBounds(860, 320, 20, 20);

        ALUop.setEditable(false);
        ALUop.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ALUop.setText("AL");
        ALUop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALUopActionPerformed(evt);
            }
        });
        getContentPane().add(ALUop);
        ALUop.setBounds(640, 390, 20, 20);

        MemWrite.setEditable(false);
        MemWrite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MemWrite.setText("MW");
        MemWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemWriteActionPerformed(evt);
            }
        });
        getContentPane().add(MemWrite);
        MemWrite.setBounds(500, 230, 20, 20);

        ALUsrc.setEditable(false);
        ALUsrc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ALUsrc.setText("AS");
        ALUsrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALUsrcActionPerformed(evt);
            }
        });
        getContentPane().add(ALUsrc);
        ALUsrc.setBounds(560, 330, 20, 20);

        GreenRegisters.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        GreenRegisters.setVisible(false);
        getContentPane().add(GreenRegisters);
        GreenRegisters.setBounds(500, 250, 40, 90);

        RedRegisters.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        RedRegisters.setVisible(true);
        getContentPane().add(RedRegisters);
        RedRegisters.setBounds(500, 250, 40, 90);

        GreenALU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        GreenALU.setVisible(false);
        getContentPane().add(GreenALU);
        GreenALU.setBounds(620, 280, 40, 90);

        RedALU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        RedALU.setVisible(true);
        getContentPane().add(RedALU);
        RedALU.setBounds(620, 280, 40, 90);

        GreenAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        GreenAdd.setVisible(false);
        getContentPane().add(GreenAdd);
        GreenAdd.setBounds(640, 110, 40, 90);

        RedAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        RedAdd.setVisible(true);
        getContentPane().add(RedAdd);
        RedAdd.setBounds(640, 110, 40, 90);

        GreenInstMem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        GreenInstMem.setVisible(false);
        getContentPane().add(GreenInstMem);
        GreenInstMem.setBounds(170, 260, 40, 90);

        RedInstMem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        RedInstMem.setVisible(true);
        getContentPane().add(RedInstMem);
        RedInstMem.setBounds(170, 260, 40, 90);

        GreenSignExtend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        GreenSignExtend.setVisible(false);
        getContentPane().add(GreenSignExtend);
        GreenSignExtend.setBounds(450, 440, 40, 90);

        RedSignExtend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        RedSignExtend.setVisible(true);
        getContentPane().add(RedSignExtend);
        RedSignExtend.setBounds(450, 440, 40, 90);

        GreenShiftLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        GreenShiftLeft.setVisible(false);
        getContentPane().add(GreenShiftLeft);
        GreenShiftLeft.setBounds(570, 130, 40, 90);

        RedShiftLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        RedShiftLeft.setVisible(true);;
        getContentPane().add(RedShiftLeft);
        RedShiftLeft.setBounds(570, 130, 40, 90);

        GreenDataMem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        GreenDataMem.setVisible(false);
        getContentPane().add(GreenDataMem);
        GreenDataMem.setBounds(730, 340, 40, 90);

        RedDataMem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        RedDataMem.setVisible(true);
        getContentPane().add(RedDataMem);
        RedDataMem.setBounds(730, 340, 40, 90);

        GreenAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        getContentPane().add(GreenAdd2);
        GreenAdd2.setBounds(160, 90, 20, 60);

        GreenShiftLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        GreenShiftLeft2.setVisible(false);
        getContentPane().add(GreenShiftLeft2);
        GreenShiftLeft2.setBounds(340, 50, 20, 60);

        RedShiftLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        RedShiftLeft2.setVisible(true);
        getContentPane().add(RedShiftLeft2);
        RedShiftLeft2.setBounds(340, 50, 20, 60);

        jLabel1.setForeground(new java.awt.Color(245, 6, 6));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/rsz_single_cycle_jump_mips.jpg"))); // NOI18N
        jLabel1.setText("+");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 930, 550);

        setBounds(0, 0, 945, 585);
    }// </editor-fold>//GEN-END:initComponents
    
    private void ALUResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALUResultActionPerformed
        // TODO add your handling code here:
        ALUResultbox.setVisible(true);
    }//GEN-LAST:event_ALUResultActionPerformed

    private void PCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_PCActionPerformed

    private void RegDstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegDstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegDstActionPerformed

    private void ALUsrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALUsrcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ALUsrcActionPerformed

    private void MemRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MemRegActionPerformed

    private void DataMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataMemoryActionPerformed
        // TODO add your handling code here:
        DataMemorybox.setVisible(true);
    }//GEN-LAST:event_DataMemoryActionPerformed

    private void InstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructionsActionPerformed
        // TODO add your handling code here:
        InstList2.setVisible(true);
    }//GEN-LAST:event_InstructionsActionPerformed

    private void RegistersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistersActionPerformed
        // TODO add your handling code here:
        RegList1.setVisible(true);
    }//GEN-LAST:event_RegistersActionPerformed

    private void JumpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JumpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JumpActionPerformed

    private void ALUopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALUopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ALUopActionPerformed

    private void NEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEXTActionPerformed
        // TODO add your handling code here:
        updateable();
    }//GEN-LAST:event_NEXTActionPerformed

    private void MemWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemWriteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MemWriteActionPerformed
    public void updateable(){
        for(int i = 0 ; i <32 ;i++){
            jTable2.setValueAt(arrRegs.reg[i], i, 1);
        }
    }
    public void updatetable1(int rs,String op, int rt,int result){
        jTable1.setValueAt(rs, 0, 0);
        jTable1.setValueAt(op, 0, 1);
        jTable1.setValueAt(rt, 0, 2);
        jTable1.setValueAt(result, 0, 3);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
JOptionPane.showMessageDialog(null, "APANO MIPS Datapath And Control Unit Simulator© \nProudct Version: v1.0 \nInstruction Supported:\n                    •Arithmetic: add, addi, sub" +
"\n" +
"                    •Load/Store: lw, sw" +
"\n" +
"                    •Logic: sll, and, or, nor" +
"\n" +
"                    •Controlflow: beq, bne, j, jal, jr" +
"\n" +
"                    •Comparison: slt, slti, sltu, sltui \nHow To Use:\n 1) Write your instruction in the following format: \n  ex: addi $s1,$s1,4 [NO SPACES AFTER COMMAS] \n 2) Write your next instruction in a new line.\n 3) Click \"RUN\". ", "About", JOptionPane.INFORMATION_MESSAGE);       
        USERFrame f = new USERFrame();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {}
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALUResult;
    private javax.swing.JInternalFrame ALUResultbox;
    public javax.swing.JTextField ALUop;
    public javax.swing.JTextField ALUsrc;
    public javax.swing.JTextField Branch;
    private javax.swing.JButton DataMemory;
    private javax.swing.JInternalFrame DataMemorybox;
    public javax.swing.JLabel GreenALU;
    public javax.swing.JLabel GreenAdd;
    private javax.swing.JLabel GreenAdd2;
    public javax.swing.JLabel GreenDataMem;
    public javax.swing.JLabel GreenInstMem;
    public javax.swing.JLabel GreenRegisters;
    public javax.swing.JLabel GreenShiftLeft;
    public javax.swing.JLabel GreenShiftLeft2;
    public javax.swing.JLabel GreenSignExtend;
    private javax.swing.JInternalFrame InstList2;
    private javax.swing.JButton Instructions;
    public javax.swing.JTextField Jump;
    public javax.swing.JTextField MemRead;
    public javax.swing.JTextField MemReg;
    public javax.swing.JTextField MemWrite;
    private javax.swing.JTextField Mux1;
    private javax.swing.JTextField Mux3;
    public javax.swing.JTextField Mux4;
    public javax.swing.JButton NEXT;
    public javax.swing.JTextField PC;
    public javax.swing.JLabel RedALU;
    public javax.swing.JLabel RedAdd;
    public javax.swing.JLabel RedDataMem;
    public javax.swing.JLabel RedInstMem;
    public javax.swing.JLabel RedRegisters;
    public javax.swing.JLabel RedShiftLeft;
    public javax.swing.JLabel RedShiftLeft2;
    public javax.swing.JLabel RedSignExtend;
    public javax.swing.JTextField RegDst;
    private javax.swing.JInternalFrame RegList1;
    public javax.swing.JTextField RegWrite;
    private javax.swing.JButton Registers;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    public java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
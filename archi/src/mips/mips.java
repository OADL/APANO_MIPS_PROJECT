
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
    public int type = 0;
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
        JfromatTable = new javax.swing.JInternalFrame();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        IFromatTable = new javax.swing.JInternalFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        RfromatTable = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        textArea1 = new java.awt.TextArea();
        Registers = new javax.swing.JButton();
        ALUResult = new javax.swing.JButton();
        DataMemory = new javax.swing.JButton();
        Instructions = new javax.swing.JButton();
        Continue = new javax.swing.JButton();
        NEXT = new javax.swing.JButton();
        PC = new javax.swing.JTextField();
        Jump = new javax.swing.JTextField();
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
        RedAdd2 = new javax.swing.JLabel();
        GreenShiftLeft2 = new javax.swing.JLabel();
        RedShiftLeft2 = new javax.swing.JLabel();
        Clock = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APANO mips");
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
        jTable2.getTableHeader().setReorderingAllowed(false);
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
        jTable1.getTableHeader().setReorderingAllowed(false);
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
                "Read/Write", "Destination", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
            jTable3.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout DataMemoryboxLayout = new javax.swing.GroupLayout(DataMemorybox.getContentPane());
        DataMemorybox.getContentPane().setLayout(DataMemoryboxLayout);
        DataMemoryboxLayout.setHorizontalGroup(
            DataMemoryboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        DataMemoryboxLayout.setVerticalGroup(
            DataMemoryboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(DataMemorybox);
        DataMemorybox.setBounds(660, 250, 294, 65);

        JfromatTable.setClosable(true);
        JfromatTable.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        JfromatTable.setTitle("J-Format");
        JfromatTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JfromatTable.setVisible(false);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "opcode 31:26", "Target address 26:0"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
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
        jTable6.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setResizable(false);
            jTable6.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout JfromatTableLayout = new javax.swing.GroupLayout(JfromatTable.getContentPane());
        JfromatTable.getContentPane().setLayout(JfromatTableLayout);
        JfromatTableLayout.setHorizontalGroup(
            JfromatTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfromatTableLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JfromatTableLayout.setVerticalGroup(
            JfromatTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(JfromatTable);
        JfromatTable.setBounds(30, 280, 309, 65);

        IFromatTable.setClosable(true);
        IFromatTable.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        IFromatTable.setTitle("I-Format");
        IFromatTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        IFromatTable.setVisible(false);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "opcode 31:26", "rs 25:21", "rt 20:16", "address/Imm 15:0"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        jTable5.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setResizable(false);
            jTable5.getColumnModel().getColumn(1).setResizable(false);
            jTable5.getColumnModel().getColumn(2).setResizable(false);
            jTable5.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout IFromatTableLayout = new javax.swing.GroupLayout(IFromatTable.getContentPane());
        IFromatTable.getContentPane().setLayout(IFromatTableLayout);
        IFromatTableLayout.setHorizontalGroup(
            IFromatTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );
        IFromatTableLayout.setVerticalGroup(
            IFromatTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(IFromatTable);
        IFromatTable.setBounds(30, 280, 557, 65);

        RfromatTable.setClosable(true);
        RfromatTable.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        RfromatTable.setTitle("R-Format");
        RfromatTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RfromatTable.setVisible(false);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "opcode 31:26", "rs 25:21", "rt 20:16", "rd 15:11", "shamt 10:6", "func 5:0"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setMinimumSize(new java.awt.Dimension(2147483647, 18));
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(1).setResizable(false);
            jTable4.getColumnModel().getColumn(2).setResizable(false);
            jTable4.getColumnModel().getColumn(3).setResizable(false);
            jTable4.getColumnModel().getColumn(4).setResizable(false);
            jTable4.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout RfromatTableLayout = new javax.swing.GroupLayout(RfromatTable.getContentPane());
        RfromatTable.getContentPane().setLayout(RfromatTableLayout);
        RfromatTableLayout.setHorizontalGroup(
            RfromatTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );
        RfromatTableLayout.setVerticalGroup(
            RfromatTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        getContentPane().add(RfromatTable);
        RfromatTable.setBounds(30, 280, 664, 65);

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

        Instructions.setBackground(new java.awt.Color(248, 249, 249));
        Instructions.setText("+");
        Instructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionsActionPerformed(evt);
            }
        });
        getContentPane().add(Instructions);
        Instructions.setBounds(180, 300, 20, 20);

        Continue.setBackground(new java.awt.Color(204, 204, 255));
        Continue.setText("Continue");
        getContentPane().add(Continue);
        Continue.setBounds(230, 470, 130, 30);

        NEXT.setBackground(new java.awt.Color(255, 51, 51));
        NEXT.setText("NEXT");
        NEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEXTActionPerformed(evt);
            }
        });
        getContentPane().add(NEXT);
        NEXT.setBounds(250, 510, 90, 30);

        PC.setEditable(false);
        PC.setText("    PC");
        PC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCActionPerformed(evt);
            }
        });
        getContentPane().add(PC);
        PC.setBounds(50, 350, 60, 20);

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

        RedAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        getContentPane().add(RedAdd2);
        RedAdd2.setBounds(160, 79, 20, 80);

        GreenShiftLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/GreenLight.png"))); // NOI18N
        GreenShiftLeft2.setVisible(false);
        getContentPane().add(GreenShiftLeft2);
        GreenShiftLeft2.setBounds(340, 50, 10, 60);

        RedShiftLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips/redlight.png"))); // NOI18N
        RedShiftLeft2.setVisible(true);
        getContentPane().add(RedShiftLeft2);
        RedShiftLeft2.setBounds(340, 50, 10, 60);

        Clock.setText("    Clock");
        Clock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(Clock);
        Clock.setBounds(50, 376, 60, 19);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PC:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 350, 30, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CC:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 374, 40, 20);

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
        if (type == 0) {
            RfromatTable.setVisible(true);
            IFromatTable.setVisible(false);
            JfromatTable.setVisible(false);
        } else if (type == 1) {
            RfromatTable.setVisible(false);
            IFromatTable.setVisible(true);
            JfromatTable.setVisible(false);
        } else {
            RfromatTable.setVisible(false);
            IFromatTable.setVisible(false);
            JfromatTable.setVisible(true);
        }
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
    public void updatedatatable(String inst , String Regname , int value)
    {
    jTable3.setValueAt(inst, 0 ,0);
    jTable3.setValueAt(Regname, 0, 1);
    jTable3.setValueAt(value, 0, 2);
        
    }
    public void updateRformat(int opcode,int rs,int rt,int rd,int shamt,int func){
        jTable4.setValueAt(opcode,0,0);
        jTable4.setValueAt(rs,0,1);
        jTable4.setValueAt(rt,0,2);
        jTable4.setValueAt(rd,0,3);
        jTable4.setValueAt(shamt,0,4);
        jTable4.setValueAt(func,0,5);
    }
    public void updateIformat(int opcode, int rs,int rt,int addr){
        jTable5.setValueAt(opcode,0,0);
        jTable5.setValueAt(rs,0,1);
        jTable5.setValueAt(rt,0,2);
        jTable5.setValueAt(addr,0,3);
    }
    public void updateJformat(int opcode,int addr){
        jTable6.setValueAt(opcode,0,0);
        jTable6.setValueAt(addr,0,1);
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
"                    •Comparison: slt, slti, sltu, sltui \nHow To Use:\n 1) Write your instruction in the following format: \n  ex:            addi $s1,$s1,4 [NO SPACES AFTER COMMAS]\n                   add $s2,$zero,$s1 [$zero]\n       LOOP: slti $t1,$s1,10 [SPACE AFTER COLON]\n                    j LOOP\n 2) Write your next instruction in a new line.\n 3) Click \"RUN\".\n *Array addresses range: [701:731] ", "About", JOptionPane.INFORMATION_MESSAGE);       
      
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
    public javax.swing.JLabel Clock;
    public javax.swing.JButton Continue;
    private javax.swing.JButton DataMemory;
    public javax.swing.JInternalFrame DataMemorybox;
    public javax.swing.JLabel GreenALU;
    public javax.swing.JLabel GreenAdd;
    public javax.swing.JLabel GreenAdd2;
    public javax.swing.JLabel GreenDataMem;
    public javax.swing.JLabel GreenInstMem;
    public javax.swing.JLabel GreenRegisters;
    public javax.swing.JLabel GreenShiftLeft;
    public javax.swing.JLabel GreenShiftLeft2;
    public javax.swing.JLabel GreenSignExtend;
    public javax.swing.JInternalFrame IFromatTable;
    private javax.swing.JButton Instructions;
    public javax.swing.JInternalFrame JfromatTable;
    public javax.swing.JTextField Jump;
    public javax.swing.JTextField MemRead;
    public javax.swing.JTextField MemReg;
    public javax.swing.JTextField MemWrite;
    public javax.swing.JTextField Mux4;
    public javax.swing.JButton NEXT;
    public javax.swing.JTextField PC;
    public javax.swing.JLabel RedALU;
    public javax.swing.JLabel RedAdd;
    private javax.swing.JLabel RedAdd2;
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
    public javax.swing.JInternalFrame RfromatTable;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    public java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
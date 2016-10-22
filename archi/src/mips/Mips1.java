package mips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class RegFrame extends JFrame {

    private JInternalFrame RegList2;
    private JScrollPane jScrollPane3;
    static JTable jTable2;

    public RegFrame() throws HeadlessException {
        this.setSize(300, 485);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RegList2 = new javax.swing.JInternalFrame("Registers File");
        this.setResizable(false);
        ImageIcon icon = new ImageIcon("icon.ico");
        setIconImage(icon.getImage());
        this.setTitle("Values");
        RegList2.setClosable(false);
        RegList2.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        RegList2.setNormalBounds(new java.awt.Rectangle(30, 10, 260, 450));
        RegList2.setVisible(true);
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane3.setMinimumSize(new java.awt.Dimension(57, 300));
        jTable2 = new javax.swing.JTable();
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {"PC", USERFrame.PC},
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
                new String[]{
                    "Register", "Value"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable2.updateUI();
        jTable2.setMinimumSize(new java.awt.Dimension(57, 300));
        jTable2.setOpaque(false);
        jScrollPane3.setViewportView(jTable2);
        RegList2.getContentPane().add(jScrollPane3, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(RegList2);
        RegList2.setBounds(30, 10, 260, 450);
    }
}

class arrRegs {

    static int[] reg = new int[32];

    arrRegs() {
        for (int i = 0; i < 32; i++) {
            reg[i] = 0;
        }
        reg[29] = USERFrame.PC;
    }

    protected void updateregs() {
        for (int i = 0; i < 32; i++) {
            reg[i] = (int) RegFrame.jTable2.getValueAt(i + 1, 1);
        }
    }
}

class storeload {

    static int rac = 0;
    static int[] rapc = new int[20];
    static int[] raj = new int[20];
    static int sp = 0;
    static int[] $at = new int[25];
    static int[] $a3 = new int[25];
    static int[] $v0 = new int[25];
    static int[] $v1 = new int[25];
    static int[] $a0 = new int[25];
    static int[] $a1 = new int[25];
    static int[] $a2 = new int[25];
    static int[] $t0 = new int[25];
    static int[] $t1 = new int[25];
    static int[] $t2 = new int[25];
    static int[] $t3 = new int[25];
    static int[] $t4 = new int[25];
    static int[] $t5 = new int[25];
    static int[] $t6 = new int[25];
    static int[] $t7 = new int[25];
    static int[] $s0 = new int[25];
    static int[] $s1 = new int[25];
    static int[] $s2 = new int[25];
    static int[] $s3 = new int[25];
    static int[] $s4 = new int[25];
    static int[] $s5 = new int[25];
    static int[] $s6 = new int[25];
    static int[] $s7 = new int[25];
    static int[] $t8 = new int[25];
    static int[] $t9 = new int[25];
    static int[] $k0 = new int[25];
    static int[] $k1 = new int[25];
    static int[] $gp = new int[25];
    static int[] $sp = new int[25];
    static int[] $fp = new int[25];
    static int[] $ra = new int[25];
}

class USERFrame extends JFrame {

    private static int path = 0;
    private static boolean add2 = false;
    private static boolean instmem = false;
    private static boolean signext = false;
    private static boolean shift2 = false;
    private static boolean regis = false;
    private static boolean alu = false;
    private static boolean shift = false;
    private static boolean add = false;
    private static boolean datamem = false;  // for the data path
    //===================================================================================
    static int j = 0;
    static String s[] = new String[100];
    static int C[] = new int[100];
    static int P[] = new int[100];
    static int PC = 800000;
    static int clock = 0; // for the jump and addresses
    //======================================================================================
    static mips m;
    private arrRegs rg;
    private JFrame userframe;
    RegFrame rf;
    private JTextArea userarea;
    private JButton run;
    private FileWriter fw;
    private PrintWriter pw;
    protected FileReader fr;
    private BufferedReader br;
    private BufferedReader br2;
    //==============================================================================================================
    public static int counter;

    public USERFrame() throws IOException {

        m = new mips();
        m.setTitle("APANO MIPS| Data Path And Control Unit Simulator");
        m.setSize(500, 500);
        m.pack();
        rg = new arrRegs();
        rf = new RegFrame();
        rf.setVisible(true);
        userframe = new JFrame("Instructions");
        userframe.setSize(300, 350);
        userframe.setResizable(false);
        userframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userframe.setLocationRelativeTo(null);
        run = new JButton("RUN");
        fw = new FileWriter("instructions.txt");
        pw = new PrintWriter(fw);
        fr = new FileReader("instructions.txt");
        br = new BufferedReader(fr);
        m.Clock.setText(" " + clock);
        run.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PC = (int) rf.jTable2.getValueAt(0, 1);
                rg.updateregs();
                userframe.setVisible(false);
                userframe.dispose();
                rf.setVisible(false);
                m.setVisible(true);
                JOptionPane.showMessageDialog(null, "Click \"Continue\" to keep-track of the current instruction datapath.\nClick \"NEXT\" to go to the next instruction.", "Help", JOptionPane.INFORMATION_MESSAGE);

                counter = userarea.getLineCount();
                pw.print(userarea.getText());
                pw.close();
                m.Clock.setText(" " + ++clock);
                P[0] = PC;
                try {
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("IOException");
                }
                try {
                    br2 = new BufferedReader(fr);
                    int l = 0;
                    for (int i = 0; i < counter; i++) {
                        PC += 4;
                        P[i + 1] = PC;

                        String str = br2.readLine();

                        if (isargument(str)) {
                            C[l] = i;
                            s[l] = str.substring(0, str.indexOf(':'));
                            l++;
                        }

                    }
                    PC = P[0];
                    TakeAction(jump(0));
                    j++;

                } catch (IOException ex) {
                    System.out.println("IOException1");
                }
                m.updateable();
            }
        });
        m.NEXT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.GreenInstMem.setVisible(false);
                m.GreenRegisters.setVisible(false);
                m.GreenALU.setVisible(false);
                m.GreenAdd.setVisible(false);
                m.GreenAdd2.setVisible(false);
                m.GreenShiftLeft.setVisible(false);
                m.GreenShiftLeft2.setVisible(false);
                m.GreenSignExtend.setVisible(false);
                m.GreenDataMem.setVisible(false);
                path = 0;
                if (j == counter) {
                    m.textArea1.setText(m.textArea1.getText() + "\n" + "--END--");
                    m.NEXT.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Enter another program?");
                    m.Continue.setVisible(false);
                } else {
                    m.Continue.setVisible(true);
                }
                if (j < counter) {
                    try {
                        TakeAction(jump(j));
                        j++;
                        m.Clock.setText(" " + ++clock);
                    } catch (IOException ex) {
                        System.out.println("IOException2");
                    } catch (NullPointerException ex) {

                        {
                            JOptionPane.showMessageDialog(null, "Empty string");
                        }
                    }
                }

            }
        });

        m.Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                path++;
                movepath(path);
                if (path == 4) {
                    m.Continue.setVisible(false);
                }
            }
        });

        run.setPreferredSize(new Dimension(10, 25));
        userarea = new JTextArea();
        userarea.setFont(new Font("DialogInput", 0, 20));
        userarea.setPreferredSize(new Dimension(300, 320));
        JScrollPane jsp = new JScrollPane(userarea);
        userframe.add(run, BorderLayout.SOUTH);
        userframe.add(jsp, BorderLayout.CENTER);
        // userframe.setPreferredSize(new Dimension(200, 300));
        userframe.setVisible(true);

    }

    public void RFormat(String func, String str) {
        m.type = 0;
        instmem = true;
        regis = true;
        alu = true;
        add = false;
        shift = false;
        shift2 = false;
        signext = false;
        datamem = false;
        add2 = true;
        m.RegDst.setText("1");
        m.Branch.setText("0");
        m.MemRead.setText("0");
        m.MemReg.setText("0");
        m.MemWrite.setText("0");
        m.ALUsrc.setText("0");
        m.RegWrite.setText("1");
        m.Jump.setText("0");
        m.Mux4.setText("0");
        String Regdst;
        String Reg1;
        String Reg2;
        int no;
        switch (func) {
            case "add":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                Reg2 = str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1);
                m.updateRformat(0, indexreg(Reg1), indexreg(Reg2), indexreg(Regdst), 0, 32);
                if (rg.reg[indexreg(Reg2)] > 700 && rg.reg[indexreg(Reg2)] <= 731 && rg.reg[indexreg(Reg1)] != 729) {
                    rg.reg[indexreg(Regdst)] = rg.reg[indexreg(Reg2)];
                } else if (Regdst.equals("$sp") && Reg2.equals("sp")) {
                    rg.reg[29] += rg.reg[indexreg(Reg2)];
                } else {
                    m.ALUop.setText("+");
                    ALUCalc('+', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                }
                break;
            case "sub":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                Reg2 = str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1);
                m.updateRformat(0, indexreg(Reg1), indexreg(Reg2), indexreg(Regdst), 0, 34);
                m.ALUop.setText("-");
                ALUCalc('-', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                break;
            case "and":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                Reg2 = str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1);
                m.updateRformat(0, indexreg(Reg1), indexreg(Reg2), indexreg(Regdst), 0, 36);
                m.ALUop.setText("&");
                ALUCalc('&', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                break;
            case "or":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                Reg2 = str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1);
                m.updateRformat(0, indexreg(Reg1), indexreg(Reg2), indexreg(Regdst), 0, 37);
                m.ALUop.setText("|");
                ALUCalc('|', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                break;
            case "slt":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                Reg2 = str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1);
                m.updateRformat(0, indexreg(Reg1), indexreg(Reg2), indexreg(Regdst), 0, 42);
                m.ALUop.setText("<");
                if (ALUComp('<', indexreg(Reg1), indexreg(Reg2))) {
                    rg.reg[indexreg(Regdst)] = 1;
                } else {
                    rg.reg[indexreg(Regdst)] = 0;
                }
                break;
            case "sltu":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                Reg2 = str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1);
                m.updateRformat(0, indexreg(Reg1), indexreg(Reg2), indexreg(Regdst), 0, 41);
                m.ALUop.setText("<");
                if (ALUComp('u', indexreg(Reg1), indexreg(Reg2))) {
                    rg.reg[indexreg(Regdst)] = 1;
                } else {
                    rg.reg[indexreg(Regdst)] = 0;
                }
                break;
            case "sll":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                no = Integer.parseInt(str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1));
                m.updateRformat(0, 0, indexreg(Reg1), indexreg(Regdst), no, 0);
                ALUCalc('s', indexreg(Reg1), no, indexreg(Regdst));
                break;
            case "jr":
                instmem = true;
                regis = true;
                alu = false;
                add = false;
                shift = false;
                shift2 = true;
                signext = false;
                datamem = false;
                add2 = true;
                m.RegDst.setText("X");
                m.Branch.setText("X");
                m.MemRead.setText("0");
                m.MemReg.setText("X");
                m.MemWrite.setText("0");
                m.ALUsrc.setText("X");
                m.RegWrite.setText("0");
                m.ALUop.setText(" ");
                m.Jump.setText("1");
                m.Mux4.setText("X");
                storeload.rac--;
                PC = storeload.rapc[storeload.rac];
                j = storeload.raj[storeload.rac];
                if (storeload.rac > 0) {
                    rg.reg[31] = storeload.rapc[storeload.rac - 1];
                } else {
                    rg.reg[31] = 0;
                }
                break;
            case "nor":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                Reg2 = str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1);
                m.updateRformat(0, indexreg(Reg1), indexreg(Reg2), indexreg(Regdst), 0, 39);
                m.ALUop.setText("~");
                ALUCalc('~', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                break;
        }
    }

    public void IFormat(String func, String str) {
        m.type = 1;
        String Regdst;
        String Reg1;
        int no;
        String Reg2;
        switch (func) {
            case ("addi"):
                instmem = true;
                regis = true;
                alu = true;
                add = false;
                shift = false;
                shift2 = false;
                signext = false;
                datamem = false;
                add2 = true;
                m.RegDst.setText("0");
                m.Branch.setText("0");
                m.MemRead.setText("0");
                m.MemReg.setText("0");
                m.MemWrite.setText("0");
                m.ALUsrc.setText("1");
                m.RegWrite.setText("1");
                m.ALUop.setText("+");
                m.Jump.setText("0");
                m.Mux4.setText("0");
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                try {
                    no = Integer.parseInt(str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1));
                    m.updateIformat(8, indexreg(Reg1), indexreg(Regdst), no);
                    if (rg.reg[indexreg(Reg1)] >= 701 && rg.reg[indexreg(Reg1)] <= 731 && rg.reg[indexreg(Reg1)] != 729) {
                        rg.reg[indexreg(Regdst)] = rg.reg[indexreg(Reg1)];
                    } else if (Reg1.equals("sp")) {
                        rg.reg[29] += no;
                    } else {
                        m.ALUop.setText("i");
                        ALUCalc('i', indexreg(Reg1), no, indexreg(Regdst));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Make sure you entered an immediate value", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case ("lw"):
                instmem = true;
                regis = true;
                alu = true;
                add = false;
                shift = false;
                shift2 = false;
                signext = true;
                datamem = true;
                add2 = true;
                m.RegDst.setText("0");
                m.Branch.setText("0");
                m.MemRead.setText("1");
                m.MemReg.setText("1");
                m.MemWrite.setText("0");
                m.ALUsrc.setText("1");
                m.RegWrite.setText("1");
                m.ALUop.setText("+");
                m.Jump.setText("0");
                m.Mux4.setText("0");
                Reg1 = str.substring(str.indexOf('$'), str.indexOf(','));
                no = Integer.parseInt(str.substring(str.indexOf(',') + 1, str.indexOf('(')));
                Regdst = str.substring(str.indexOf('(') + 1, str.indexOf(')'));
                m.updateIformat(35, indexreg(Regdst), indexreg(Reg1), no);
                switch (rg.reg[indexreg(Regdst)]) {
                    case 701:
                        rg.reg[indexreg(Reg1)] = storeload.$at[no / 4];
                        break;
                    case 704:
                        rg.reg[indexreg(Reg1)] = storeload.$a0[no / 4];
                        break;
                    case 705:
                        rg.reg[indexreg(Reg1)] = storeload.$a1[no / 4];
                        break;
                    case 706:
                        rg.reg[indexreg(Reg1)] = storeload.$a2[no / 4];
                        break;
                    case 707:
                        rg.reg[indexreg(Reg1)] = storeload.$a3[no / 4];
                        break;
                    case 702:
                        rg.reg[indexreg(Reg1)] = storeload.$v0[no / 4];
                        break;
                    case 703:
                        rg.reg[indexreg(Reg1)] = storeload.$v1[no / 4];
                        break;
                    case 708:
                        rg.reg[indexreg(Reg1)] = storeload.$t0[no / 4];
                        break;
                    case 709:
                        rg.reg[indexreg(Reg1)] = storeload.$t1[no / 4];
                        break;
                    case 710:
                        rg.reg[indexreg(Reg1)] = storeload.$t2[no / 4];
                        break;
                    case 711:
                        rg.reg[indexreg(Reg1)] = storeload.$t3[no / 4];
                        break;
                    case 712:
                        rg.reg[indexreg(Reg1)] = storeload.$t4[no / 4];
                        break;
                    case 713:
                        rg.reg[indexreg(Reg1)] = storeload.$t5[no / 4];
                        break;
                    case 714:
                        rg.reg[indexreg(Reg1)] = storeload.$t6[no / 4];
                        break;
                    case 715:
                        rg.reg[indexreg(Reg1)] = storeload.$t7[no / 4];
                        break;
                    case 724:
                        rg.reg[indexreg(Reg1)] = storeload.$t8[no / 4];
                        break;
                    case 725:
                        rg.reg[indexreg(Reg1)] = storeload.$t9[no / 4];
                        break;
                    case 716:
                        rg.reg[indexreg(Reg1)] = storeload.$s0[no / 4];
                        break;
                    case 717:
                        rg.reg[indexreg(Reg1)] = storeload.$s1[no / 4];
                        break;
                    case 718:
                        rg.reg[indexreg(Reg1)] = storeload.$s2[no / 4];
                        break;
                    case 719:
                        rg.reg[indexreg(Reg1)] = storeload.$s3[no / 4];
                        break;
                    case 720:
                        rg.reg[indexreg(Reg1)] = storeload.$s4[no / 4];
                        break;
                    case 721:
                        rg.reg[indexreg(Reg1)] = storeload.$s5[no / 4];
                        break;
                    case 722:
                        rg.reg[indexreg(Reg1)] = storeload.$s6[no / 4];
                        break;
                    case 723:
                        rg.reg[indexreg(Reg1)] = storeload.$s7[no / 4];
                        break;
                    case 726:
                        rg.reg[indexreg(Reg1)] = storeload.$k0[no / 4];
                        break;
                    case 727:
                        rg.reg[indexreg(Reg1)] = storeload.$k1[no / 4];
                        break;
                    case 728:
                        rg.reg[indexreg(Reg1)] = storeload.$gp[no / 4];
                        break;
                    case 730:
                        rg.reg[indexreg(Reg1)] = storeload.$fp[no / 4];
                        break;
                    case 731:
                        rg.reg[indexreg(Reg1)] = storeload.$ra[no / 4];
                        break;
                }
                if (Regdst.equals("$sp")) {
                    storeload.sp--;
                    rg.reg[indexreg(Reg1)] = storeload.$sp[storeload.sp];
                }
                m.updatedatatable("Read", Regdst, rg.reg[indexreg(Reg1)]);
                break;
            case ("sw"):
                instmem = true;
                regis = true;
                alu = true;
                add = false;
                shift = false;
                shift2 = false;
                signext = true;
                datamem = true;
                add2 = true;
                m.RegDst.setText("X");
                m.Branch.setText("0");
                m.MemRead.setText("0");
                m.MemReg.setText("X");
                m.MemWrite.setText("1");
                m.ALUsrc.setText("1");
                m.RegWrite.setText("0");
                m.ALUop.setText("+");
                m.Jump.setText("0");
                m.Mux4.setText("0");
                Reg1 = str.substring(str.indexOf('$'), str.indexOf(','));
                no = Integer.parseInt(str.substring(str.indexOf(',') + 1, str.indexOf('(')));
                Regdst = str.substring(str.indexOf('(') + 1, str.indexOf(')'));
                m.updateIformat(43, indexreg(Regdst), indexreg(Reg1), no);
                switch (rg.reg[indexreg(Regdst)]) {
                    case 701:
                        storeload.$at[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$at[no / 4]);
                        break;
                    case 704:
                        storeload.$a0[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$a0[no / 4]);
                        break;
                    case 705:
                        storeload.$a1[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$a1[no / 4]);
                        break;
                    case 706:
                        storeload.$a2[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$a2[no / 4]);
                        break;
                    case 707:
                        storeload.$a3[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$a3[no / 4]);
                        break;
                    case 702:
                        storeload.$v0[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$v0[no / 4]);
                        break;
                    case 703:
                        storeload.$v1[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$v1[no / 4]);
                        break;
                    case 708:
                        storeload.$t0[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t0[no / 4]);
                        break;
                    case 709:
                        storeload.$t1[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t1[no / 4]);
                        break;
                    case 710:
                        storeload.$t2[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t2[no / 4]);
                        break;
                    case 711:
                        storeload.$t3[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t3[no / 4]);
                        break;
                    case 712:
                        storeload.$t4[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t4[no / 4]);
                        break;
                    case 713:
                        storeload.$t5[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t5[no / 4]);
                        break;
                    case 714:
                        storeload.$t6[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t6[no / 4]);
                        break;
                    case 715:
                        storeload.$t7[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t7[no / 4]);
                        break;
                    case 724:
                        storeload.$t8[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t8[no / 4]);
                        break;
                    case 725:
                        storeload.$t9[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$t9[no / 4]);
                        break;
                    case 716:
                        storeload.$s0[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$s0[no / 4]);
                        break;
                    case 717:
                        storeload.$s1[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$s1[no / 4]);
                        break;
                    case 718:
                        storeload.$s2[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$s2[no / 4]);
                        break;
                    case 719:
                        storeload.$s3[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$s3[no / 4]);
                        break;
                    case 720:
                        storeload.$s4[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$s4[no / 4]);
                        break;
                    case 721:
                        storeload.$s5[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$s5[no / 4]);
                        break;
                    case 722:
                        storeload.$s6[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$s6[no / 4]);
                        break;
                    case 723:
                        storeload.$s7[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$s7[no / 4]);
                        break;
                    case 726:
                        storeload.$k0[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$k0[no / 4]);
                        break;
                    case 727:
                        storeload.$k1[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$k1[no / 4]);
                        break;
                    case 728:
                        storeload.$gp[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$gp[no / 4]);
                        break;
                    case 730:
                        storeload.$fp[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$fp[no / 4]);
                        break;
                    case 731:
                        storeload.$ra[no / 4] = rg.reg[indexreg(Reg1)];
                        m.updatedatatable("Write", Regdst, storeload.$ra[no / 4]);
                        break;
                }
                if (Regdst.equals("$sp")) {
                    storeload.$sp[storeload.sp] = rg.reg[indexreg(Reg1)];
                    m.updatedatatable("Write", Regdst, storeload.$sp[storeload.sp]);
                    storeload.sp++;
                }
                break;
            case ("beq"):
                instmem = true;
                regis = true;
                alu = true;
                add = true;
                shift = true;
                shift2 = false;
                signext = true;
                datamem = false;
                add2 = true;
                m.RegDst.setText("X");
                m.Branch.setText("1");
                m.MemRead.setText("0");
                m.MemReg.setText("X");
                m.MemWrite.setText("0");
                m.ALUsrc.setText("0");
                m.RegWrite.setText("0");
                m.ALUop.setText("-");
                m.Jump.setText("0");
                m.Mux4.setText("1");
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                Reg2 = str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1);
                int jump = 0;
                if (ALUComp('=', indexreg(Regdst), indexreg(Reg1))) {
                    for (int i = 0; i < 10; i++) {
                        if (Reg2.equals(s[i])) {
                            PC = P[i];
                            jump = i - j;
                            j = C[i] - 1;
                            break;
                        }
                    }
                }
                m.updateIformat(4, indexreg(Regdst), indexreg(Reg1), jump);
                break;
            case ("bne"):
                instmem = true;
                regis = true;
                alu = true;
                add = true;
                shift = true;
                shift2 = false;
                signext = true;
                datamem = false;
                add2 = true;
                m.RegDst.setText("X");
                m.Branch.setText("1");
                m.MemRead.setText("0");
                m.MemReg.setText("X");
                m.MemWrite.setText("0");
                m.ALUsrc.setText("0");
                m.RegWrite.setText("0");
                m.ALUop.setText("-");
                m.Jump.setText("0");
                m.Mux4.setText("1");
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                Reg2 = str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1);
                int jumpi = 0;
                if (!ALUComp('=', indexreg(Regdst), indexreg(Reg1))) {
                    for (int i = 0; i < 10; i++) {
                        if (Reg2.equals(s[i])) {
                            PC = P[i];
                            jump = i - j;
                            j = C[i] - 1;
                            break;
                        }
                    }
                }
                m.updateIformat(4, indexreg(Regdst), indexreg(Reg1), jumpi);
                break;
            case "slti":
                instmem = true;
                regis = true;
                alu = true;
                add = false;
                shift = false;
                shift2 = false;
                signext = false;
                datamem = false;
                add2 = true;
                m.RegDst.setText("0");
                m.Branch.setText("0");
                m.MemRead.setText("0");
                m.MemReg.setText("0");
                m.MemWrite.setText("0");
                m.ALUsrc.setText("1");
                m.RegWrite.setText("1");
                m.ALUop.setText("<");
                m.Jump.setText("0");
                m.Mux4.setText("0");
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                no = Integer.parseInt(str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1));
                m.updateIformat(10, indexreg(Reg1), indexreg(Regdst), no);
                if (ALUComp('i', indexreg(Reg1), no)) {
                    rg.reg[indexreg(Regdst)] = 1;
                } else {
                    rg.reg[indexreg(Regdst)] = 0;
                }
                break;
            case "sltui":
                instmem = true;
                regis = true;
                alu = true;
                add = false;
                shift = false;
                shift2 = false;
                signext = false;
                datamem = false;
                add2 = true;
                m.RegDst.setText("0");
                m.Branch.setText("0");
                m.MemRead.setText("0");
                m.MemReg.setText("0");
                m.MemWrite.setText("0");
                m.ALUsrc.setText("1");
                m.RegWrite.setText("1");
                m.ALUop.setText("<");
                m.Jump.setText("0");
                m.Mux4.setText("0");
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',', str.indexOf(',') + 1));
                no = Integer.parseInt(str.substring(str.indexOf(',', str.indexOf(',') + 1) + 1));
                m.updateIformat(9, indexreg(Reg1), indexreg(Regdst), no);
                if (ALUComp('u', indexreg(Reg1), no)) {
                    rg.reg[indexreg(Regdst)] = 1;
                } else {
                    rg.reg[indexreg(Regdst)] = 0;
                }
                break;
        }

    }

    public void JFormat(String fun, String str) {
        m.type = 2;
        instmem = true;
        regis = true;
        alu = false;
        add = false;
        shift = false;
        shift2 = true;
        signext = false;
        datamem = false;
        add2 = true;
        if (isargument(str)) {
            str = str.substring(str.indexOf(" ") + 1);
        }
        String ADDrJUMP;
        switch (fun) {
            case "j":
                m.RegDst.setText("X");
                m.Branch.setText("X");
                m.MemRead.setText("0");
                m.MemReg.setText("X");
                m.MemWrite.setText("0");
                m.ALUsrc.setText("X");
                m.RegWrite.setText("0");
                m.ALUop.setText(" ");
                m.Jump.setText("1");
                m.Mux4.setText("X");
                ADDrJUMP = str.substring(str.indexOf(' ') + 1);
                for (int i = 0; i < 10; i++) {
                    if (ADDrJUMP.equals(s[i])) {
                        PC = P[i];
                        j = C[i] - 1;
                        break;
                    }
                }
                m.updateJformat(2, PC / 4);
                break;
            case "jal":
                m.RegDst.setText("X");
                m.Branch.setText("X");
                m.MemRead.setText("0");
                m.MemReg.setText("X");
                m.MemWrite.setText("0");
                m.ALUsrc.setText("X");
                m.RegWrite.setText("0");
                m.ALUop.setText(" ");
                m.Jump.setText("1");
                m.Mux4.setText("X");
                rg.reg[31] = PC + 4;
                storeload.rapc[storeload.rac] = PC + 4;
                storeload.raj[storeload.rac] = j;
                storeload.rac++;
                ADDrJUMP = str.substring(str.indexOf(' ') + 1);
                for (int i = 0; i < 10; i++) {
                    if (ADDrJUMP.equals(s[i])) {
                        PC = P[i];
                        j = C[i] - 1;
                        break;
                    }
                }
                m.updateJformat(3, PC / 4);
                break;
        }
    }

    public boolean ALUComp(char s, int reg1, int reg2) {
        boolean result;
        int res;
        String op;
        if (s == '<') {
            result = (rg.reg[reg1] < rg.reg[reg2]) ? true : false;
            op = "<";
            if (result) {
                res = 1;
            } else {
                res = 0;
            }
            m.updatetable1(rg.reg[reg1], op, rg.reg[reg2], res);
            return result;
        } else if (s == 'i') {
            result = (rg.reg[reg1] < reg2) ? true : false;
            op = "<";
            if (result) {
                res = 1;
            } else {
                res = 0;
            }
            m.updatetable1(rg.reg[reg1], op, rg.reg[reg2], res);
            return result;
        } else if (s == '=') {
            int result2 = rg.reg[reg1] - rg.reg[reg2];
            op = "-";
            if (result2 == 0) {
                result = true;
                res = 1;
            } else {
                result = false;
                res = 0;
            }
            m.updatetable1(rg.reg[reg1], op, rg.reg[reg2], res);
            return result;
        } else if (s == 'u') {
            result = (Math.abs(rg.reg[reg1]) < Math.abs(rg.reg[reg2])) ? true : false;
            op = "<";
            if (result) {
                res = 1;
            } else {
                res = 0;
            }
            m.updatetable1(rg.reg[reg1], op, rg.reg[reg2], res);
            return result;
        } else {
            return false;
        }
    }

    public void ALUCalc(char s, int reg1, int reg2, int regdst) {
        String op;
        switch (s) {
            case '+':
                rg.reg[regdst] = rg.reg[reg1] + rg.reg[reg2];
                op = "+";
                m.updatetable1(rg.reg[reg1], op, rg.reg[reg2], rg.reg[regdst]);
                break;
            case 'i':
                rg.reg[regdst] = rg.reg[reg1] + reg2;
                op = "+";
                m.updatetable1(rg.reg[reg1], op, reg2, rg.reg[regdst]);
                break;
            case '-':
                rg.reg[regdst] = rg.reg[reg1] - rg.reg[reg2];
                op = "-";
                m.updatetable1(rg.reg[reg1], op, rg.reg[reg2], rg.reg[regdst]);
                break;
            case '&':
                rg.reg[regdst] = rg.reg[reg1] & rg.reg[reg2];
                op = "and";
                m.updatetable1(rg.reg[reg1], op, rg.reg[reg2], rg.reg[regdst]);
                break;
            case '|':
                rg.reg[regdst] = rg.reg[reg1] | rg.reg[reg2];
                op = "or";
                m.updatetable1(rg.reg[reg1], op, rg.reg[reg2], rg.reg[regdst]);
                break;
            case 's':
                rg.reg[regdst] = (rg.reg[reg1] << reg2);
                op = "shift left";
                m.updatetable1(rg.reg[reg1], op, reg2, rg.reg[regdst]);
                break;
            case '~':
                rg.reg[regdst] = ~(rg.reg[reg1] | rg.reg[reg2]);
                op = "nor";
                m.updatetable1(rg.reg[reg1], op, rg.reg[reg2], rg.reg[regdst]);
                break;
        }
    }

    public void movepath(int i) {
        switch (i) {
            case 1:
                if (add2) {
                    m.GreenAdd2.setVisible(true);
                }
                if (instmem) {
                    m.GreenInstMem.setVisible(true);
                }
                break;
            case 2:
                if (signext) {
                    m.GreenSignExtend.setVisible(true);
                }
                if (shift2) {
                    m.GreenShiftLeft2.setVisible(true);
                }
                if (regis) {
                    m.GreenRegisters.setVisible(true);
                }
                break;
            case 3:
                if (alu) {
                    m.GreenALU.setVisible(true);
                }
                if (shift) {
                    m.GreenShiftLeft.setVisible(true);
                }
                break;
            case 4:
                if (add) {
                    m.GreenAdd.setVisible(true);
                }
                if (datamem) {
                    m.GreenDataMem.setVisible(true);
                }
                break;
        }
    }

    public String jump(int y) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("instructions.txt"));
        PC = P[y];
        m.PC.setText("" + PC);
        int x = 0;
        while (x < y) {
            r.readLine();
            x++;
        }
        return r.readLine();
    }

    public void TakeAction(String str) {
        try {
            m.textArea1.setText(m.textArea1.getText() + "\n" + str);
            String FUNC;
            if (isargument(str)) {
                if (!isexit(str)) {
                    FUNC = str.substring(str.indexOf(' ') + 1, str.indexOf(' ', str.indexOf(' ') + 1));
                } else {
                    instmem = false;
                    regis = false;
                    alu = false;
                    add = false;
                    shift = false;
                    shift2 = false;
                    signext = false;
                    datamem = false;
                    add2 = false;
                    m.RegDst.setText("X");
                    m.Branch.setText("X");
                    m.MemRead.setText("0");
                    m.MemReg.setText("X");
                    m.MemWrite.setText("0");
                    m.ALUsrc.setText("X");
                    m.RegWrite.setText("0");
                    m.ALUop.setText(" ");
                    m.Jump.setText("X");
                    m.Mux4.setText("X");
                    return;
                }
            } else {
                FUNC = str.substring(0, str.indexOf(' '));

            }
            if (FUNC.equals((String) ("add")) || FUNC.equals((String) ("sub")) || FUNC.equals((String) ("and")) || FUNC.equals((String) ("jr")) || FUNC.equals((String) ("nor")) || FUNC.equals((String) ("or")) || FUNC.equals((String) ("sll")) || FUNC.equals((String) ("slt")) || FUNC.equals((String) ("sltu"))) {
                RFormat(FUNC, str);
            } else if (FUNC.equals((String) ("lw")) || FUNC.equals((String) ("sw")) || FUNC.equals((String) ("addi")) || FUNC.equals((String) ("slti")) || FUNC.equals((String) ("sltui")) || FUNC.equals((String) ("beq")) || FUNC.equals((String) ("bne"))) {
                IFormat(FUNC, str);
            } else if (FUNC.equalsIgnoreCase("j") || FUNC.equals((String) ("jal"))) {
                JFormat(FUNC, str);
            } else {
                JOptionPane.showMessageDialog(null, "Unsupported instruction found", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NullPointerException ex3) {
            JOptionPane.showMessageDialog(null, "Empty File Found", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean isargument(String str) {
        try {
            String argu = str.substring(0, str.indexOf(':'));
            return true;
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isexit(String str) {
        try {
            String argu = str.substring(str.indexOf(' ') + 1, str.indexOf(' ', str.indexOf(' ') + 1));
            return false;
        } catch (StringIndexOutOfBoundsException e) {
            return true;
        } catch (NullPointerException e) {
            return true;
        }
    }

    private int indexreg(String str) {
        switch (str) {
            case "$zero":
                return 0;
            case "$at":
                return 1;
            case "$v0":
                return 2;
            case "$v1":
                return 3;
            case "$a0":
                return 4;
            case "$a1":
                return 5;
            case "$a2":
                return 6;
            case "$a3":
                return 7;
            case "$t0":
                return 8;
            case "$t1":
                return 9;
            case "$t2":
                return 10;
            case "$t3":
                return 11;
            case "$t4":
                return 12;
            case "$t5":
                return 13;
            case "$t6":
                return 14;
            case "$t7":
                return 15;
            case "$s0":
                return 16;
            case "$s1":
                return 17;
            case "$s2":
                return 18;
            case "$s3":
                return 19;
            case "$s4":
                return 20;
            case "$s5":
                return 21;
            case "$s6":
                return 22;
            case "$s7":
                return 23;
            case "$t8":
                return 24;
            case "$t9":
                return 25;
            case "$k0":
                return 26;
            case "$k1":
                return 27;
            case "$gp":
                return 28;
            case "$sp":
                return 29;
            case "$fp":
                return 30;
            case "$ra":
                return 31;
            default:
                JOptionPane.showMessageDialog(null, "Error reg " + str + "\nMake sure you entered your instruction in the correct format (NO SPACES AFTER COMMAS).", "ERROR", JOptionPane.WARNING_MESSAGE);
                return -1;
        }
    }
}

package mips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

class arrRegs {

    static int[] reg = new int[32];
    static boolean[] shifted = new boolean[32];
    arrRegs() {
        for (int i = 0; i < 32; i++) {
            reg[i] = 0;
            shifted[i] = false;
        }
        shifted[29] = true ;
    }
    boolean isShifted(int i){
        return shifted[i];
    }
}
class storeload {
    
    static int ra = 0;
    static int sp = -1 ;
    static int[] sz =new int[50];
    static int[] $at;
    static int[] $a0;
    static int[] $a1;
    static int[] $a2;
    static int[] $a3;
    static int[] $v0;
    static int[] $v1;
    static int[] $t0;
    static int[] $t1;
    static int[] $t2;
    static int[] $t3;
    static int[] $t4;
    static int[] $t5;
    static int[] $t6;
    static int[] $t7;
    static int[] $t8;
    static int[] $t9;
    static int[] $s0;
    static int[] $s1;
    static int[] $s2;
    static int[] $s3;
    static int[] $s4;
    static int[] $s5;
    static int[] $s6;
    static int[] $s7;
    static int[] $k0;
    static int[] $k1;
    static int[] $gp;
    static int[] $sp;
    static int[] $fp;
    static int[] $ra;
    storeload(int[] reg,int index){
                $at = new int[index];           
                $a0 = new int[index];
                $a1 = new int[index];
                $a2 = new int[index];
                $a3 = new int[index];
                $v0 = new int[index];
                $v1 = new int[index];
                $t0 = new int[index];
                $t1 = new int[index];
                $t2 = new int[index];
                $t3 = new int[index];
                $t4 = new int[index];
                $t5 = new int[index];
                $t6 = new int[index];
                $t7 = new int[index];
                $t8 = new int[index];
                $t9 = new int[index];
                $s0 = new int[index];
                $s1 = new int[index];
                $s2 = new int[index];
                $s3 = new int[index];
                $s4 = new int[index];
                $s5 = new int[index];
                $s6 = new int[index];
                $s7 = new int[index];
                $k0 = new int[index];
                $k1 = new int[index];
                $gp = new int[index];
                $sp = new int[index];
                $fp = new int[index];
                $ra = new int[index];
    }
}

class USERFrame extends JFrame {
    static int j =1;
    static String s[] = new String [10];
    static int C[]= new int [10];
    static int P[]= new int [10];
    static int PC = 800000 ;
    static mips m;
    private arrRegs rg;
    private JFrame userframe;
    private JTextArea userarea;
    private JButton run;
    private FileWriter fw;
    private PrintWriter pw;
    protected FileReader fr;
    private BufferedReader br;
    private BufferedReader br2;
    public static boolean runclk = false;
    public static int counter;

    public USERFrame() throws IOException {
       
        m = new mips();
        m.setSize(500, 500);
        m.pack();
        rg = new arrRegs();
        userframe = new JFrame("Instructions ");
        userframe.setSize(200, 300);
        userframe.setResizable(false);
        userframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        run = new JButton("RUN");
        fw = new FileWriter("instructions.txt");
        pw = new PrintWriter(fw);
        fr = new FileReader("instructions.txt");
        br = new BufferedReader(fr);
        P[0] = 800000;
        run.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                userframe.setVisible(false);
                userframe.dispose();
                m.setVisible(true);
                 counter = userarea.getLineCount();
                pw.print(userarea.getText());
                pw.close();
                
                try {
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("IOException");
                }
                try {
                    br2 = new BufferedReader(fr);
                    int l = 0 ;
                    for(int i=0 ; i<counter ; i++){
                        PC += 4 ;
                        P[i+1]=PC;
                        String str = br2.readLine();
                        if(isargument(str)){
                            C[l] = i ;
                            s[l]= str.substring(0, str.indexOf(':'));
                            l++;
                        }
                    }
                    PC = 800000 ;
                    TakeAction(jump(0));
                } catch (IOException ex) {
                    System.out.println("IOException1");
                }
                m.updateable();
            }
        });
        m.NEXT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counter = userarea.getLineCount();
                if(j==counter) 
                {    m.textArea1.setText(m.textArea1.getText()+"\n"+ "--END--");
                m.NEXT.setVisible(false);
            }

                if(j<counter){
                    try {
                        TakeAction(jump(j));
                        j++;
                    } catch (IOException ex) {
                        System.out.println("IOException2");
                    }catch(NullPointerException ex){
                    }
                }
                
            }
        });
        run.setPreferredSize(new Dimension(10, 25));
        userarea = new JTextArea();
        userarea.setPreferredSize(new Dimension(200, 285));
        userframe.add(run, BorderLayout.SOUTH);
        userframe.add(userarea, BorderLayout.CENTER);
        userframe.setPreferredSize(new Dimension(200, 300));
        userframe.setVisible(true);

    }

    public void RFormat(String func, String str) {
        m.GreenInstMem.setVisible(true);
        m.GreenRegisters.setVisible(true);
        m.GreenALU.setVisible(true);
        m.GreenAdd.setVisible(false);
        m.GreenShiftLeft.setVisible(false);
        m.GreenShiftLeft2.setVisible(false);
        m.GreenSignExtend.setVisible(false);
        m.GreenDataMem.setVisible(false);
        m.RegDst.setText("1");
        m.Branch.setText("0");
        m.MemRead.setText("0");
        m.MemReg.setText("0");
        m.MemWrite.setText("0");
        m.ALUsrc.setText("0");
        m.RegWrite.setText("1");
        m.Jump.setText("0");
        m.Mux4.setText("0");
        String Regdst ;
        String Reg1 ;
        String Reg2 ;
        int no ;
        switch (func) {
            case "add":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                if(arrRegs.shifted[indexreg(Reg1)]){
                    switch (Regdst) {
                        case "$at":
                            storeload.$at = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$a0":
                            storeload.$a0 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$a1":
                            storeload.$a1 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$a2":
                            storeload.$a2 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$a3":
                            storeload.$a3 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$v0":
                            storeload.$v0 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$v1":
                            storeload.$v1 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t0":
                            storeload.$t0 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t1":
                            storeload.$t1 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t2":
                            storeload.$t2 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t3":
                            storeload.$t3 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t4":
                            storeload.$t4 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t5":
                            storeload.$t5 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t6":
                            storeload.$t6 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t7":
                            storeload.$t7 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t8":
                            storeload.$t8 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$t9":
                            storeload.$t9 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$s0":
                            storeload.$s0 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$s1":
                            storeload.$s1 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$s2":
                            storeload.$s2 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$s3":
                            storeload.$s3 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$s4":
                            storeload.$s4 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$s5":
                            storeload.$s5 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$s6":
                            storeload.$s6 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$s7":
                            storeload.$s7 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$k0":
                            storeload.$k0 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$k1":
                            storeload.$k1 = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$gp":
                            storeload.$gp = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$sp":
                            int[] temp = storeload.$sp;
                            try {
                                storeload.$sp = new int[(rg.reg[indexreg(Reg1)] / 4) + temp.length];
                                for (int i = 0; i < temp.length; i++) {
                                    storeload.$sp[i] = temp[i];
                                }
                            } catch (NullPointerException e) {
                                storeload.$sp = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            }
                            storeload.sp += 1;
                            storeload.sz[storeload.sp]= storeload.$sp.length ;
                            break;
                        case "$fp":
                            storeload.$fp = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$ra":
                            storeload.$ra = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                    }
                }else {
                    m.ALUop.setText("+");
                    ALUCalc('+', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                }
                break;
            case "sub":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                m.ALUop.setText("-");
                ALUCalc('-', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                break;
            case "and":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                m.ALUop.setText("&");
                ALUCalc('&', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                break;
            case "or":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                m.ALUop.setText("|");
                ALUCalc('|', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                break;
            case "slt":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                m.ALUop.setText("<");
                if (ALUComp('<', indexreg(Reg1), indexreg(Reg2))) {
                    rg.reg[indexreg(Regdst)] = 1;
                } else {
                    rg.reg[indexreg(Regdst)] = 0;
                }
                break;
            case "sltu":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                m.ALUop.setText("<");
                if (ALUComp('u', indexreg(Reg1), indexreg(Reg2))) {
                    rg.reg[indexreg(Regdst)] = 1;
                } else {
                    rg.reg[indexreg(Regdst)] = 0;
                }
                break;
            case "sll" :
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                no = Integer.parseInt(str.substring(str.indexOf(',')+5)) ;
                ALUCalc('s',indexreg(Reg1), no,indexreg(Regdst));
                arrRegs.shifted[indexreg(Regdst)] = true ;
                break;
             case "jr" :
                PC = rg.reg[31];
                j = storeload.ra ;
                break;
             case "nor":
                Regdst = str.substring(str.indexOf('$'), str.indexOf(','));
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                m.ALUop.setText("~");
                ALUCalc('~', indexreg(Reg1), indexreg(Reg2), indexreg(Regdst));
                break;
        }
    }

    public void IFormat(String func, String str) {
        String Regdst;
        String Reg1;
        int no;
        String Reg2;
        switch (func) {
            case ("addi"):
                m.GreenInstMem.setVisible(true);
                m.GreenRegisters.setVisible(true);
                m.GreenALU.setVisible(true);
                m.GreenAdd.setVisible(false);
                m.GreenShiftLeft.setVisible(false);
                m.GreenShiftLeft2.setVisible(false);
                m.GreenSignExtend.setVisible(false);
                m.GreenDataMem.setVisible(false);
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
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                no = Integer.parseInt(str.substring(str.indexOf(',') + 5));
                if(arrRegs.shifted[indexreg(Reg1)]){
                    switch (Regdst) {
                        case "$at":
                            storeload.$at = new int[ no / 4];
                            break;
                        case "$a0":
                            storeload.$a0 = new int[no / 4];
                            break;
                        case "$a1":
                            storeload.$a1 = new int[no / 4];
                            break;
                        case "$a2":
                            storeload.$a2 = new int[no / 4];
                            break;
                        case "$a3":
                            storeload.$a3 = new int[no / 4];
                            break;
                        case "$v0":
                            storeload.$v0 = new int[no / 4];
                            break;
                        case "$v1":
                            storeload.$v1 = new int[no / 4];
                            break;
                        case "$t0":
                            storeload.$t0 = new int[no / 4];
                            break;
                        case "$t1":
                            storeload.$t1 = new int[no / 4];
                            break;
                        case "$t2":
                            storeload.$t2 = new int[no / 4];
                            break;
                        case "$t3":
                            storeload.$t3 = new int[no / 4];
                            break;
                        case "$t4":
                            storeload.$t4 = new int[no / 4];
                            break;
                        case "$t5":
                            storeload.$t5 = new int[no / 4];
                            break;
                        case "$t6":
                            storeload.$t6 = new int[no / 4];
                            break;
                        case "$t7":
                            storeload.$t7 = new int[no / 4];
                            break;
                        case "$t8":
                            storeload.$t8 = new int[no / 4];
                            break;
                        case "$t9":
                            storeload.$t9 = new int[no / 4];
                            break;
                        case "$s0":
                            storeload.$s0 = new int[no / 4];
                            break;
                        case "$s1":
                            storeload.$s1 = new int[no / 4];
                            break;
                        case "$s2":
                            storeload.$s2 = new int[no / 4];
                            break;
                        case "$s3":
                            storeload.$s3 = new int[no / 4];
                            break;
                        case "$s4":
                            storeload.$s4 = new int[no / 4];
                            break;
                        case "$s5":
                            storeload.$s5 = new int[no / 4];
                            break;
                        case "$s6":
                            storeload.$s6 = new int[no / 4];
                            break;
                        case "$s7":
                            storeload.$s7 = new int[no / 4];
                            break;
                        case "$k0":
                            storeload.$k0 = new int[no / 4];
                            break;
                        case "$k1":
                            storeload.$k1 = new int[no / 4];
                            break;
                        case "$gp":
                            storeload.$gp = new int[no / 4];
                            break;
                        case "$sp":
                            try {
                                no = Integer.parseInt(str.substring(str.indexOf('-')+1));
                                 int[] temp = storeload.$sp;
                                try {
                                    storeload.$sp = new int[no / 4 + temp.length];
                                    for (int i = 0; i < temp.length; i++) {
                                        storeload.$sp[i] = temp[i];
                                    }
                                } catch (NullPointerException e) {
                                    storeload.$sp = new int[no / 4];
                                }
                                storeload.sp += 1;
                                storeload.sz[storeload.sp] = storeload.$sp.length;
                            } catch (Exception ex) {
                                no = Integer.parseInt(str.substring(str.indexOf(',') + 5));
                                storeload.sz[storeload.sp] = 0;
                                storeload.sp -= 1;
                            }
                            break;
                        case "$fp":
                            storeload.$fp = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                        case "$ra":
                            storeload.$ra = new int[(rg.reg[indexreg(Reg1)] / 4)];
                            break;
                    }
                }else {
                    m.ALUop.setText("i");
                    ALUCalc('i', indexreg(Reg1), no, indexreg(Regdst));
                }
                break;
            case ("lw"):
                m.GreenInstMem.setVisible(true);
                m.GreenRegisters.setVisible(true);
                m.GreenALU.setVisible(true);
                m.GreenAdd.setVisible(false);
                m.GreenShiftLeft.setVisible(false);
                m.GreenShiftLeft2.setVisible(false);
                m.GreenSignExtend.setVisible(true);
                m.GreenDataMem.setVisible(true);
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
                Regdst = str.substring(str.indexOf('(')+1,str.indexOf(')'));
                switch (Regdst) {
                        case "$at":
                              rg.reg[indexreg(Reg1)]= storeload.$at[no/4];  
                            break;
                        case "$a0":
                              rg.reg[indexreg(Reg1)]= storeload.$a0[no/4];  
                            break;
                        case "$a1":
                              rg.reg[indexreg(Reg1)]= storeload.$a1[no/4];  
                            break;
                        case "$a2":
                              rg.reg[indexreg(Reg1)]= storeload.$a2[no/4];  
                            break;
                        case "$a3":
                              rg.reg[indexreg(Reg1)]= storeload.$a3[no/4];  
                            break;
                        case "$v0":
                              rg.reg[indexreg(Reg1)]= storeload.$v0[no/4];  
                            break;
                        case "$v1":
                              rg.reg[indexreg(Reg1)]= storeload.$v1[no/4];  
                            break;
                        case "$t0":
                              rg.reg[indexreg(Reg1)]= storeload.$t0[no/4];  
                            break;
                        case "$t1":
                              rg.reg[indexreg(Reg1)]= storeload.$t1[no/4];  
                            break;
                        case "$t2":
                              rg.reg[indexreg(Reg1)]= storeload.$t2[no/4];  
                            break;
                        case "$t3":
                              rg.reg[indexreg(Reg1)]= storeload.$t3[no/4];  
                            break;
                        case "$t4":
                              rg.reg[indexreg(Reg1)]= storeload.$t4[no/4];  
                            break;
                        case "$t5":
                              rg.reg[indexreg(Reg1)]= storeload.$t5[no/4];  
                            break;
                        case "$t6":
                              rg.reg[indexreg(Reg1)]= storeload.$t6[no/4];  
                            break;
                        case "$t7":
                              rg.reg[indexreg(Reg1)]= storeload.$t7[no/4];  
                            break;
                        case "$t8":
                              rg.reg[indexreg(Reg1)]= storeload.$t8[no/4];  
                            break;
                        case "$t9":
                              rg.reg[indexreg(Reg1)]= storeload.$t9[no/4];  
                            break;
                        case "$s0":
                              rg.reg[indexreg(Reg1)]= storeload.$s0[no/4];  
                            break;
                        case "$s1":
                              rg.reg[indexreg(Reg1)]= storeload.$s1[no/4];  
                            break;
                        case "$s2":
                              rg.reg[indexreg(Reg1)]= storeload.$s2[no/4];  
                            break;
                        case "$s3":
                              rg.reg[indexreg(Reg1)]= storeload.$s3[no/4];  
                            break;
                        case "$s4":
                              rg.reg[indexreg(Reg1)]= storeload.$s4[no/4];  
                            break;
                        case "$s5":
                              rg.reg[indexreg(Reg1)]= storeload.$s5[no/4];  
                            break;
                        case "$s6":
                              rg.reg[indexreg(Reg1)]= storeload.$s6[no/4];  
                            break;
                        case "$s7":
                              rg.reg[indexreg(Reg1)]= storeload.$s7[no/4];  
                            break;
                        case "$k0":
                              rg.reg[indexreg(Reg1)]= storeload.$k0[no/4];  
                            break;
                        case "$k1":
                              rg.reg[indexreg(Reg1)]= storeload.$k1[no/4];  
                            break;
                        case "$gp":
                              rg.reg[indexreg(Reg1)]= storeload.$gp[no/4];  
                            break;
                        case "$sp":
                            if (storeload.sp == 0) {
                                rg.reg[indexreg(Reg1)] = storeload.$sp[no / 4];
                            } else {
                                rg.reg[indexreg(Reg1)] = storeload.$sp[no / 4 + storeload.sz[storeload.sp - 1]];
                            }
                            break;
                        case "$fp":
                              rg.reg[indexreg(Reg1)]= storeload.$fp[no/4];  
                            break;
                        case "$ra":
                              rg.reg[indexreg(Reg1)]= storeload.$ra[no/4];  
                            break;
                    }
                break;               
            case ("sw"):
                m.GreenInstMem.setVisible(true);
                m.GreenRegisters.setVisible(true);
                m.GreenALU.setVisible(true);
                m.GreenAdd.setVisible(false);
                m.GreenShiftLeft.setVisible(false);
                m.GreenShiftLeft2.setVisible(false);
                m.GreenSignExtend.setVisible(true);
                m.GreenDataMem.setVisible(true);
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
                Regdst = str.substring(str.indexOf('(')+1,str.indexOf(')'));
                 switch (Regdst) {
                    case "$at":
                        storeload.$at[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$a0":
                        storeload.$a0[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$a1":
                        storeload.$a1[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$a2":
                        storeload.$a2[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$a3":
                        storeload.$a3[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$v0":
                        storeload.$v0[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$v1":
                        storeload.$v1[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t0":
                        storeload.$t0[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t1":
                        storeload.$t1[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t2":
                        storeload.$t2[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t3":
                        storeload.$t3[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t4":
                        storeload.$t4[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t5":
                        storeload.$t5[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t6":
                        storeload.$t6[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t7":
                        storeload.$t7[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t8":
                        storeload.$t8[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$t9":
                        storeload.$t9[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$s0":
                        storeload.$s0[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$s1":
                        storeload.$s1[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$s2":
                        storeload.$s2[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$s3":
                        storeload.$s3[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$s4":
                        storeload.$s4[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$s5":
                        storeload.$s5[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$s6":
                        storeload.$s6[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$s7":
                        storeload.$s7[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$k0":
                        storeload.$k0[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$k1":
                        storeload.$k1[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$gp":
                        storeload.$gp[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$sp":
                        if (storeload.sp == 0) {
                            storeload.$sp[no / 4] = rg.reg[indexreg(Reg1)];
                        } else {
                            storeload.$sp[no / 4 + storeload.sz[storeload.sp - 1]] = rg.reg[indexreg(Reg1)];
                        }
                        break;
                    case "$fp":
                        storeload.$fp[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                    case "$ra":
                        storeload.$ra[no / 4] = rg.reg[indexreg(Reg1)];
                        break;
                }
                break;
            case ("beq"):
                m.GreenInstMem.setVisible(true);
                m.GreenRegisters.setVisible(true);
                m.GreenALU.setVisible(true);
                m.GreenAdd.setVisible(true);
                m.GreenShiftLeft.setVisible(true);
                m.GreenShiftLeft2.setVisible(false);
                m.GreenSignExtend.setVisible(true);
                m.GreenDataMem.setVisible(false);
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
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                if(ALUComp('=',indexreg(Regdst),indexreg(Reg1))){
                    for(int i =0 ; i<10 ; i++){
                        if(Reg2.equals(s[i])){
                            PC = P[i];
                            j = C[i]-1 ;
                            break;
                        }
                    }
                }
                break;
            case ("bne"):
                m.GreenInstMem.setVisible(true);
                m.GreenRegisters.setVisible(true);
                m.GreenALU.setVisible(true);
                m.GreenAdd.setVisible(true);
                m.GreenShiftLeft.setVisible(true);
                m.GreenShiftLeft2.setVisible(false);
                m.GreenSignExtend.setVisible(true);
                m.GreenDataMem.setVisible(false);
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
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                Reg2 = str.substring(str.indexOf(',') + 5);
                if(!ALUComp('=',indexreg(Regdst),indexreg(Reg1))){
                    for(int i =0 ; i<10 ; i++){
                        if(Reg2.equals(s[i])){
                            PC = P[i];
                            j = C[i]-1 ;
                            break;
                        }
                    }
                }
                break;
            case "slti":
                m.GreenInstMem.setVisible(true);
                m.GreenRegisters.setVisible(true);
                m.GreenALU.setVisible(true);
                m.GreenAdd.setVisible(false);
                m.GreenShiftLeft.setVisible(false);
                m.GreenShiftLeft2.setVisible(false);
                m.GreenSignExtend.setVisible(false);
                m.GreenDataMem.setVisible(false);
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
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                no = Integer.parseInt(str.substring(str.indexOf(',') + 5));
                if (ALUComp('i', indexreg(Reg1), no)) {
                    rg.reg[indexreg(Regdst)] = 1;
                } else {
                    rg.reg[indexreg(Regdst)] = 0;
                }
                break;
            case "sltui":
                m.GreenInstMem.setVisible(true);
                m.GreenRegisters.setVisible(true);
                m.GreenALU.setVisible(true);
                m.GreenAdd.setVisible(false);
                m.GreenShiftLeft.setVisible(false);
                m.GreenShiftLeft2.setVisible(false);
                m.GreenSignExtend.setVisible(false);
                m.GreenDataMem.setVisible(false);
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
                Reg1 = str.substring(str.indexOf(',') + 1, str.indexOf(',') + 4);
                no = Integer.parseInt(str.substring(str.indexOf(',') + 5));
                if (ALUComp('u', indexreg(Reg1), no)) {
                    rg.reg[indexreg(Regdst)] = 1;
                } else {
                    rg.reg[indexreg(Regdst)] = 0;
                }
                break;
        }

    }

    public void JFormat(String fun, String str) {
        String ADDrJUMP;
        switch (fun){
            case "j":
                m.GreenInstMem.setVisible(true);
                m.GreenRegisters.setVisible(false);
                m.GreenALU.setVisible(false);
                m.GreenAdd.setVisible(false);
                m.GreenShiftLeft.setVisible(false);
                m.GreenShiftLeft2.setVisible(true);
                m.GreenSignExtend.setVisible(false);
                m.GreenDataMem.setVisible(false);
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
                for(int i =0 ; i<10 ; i++){
                    if(ADDrJUMP.equals(s[i])){
                        PC = P[i];
                        j = C[i]-1 ;
                        break;
                    }
                }
                break;
            case "jal":
                m.GreenInstMem.setVisible(true);
                m.GreenRegisters.setVisible(false);
                m.GreenALU.setVisible(false);
                m.GreenAdd.setVisible(false);
                m.GreenShiftLeft.setVisible(false);
                m.GreenShiftLeft2.setVisible(true);
                m.GreenSignExtend.setVisible(false);
                m.GreenDataMem.setVisible(false);
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
                rg.reg[31] = PC + 4 ;
                storeload.ra = j;
                ADDrJUMP = str.substring(str.indexOf(' ') + 1);
                for(int i =0 ; i<10 ; i++){
                    if(ADDrJUMP.equals(s[i])){
                        PC = P[i];
                        j = C[i]-1 ;
                        break;
                    }
                }
                break ;
        }
    }

    public boolean ALUComp(char s, int reg1, int reg2) {
        boolean result;
        int res;
        String op ;
        if (s == '<') {
            result = (rg.reg[reg1] < rg.reg[reg2]) ? true : false;
            op = "<" ;
            if(result){
                res =1;
            }else{
                res= 0;
            }
            m.updatetable1(rg.reg[reg1],op,rg.reg[reg2],res);
            return result;
        } else if (s == 'i') {
            result = (rg.reg[reg1] < reg2) ? true : false;
            op = "<";
            if(result){
                res =1;
            }else{
                res= 0;
            }
            m.updatetable1(rg.reg[reg1],op,rg.reg[reg2],res);
            return result;
        } else if (s == '=') {
            int result2 = rg.reg[reg1] - rg.reg[reg2] ;
            op = "-" ;
            if(result2 == 0){
                result = true;
                res = 1;
            }else{
                result = false;
                res = 0;
            }
            m.updatetable1(rg.reg[reg1],op,rg.reg[reg2],res);
            return result;
        } else if (s == 'u') {
            result = (Math.abs(rg.reg[reg1]) < Math.abs(rg.reg[reg2])) ? true : false;
            op = "<" ;
            if(result){
                res =1;
            }else{
                res= 0;
            }
            m.updatetable1(rg.reg[reg1],op,rg.reg[reg2],res);
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
                op = "+" ;
                m.updatetable1(rg.reg[reg1],op,rg.reg[reg2],rg.reg[regdst]);
                break;
            case 'i':
                rg.reg[regdst] = rg.reg[reg1] + reg2;
                op = "+" ;
                m.updatetable1(rg.reg[reg1],op,reg2,rg.reg[regdst]);
                break;
            case '-':
                rg.reg[regdst] = rg.reg[reg1] - rg.reg[reg2];
                op = "-" ;
                m.updatetable1(rg.reg[reg1],op,rg.reg[reg2],rg.reg[regdst]);
                break;
            case '&':
                rg.reg[regdst] = rg.reg[reg1] & rg.reg[reg2];
                op = "and" ;
                m.updatetable1(rg.reg[reg1],op,rg.reg[reg2],rg.reg[regdst]);
                break;
            case '|':
                rg.reg[regdst] = rg.reg[reg1] | rg.reg[reg2];
                op = "or" ;
                m.updatetable1(rg.reg[reg1],op,rg.reg[reg2],rg.reg[regdst]);
                break;
            case 's':
                rg.reg[regdst] = (reg2 << rg.reg[reg1]);
                op = "shift left" ;
                m.updatetable1(rg.reg[reg1],op,reg2,rg.reg[regdst]);
                break;
            case '~' :
                rg.reg[regdst] = ~(rg.reg[reg1] | rg.reg[reg2]) ;
                op = "nor";
                m.updatetable1(rg.reg[reg1],op,rg.reg[reg2],rg.reg[regdst]);
                break;
        }
    }
    public String jump(int y) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("instructions.txt"));
        PC = P[y];
        m.PC.setText(""+PC);
        int x=0;
        while(x<y){
            r.readLine();
            x++;
        }
        return r.readLine();        
    }
    public void TakeAction(String str) {
        m.textArea1.setText(m.textArea1.getText() +"\n" + str);
        String FUNC;
        if(isargument(str)){
            if(!isexit(str)){
                FUNC = str.substring(str.indexOf(' ')+1,str.indexOf(' ',str.indexOf(' ')+1));
            }else{
                return;
            }
        }else{
            FUNC = str.substring(0,str.indexOf(' '));
        }
        if (FUNC.equals((String) ("add")) || FUNC.equals((String) ("sub")) || FUNC.equals((String) ("and")) || FUNC.equals((String) ("jr")) || FUNC.equals((String) ("nor")) || FUNC.equals((String) ("or")) || FUNC.equals((String) ("sll")) || FUNC.equals((String) ("slt")) || FUNC.equals((String) ("sltu"))) {
            RFormat(FUNC, str);
        } else if (FUNC.equals((String) ("lw")) || FUNC.equals((String) ("sw")) || FUNC.equals((String) ("addi")) || FUNC.equals((String) ("slti")) || FUNC.equals((String) ("sltui")) || FUNC.equals((String) ("beq")) || FUNC.equals((String) ("bne"))) {
            IFormat(FUNC, str);
        } else if (FUNC.equalsIgnoreCase("j") || FUNC.equals((String) ("jal"))) {
            JFormat(FUNC, str);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR!");
        }

    }
    public boolean isargument(String str){
        try{
            String argu = str.substring(0, str.indexOf(':'));
            return true;
        }
        catch(StringIndexOutOfBoundsException e){
            return false;
        }
        catch(NullPointerException e){
            return false;
        }
    } 
    public boolean isexit(String str){
        try{
            String argu = str.substring(str.indexOf(' ')+1,str.indexOf(' ',str.indexOf(' ')+1));
            return false;
        }
        catch(StringIndexOutOfBoundsException e){
            return true;
        }
        catch(NullPointerException e){
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
                JOptionPane.showMessageDialog(null, "Error reg " + str);
                return -1;
        }
    }
}
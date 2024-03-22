package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline, finish;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "5 * 5";
        questions[0][1] = "25";
        questions[0][2] = "30";
        questions[0][3] = "100";
        questions[0][4] = "150";

        questions[1][0] = "-38 + (218-26) / 24";
        questions[1][1] = "-30";
        questions[1][2] = "-21";
        questions[1][3] = "-24";
        questions[1][4] = "-23";

        questions[2][0] = "3 + 16 * 5";
        questions[2][1] = "93";
        questions[2][2] = "83";
        questions[2][3] = "85";
        questions[2][4] = "95";

        questions[3][0] = "2^3 + 15";
        questions[3][1] = "33";
        questions[3][2] = "25";
        questions[3][3] = "23";
        questions[3][4] = "21";

        questions[4][0] = "10 - (-12)";
        questions[4][1] = "21";
        questions[4][2] = "22";
        questions[4][3] = "-2";
        questions[4][4] = "-22";

        questions[5][0] = "8^2 - 60";
        questions[5][1] = "44";
        questions[5][2] = "4";
        questions[5][3] = "5";
        questions[5][4] = "20";

        questions[6][0] = "20 / 4 + 9 * 2";
        questions[6][1] = "80";
        questions[6][2] = "23";
        questions[6][3] = "90";
        questions[6][4] = "33";

        questions[7][0] = "3^3 / 3";
        questions[7][1] = "3";
        questions[7][2] = "9";
        questions[7][3] = "6";
        questions[7][4] = "18";

        questions[8][0] = "27 + 67";
        questions[8][1] = "94";
        questions[8][2] = "91";
        questions[8][3] = "95";
        questions[8][4] = "97";

        questions[9][0] = "-9 + (-19)";
        questions[9][1] = "-27";
        questions[9][2] = "28";
        questions[9][3] = "-28";
        questions[9][4] = "27";

        answers[0][1] = "25";
        answers[1][1] = "-30";
        answers[2][1] = "83";
        answers[3][1] = "23";
        answers[4][1] = "22";
        answers[5][1] = "4";
        answers[6][1] = "23";
        answers[7][1] = "9";
        answers[8][1] = "94";
        answers[9][1] = "-28";

        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 600, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
        repaint();
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);

        ans_given = 1;
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = ""; // Jawaban disimpan disini
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }

        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true); // Aktifkan tombol Submit ketika mencapai pertanyaan terakhir
        }

        count++;
        if (count < 10) {
            start(count);
        } else {
            // Jika mencapai pertanyaan terakhir, tampilkan tombol Submit
            submit.setEnabled(true);
        }
    } else if (ae.getSource() == submit) {
        ans_given = 1;
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }
        // Hitung skor ketika menekan tombol Submit
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }
        setVisible(false);
        new Score(name, score);
    }
}
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                //submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}

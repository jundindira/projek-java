package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    
    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 450);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. Hindari mencontek dari teman atau sumber lainnya. Kuis matematika adalah kesempatan untuk menguji pemahaman Anda sendiri." + "<br><br>" +
                "2. Bacalah soal dengan teliti dan tidak terburu-buru." + "<br><br>" +
                "3. Pastikan menggunakan rumus matematika yang tepat untuk menyelesaikan masalah dalam soal." + "<br><br>" +
                "4. Kerjakan soal secara berurutan, langkah demi langkah, untuk menghindari kesalahan perhitungan." + "<br><br>" +
                "5. Alokasikan waktu dengan bijak untuk mengerjakan semua soal." + "<br><br>" +
            "<html>"

        );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Rules("User");
    }
}

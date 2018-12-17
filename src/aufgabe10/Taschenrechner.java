package aufgabe10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Taschenrechner extends JFrame implements ActionListener {

    double x;
    double y;
    double result;

    public Taschenrechner() {
        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.lightGray);
        this.setVisible(true);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.blue);
        buttonPanel.setPreferredSize(new Dimension(360,90));

        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton mult = new JButton("*");
        JButton div = new JButton("/");
        JButton sin = new JButton("sin");
        JButton cos = new JButton("cos");
        JButton power = new JButton("x^y");
        JButton log2 = new JButton("log2");

        //Panel zusammenbauen
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(plus);
        buttonPanel.add(minus);
        buttonPanel.add(mult);
        buttonPanel.add(div);
        buttonPanel.add(sin);
        buttonPanel.add(cos);
        buttonPanel.add(power);
        buttonPanel.add(log2);


        this.setLayout(new FlowLayout());
        this.add(buttonPanel);

        this.pack();








        JLabel opXLabel = new JLabel("Operad1");
        JLabel opYLabel = new JLabel("Operand2");
        JLabel reLabel = new JLabel("Result");




        /*
        JTextField opXTextField = new JTextField();
        JTextField opYTextField = new JTextField();
        JTextField reTextfield = new JTextField();
        reTextfield.setEditable(false);


        this.add(opXLabel);
        this.add(opYLabel);
        this.add(reLabel);
        this.add(opXTextField);
        this.add(opYTextField);
        this.add(reTextfield);
        */

    }

    public static void main(String[] args) {
        new Taschenrechner();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}


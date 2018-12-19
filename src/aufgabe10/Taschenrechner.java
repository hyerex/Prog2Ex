package aufgabe10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Taschenrechner extends JFrame implements ActionListener, ItemListener {

    double x;
    double y;
    double result;

    JTextField opXTextField;
    JTextField opYTextField;
    JTextField reTextField;

    JCheckBox deg;
    JCheckBox rad;
    JCheckBox theme;
    public boolean display;

    public Taschenrechner() {
        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 400));
        this.setLocationRelativeTo(null);
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout());
        this.setVisible(true);


        //Operand X + Y + Resultat
        JPanel opPanel = new JPanel();
        opPanel.setBackground(Color.red);
        opPanel.setPreferredSize(new Dimension(360,90));
        JLabel opXLabel = new JLabel("Operand X");
        JLabel opYLabel = new JLabel("Operand Y");
        JLabel reLabel = new JLabel("Result");

        opXTextField = new JTextField("0",10);
        opYTextField = new JTextField("0",10);
        reTextField = new JTextField("0", 10);
        reTextField.setEditable(false);

        opPanel.setLayout(new GridLayout(3,2));

        opPanel.add(opXLabel);
        opPanel.add(opXTextField);
        opPanel.add(opYLabel);
        opPanel.add(opYTextField);
        opPanel.add(reLabel);
        opPanel.add(reTextField);

        this.add(opPanel);

        ///////////////////////////////////////////////////////////////////
        JPanel boxPanel = new JPanel();
        boxPanel.setBackground(Color.blue);
        boxPanel.setPreferredSize(new Dimension(400,50));
        boxPanel.setLayout(new FlowLayout());

        deg = new JCheckBox("Deg");
        deg.setSelected(true);
        deg.addActionListener(this);
        rad = new JCheckBox("Rad");
        rad.setSelected(false);
        rad.addActionListener(this);
        theme = new JCheckBox("Helles Display");
        theme.setSelected(true);
        theme.addItemListener(this);


        boxPanel.add(deg);
        boxPanel.add(rad);
        boxPanel.add(theme);

        pack();
        setVisible(true);

        this.add(boxPanel);




        //////////////////////////////////////////////////////////////////
        //ButtonPanel

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.blue);
        buttonPanel.setPreferredSize(new Dimension(360,90));

        JButton plus = new JButton("+");
        plus.addActionListener(this);
        JButton minus = new JButton("-");
        minus.addActionListener(this);
        JButton mult = new JButton("*");
        mult.addActionListener(this);
        JButton div = new JButton("/");
        div.addActionListener(this);
        JButton sin = new JButton("sin");
        sin.addActionListener(this);
        JButton cos = new JButton("cos");
        cos.addActionListener(this);
        JButton power = new JButton("x^y");
        power.addActionListener(this);
        JButton log2 = new JButton("log2");
        log2.addActionListener(this);

        //ButtonPanel zusammenbauen
        buttonPanel.setLayout(new GridLayout(2,4));
        buttonPanel.add(plus);
        buttonPanel.add(minus);
        buttonPanel.add(mult);
        buttonPanel.add(div);
        buttonPanel.add(sin);
        buttonPanel.add(cos);
        buttonPanel.add(power);
        buttonPanel.add(log2);

        this.add(buttonPanel);

        this.pack();

        /////////////////////////////////////////////////////////////
        //Clear Button
        JButton clear = new JButton("clear");
        clear.addActionListener(this);
        this.add(clear);
        this.pack();


    }

    public static void main(String[] args) {
        new Taschenrechner();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String sX = opXTextField.getText();
        String sY = opYTextField.getText();
        try {
            x = Double.parseDouble(sX);
            y = Double.parseDouble(sY);
        } catch(NumberFormatException f){
            System.out.println("ERROR");
            reTextField.setText("");
            return;
        }
        String str = e.getActionCommand();
        switch(str){
            case "+":
                result = x + y;
                reTextField.setText("" + result);
                System.out.println(result);
                break;
            case "-":
                result = x - y;
                reTextField.setText("" + result);
                System.out.println(result);
                break;
            case "*":
                result = x * y;
                reTextField.setText("" + result);
                System.out.println(result);
                break;
            case "/":
                result = x / y;
                reTextField.setText("" + result);
                System.out.println(result);
                break;
            case "sin":
                opYTextField.setText("0");
                if(deg.isSelected() == true) {
                    result = Math.sin(Math.toRadians(x));
                } else if (rad.isSelected() == true) {
                    result = Math.sin(x);
                }
                reTextField.setText("" + result);
                break;
            case "cos":
                opYTextField.setText("0");
                if (deg.isSelected() == true) {
                    result = Math.cos(Math.toRadians(x));
                } else if (rad.isSelected() == true) {
                    result = Math.cos(x);
                }
                reTextField.setText("" + result);
                break;
            case "x^y":
                result = Math.pow(x, y);
                reTextField.setText("" + result);
                System.out.println(result);
                break;
            case "log2":
                result = Math.log(x);
                reTextField.setText("" + result);
                System.out.println(result);
                break;
            case "clear":
                opXTextField.setText("0");
                opYTextField.setText("0");
                reTextField.setText("0");
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        Object source  = ie.getItemSelectable();
        if(source == theme) {
            display = true;
        }
        if (ie.getStateChange() == ItemEvent.DESELECTED){
            display = false;
        }
        updateDisplay();
    }

    private void updateDisplay() {
        if(display == false){
            opXTextField.setBackground(Color.BLACK);
            opYTextField.setBackground(Color.BLACK);
            reTextField.setBackground(Color.BLACK);
            opXTextField.setForeground(Color.YELLOW);
            opYTextField.setForeground(Color.YELLOW);
            reTextField.setForeground(Color.YELLOW);
        }
        else{
            opXTextField.setBackground(Color.WHITE);
            opYTextField.setBackground(Color.WHITE);
            reTextField.setBackground(Color.WHITE);
            opXTextField.setForeground(Color.BLACK);
            opYTextField.setForeground(Color.BLACK);
            reTextField.setForeground(Color.BLACK);
        }
    }
}


package com.calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Calculator extends JFrame implements ActionListener {
    JPanel panel = new JPanel(new GridLayout(3, 1));
    JPanel numpad = new JPanel(new GridLayout(2, 5));
    JPanel operators = new JPanel(new GridLayout(1, 6));

    JButton calculate_button = new JButton("=");
    JButton plus_button = new JButton("+");
    JButton minus_button = new JButton("-");
    JButton mult_button = new JButton("*");
    JButton div_button = new JButton("/");
    JButton delete_button = new JButton("DEL");

    JButton zero_button = new JButton("0");
    JButton one_button = new JButton("1");
    JButton two_button = new JButton("2");
    JButton three_button = new JButton("3");
    JButton four_button = new JButton("4");
    JButton five_button = new JButton("5");
    JButton six_button = new JButton("6");
    JButton seven_button = new JButton("7");
    JButton eight_button = new JButton("8");
    JButton nine_button = new JButton("9");

    JTextField calculation = new JTextField();

    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

    private Calculator() {
        super("Calculator");
        setBounds(200, 200, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(panel);

        calculation.setFont(new Font("Ubuntu", Font.BOLD, 50));
        calculation.setEnabled(false);
        panel.add(calculation);

        panel.add(numpad);
        panel.add(operators);

        zero_button.addActionListener(this);
        numpad.add(zero_button);

        one_button.addActionListener(this);
        numpad.add(one_button);

        two_button.addActionListener(this);
        numpad.add(two_button);

        three_button.addActionListener(this);
        numpad.add(three_button);

        four_button.addActionListener(this);
        numpad.add(four_button);

        five_button.addActionListener(this);
        numpad.add(five_button);

        six_button.addActionListener(this);
        numpad.add(six_button);

        seven_button.addActionListener(this);
        numpad.add(seven_button);

        eight_button.addActionListener(this);
        numpad.add(eight_button);

        nine_button.addActionListener(this);
        numpad.add(nine_button);

        calculate_button.addActionListener(this);
        operators.add(calculate_button);

        plus_button.addActionListener(this);
        operators.add(plus_button);

        minus_button.addActionListener(this);
        operators.add(minus_button);

        mult_button.addActionListener(this);
        operators.add(mult_button);

        div_button.addActionListener(this);
        operators.add(div_button);

        delete_button.addActionListener(this);
        operators.add(delete_button);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent event) {
        Object source = event.getSource();
        if (source == zero_button) {
            if (!calculation.getText().equals("")) {
                calculation.setText(calculation.getText().concat("0"));
            }
        } else if (source == one_button) {
            calculation.setText(calculation.getText().concat("1"));
        } else if (source == two_button) {
            calculation.setText(calculation.getText().concat("2"));
        } else if (source == three_button) {
            calculation.setText(calculation.getText().concat("3"));
        } else if (source == four_button) {
            calculation.setText(calculation.getText().concat("4"));
        } else if (source == five_button) {
            calculation.setText(calculation.getText().concat("5"));
        } else if (source == six_button) {
            calculation.setText(calculation.getText().concat("6"));
        } else if (source == seven_button) {
            calculation.setText(calculation.getText().concat("7"));
        } else if (source == eight_button) {
            calculation.setText(calculation.getText().concat("8"));
        } else if (source == nine_button) {
            calculation.setText(calculation.getText().concat("9"));
        } else if (source == plus_button) {
            if (!calculation.getText().equals("") && !"+-/*".contains(calculation.getText().substring(calculation.getText().length() - 1))) {
                calculation.setText(calculation.getText().concat("+"));
            }
        } else if (source == minus_button) {
            calculation.setText(calculation.getText().concat("-"));
        } else if (source == mult_button) {
            if (!calculation.getText().equals("") && !"+-/*".contains(calculation.getText().substring(calculation.getText().length() - 1))) {
                calculation.setText(calculation.getText().concat("*"));
            }
        } else if (source == div_button) {
            if (!calculation.getText().equals("") && !"+-/*".contains(calculation.getText().substring(calculation.getText().length() - 1))) {
                calculation.setText(calculation.getText().concat("/"));
            }
        } else if (source == delete_button) {
            if (calculation.getText().length() > 0) {
                calculation.setText(calculation.getText().substring(0, calculation.getText().length() - 1));
            }
        } else if (source == calculate_button) {
            try {
                if (engine.eval(calculation.getText()) != null) {
                    calculation.setText(engine.eval(calculation.getText()).toString());
                }
            } catch (ScriptException e) {}
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

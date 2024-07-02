import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main extends JFrame {

    private JTextField aField;
    private JTextField bField;
    private JTextField cField;
    private JTextField minField;
    private JTextField maxField;

    public Main() {
        super("Find Minimum and Maximum");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(7, 2));

        JLabel aLabel = new JLabel("A:");
        aField = new JTextField();
        JLabel bLabel = new JLabel("B:");
        bField = new JTextField();
        JLabel cLabel = new JLabel("C:");
        cField = new JTextField();
        JLabel minLabel = new JLabel("Min:");
        minField = new JTextField();
        minField.setEditable(false);
        JLabel maxLabel = new JLabel("Max:");
        maxField = new JTextField();
        maxField.setEditable(false);

        JButton findButton = new JButton("Find");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(aField.getText());
                    int b = Integer.parseInt(bField.getText());
                    int c = Integer.parseInt(cField.getText());

                    int min = Math.min(Math.min(a, b), c);
                    int max = Math.max(Math.max(a, b), c);

                    minField.setText(String.valueOf(min));
                    maxField.setText(String.valueOf(max));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Main.this, "Invalid input. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(aLabel);
        add(aField);
        add(bLabel);
        add(bField);
        add(cLabel);
        add(cField);
        add(minLabel);
        add(minField);
        add(maxLabel);
        add(maxField);
        add(findButton);
        add(closeButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
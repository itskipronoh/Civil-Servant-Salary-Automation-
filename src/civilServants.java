import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CivilServantSalaryCalculator {
    private JFrame frame;
    private JTextField nameField, jobTitleField, yearsOfServiceField;
    private JTextArea resultTextArea;

    public CivilServantSalaryCalculator() {
        frame = new JFrame("Civil Servant Salary Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameField = new JTextField(20);
        jobTitleField = new JTextField(20);
        yearsOfServiceField = new JTextField(5);
        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);

        JButton calculateButton = new JButton("Calculate Salary");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateSalary();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Job Title:"));
        inputPanel.add(jobTitleField);
        inputPanel.add(new JLabel("Years of Service:"));
        inputPanel.add(yearsOfServiceField);
        inputPanel.add(calculateButton);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private void calculateSalary() {
        String name = nameField.getText();
        String jobTitle = jobTitleField.getText();
        int yearsOfService = Integer.parseInt(yearsOfServiceField.getText());

        // Calculate salary
        double salary = calculateCivilServantSalary(yearsOfService);

        // Display the result in the text area
        String result = "Name: " + name + "\nJob Title: " + jobTitle + "\nYears of Service: " + yearsOfService + "\nSalary: $" + salary;
        resultTextArea.setText(result);
    }

    private double calculateCivilServantSalary(int yearsOfService) {
        double baseSalary = 50000;
        double annualIncrement = 2000;
        return baseSalary + (yearsOfService * annualIncrement);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CivilServantSalaryCalculator();
            }
        });
    }
}

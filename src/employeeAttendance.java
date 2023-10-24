import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class Employee {
    private String empId;
    private String name;
    private int totalWorkHours;
    private int leavesTaken;

    public Employee(String empId, String name) {
        this.empId = empId;
        this.name = name;
        this.totalWorkHours = 0;
        this.leavesTaken = 0;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int getTotalWorkHours() {
        return totalWorkHours;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public void clockIn() {
        System.out.println(name + " clocked in.");
    }

    public void clockOut(int workHours) {
        totalWorkHours += workHours;
        System.out.println(name + " clocked out after working " + workHours + " hours.");
    }

    public void requestLeave(int days) {
        if (days > 0) {
            leavesTaken += days;
            System.out.println(name + " has taken " + days + " days leave.");
        } else {
            System.out.println("Invalid leave request.");
        }
    }
}



class EmployeeAttendanceSystem {
    private static void displayAttendanceDetails(Map<String, Employee> employees) {
        JFrame frame = new JFrame("Employee Attendance System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> employeeList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(employeeList);
        frame.add(scrollPane, BorderLayout.CENTER);

        for (Employee emp : employees.values()) {
            listModel.addElement("Employee ID: " + emp.getEmpId());
            listModel.addElement("Employee Name: " + emp.getName());
            listModel.addElement("Total Work Hours: " + emp.getTotalWorkHours());
            listModel.addElement("Leaves Taken: " + emp.getLeavesTaken());
            listModel.addElement("");
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Map<String, Employee> employees = new HashMap<>();

        Employee emp1 = new Employee("E001", "John Doe");
        Employee emp2 = new Employee("E002", "Jane Smith");

        employees.put(emp1.getEmpId(), emp1);
        employees.put(emp2.getEmpId(), emp2);

        // Employee 1 actions
        Employee employee1 = employees.get("E001");
        employee1.clockIn();
        employee1.clockOut(8);
        employee1.requestLeave(2);

        // Employee 2 actions
        Employee employee2 = employees.get("E002");
        employee2.clockIn();
        employee2.clockOut(7);
        employee2.requestLeave(1);

        // Display employee attendance and leave details
        for (Employee emp : employees.values()) {
            System.out.println("Employee ID: " + emp.getEmpId());
            System.out.println("Employee Name: " + emp.getName());
            System.out.println("Total Work Hours: " + emp.getTotalWorkHours());
            System.out.println("Leaves Taken: " + emp.getLeavesTaken());
            displayAttendanceDetails(employees);
            System.out.println();

        }
    }
}

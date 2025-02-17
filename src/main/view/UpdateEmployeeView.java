package main.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import main.MotorPH;
import main.classes.Employee;

public class UpdateEmployeeView {
    // Constant Variables
    private static final String EMPLOYEE_DETAILS_CSV = System.getProperty("user.dir") + "/src/main/resources/employee_details.csv";
    
    // Variables needed for the Add Employee View
    private BufferedReader employeeDetailsReader = null;
    private JLabel lblHeader, lblFirstName, lblLastName, lblBirthday, lblSSS, lblPhilHealth, lblTIN, lblPagibig, lblPosition, lblBasicSalary, lblHourlyRate;
    private JTextField txtFirstName, txtLastName, txtBirthday, txtSSS, txtPhilHealth, txtTIN, txtPagibig, txtPosition, txtBasicSalary, txtHourlyRate;
    private JButton saveButton;
    
	public UpdateEmployeeView (Employee employee, int tableRow) {
		
		// Set Frame
		JFrame frame = new JFrame();
        frame.setSize(350, 430);
        frame.setTitle("MotorPH Employee App");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        // Set Panel 1
        // Create labels and textfields
        lblHeader = new JLabel("Update Employee Details");
        lblHeader.setFont(new Font("Calibri", Font.BOLD, 20));

        lblFirstName = new JLabel("First Name:");
        txtFirstName = new JTextField(20);
        txtFirstName.setText(employee.getFirstName());
        
        lblLastName = new JLabel("Last Name:");
        txtLastName = new JTextField(20);
        txtLastName.setText(employee.getLastName());

        lblBirthday = new JLabel("Birthday:");
        txtBirthday = new JTextField(20);
        txtBirthday.setText(employee.getBirthday());

        lblSSS = new JLabel("SSS No:");
        txtSSS = new JTextField(20);
        txtSSS.setText(employee.getSSS());

        lblPhilHealth = new JLabel("PhilHealth No:");
        txtPhilHealth = new JTextField(20);
        txtPhilHealth.setText(employee.getPhilHealth());

        lblTIN = new JLabel("TIN:");
        txtTIN = new JTextField(20);
        txtTIN.setText(employee.getTIN());

        lblPagibig = new JLabel("Pagibig No:");
        txtPagibig = new JTextField(20);
        txtPagibig.setText(employee.getPagibig());

        lblPosition = new JLabel("Position:");
        txtPosition = new JTextField(20);
        txtPosition.setText(employee.getPosition());

        lblBasicSalary = new JLabel("Basic Salary:");
        txtBasicSalary = new JTextField(20);
        txtBasicSalary.setText(String.valueOf(employee.getBasicSalary()));

        lblHourlyRate = new JLabel("Hourly Rate:");
        txtHourlyRate = new JTextField(20);
        txtHourlyRate.setText(String.valueOf(employee.getHourlyRate()));
        
        saveButton = new JButton("Save");
        
        // Define the panel to hold the components  
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
       
        // Add the components to the frame
        panel.add(lblHeader);
        panel.add(lblFirstName);
        panel.add(txtFirstName);
        panel.add(lblLastName);
        panel.add(txtLastName);
        panel.add(lblBirthday);
        panel.add(txtBirthday);
        panel.add(lblSSS);
        panel.add(txtSSS);
        panel.add(lblPhilHealth);
        panel.add(txtPhilHealth);
        panel.add(lblTIN);
        panel.add(txtTIN);
        panel.add(lblPagibig);
        panel.add(txtPagibig);
        panel.add(lblPosition);
        panel.add(txtPosition);
        panel.add(lblBasicSalary);
        panel.add(txtBasicSalary);
        panel.add(lblHourlyRate);
        panel.add(txtHourlyRate);

        panel.add(saveButton);
        
        // Put constraint on components       
        // Employee Details Section
        // Set label and textfield position: top and bottom
        layout.putConstraint(SpringLayout.NORTH, lblHeader, 20, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblHeader, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        
        layout.putConstraint(SpringLayout.NORTH, lblFirstName, 20, SpringLayout.SOUTH, lblHeader);
        layout.putConstraint(SpringLayout.WEST, lblFirstName, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtFirstName, 20, SpringLayout.SOUTH, lblHeader);
        layout.putConstraint(SpringLayout.EAST, txtFirstName, -20, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblLastName, 10, SpringLayout.SOUTH, lblFirstName);
        layout.putConstraint(SpringLayout.WEST, lblLastName, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtLastName, 6, SpringLayout.SOUTH, txtFirstName);
        layout.putConstraint(SpringLayout.EAST, txtLastName, -20, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblBirthday, 10, SpringLayout.SOUTH, lblLastName);
        layout.putConstraint(SpringLayout.WEST, lblBirthday, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtBirthday, 6, SpringLayout.SOUTH, txtLastName);
        layout.putConstraint(SpringLayout.EAST, txtBirthday, -20, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblPosition, 10, SpringLayout.SOUTH, lblBirthday);
        layout.putConstraint(SpringLayout.WEST, lblPosition, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtPosition, 6, SpringLayout.SOUTH, txtBirthday);
        layout.putConstraint(SpringLayout.EAST, txtPosition, -20, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblSSS, 10, SpringLayout.SOUTH, lblPosition);
        layout.putConstraint(SpringLayout.WEST, lblSSS, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtSSS, 6, SpringLayout.SOUTH, txtPosition);
        layout.putConstraint(SpringLayout.EAST, txtSSS, -20, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblPhilHealth, 10, SpringLayout.SOUTH, lblSSS);
        layout.putConstraint(SpringLayout.WEST, lblPhilHealth, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtPhilHealth, 6, SpringLayout.SOUTH, txtSSS);
        layout.putConstraint(SpringLayout.EAST, txtPhilHealth, -20, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblTIN, 10, SpringLayout.SOUTH, lblPhilHealth);
        layout.putConstraint(SpringLayout.WEST, lblTIN, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtTIN, 6, SpringLayout.SOUTH, txtPhilHealth);
        layout.putConstraint(SpringLayout.EAST, txtTIN, -20, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblPagibig, 10, SpringLayout.SOUTH, lblTIN);
        layout.putConstraint(SpringLayout.WEST, lblPagibig, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtPagibig, 6, SpringLayout.SOUTH, txtTIN);
        layout.putConstraint(SpringLayout.EAST, txtPagibig, -20, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblBasicSalary, 10, SpringLayout.SOUTH, lblPagibig);
        layout.putConstraint(SpringLayout.WEST, lblBasicSalary, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtBasicSalary, 6, SpringLayout.SOUTH, txtPagibig);
        layout.putConstraint(SpringLayout.EAST, txtBasicSalary, -20, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblHourlyRate, 10, SpringLayout.SOUTH, lblBasicSalary);
        layout.putConstraint(SpringLayout.WEST, lblHourlyRate, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtHourlyRate, 6, SpringLayout.SOUTH, txtBasicSalary);
        layout.putConstraint(SpringLayout.EAST, txtHourlyRate, -20, SpringLayout.EAST, panel);
        
        // Set button position
        layout.putConstraint(SpringLayout.NORTH, saveButton, 30, SpringLayout.SOUTH, lblHourlyRate);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, saveButton, 0, SpringLayout.HORIZONTAL_CENTER, panel);


        //Add panel to frame
        frame.add(panel);
        frame.setVisible(true);

        // Add an ActionListener to the button
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    			
    			try {
            		resetData();
            		readCSVFiles();
                    List<String> employeesList = getEmployeesList();
                    
	        		String firstName = txtFirstName.getText();
	        		String lastName = txtLastName.getText();
	        		String birthday = txtBirthday.getText();
	        		String sss = txtSSS.getText();
	        		String philHealth = txtPhilHealth.getText();
	        		String tin = txtTIN.getText();
	        		String pagibig = txtPagibig.getText();
	        		String position = txtPosition.getText();
	        		double basicSalary = Double.parseDouble(txtBasicSalary.getText());
	    			double hourlyRate = Double.parseDouble(txtHourlyRate.getText());

		            StringBuilder stringBuilder = new StringBuilder();
		            stringBuilder.append(employee.getEmployeeNumber());
		            stringBuilder.append(',');
		            stringBuilder.append(lastName);
		            stringBuilder.append(',');
		            stringBuilder.append(firstName);
		            stringBuilder.append(',');
		            stringBuilder.append(birthday);
		            stringBuilder.append(',');
		            stringBuilder.append(',');
		            stringBuilder.append(',');
		            stringBuilder.append(sss);
		            stringBuilder.append(',');
		            stringBuilder.append(philHealth);
		            stringBuilder.append(',');
		            stringBuilder.append(tin);
		            stringBuilder.append(',');
		            stringBuilder.append(pagibig);
		            stringBuilder.append(',');
		            stringBuilder.append(',');
		            stringBuilder.append(position);
		            stringBuilder.append(',');
		            stringBuilder.append(',');
		            stringBuilder.append(basicSalary);
		            stringBuilder.append(',');
		            stringBuilder.append(',');
		            stringBuilder.append(',');
		            stringBuilder.append(',');
		            stringBuilder.append(',');
		            stringBuilder.append(hourlyRate);

		            employeesList.set(tableRow, stringBuilder.toString());
		            
	                // Write the updated List back to CSV file
	                writeCSV(employeesList);
            		JOptionPane.showMessageDialog(null, "Record successfully updated.", "Success!", JOptionPane.PLAIN_MESSAGE);
            		
            		new EmployeeListView();
            		frame.dispose();
            		
    		    } catch (Exception e1) {
                    Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e1);
            		JOptionPane.showMessageDialog(null, "Invalid Input.", "ERROR!", JOptionPane.ERROR_MESSAGE);
    		    }
            }
        });
	}
	
    // Method used for reseting data used in the system
    private void resetData () {
        employeeDetailsReader = null;
    }

    // Method used for reading CSV files
    private void readCSVFiles() {
        try {
            employeeDetailsReader = new BufferedReader(new FileReader(EMPLOYEE_DETAILS_CSV));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<String> getEmployeesList() throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        try {
            while ((line = employeeDetailsReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    }

    private static void writeCSV(List<String> employeesList) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(EMPLOYEE_DETAILS_CSV))) {
            for (String line : employeesList) {
                bw.write(line);
                bw.newLine();
            }
        }
    }
}

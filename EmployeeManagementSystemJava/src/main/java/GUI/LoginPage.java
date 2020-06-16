package GUI;

import Database.DBRequests;
import Employee.HR;
import Employee.NonHR;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

public class LoginPage {

    private static JPanel login;
    private JTextField username, password;
    private JButton sendLogin;
    private JLabel data;

    public static JPanel getLogin() {
        return login;
    }

    public LoginPage() {

        login = new JPanel();
        login.setLayout(null);

        username = new JTextField("Username", 15);
        password = new JTextField("Password", 15);
        sendLogin = new JButton("Login");
        data = new JLabel();

        sendLogin.addActionListener(listener -> {
            String userName = "";
            String password = "";
            int id;
            try {
                userName = username.getText();
                password = this.password.getText();
                id = Integer.parseInt(userName);
                String accountType = DBRequests.isEmployee(id);
                try {
                    if (accountType.equals("1") && password.equals(DBRequests.getPassword(id))) {
                        SystemInfo.setUser(new HR(id, DBRequests.getFirstName(id), DBRequests.getLastName(id), DBRequests.getGender(id)));
                        data.setText("Successful Login to HR");
                    } else if (accountType.equals("0") && password.equals(DBRequests.getPassword(id))) {
                        SystemInfo.setUser(new NonHR(id, DBRequests.getFirstName(id), DBRequests.getLastName(id), DBRequests.getGender(id)));
                        data.setText("Successful Login to NonHR");
                    } else if (accountType.equalsIgnoreCase("User does not exist")) {
                        data.setText(accountType);
                    } else {
                        data.setText("Incorrect password");
                    }
                } catch (ClassNotFoundException ex) {
                    data.setText("This account does not exist");
                }
            } catch (Exception e) {
                data.setText("A valid ID does not include letters");
            }

        });

        username.setBounds(315, 120, 171, 30);
        login.add(username);
        password.setBounds(315, 150, 171, 30);
        login.add(password);
        sendLogin.setBounds(355, 200, 91, 27);
        login.add(sendLogin);
        data.setBounds(200, 250, 401, 27);
        login.add(data);
    }

}

package org.main.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    
    private String url = "jdbc:mysql://localhost:3306/e_commerce_db_3";
    private String password = "S@ngl!#10@";
    private String username = "root";
    
    @GetMapping("/username")
    public String userName() {
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select username from users where id=4")) {

            if (rs.next()) {
                return "userName: " + rs.getString("username");
            } else {
                return "Username you are looking for not found!";
            }

        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}


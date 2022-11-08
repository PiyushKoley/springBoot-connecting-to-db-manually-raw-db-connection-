package com.example.dbqueries.dbapplication;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class DBManager {


    public static Connection connection;

    public DBManager() throws SQLException {
        getConnection();
        createTable();
    }

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDB", "root", "root");
        }

        return connection;

    }

    public static void createTable() throws SQLException {
        String sql = "create table if not exists student_info (id INT primary key auto_increment, name VARCHAR(30), age INT);";

        Statement st = connection.createStatement();

        st.execute(sql);

    }

    public static void insertInfo(Student student) throws SQLException {

        String sql = "insert into student_info (name,age) values ('" + student.getName() + "',"+ student.getAge()+");";

        Statement st = connection.createStatement();

        int row = st.executeUpdate(sql);

        System.out.println(row +" rows affected.");
    }

    public static List<String> getInfo() throws SQLException {
        String sql = "select * from student_info;";

        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(sql);

        List <String> listOfStudents = new ArrayList<>();

        while(resultSet.next()) {
            String s = resultSet.getString(2);
            listOfStudents.add(s);
        }

        return listOfStudents;
    }
}

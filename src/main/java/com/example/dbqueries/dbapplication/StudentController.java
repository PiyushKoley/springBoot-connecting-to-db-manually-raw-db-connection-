package com.example.dbqueries.dbapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    DBManager dbManager;

    @GetMapping("/get-all-students")
    List<String> getAllStudents() throws SQLException {

        return dbManager.getInfo();
    }

    @PostMapping("/create-student")
    public void createStudent(@RequestBody() Student student) throws SQLException {

        dbManager.insertInfo(student);
    }

}

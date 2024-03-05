package com.example;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class StudentsController extends MainController {
    @FXML
    AnchorPane studentsParentPane;
    @FXML
    Button addStudentButton;
    @FXML
    Button expelStudentButton;
    @FXML
    Button viewStudentsButton;
    @FXML
    VBox buttonsBox;
    @FXML
    Label nameLabel;
    @FXML
    TextArea viewArea;

    public void displayStudents() throws ClassNotFoundException {
        String selectAll = "select * from students";

        try (ResultSet result = executeQuery(selectAll)) {
            while (result.next()) {
                String idnpStudent = result.getString("idnp_student");
                String numeStudent = result.getString("nume_student");
                String prenumeStudent = result.getString("prenume_student");
                String grupaStudent = result.getString("grupa");
                String specialitate = result.getString("specialitate");

                viewArea.setText(idnpStudent);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonsBox.prefWidthProperty().bind(studentsParentPane.widthProperty().multiply(0.18));
        addStudentButton.prefWidthProperty().bind(studentsParentPane.widthProperty().multiply(0.18));
        expelStudentButton.prefWidthProperty().bind(studentsParentPane.widthProperty().multiply(0.18));
        viewStudentsButton.prefWidthProperty().bind(studentsParentPane.widthProperty().multiply(0.18));
        nameLabel.prefWidthProperty().bind(studentsParentPane.widthProperty());
    }
}
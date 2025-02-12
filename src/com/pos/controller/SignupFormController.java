package com.pos.controller;

import com.pos.db.DatabaseAccessCode;
import com.pos.entity.SystemUser;
import com.pos.util.PasswordGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

public class SignupFormController {
    public AnchorPane context;
    public TextField txtFullname;
    public TextField txtEmail;
    public PasswordField txtPassword;
    public TextField txtNumber;


    public void openLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(
                new Scene(
                        FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
                )
        );
    }

    public void registerOnAction(ActionEvent actionEvent) {
        try{
            SystemUser user = new SystemUser(
                    UUID.randomUUID().toString(),
                    txtFullname.getText(),
                    txtEmail.getText(),
                    txtNumber.getText(),
                    PasswordGenerator.encrypt(txtPassword.getText())
            );
            if(DatabaseAccessCode.createUser(user)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"User saved successfully");
                setUi("LoginForm");
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Something went wrong");
            }
        } catch (ClassNotFoundException | RuntimeException | SQLException | IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
            e.printStackTrace();
        }

    }
}

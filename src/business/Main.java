package business;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.Client;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @FXML
    private Button btn;
    @FXML
    private Button btn2;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    Client s;
    @Override
    public void start(Stage primaryStage) throws Exception{
      Parent root = FXMLLoader.load(getClass().getResource("/presentation/loginView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }
    @FXML
    public void login()
    {
        try{
            Stage user=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root=(Pane)loader.load(getClass().getResource("/presentation/bazadedate.fxml").openStream());
            Scene scene=new Scene(root);
            user.setScene(scene);
            user.setTitle("baza");
            user.setResizable(false);
            user.show();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void login2()
    {
        try{
            Stage user=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root=(Pane)loader.load(getClass().getResource("/presentation/bazadedate2.fxml").openStream());
            Scene scene=new Scene(root);
            user.setScene(scene);
            user.setTitle("baza");
            user.setResizable(false);
            user.show();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }


    @FXML
    public void Username1(ActionEvent event) throws SQLException {
        try{
            if(this.user.getText().equals("admin") && this.pass.getText().equals("admin")){
                Stage stage = (Stage) this.btn.getScene().getWindow();
                stage.close();
                login();
            } else
            if(this.user.getText().equals("elev") && this.pass.getText().equals("parola")) {
                Stage stage = (Stage) this.btn.getScene().getWindow();
                stage.close();
                login2();
            }
            else{

            }
        }catch(Exception e){System.out.println(e);}

    }


}
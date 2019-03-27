package dataAccess;

//package model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Profile;
//import business.Legare;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import business.Legare;
import model.Student;

public class ProcesareProfile implements Initializable {
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet resultSet;
    @FXML
    private Label label;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student,Integer> columnId;
    @FXML
    private TableColumn<Student,String> columnName;
    @FXML
    private TableColumn<Student,String> columnPNC;
    @FXML
    private TableColumn<Student,String> columnAddress;
    @FXML
    private Button btn2;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField pnc;
    @FXML
    private TextField address;
    @FXML
    private TextField username;
    @FXML
    private TextField parola;
    //@FXML private TableView<Student>
    private Legare dc;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        dc = new Legare();
    }
    @FXML
    public void addProfileQuery(ActionEvent event) throws SQLException{
        try{
            Connection con=Legare.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into student(id,name,pnc,address) values(?,?,?,?)");
            ps.setString(1,this.id.getText());
            ps.setString(2,this.name.getText());
            ps.setString(3,this.pnc.getText());
            ps.setString(4,this.address.getText());
            ps.execute();
            con.close();
        }catch(Exception e){System.out.println(e);}
    }
    @FXML
    public void deleteProfileQuery(ActionEvent event) throws SQLException{
        try{
            Connection con=Legare.getConnection();
            PreparedStatement ps=con.prepareStatement("DELETE FROM student WHERE id = ?");
            ps.setString(1,this.id.getText());
            ps.execute();
            con.close();
        }catch(Exception e){System.out.println(e);}

    }
    @FXML
    public void updateProfileQuery(ActionEvent event) throws SQLException{
        try{
            Connection con=Legare.getConnection();
            PreparedStatement ps=con.prepareStatement("update student set name=?,pnc=?,address=? where id=?");
            ps.setString(4,this.id.getText());
            ps.setString(1,this.name.getText());
            ps.setString(2, this.pnc.getText());
            ps.setString(3,this.address.getText());
            ps.execute();
            con.close();
        }catch(Exception e){System.out.println(e);}
    }


   public void loadScene(){
       try{
           Stage user2=new Stage();
           FXMLLoader loader2=new FXMLLoader();
           Pane root2=(Pane)loader2.load(getClass().getResource("/presentation/TableView.fxml").openStream());
           Scene scene=new Scene(root2);
            user2.setScene(scene);
           user2.setTitle("baza");
           user2.setResizable(false);
           user2.show();
       }
       catch (IOException ex){
           ex.printStackTrace();
       }
   }
    @FXML
    public void load(ActionEvent event){
        try {
            Stage stage = (Stage) this.btn2.getScene().getWindow();
            stage.close();
            loadScene();
        }
        catch (Exception ex){
        ex.printStackTrace();
        }
    }

}

package dataAccess;

import business.Legare;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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
    Legare dc=new Legare();
    @Override
    public void initialize(URL url, ResourceBundle rb){
        dc = new Legare();
    }
    private ObservableList<Student> data;
    @FXML

    private void loadData(){

        try {
            Connection con=dc.createConnection();
            this.data= FXCollections.observableArrayList();
            ResultSet resultSet=con.createStatement().executeQuery("select * from student");
            while(resultSet.next()){
                this.data.add(new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
            }

        } catch (SQLException e) {
            //e.printStackTrace();
            System.err.println("Err"+e);
        }
        columnId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        columnPNC.setCellValueFactory(new PropertyValueFactory<Student,String>("pnc"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
        tableView.setItems(null);
        tableView.setItems(this.data);

    }
}

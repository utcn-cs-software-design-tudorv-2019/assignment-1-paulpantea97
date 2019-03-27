package model;

import javafx.beans.property.*;

import java.util.Scanner;

public class Student {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty  pnc;
    private StringProperty  address;

   /* public Student() {
        this.id.set(0);
        this.name=null;
        this.pnc=null;
        this.address=null;
    }*/
    public Student( int id,String name,String pnc,String address) {
        this.id=new SimpleIntegerProperty(id);
        this.name=new SimpleStringProperty(name);
        this.pnc=new SimpleStringProperty(pnc);
        this.address=new SimpleStringProperty(address);
    }
    public IntegerProperty getId(){
        return id;
    }
    public void setId(SimpleIntegerProperty id){
        this.id=id;
    }
    public StringProperty getName(){
        return name;
    }
    public void setName(SimpleStringProperty name){
        this.name=name;
    }
    public StringProperty getPnc(){
        return pnc;
    }
    public void setPnc(SimpleStringProperty pnc){
        this.pnc=pnc;
    }
    public StringProperty getAddress(){
        return address;
    }
    public void setAddress(SimpleStringProperty address){
        this.address=address;
    }


    @Override
    public String toString() {
        return "Student ("+ id.get() +","+ name+","+ pnc+","+ address+")\n";
    }
}

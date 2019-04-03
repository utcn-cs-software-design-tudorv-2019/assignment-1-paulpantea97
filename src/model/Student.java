package model;

public class Student {
	private int id;
	private String name;
	private String pnc;
	private String address;
	private Client client;
	
	public Student() {
		this.id=0;
		this.name=null;
		this.pnc=null;
		this.address=null;
		this.client=null;
	}
	
	public Student(int id,String name, String pnc, String address,Client client) {
		this.id=id;
		this.name=name;
		this.pnc=pnc;
		this.address=address;
		this.client=client;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getPnc() {
		return pnc;
	}
	
	public void setPnc(String pnc) {
		this.pnc = pnc;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Student ("+id +","+ name+","+ pnc+","+ address+")\n";
	}	
}

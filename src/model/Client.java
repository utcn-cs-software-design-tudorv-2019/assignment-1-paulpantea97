package model;

public class Client {
	
	private int id;
	private String username;
	private String password;
	private Boolean is_admin;
	private Boolean is_logged;
	
	public Client() {
		this.id=0;
		this.username=null;
		this.password=null;
		this.is_admin=null;
		this.is_logged=false;
	}
	public Client(int id,String username,String password,Boolean is_admin, Boolean is_logged)
	{
		this.id=id;
		this.username=username;
		this.password=password;
		this.is_admin=is_admin;
		this.is_logged=is_logged;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(Boolean is_admin) {
		this.is_admin = is_admin;
	}
	public Boolean getIs_logged() {
		return is_logged;
	}
	public void setIs_logged(Boolean is_logged) {
		this.is_logged = is_logged;
	}
	@Override
	public String toString() {
		return "Client ("+ id + "," +username +","+ password+","+ is_admin+ "," + is_logged + ")\n";
	}
}

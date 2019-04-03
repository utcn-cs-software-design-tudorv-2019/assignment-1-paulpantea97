package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Client;

public class ClientDao {
	
	public static Client login(String name,String password){
		Client client = null;
		try{
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from client where username=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				client = new Client();
				client.setId(rs.getInt("id"));
				client.setUsername(rs.getString("username"));
				client.setPassword(rs.getString("password"));
				client.setIs_admin(rs.getBoolean("is_admin"));
				client.setIs_logged(rs.getBoolean("is_logged"));
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return client;
	}
	
	public static Client findById(int id){
		Client client = new Client();
		try{
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from client where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				client.setId(rs.getInt("id"));
				client.setUsername(rs.getString("username"));
				client.setPassword(rs.getString("password"));
				client.setIs_admin(rs.getBoolean("is_admin"));
				client.setIs_logged(rs.getBoolean("is_logged"));
			}
			
			con.close();
		}catch(Exception e){e.printStackTrace();}	
		return client;
	}
	
	public static Client getLoggedClient(){
		Client client = new Client();
		try{
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from client where is_logged=1");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				client.setId(rs.getInt("id"));
				client.setUsername(rs.getString("username"));
				client.setPassword(rs.getString("password"));
				client.setIs_admin(rs.getBoolean("is_admin"));
				client.setIs_logged(rs.getBoolean("is_logged"));
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}	
		System.out.println(client);
		return client;
	}
	
	public static Client save(Client client){
		try{
			Connection con=ConnectionFactory.getConnection();
			String generatedColumns[] = { "id" };
			PreparedStatement ps=con.prepareStatement("insert into client(username,password,is_admin,is_logged) values(?,?,?,?)", generatedColumns);
			ps.setString(1,client.getUsername());
			ps.setString(2,client.getPassword());
			ps.setBoolean(3,client.getIs_admin());
			ps.setBoolean(4, client.getIs_logged());
			ps.executeUpdate();
			
			ResultSet set = ps.getGeneratedKeys();
			if(set.next()) {
				client.setId(set.getInt(1));
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return client;
	}
	
	public static void delete(int id){
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from client where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
	}
	
	public static void setLoggedIn(Client client){
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("update client set is_logged=1 where id=?");
			ps.setInt(1,client.getId());
			ps.executeUpdate();
			con.close();
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static void setLoggedOff(Client client){
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("update client set is_logged=0 where id=?");
			ps.setInt(1,client.getId());
			ps.executeUpdate();
			con.close();
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static List<Client> view(){
		List<Client> list=new ArrayList<>();
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from client");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Client client=new Client();
				client.setId(rs.getInt("id"));
				client.setUsername(rs.getString("username"));
				client.setPassword(rs.getString("password"));
				client.setIs_admin(rs.getBoolean("is_admin"));
				client.setIs_logged(rs.getBoolean("is_logged"));
				list.add(client);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
}

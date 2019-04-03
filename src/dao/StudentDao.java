package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Student;
public class StudentDao {
		
	public static Student save(Student student){
		try{
			Connection con = ConnectionFactory.getConnection();
			String[] generatedColumns = {"id"};
			PreparedStatement ps=con.prepareStatement("insert into student(name,pnc,address,user_id) values(?,?,?,?)", generatedColumns);
			ps.setString(1,student.getName());
			ps.setString(2,student.getPnc());
			ps.setString(3, student.getAddress());
			ps.setInt(4, student.getClient().getId());
			ps.executeUpdate();
			
			ResultSet set = ps.getGeneratedKeys();
			if(set.next()) {
				student.setId(set.getInt(1));
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return student;
	}
	
	public static int update(Student student){
		int status=0;
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("update student set name=?,pnc=?,address=?,user_id=? where id=?");
			ps.setString(1,student.getName());
			ps.setString(2,student.getPnc());
			ps.setString(3,student.getAddress());
			ps.setInt(4,student.getClient().getId());
			ps.setInt(5,student.getId());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
	
	public static List<Student> view(){
		List<Student> list=new ArrayList<Student>();
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPnc(rs.getString("pnc"));
				s.setAddress(rs.getString("address"));
				s.setClient(ClientDao.findById(rs.getInt("user_id")));
				list.add(s);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	
	public static void delete(int id){
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static Student findById(int id){
		Student s = new Student();
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPnc(rs.getString("pnc"));
				s.setAddress(rs.getString("address"));
				s.setClient(ClientDao.findById(rs.getInt("user_id")));
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return s;
	}
	
	public static Student findByClientId(int id){
		Student s = new Student();
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student where user_id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPnc(rs.getString("pnc"));
				s.setAddress(rs.getString("address"));
				s.setClient(ClientDao.findById(rs.getInt("user_id")));
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return s;
	}
}

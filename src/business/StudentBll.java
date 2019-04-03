
package business;

import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.JTable;
import dao.ClientDao;
import dao.StudentDao;
import model.Client;
import model.Student;

public class StudentBll {
		
	public StudentBll() {}
	
	public void addStudent(String name, String pnc, String address, int clientId) {
		Client client = ClientDao.findById(clientId);
		StudentDao.save(new Student(0, name, pnc, address, client));
	}
	
	public void addStudent(String name, String pnc, String address) {
		ClientBll clientBll = new ClientBll();
		Client client = clientBll .getLoggedIn();
		Student student = findByLoggedUser();
		
		if(student.getName() == null)
			StudentDao.save(new Student(0, name, pnc, address, client));
	}
		
	public ArrayList<Student> viewStudents(){
		return (ArrayList<Student>) StudentDao.view();
	}
	
	public void deleteStudent(int id) {
		StudentDao.delete(id);
	}
	
	public Student findById(int id) {
		return StudentDao.findById(id);
	}
	
	public Student findByLoggedUser() {
		ClientBll clientBll = new ClientBll();
		Client client = clientBll.getLoggedIn();
		Student st =  StudentDao.findByClientId(client.getId());
		return st;
	}
	
	public void editStudent(int id, String name, String pnc, String address) {
		ClientBll clientBll = new ClientBll();
		Client client = clientBll .getLoggedIn();
		StudentDao.update(new Student(id, name, pnc, address, client));
	}
	
	public void editStudent(int id, String name, String pnc, String address, int clientId) {
		Client client = ClientDao.findById(clientId);
		Student student = new Student(id, name, pnc, address, client);
		StudentDao.update(student);
	}
	
	public JTable createTable(ArrayList<Student> objects) {

		Object[] coloane = new String[objects.get(0).getClass().getDeclaredFields().length];
		Object[][] randuri = new Object[objects.size()][objects.get(0).getClass().getDeclaredFields().length];
		
		if(objects.size() > 0) {
			
			for(int i = 0; i <objects.get(0).getClass().getDeclaredFields().length; i++) {
				
				Field field = objects.get(0).getClass().getDeclaredFields()[i];
				field.setAccessible(true);
				coloane[i] = objects.get(0).getClass().getDeclaredFields()[i].getName();
			}
		}
		
		for(int i = 0; i < objects.size(); i++) {
			for(int j = 0; j < objects.get(i).getClass().getDeclaredFields().length; j++) {
				try {
					Field field = objects.get(i).getClass().getDeclaredFields()[j];
					field.setAccessible(true);
					randuri[i][j] = field.get(objects.get(i));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}             
		}
		
		JTable afisare = new JTable(randuri, coloane);
		return afisare;
	}

}

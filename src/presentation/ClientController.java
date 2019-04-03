package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import business.ClientBll;
import business.StudentBll;
import model.Student;

public class ClientController {
	
	private ClientView clientView;
	ClientBll clientBll = new ClientBll();
	StudentBll studentBll = new StudentBll();
	
	public ClientController(ClientView cv) {
		this.clientView = cv;
		
		clientView.addAddListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = clientView.getId();
				String name = clientView.getName();
				String pnc = clientView.getPnc();
				String address = clientView.getAddress();
				
				studentBll.addStudent(name, pnc, address);
				ArrayList<Student> student = new ArrayList<Student>();
				student.add(studentBll.findById(id));
				JTable table = studentBll.createTable(student);
				clientView.addTable(table);
			}
		});
		
		clientView.addViewListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Student> student = new ArrayList<Student>();
				student.add(studentBll.findByLoggedUser());
				JTable table = studentBll.createTable(student);
				clientView.addTable(table);
			}
		});
		
		clientView.addUpdateListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = clientView.getId();
				String name = clientView.getName();
				String pnc = clientView.getPnc();
				String address = clientView.getAddress();
				
				studentBll.editStudent(id, name, pnc, address);
				
				ArrayList<Student> student = new ArrayList<Student>();
				student.add(studentBll.findById(id));
				JTable table = studentBll.createTable(student);
				clientView.addTable(table);
			}
		});
		
		
	}
}

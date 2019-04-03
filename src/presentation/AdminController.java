package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import business.StudentBll;
import dao.StudentDao;

public class AdminController {
	
	public AdminView adminView;
	
	public AdminController(AdminView av) {
		this.adminView = av;
		StudentBll studentBll = new StudentBll();
			
		adminView.addBtnAddListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String name = adminView.getName();
				String address = adminView.getAddress();
				String pnc = adminView.getPnc();
				int idClient = adminView.getClientId();
				studentBll.addStudent(name, pnc, address, idClient);
				JTable table = studentBll.createTable(studentBll.viewStudents());
				adminView.addTable(table);
			}
		});
		
		adminView.addBtnDeleteListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int id = adminView.getId();
				
				StudentDao.delete(id);
				JTable table = studentBll.createTable(studentBll.viewStudents());
				adminView.addTable(table);
			}
		});
		
		adminView.addBtnUpdateListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String name = adminView.getName();
				String address = adminView.getAddress();
				String pnc = adminView.getPnc();
				int id = adminView.getId();
				int idClient = adminView.getClientId();
				
				studentBll.editStudent(id,  name, pnc, address, idClient);
				JTable table = studentBll.createTable(studentBll.viewStudents());
				adminView.addTable(table);
			}
		});
		
		adminView.addBtnViewListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JTable table = studentBll.createTable(studentBll.viewStudents());
				adminView.addTable(table);
			}
		});
	}

}

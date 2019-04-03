package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.ClientBll;
import dao.ClientDao;
import model.Client;

public class LoginController {
	
	private LoginView loginView;
	ClientBll clientBll = new ClientBll();
	
	public LoginController(LoginView lv) {
		this.loginView = lv;
		
		loginView.addLoginListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = loginView.getUsername();
				String password = loginView.getPassword();
								
				Client client = clientBll.login(username, password);
				if(client == null) {
					System.out.println("Eroare la logare");
				} else {
					clientBll.setLoggedIn(client);
					System.out.println(client.toString());
					if(client.getIs_admin() == true) {
						new AdminController(new AdminView());
					} else {
						new ClientController(new ClientView());
					}
				}
			}
		});
		
		loginView.addClientListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = loginView.getUsername();
				String password = loginView.getPassword();
				
				Client newClient = new Client(0, username, password, false, true); 
				ClientDao.save(newClient);
				clientBll.setLoggedIn(newClient);
			}
		});
	}
}

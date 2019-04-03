package business;

import java.util.ArrayList;

import dao.ClientDao;
import model.Client;

public class ClientBll {
	
	public ClientBll() {}
	
	public Client login(String username, String password) {
		return ClientDao.login(username, password);
	}
	
	public Client findById(int id) {
		return ClientDao.findById(id);
	}
	
	public void setLoggedIn(Client client) {
		ClientDao.setLoggedIn(client);
		ArrayList<Client> clients = (ArrayList<Client>) ClientDao.view();
		for(Client c : clients) {
			if(!c.getUsername().equals(client.getUsername()))
				ClientDao.setLoggedOff(c);
		}
	}
	
	public Client getLoggedIn() {
		return ClientDao.getLoggedClient();
	}
}

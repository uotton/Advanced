package main.java.ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private List<User> ListOfUsers = new ArrayList<>();
	private static UserService userService;
	
	private UserService() {
		
	}
	
	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
	}
	
	public List<User> getListOfUsers (){
		return ListOfUsers;
	}
	
	public void saveUser(User user) {
		ListOfUsers.add(user);
	}
	
	public User getUser (String email) {
		return ListOfUsers.stream().filter(user->user.getEmail().equals(email)).findFirst().get();
	}
}

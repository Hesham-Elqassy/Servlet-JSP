package com.service;

import com.dao.*;
import com.entity.User;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class UsersService {
	UserDAO userDAO = null;
	ProductsDAO productsDAO =null;
	
	public UsersService(){
		
		userDAO = new UserDAOImpl();
		
	}
	

	public User loginCheck(String loginUserName, String loginPassword)
	{    
		User user = userDAO.loginUser(loginUserName, loginPassword);
		return user;
		
	
		
	}
	
	public boolean addUserCheck(String username, String password, String adminstatus)
	{
		
		 boolean rs=false;
			boolean loginResult = userDAO.addUser(username, password, adminstatus);
			
			if (loginResult == true )
			{
				rs=true;
				return rs;
			}
			else
			{
				rs=false;
				return rs;
			}
		
		
	}
	
	
}

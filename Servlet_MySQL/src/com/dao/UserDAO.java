package com.dao;

import java.sql.Array;
import java.util.List;

import com.entity.*;

public interface UserDAO {

	List<User> getUsers();
	int deleteUser(int id);
	boolean updateUser(int editeid, String newusername ,String newpassword, String newadminstatus );
	User loginUser(String loginUserName, String loginPassword);
	boolean addUser(String username ,String password, String adminstatus);
	List<User> getUserInfoList(String userName);
	boolean updateSingleUserInfo(int editedid, String newusername, String newpassword);
	List<Order> getUserOrdersInfoList(int uid);
	List<Integer> getOrdersIdsByUserID(int UserID);
	List<Integer> getProductsIDsByOrdersIDs(List<Integer> ordersIDsList);
	List<Product> getUserOrderProductsList(int userID);
	
	
}

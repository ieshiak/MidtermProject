package com.skilldistillery.artgallery.data;

import com.skilldistillery.artgallery.entities.User;

public interface UserDAO {

	User authenticateUser(String username, String password);
}

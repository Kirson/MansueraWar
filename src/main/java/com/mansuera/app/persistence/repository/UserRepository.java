package com.mansuera.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mansuera.app.persistence.entity.Catalog;
import com.mansuera.app.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
	public List<User> findByLogin(String login);
	public List<User> findByRole(Catalog role);
	public User findByLoginAndPassword(String login, String password);
}

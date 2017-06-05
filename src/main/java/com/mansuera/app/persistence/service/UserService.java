package com.mansuera.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.mansuera.app.persistence.entity.User;
import com.mansuera.app.persistence.repository.UserRepository;
import com.mansuera.app.util.PasswordUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;

	private @Value("${mansuera.password.key}") String mansueraPasswordKey;
	private @Value("${mansuera.password.vector}") String mansueraPasswordVector;
	private @Value("${mansuera.encript.flag}") String mansueraEncriptFlag;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	

	@Transactional
	public User save(User user) {
		if (user.getUserRole() != null) {
			user.setRole(user.getUserRole());
		}
		if (mansueraEncriptFlag != null && mansueraEncriptFlag.equals("Y")) {
			try {
				String encriptPwd = PasswordUtil.encrypt(mansueraPasswordKey, mansueraPasswordVector, user.getPassword());
				user.setPassword(encriptPwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userRepository.save(user);
	}

	public User findByLoginAndPassword(String login, String password) {
		if (mansueraEncriptFlag != null && mansueraEncriptFlag.equals("Y")) {
			try {
				String encriptPwd = PasswordUtil.encrypt(mansueraPasswordKey, mansueraPasswordVector, password);
				password = encriptPwd;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userRepository.findByLoginAndPassword(login, password);
	}
	
	/**
	 * DecriptPassword
	 * @param login
	 * @return
	 */
	public List<User> getDecriptPassword(String login){
		
		List<User> query = userRepository.findByLogin(login);
		List<User> result = new ArrayList<User>();
		
		if(query!=null && !query.isEmpty()){
			for(User u:query){
				String decript = "";
				try {
					 decript = PasswordUtil.decrypt(mansueraPasswordKey, mansueraPasswordVector, u.getPassword());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				u.setClearPassword(decript);
				result.add(u);
			}
		}
		
		return result;
	}

	
}

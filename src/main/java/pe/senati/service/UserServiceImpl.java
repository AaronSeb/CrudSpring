package pe.senati.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.RoleEntity;
import pe.senati.entity.UserEntity;
import pe.senati.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	
	
	public UserServiceImpl() {
	}
	
	
	
	@Override
	@Transactional(readOnly = true)
	public UserEntity findByUsername(String username) {
		
		return repository.findByUsername(username);
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userDb = findByUsername(username);
		if(userDb !=null) {
			
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			
			//RECORRE TODOS LOS ROLES Y LO GUARDA EN LA COLECIÓN authorities
			for(RoleEntity role:userDb.getItemsRole()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getType()));
			}
			
			//PARA USUARIOS
			
			User user = new User(userDb.getUsername(), userDb.getPassword(), userDb.getState().equals("ACTIVE"), true, true, true, authorities);
			
			return user;
		}
		
		
		
		 throw new UsernameNotFoundException("Usuario "+username+" no existe");
	}
	
	
	
	

}

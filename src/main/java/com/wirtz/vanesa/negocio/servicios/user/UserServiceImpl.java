package com.wirtz.vanesa.negocio.servicios.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.excepciones.UsernameAlreadyExists;
import com.wirtz.vanesa.negocio.servicios.rol.RolServiceImpl;
import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.persistencia.entidades.Rol;
import com.wirtz.vanesa.persistencia.repositorio.user.UserRepository;
import com.wirtz.vanesa.vista.dto.user.UserBean;
import com.wirtz.vanesa.vista.dto.user.UserForm;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RolServiceImpl rolService;

	@Autowired
	private SessionRegistry sessionRegistry;

	public void expireUserSessions(String username) {
		for (Object principal : sessionRegistry.getAllPrincipals()) {
			if (principal instanceof User) {
				UserDetails userDetails = (UserDetails) principal;
				if (userDetails.getUsername().equals(username)) {
					for (SessionInformation information : sessionRegistry.getAllSessions(userDetails, true)) {
						information.expireNow();
					}
				}
			}
		}
	}

	@Override
	public void createUser(UserForm usuarioForm) throws DifferentPasswords, UsernameAlreadyExists {

		if (usuarioForm.getPassword().contentEquals(usuarioForm.getPassword2())) {

			if (!usernameExists(usuarioForm)) {
				MyUser userEntity = convertFormToEntity(usuarioForm);
				rolService.createRol(userEntity, "user");
				userRepo.save(userEntity);
			} else {
				throw new UsernameAlreadyExists("Ese nombre de usuario ya existe, introduzca otro");
			}

		} else {
			throw new DifferentPasswords("Las contraseñas no coinciden, vuelva a intentarlo");
		}
	}

	private boolean usernameExists(UserForm userForm) {
		try {
			if (userForm.getUsername().equals(userRepo.findByUsername(userForm.getUsername()).get().getUsername())) {
				return true;
			}
		} catch (java.util.NoSuchElementException e) {
			return false;
		}
		return false;
	}

	@Override
	public void deleteByUsername(String username) {
		MyUser userDelete = userRepo.findByUsername(username).get();
		userRepo.delete(userDelete);
	}

	@Override
	public void updateUser(UserForm userForm) throws DifferentPasswords {
		if (userForm.getPassword().contentEquals(userForm.getPassword2())) {

			MyUser user = convertFormToEntity(userForm);
			userRepo.save(user);

		} else {
			throw new DifferentPasswords("Las contraseñas no coinciden, vuelva a intentarlo");
		}
	}

	@Override
	public UserBean findUserById(Long id) {
		Optional<MyUser> foundUser = (userRepo.findById(id));
		return convertEntityToBean(foundUser.get());
	}

	public MyUser convertFormToEntity(UserForm user) {
		MyUser miUsuario = new MyUser();
		miUsuario.setUsername(user.getUsername());
		miUsuario.setPassword(encoder.encode(user.getPassword()));
		miUsuario.setName(user.getName());
		miUsuario.setFirstName(user.getFirstName());
		miUsuario.setSecondName(user.getSecondName());
		miUsuario.setEmail(user.getEmail());
		return miUsuario;
	}

	public UserBean convertEntityToBean(MyUser userEntity) {
		return new UserBean(userEntity.getId(), userEntity.getUsername(), userEntity.getName(), userEntity.getFirstName(),
				userEntity.getSecondName(), userEntity.getEmail());
	}

	@Override
	public List<UserBean> listUsers() {

		List<UserBean> clientsUser = new ArrayList<UserBean>();
		for (MyUser user : userRepo.findAll()) {
			for (Rol rol : user.getRoles()) {
				if (rol.getName().equals("user")) {
					clientsUser.add(convertEntityToBean(user));
				}
			}
		}

		return clientsUser;
	}

	@Override
	public UserBean findUserByUsername(String username) {
		Optional<MyUser> foundUser = (userRepo.findByUsername(username));
		return convertEntityToBean(foundUser.get());
	}

}

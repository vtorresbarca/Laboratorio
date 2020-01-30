package com.wirtz.vanesa.negocio.servicios.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.persistencia.entidades.Rol;
import com.wirtz.vanesa.persistencia.repositorio.rol.RolRepository;
import com.wirtz.vanesa.persistencia.repositorio.user.UserRepository;
import com.wirtz.vanesa.vista.dto.user.UserForm;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	private RolRepository rolRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public void createUser(UserForm usuarioForm) throws DifferentPasswords {

		if (usuarioForm.getPassword().contentEquals(usuarioForm.getPassword2())) {
			MyUser userEntity = convertirFormToEntity(usuarioForm);
			Rol newRol = new Rol();

			newRol.setName("user");

			rolRepo.save(newRol);
			userEntity.getRoles().add(newRol);
			userRepo.save(userEntity);
		} else {
			throw new DifferentPasswords("Las contraseñas no coinciden, vuelva a intentarlo");
		}
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public void updateUser(Long id, String username, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public MyUser readUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyUser convertirFormToEntity(UserForm user) {
		MyUser miUsuario = new MyUser();
		miUsuario.setUsername(user.getUsername());
		miUsuario.setPassword(encoder.encode(user.getPassword()));
		miUsuario.setName(user.getName());
		miUsuario.setFirstName(user.getFirstName());
		miUsuario.setSecondName(user.getSecondName());
		miUsuario.setEmail(user.getEmail());
		return miUsuario;
	}

	@Override
	public List<MyUser> listUsers() {
		// TODO: esto tiene que devolver un UserBean
		List<MyUser> clientsUser = new ArrayList<MyUser>();
		for(MyUser user : userRepo.findAll()) {
			for(Rol rol : user.getRoles()) {
				if(rol.getName().equals("user")) {
					clientsUser.add(user);
				}
			}
		}
		
		return clientsUser;
	}

	/*
	 * private MyUser createAdmin() { MyUser admin = new MyUser();
	 * admin.setUsername("admin"); admin.setPassword("admin");
	 * admin.setName("administrator"); Rol newRol = new Rol(); rolRepo.save(newRol);
	 * admin.getRoles().add(newRol); usuarioRepo.save(admin);
	 * 
	 * return admin; }
	 */
}

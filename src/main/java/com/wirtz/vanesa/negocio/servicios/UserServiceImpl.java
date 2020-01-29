package com.wirtz.vanesa.negocio.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.persistencia.entidades.Rol;
import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.persistencia.repositorio.RoleRepository;
import com.wirtz.vanesa.persistencia.repositorio.UserRepository;
import com.wirtz.vanesa.vista.dto.UserForm;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	private RoleRepository rolRepo;
	
	@Autowired
	private UserRepository usuarioRepo;
	
	@Override
	public void createUser(UserForm usuarioForm) throws DifferentPasswords{

		if(usuarioForm.getPassword().contentEquals(usuarioForm.getPassword2())) {
			MyUser userEntity = convertirFormToEntity(usuarioForm);
			Rol newRol = new Rol();
			newRol.setName("user");
			rolRepo.save(newRol);
			userEntity.getRoles().add(newRol);
			usuarioRepo.save(userEntity);
		}else {
			throw new DifferentPasswords("Las contraseñas no coinciden, vuelva a intentarlo");
		}
	}

	@Override
	public void borrarUsuario(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarUsuario(Long id, String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MyUser verDatosUsuario(Long id) {
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

}

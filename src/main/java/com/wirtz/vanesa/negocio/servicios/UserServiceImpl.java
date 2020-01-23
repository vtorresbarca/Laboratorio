package com.wirtz.vanesa.negocio.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wirtz.vanesa.excepciones.ContrasenhasNoCoincidentes;
import com.wirtz.vanesa.persistencia.entidades.Rol;
import com.wirtz.vanesa.persistencia.entidades.Usuario;
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
	public void crearUsuario(UserForm usuarioForm) throws ContrasenhasNoCoincidentes{
//		Usuario miUsuario = new Usuario();
//		miUsuario.setNombreUsuario(username);
//		miUsuario.setContrasenha(encoder.encode(password));
//		
//		//asigno un rol
//		Rol nuevoRol = new Rol();
//		nuevoRol.setName("user");
//		rolRepo.save(nuevoRol);	
//		//añado el rol a la lista del usuario
//		miUsuario.getRoles().add(nuevoRol);
//		//guardo el usuario
//		usuarioRepo.save(miUsuario);
		if(usuarioForm.getContrasenha().contentEquals(usuarioForm.getContrasenha2())) {
			Usuario userEntity = convertirFormToEntity(usuarioForm);
			Rol nuevoRol = new Rol();
			nuevoRol.setName("user");
			rolRepo.save(nuevoRol);
			userEntity.getRoles().add(nuevoRol);
			usuarioRepo.save(userEntity);
		}else {
			throw new ContrasenhasNoCoincidentes("Las contraseñas no coinciden, vuelva a intentarlo");
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
	public Usuario verDatosUsuario(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario convertirFormToEntity(UserForm user) {
		Usuario miUsuario = new Usuario();
		miUsuario.setNombreUsuario(user.getNombreUsuario());
		miUsuario.setContrasenha(encoder.encode(user.getContrasenha()));
		
		return miUsuario;
	}

}

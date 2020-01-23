package com.wirtz.vanesa.negocio.servicios;

import com.wirtz.vanesa.excepciones.ContrasenhasNoCoincidentes;
import com.wirtz.vanesa.persistencia.entidades.Usuario;
import com.wirtz.vanesa.vista.dto.UserForm;

public interface UserService {

	public void crearUsuario(UserForm usuario) throws ContrasenhasNoCoincidentes;
	public void borrarUsuario(Long id);
	public void modificarUsuario(Long id, String username, String password);
	public Usuario verDatosUsuario(Long id);
	public Usuario convertirFormToEntity(UserForm user);
}

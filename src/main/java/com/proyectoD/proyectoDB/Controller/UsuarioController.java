package com.proyectoD.proyectoDB.Controller;

import com.proyectoD.proyectoDB.Dao.UsuarioDao;
import com.proyectoD.proyectoDB.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value="api/usuarios")
    public List<Usuario> getUsuario() {
        List<Usuario> user = usuarioDao.getUsuarios();

        return user;
    }

    @RequestMapping (value = "api/usuarios/{id}",method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {

        usuarioDao.eliminar(id);
    }

    @RequestMapping (value = "api/usuarios",method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String pass_hasheado = argon2.hash(1,1024,1,usuario.getContrasenia());
        usuario.setContrasenia(pass_hasheado);

        usuarioDao.registrar(usuario);
    }
}

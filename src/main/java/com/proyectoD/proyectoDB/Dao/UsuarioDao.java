package com.proyectoD.proyectoDB.Dao;

import com.proyectoD.proyectoDB.Model.Usuario;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);


}

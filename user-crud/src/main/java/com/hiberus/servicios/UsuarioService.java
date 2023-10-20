package com.hiberus.servicios;
import com.hiberus.Usuario;
import com.hiberus.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hiberus.excepciones.UsuarioNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @Transactional
    public Usuario modificarUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = obtenerUsuarioPorId(id);

        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setPizzasfavoritas(usuario.getPizzasfavoritas());

            return usuarioRepository.save(usuarioExistente);
        } else throw new UsuarioNotFoundException("El usuario con ID " + id + " no se encontró.");
    }
    @Transactional
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    @Transactional
    public Usuario marcarPizzaFavorita(Long idUsuario, String pizzaNombre) {
        Usuario usuario = obtenerUsuarioPorId(idUsuario);
        if (usuario != null) {
            usuario.setPizzasfavoritas(pizzaNombre);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Transactional
    public Usuario desmarcarPizzaFavorita(Long idUsuario) {
        Usuario usuario = obtenerUsuarioPorId(idUsuario);
        if (usuario != null) {
            usuario.setPizzasfavoritas(null);
            return usuarioRepository.save(usuario);
        }
        return null;
    }
}

package com.example.App.services;

import com.example.App.entities.Usuario;
import com.example.App.repositories.UsuarioRepository;
import com.example.App.response.DeleteResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findByid_Usuario(Long id_Usuario){
        return usuarioRepository.findById(id_Usuario);
    }

    public DeleteResult deleteById(Long id) {
        DeleteResult result = new DeleteResult();
        try {
            usuarioRepository.deleteById(id);
            result.setSuccess(true);
            result.setMessage("Usuario eliminado correctamente");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Error al eliminar usuario: " + e.getMessage());
        }
        return result;
    }
    // Metodo para actualizar un cliente existente
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        usuario.setId_Usuario(id); // Asegurar que el id del usuario coincida con el proporcionado
        return usuarioRepository.save(usuario);
    }
    public Optional<Usuario> findByUserName(String user_name) {
        return usuarioRepository.findByUserName(user_name);
    }

    public boolean existsById(Long id_Usuario) {
        return usuarioRepository.existsById(id_Usuario);
    }
}


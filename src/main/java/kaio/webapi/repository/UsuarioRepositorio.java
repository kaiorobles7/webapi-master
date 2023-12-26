package kaio.webapi.repository;

import kaio.webapi.model.Setor;
import kaio.webapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    List<Usuario> findByLogin(String login);
}
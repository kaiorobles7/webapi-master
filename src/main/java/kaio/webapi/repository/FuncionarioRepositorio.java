package kaio.webapi.repository;

import kaio.webapi.model.Funcionario;
import kaio.webapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario,Long> {

    List<Funcionario> findByNome(String nome);
}

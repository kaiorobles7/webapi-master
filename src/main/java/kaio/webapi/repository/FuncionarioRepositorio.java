package kaio.webapi.repository;

import kaio.webapi.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario,Long> {


}

package kaio.webapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "funcionarios")
@Data
public class Funcionario {
    private Usuario usuario;
    private Setor setor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String Nome;
    private Cargo cargo;

}


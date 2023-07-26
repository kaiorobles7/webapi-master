package kaio.webapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "setor")
@NoArgsConstructor
@AllArgsConstructor
public class Setor {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idsetor;
    @Getter
    @Setter
    private  String nome;

    public Setor(String nome) {
        this.nome = nome;

    }
}
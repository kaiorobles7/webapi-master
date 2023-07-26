package kaio.webapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Getter
    @Setter
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String nome;
    @Getter
    private Integer quantidade;
    @Getter
    private Float preco;

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}

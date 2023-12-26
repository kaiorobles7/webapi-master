package kaio.webapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String login;

    @Getter
    private String password;


    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Getters, setters e demais métodos...
}

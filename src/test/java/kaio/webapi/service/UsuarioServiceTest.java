package kaio.webapi.service;

import kaio.webapi.model.Setor;
import kaio.webapi.model.Usuario;
import kaio.webapi.repository.SetorRepositorio;
import kaio.webapi.repository.UsuarioRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class )
public class UsuarioServiceTest {
    private SetorRepositorio setorRepositorio;
    private UsuarioRepositorio repository;
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        setorRepositorio = mock(SetorRepositorio.class);
        repository = mock(UsuarioRepositorio.class);
        usuarioService = new UsuarioService(setorRepositorio, repository);
    }

    @Test
    void deveAtualizarUsuariosComSetorComSucesso() {
        Long setorId = 1L;
        List<Usuario> usuarios = Arrays.asList(
                new Usuario(1L, "michael", "WorldsBestBoss#1", null),
                new Usuario(2L, "jim", "BeetleDwight#2", null),
                new Usuario(3L, "pam", "ArtisticReceptionist#3", null)
        );

        Setor setor = new Setor(1L, "padrao");

        when(setorRepositorio.findById(setor.getIdsetor())).thenReturn(Optional.of(setor));

        usuarioService.atualizarUsuariosComSetor(setorId, usuarios);

        for (Usuario usuario : usuarios) {
            verify(repository).save(usuario);
        }

        verify(setorRepositorio).findById(setorId);
        verifyNoMoreInteractions(setorRepositorio);
        verifyNoMoreInteractions(repository);
    }
}


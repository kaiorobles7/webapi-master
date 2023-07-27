package kaio.webapi.service;

import kaio.webapi.model.Setor;
import kaio.webapi.repository.SetorRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class )
public class SetorServiceTest {

    @InjectMocks
    SetorService service;

    @Mock
    SetorRepositorio repository;

    Setor setor;

    @BeforeEach
    public void setUp(){
        setor = new Setor(1L, "padrao");
    }

    @Test
    void deveBuscarSetorPeloIdComSucesso() {

        Setor setorEsperado = new Setor();

        when(repository.findById(setor.getIdsetor())).thenReturn(Optional.ofNullable(setorEsperado));

        Optional<Setor> setores = service.buscarSetorPorId(setor.getIdsetor());

        Setor setorRetornado = setores.orElse(null);

        assertEquals(setorEsperado, setorRetornado);

        verify(repository).findById(setor.getIdsetor());

        verifyNoMoreInteractions(repository);
    }
}

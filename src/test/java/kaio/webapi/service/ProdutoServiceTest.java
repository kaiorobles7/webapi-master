package kaio.webapi.service;
import kaio.webapi.model.Produto;
import kaio.webapi.repository.ProdutoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class )
public class ProdutoServiceTest {

    @InjectMocks
    ProdutoService service;

    @Mock
    ProdutoRepositorio repository;

    Produto produto;

    @BeforeEach
    public void setUp(){
        produto = new Produto(1L, "Caneta", 100, 2.0f);
    }

    @Test
    void deveBuscarProdutosPeloNomeComSucesso() {
        when(repository.findByNome(produto.getNome())).thenReturn(Collections.singletonList(produto));

        List<Produto> produtos = service.buscarProdutoPeloNome(produto.getNome());

        assertEquals(Collections.singletonList(produto), produtos);
        verify(repository).findByNome(produto.getNome());
        verifyNoMoreInteractions(repository);
    }
}

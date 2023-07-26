package kaio.webapi.service;

import kaio.webapi.model.Produto;
import kaio.webapi.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio prepository;

    @Autowired
    public ProdutoService(ProdutoRepositorio prepository) {
        this.prepository = prepository;
    }

    public Produto criarProduto(Produto produto) {
        return prepository.save(produto);
    }
    public Optional<Produto> atualizarProduto(Produto produto) {//put
        Optional<Produto> usuarioExistente = prepository.findById(produto.getId());
        if (usuarioExistente.isPresent()) {
            return Optional.of(prepository.save(produto));
        }
        return Optional.empty();
    }

    public List<Produto> buscarProduto(){
        return prepository.findAll();
    }

    public List<Produto> buscarProdutoPeloNome(String nome) {
        return prepository.findByNome(nome);
    }

    public List<Produto> deletarUsuario(Long id) {
        prepository.deleteById(id);
        return prepository.findAll();
    }
}


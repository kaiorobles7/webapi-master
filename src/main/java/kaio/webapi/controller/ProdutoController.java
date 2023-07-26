package kaio.webapi.controller;

import kaio.webapi.model.Produto;
import kaio.webapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProdutoController {

    @Autowired
    private ProdutoService pservice;

    @GetMapping()
    public List<Produto> getProduto(){
        return pservice.buscarProduto();
    }

    @GetMapping("/{nome}")
    public List<Produto>getProdutoByCodigo(@PathVariable String nome){
        return pservice.buscarProdutoPeloNome(nome);
    }

    @PostMapping("/create")
    public Produto createProduto(@RequestBody Produto produto){
        return pservice.criarProduto(produto);
    }

    @PutMapping("/atualizar")
    public Optional<Produto> putProduto(@RequestBody Produto produto){
        return pservice.atualizarProduto(produto);
    }

    @DeleteMapping("/delete/{id}")
    public List<Produto> deleteProduto(@PathVariable Long id){
        return pservice.deletarUsuario(id);
    }
}

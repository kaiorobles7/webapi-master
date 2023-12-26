package kaio.webapi.controller;

import kaio.webapi.model.Funcionario;
import kaio.webapi.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/funcionarios")

public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping()
    public List<Funcionario> getFuncionarios(){return service.buscarFuncionario();}

    @GetMapping()
    public List<Funcionario> getFuncionarios(@PathVariable String nome){return service.buscarFuncionarioPeloNome(nome);}

    @PostMapping("/create")
    public Funcionario createFuncionarios(@RequestBody Funcionario funcionario){return service.criarFuncionario(funcionario);}

    @PutMapping("/atualizar")
    public Optional<Funcionario> putFuncionarios(@RequestBody Funcionario funcionario){return service.atualizarFuncionario(funcionario);}

    @DeleteMapping("/delete/{id}")
    public List<Funcionario> deleteFuncionarios(@PathVariable Long id){return service.deletarFuncionario(id);}
}

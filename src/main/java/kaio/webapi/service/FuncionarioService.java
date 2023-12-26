package kaio.webapi.service;

import kaio.webapi.model.Funcionario;
import kaio.webapi.repository.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @Autowired
    public FuncionarioService(FuncionarioRepositorio funcionarioRepositorio){
        this.funcionarioRepositorio = funcionarioRepositorio;
    }
    public Funcionario criarFuncionario(Funcionario funcionario){
        return funcionarioRepositorio.save(funcionario);
    }
    public Optional<Funcionario> atualizarFuncionario (Funcionario funcionario){
        Optional<Funcionario> funcionarioExistente = funcionarioRepositorio.findById(funcionario.getId());
        if (funcionarioExistente.isPresent()){
            return Optional.of(funcionarioRepositorio.save(funcionario));
        }
        return Optional.empty();
    }
    public List<Funcionario> buscarFuncionario(){return funcionarioRepositorio.findAll();}

    public List<Funcionario> buscarFuncionarioPeloNome(String nome){return funcionarioRepositorio.findByNome(nome);}

    public List<Funcionario> deletarFuncionario(Long id){
        funcionarioRepositorio.deleteById(id);
        return funcionarioRepositorio.findAll();
    }
}

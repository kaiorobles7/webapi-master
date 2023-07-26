package kaio.webapi.service;

import kaio.webapi.model.Setor;
import kaio.webapi.repository.SetorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SetorService {
    @Autowired
    private final SetorRepositorio setorRepositorio;

    @Autowired
    public SetorService(SetorRepositorio setorRepositorio) {
        this.setorRepositorio = setorRepositorio;
    }

    public List<Setor> buscarSetores() {
        return setorRepositorio.findAll();
    }

    public Optional<Setor> buscarSetorPorId(Long id) {
        return setorRepositorio.findById(id);
    }

    public Setor criarSetor(Setor setor) {
        return setorRepositorio.save(setor);
    }

    public Optional<Setor> atualizarSetor(Long id, Setor setorAtualizado) {
        Optional<Setor> setorExistente = setorRepositorio.findById(id);
        if (setorExistente.isPresent()) {
            setorAtualizado.setIdsetor(id);
            return Optional.of(setorRepositorio.save(setorAtualizado));
        }
        return Optional.empty();
    }

    public List<Setor> deletarSetor(Long id) {
        setorRepositorio.deleteById(id);
        return setorRepositorio.findAll();
    }
}

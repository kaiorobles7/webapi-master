package kaio.webapi.controller;

import kaio.webapi.model.Setor;
import kaio.webapi.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/setores")
public class SetorController {

    private final SetorService setorService;

    @Autowired
    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @GetMapping
    public List<Setor> getSetores() {
        return setorService.buscarSetores();
    }

    @GetMapping("/{id}")
    public Optional<Setor> getSetor(@PathVariable Long id) {
        return setorService.buscarSetorPorId(id);
    }

    @PostMapping("/create")
    public Setor createSetor(@RequestBody Setor setor) {
        return setorService.criarSetor(setor);
    }

    @PutMapping("/atualizar/{id}")
    public Optional<Setor> putSetor(@PathVariable Long id, @RequestBody Setor setor) {
        return setorService.atualizarSetor(id, setor);
    }

    @DeleteMapping("/delete/{id}")
    public List<Setor> deleteSetor(@PathVariable Long id) {
        return setorService.deletarSetor(id);
    }

}

package br.com.senac.demo.controller;

import br.com.senac.demo.model.Paciente;
import br.com.senac.demo.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public Page<Paciente> findAll(@RequestParam(name = "numeroPagina", required = false, defaultValue = "0") int numeroPagina,
                                  @RequestParam(name = "quantidade", required = false, defaultValue = "5") int quantidade) {
        PageRequest pageRequest = PageRequest.of(numeroPagina, quantidade);
        return pacienteRepository.findAll(pageRequest);
    }

    @PostMapping
    public Paciente save(@RequestBody Paciente paciente) {
        pacienteRepository.save(paciente);
        return paciente;
    }

    @PutMapping("{id}")
    public Paciente update(@PathVariable("id") Integer id, @RequestBody Paciente pacienteRequisicao) {
        Optional<Paciente> clienteOpt = pacienteRepository.findById(id);

        if (clienteOpt.isPresent()) {
            Paciente pacienteSalvo = clienteOpt.get();
            pacienteSalvo.setNome(pacienteRequisicao.getNome());

            return pacienteRepository.save(pacienteSalvo);
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        pacienteRepository.deleteById(id);
    }
}

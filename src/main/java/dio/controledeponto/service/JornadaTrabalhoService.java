package dio.controledeponto.service;

import dio.controledeponto.model.JornadaTrabalho;
import dio.controledeponto.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaTrabalhoService {

    @Autowired
    private JornadaTrabalhoRepository repository;

    public JornadaTrabalho salvar(JornadaTrabalho dto) {
        return repository.save(dto);
    }

    public Optional<JornadaTrabalho> atualizar(Long id, JornadaTrabalho dto) {
        return repository.findById(id).map(jornada -> {
            jornada.setDescricao(dto.getDescricao());
            jornada.setHorarioEntrada(dto.getHorarioEntrada());
            jornada.setHorarioSaida(dto.getHorarioSaida());
            jornada.setIntervalo(dto.getIntervalo());
            return repository.save(jornada);
        });
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<JornadaTrabalho> listarTodos() {
        return repository.findAll();
    }

    public Optional<JornadaTrabalho> buscarPorId(Long id) {
        return repository.findById(id);
    }
}

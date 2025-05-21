package dio.controledeponto.service;

import dio.controledeponto.dto.AjusteManualInputDTO;
import dio.controledeponto.model.AjusteManual;
import dio.controledeponto.repository.AjusteManualRepository;
import dio.controledeponto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AjusteManualService {

    @Autowired
    private AjusteManualRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public AjusteManual salvar(AjusteManualInputDTO dto) {
        AjusteManual ajuste = new AjusteManual();
        ajuste.setFuncionario(funcionarioRepository.findById(dto.getFuncionarioId()).orElseThrow());
        ajuste.setData(dto.getData());
        ajuste.setJustificativa(dto.getJustificativa());
        ajuste.setHorarioCorrigido(dto.getHorarioCorrigido());
        return repository.save(ajuste);
    }

    public Optional<AjusteManual> atualizar(Long id, AjusteManualInputDTO dto) {
        return repository.findById(id).map(ajuste -> {
            ajuste.setFuncionario(funcionarioRepository.findById(dto.getFuncionarioId()).orElseThrow());
            ajuste.setData(dto.getData());
            ajuste.setJustificativa(dto.getJustificativa());
            ajuste.setHorarioCorrigido(dto.getHorarioCorrigido());
            return repository.save(ajuste);
        });
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<AjusteManual> listarTodos() {
        return repository.findAll();
    }

    public Optional<AjusteManual> buscarPorId(Long id) {
        return repository.findById(id);
    }
}

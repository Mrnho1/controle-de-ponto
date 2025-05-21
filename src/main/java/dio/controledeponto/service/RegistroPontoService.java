package dio.controledeponto.service;

import dio.controledeponto.dto.RegistroPontoInputDTO;
import dio.controledeponto.model.PunchType;
import dio.controledeponto.model.RegistroPonto;
import dio.controledeponto.repository.FuncionarioRepository;
import dio.controledeponto.repository.RegistroPontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroPontoService {

    @Autowired
    private RegistroPontoRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public RegistroPonto salvar(RegistroPontoInputDTO dto) {
        RegistroPonto registro = new RegistroPonto();
        registro.setFuncionario(funcionarioRepository.findById(dto.getFuncionarioId()).orElseThrow());
        registro.setDataHora(dto.getDataHora());
        registro.setTipo(PunchType.valueOf(dto.getTipo()));
        return repository.save(registro);
    }

    public Optional<RegistroPonto> atualizar(Long id, RegistroPontoInputDTO dto) {
        return repository.findById(id).map(registro -> {
            registro.setFuncionario(funcionarioRepository.findById(dto.getFuncionarioId()).orElseThrow());
            registro.setDataHora(dto.getDataHora());
            registro.setTipo(PunchType.valueOf(dto.getTipo()));
            return repository.save(registro);
        });
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<RegistroPonto> listarTodos() {
        return repository.findAll();
    }

    public Optional<RegistroPonto> buscarPorId(Long id) {
        return repository.findById(id);
    }
}

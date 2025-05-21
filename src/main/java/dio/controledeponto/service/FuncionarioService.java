package dio.controledeponto.service;

import dio.controledeponto.dto.FuncionarioInputDTO;
import dio.controledeponto.dto.FuncionarioOutputDTO;
import dio.controledeponto.model.Funcionario;
import dio.controledeponto.repository.FuncionarioRepository;
import dio.controledeponto.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private JornadaTrabalhoRepository jornadaRepository;

    public FuncionarioOutputDTO salvar(FuncionarioInputDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setEmail(dto.getEmail());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setCargo(dto.getCargo());
        funcionario.setDataAdmissao(dto.getDataAdmissao());
        funcionario.setJornadaTrabalho(jornadaRepository.findById(dto.getJornadaTrabalhoId()).orElseThrow());
        return new FuncionarioOutputDTO(repository.save(funcionario));
    }

    public Optional<FuncionarioOutputDTO> atualizar(Long id, FuncionarioInputDTO dto) {
        return repository.findById(id).map(funcionario -> {
            funcionario.setNome(dto.getNome());
            funcionario.setCpf(dto.getCpf());
            funcionario.setEmail(dto.getEmail());
            funcionario.setTelefone(dto.getTelefone());
            funcionario.setCargo(dto.getCargo());
            funcionario.setDataAdmissao(dto.getDataAdmissao());
            funcionario.setJornadaTrabalho(jornadaRepository.findById(dto.getJornadaTrabalhoId()).orElseThrow());
            return new FuncionarioOutputDTO(repository.save(funcionario));
        });
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<FuncionarioOutputDTO> listarTodos() {
        return repository.findAll().stream()
                .map(FuncionarioOutputDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<FuncionarioOutputDTO> buscarPorId(Long id) {
        return repository.findById(id).map(FuncionarioOutputDTO::new);
    }
}

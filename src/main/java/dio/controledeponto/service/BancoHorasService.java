package dio.controledeponto.service;

import dio.controledeponto.dto.BancoHorasInputDTO;
import dio.controledeponto.model.BancoHoras;
import dio.controledeponto.repository.BancoHorasRepository;
import dio.controledeponto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    @Autowired
    private BancoHorasRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public BancoHoras salvar(BancoHorasInputDTO dto) {
        BancoHoras banco = new BancoHoras();
        banco.setFuncionario(funcionarioRepository.findById(dto.getFuncionarioId()).orElseThrow());
        banco.setHorasExcedentes(dto.getHorasExcedentes());
        banco.setHorasFaltantes(dto.getHorasFaltantes());
        banco.setSaldo(dto.getSaldo());
        return repository.save(banco);
    }

    public Optional<BancoHoras> atualizar(Long id, BancoHorasInputDTO dto) {
        return repository.findById(id).map(banco -> {
            banco.setFuncionario(funcionarioRepository.findById(dto.getFuncionarioId()).orElseThrow());
            banco.setHorasExcedentes(dto.getHorasExcedentes());
            banco.setHorasFaltantes(dto.getHorasFaltantes());
            banco.setSaldo(dto.getSaldo());
            return repository.save(banco);
        });
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<BancoHoras> listarTodos() {
        return repository.findAll();
    }

    public Optional<BancoHoras> buscarPorId(Long id) {
        return repository.findById(id);
    }
}

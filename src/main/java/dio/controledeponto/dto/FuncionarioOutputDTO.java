package dio.controledeponto.dto;

import dio.controledeponto.model.Funcionario;
import lombok.Data;


import java.time.LocalDate;

@Data
public class FuncionarioOutputDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String cargo;
    private LocalDate dataAdmissao;
    private JornadaTrabalhoOutputDTO jornadaTrabalho;

    public FuncionarioOutputDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.email = funcionario.getEmail();
        this.telefone = funcionario.getTelefone();
        this.cargo = funcionario.getCargo();
        this.dataAdmissao = funcionario.getDataAdmissao();
        if (funcionario.getJornadaTrabalho() != null) {
            this.jornadaTrabalho = new JornadaTrabalhoOutputDTO(funcionario.getJornadaTrabalho());
        }
    }
}
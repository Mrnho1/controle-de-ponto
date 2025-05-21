package dio.controledeponto.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FuncionarioInputDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String cargo;
    private LocalDate dataAdmissao;
    private Long jornadaTrabalhoId;
}

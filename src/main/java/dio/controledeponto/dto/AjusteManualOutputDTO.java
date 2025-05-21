package dio.controledeponto.dto;

import dio.controledeponto.model.AjusteManual;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AjusteManualOutputDTO {
    private Long id;
    private Long funcionarioId;
    private LocalDate data;
    private String justificativa;
    private LocalTime horarioCorrigido;

    public AjusteManualOutputDTO(AjusteManual ajuste) {
        this.id = ajuste.getId();
        this.funcionarioId = ajuste.getFuncionario().getId();
        this.data = ajuste.getData();
        this.justificativa = ajuste.getJustificativa();
        this.horarioCorrigido = ajuste.getHorarioCorrigido();
    }
}
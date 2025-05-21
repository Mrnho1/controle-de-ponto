package dio.controledeponto.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AjusteManualInputDTO {
    private Long funcionarioId;
    private LocalDate data;
    private String justificativa;
    private LocalTime horarioCorrigido;
}
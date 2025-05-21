package dio.controledeponto.dto;

import dio.controledeponto.model.PunchType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistroPontoInputDTO {
    private Long funcionarioId;
    private LocalDateTime dataHora;
    private PunchType tipo;
}
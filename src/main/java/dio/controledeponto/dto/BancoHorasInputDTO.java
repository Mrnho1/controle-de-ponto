package dio.controledeponto.dto;

import lombok.Data;
import java.time.Duration;

@Data
public class BancoHorasInputDTO {
    private Long funcionarioId;
    private Duration horasExcedentes;
    private Duration horasFaltantes;
    private Duration saldo;
}

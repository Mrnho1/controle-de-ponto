package dio.controledeponto.dto;

import dio.controledeponto.model.BancoHoras;
import lombok.Data;

import java.time.Duration;

@Data
public class BancoHorasOutputDTO {
    private Long id;
    private Long funcionarioId;
    private Duration horasExcedentes;
    private Duration horasFaltantes;
    private Duration saldo;

    public BancoHorasOutputDTO(BancoHoras bh) {
        this.id = bh.getId();
        this.funcionarioId = bh.getFuncionario().getId();
        this.horasExcedentes = bh.getHorasExcedentes();
        this.horasFaltantes = bh.getHorasFaltantes();
        this.saldo = bh.getSaldo();
    }
}

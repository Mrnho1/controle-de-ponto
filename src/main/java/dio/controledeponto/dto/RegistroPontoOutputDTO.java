package dio.controledeponto.dto;

import dio.controledeponto.model.RegistroPonto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistroPontoOutputDTO {
    private Long id;
    private Long funcionarioId;
    private LocalDateTime dataHora;
    private String tipo;

    public RegistroPontoOutputDTO(RegistroPonto registro) {
        this.id = registro.getId();
        this.funcionarioId = registro.getFuncionario().getId();
        this.dataHora = registro.getDataHora();
        this.tipo = registro.getTipo().name();
    }
}
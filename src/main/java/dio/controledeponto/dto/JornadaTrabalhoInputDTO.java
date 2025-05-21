package dio.controledeponto.dto;


import lombok.Data;
import java.time.LocalTime;

@Data
public class JornadaTrabalhoInputDTO {
    private String descricao;
    private LocalTime horarioEntrada;
    private LocalTime horarioSaida;
    private LocalTime intervalo;
}
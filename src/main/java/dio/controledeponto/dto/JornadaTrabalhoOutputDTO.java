package dio.controledeponto.dto;

import dio.controledeponto.model.JornadaTrabalho;
import lombok.Data;

import java.time.LocalTime;

@Data
public class JornadaTrabalhoOutputDTO {
    private Long id;
    private String descricao;
    private LocalTime horarioEntrada;
    private LocalTime horarioSaida;
    private LocalTime intervalo;

    public JornadaTrabalhoOutputDTO(JornadaTrabalho jt) {
        this.id = jt.getId();
        this.descricao = jt.getDescricao();
        this.horarioEntrada = jt.getHorarioEntrada();
        this.horarioSaida = jt.getHorarioSaida();
        this.intervalo = jt.getIntervalo();
    }
}
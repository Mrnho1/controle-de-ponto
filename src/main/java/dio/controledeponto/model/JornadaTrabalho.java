package dio.controledeponto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class JornadaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private LocalTime horarioEntrada;
    private LocalTime horarioSaida;
    private LocalTime intervalo;

    @OneToMany(mappedBy = "jornadaTrabalho", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;
}

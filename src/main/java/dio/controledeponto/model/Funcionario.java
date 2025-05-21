package dio.controledeponto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String cargo;
    private LocalDate dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "jornada_trabalho_id")
    private JornadaTrabalho jornadaTrabalho;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<RegistroPonto> registros;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<BancoHoras> bancoHoras;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<AjusteManual> ajustes;
}

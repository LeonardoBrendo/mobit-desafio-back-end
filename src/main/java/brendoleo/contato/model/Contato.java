package brendoleo.contato.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @Column(nullable = false, length = 100)
    @NotEmpty
    @NotNull
    private String nome;
    
    @Column(nullable = false, length = 100)
    @NotEmpty
    @NotNull
    private String sobreNome;

    @Column(nullable = false, unique = true, length = 11)
    @NotEmpty
    @NotNull
    @CPF
    private String cpf;
    
    @Column(nullable = false, unique = true, length = 100)
    @NotNull
    @NotEmpty
    @Email
    private String email;
    
    @Column
    private String endereco;
    
    @Column
    private String telefone;

}   

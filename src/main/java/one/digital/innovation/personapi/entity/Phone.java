package one.digital.innovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity

@Data //get e set
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera id de forma incremental
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false) //obrigatório
    private PhoneType type;
    @Column(nullable = false) //obrigatório
    private String number;
}

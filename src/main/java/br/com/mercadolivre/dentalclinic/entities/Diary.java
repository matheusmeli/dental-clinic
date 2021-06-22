package br.com.mercadolivre.dentalclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diarys")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diary")
    private Integer id;

    private LocalDateTime startTime;
    private LocalDateTime endingTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dentist", referencedColumnName = "id_dentist")
    private Dentist dentist;

    @OneToMany(mappedBy = "diary")
    private Set<Turn> turns;
}

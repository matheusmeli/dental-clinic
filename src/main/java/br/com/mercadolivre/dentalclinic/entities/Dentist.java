package br.com.mercadolivre.dentalclinic.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentist")
    private Integer id;

    @Embedded
    private PersonData personData;

    private String codeMp;

    @OneToOne(mappedBy = "dentist")
    private Diary diary;
}

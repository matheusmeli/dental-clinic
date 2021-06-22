package br.com.mercadolivre.dentalclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Embeddable
public class PersonData {

    @Column(name = "name")
    private String firstName;

    private String lastName;
    private String dni;
    private LocalDate birthDate;
    private String phone;
    private String email;
}

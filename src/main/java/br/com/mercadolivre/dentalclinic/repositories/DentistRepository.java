package br.com.mercadolivre.dentalclinic.repositories;

import br.com.mercadolivre.dentalclinic.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}

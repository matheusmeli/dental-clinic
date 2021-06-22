package br.com.mercadolivre.dentalclinic.repositories;

import br.com.mercadolivre.dentalclinic.entities.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {
}

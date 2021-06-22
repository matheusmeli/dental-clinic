package br.com.mercadolivre.dentalclinic;

import br.com.mercadolivre.dentalclinic.entities.Dentist;
import br.com.mercadolivre.dentalclinic.entities.Diary;
import br.com.mercadolivre.dentalclinic.entities.PersonData;
import br.com.mercadolivre.dentalclinic.repositories.DentistRepository;
import br.com.mercadolivre.dentalclinic.repositories.DiaryRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

@SpringBootApplication
public class DentalClinicApplication implements CommandLineRunner {

    private final DiaryRepository diaryRepository;
    private final DentistRepository dentistRepository;

    public DentalClinicApplication(DiaryRepository diaryRepository, DentistRepository dentistRepository) {
        this.diaryRepository = diaryRepository;
        this.dentistRepository = dentistRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DentalClinicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("pt-BR"));

        Dentist dentist1 = Dentist.builder()
                .personData(PersonData.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .birthDate(faker.date().birthday(20, 30).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                        .dni("" + faker.number().randomNumber())
                        .email("email@gmail.com")
                        .phone(faker.phoneNumber().cellPhone())
                        .build())
                .codeMp("" + faker.number().randomNumber())
                .build();



        System.out.println(dentist1.getPersonData().getBirthDate());
        System.out.println(dentist1);

        Diary diary1 = new Diary(null, LocalDateTime.now().minusHours(8), LocalDateTime.now(), dentist1, null);

        diaryRepository.save(diary1);
        dentistRepository.save(dentist1);
    }
}

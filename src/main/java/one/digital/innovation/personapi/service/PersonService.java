package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.Person;
import one.digital.innovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;
    @Autowired //injeção de dependencia - no construtor facilita criação de testes unitários
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = this.personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

}

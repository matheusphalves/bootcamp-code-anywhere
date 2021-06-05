package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.PersonDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.Person;
import one.digital.innovation.personapi.exception.PersonNotFoundException;
import one.digital.innovation.personapi.mapper.PersonMapper;
import one.digital.innovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired //injeção de dependencia - no construtor facilita criação de testes unitários
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = this.personMapper.toModel(personDTO);
        Person savedPerson = this.personRepository.save(personToSave);
        return getMessageResponseDTO("Created", String.valueOf(savedPerson.getId()));
    }

    public List<PersonDTO> listAll() {

        List<Person> allPeople = this.personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toModel)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = this.verifyIfExists(id);
        return personMapper.toModel(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        this.verifyIfExists(id);
        this.personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
       this.verifyIfExists(id);
       this.delete(id); //precisa?
        Person personToUpdate = this.personMapper.toModel(personDTO);
        Person updatedPerson = this.personRepository.save(personToUpdate);
        return this.getMessageResponseDTO("Updated", String.valueOf(updatedPerson.getId()));

    }

    private MessageResponseDTO getMessageResponseDTO(String message, String id) {
        return MessageResponseDTO
                .builder()
                .message( message + " person with ID " + id)
                .build();
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return this.personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

}

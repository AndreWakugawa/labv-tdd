import org.junit.jupiter.api.Test;
import tdd.ex2.Email;
import tdd.ex2.Person;
import tdd.ex2.PersonDAO;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDAOTest {
        private final PersonDAO dao = new PersonDAO();

    @Test
    void getId_ValidEmail_ReturnsId() {
        Email email = new Email(1, "test@test.com");
        assertEquals(1, email.getId());
    }

    @Test
    void getId_ValidPerson_ReturnsId() {
        Person person = new Person();
        person.setId(1);
        assertEquals(1, person.getId());
    }

    @Test
    void isValidToInclude_ValidPerson_ReturnsEmptyList() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);
        person.setEmails(List.of(new Email(1, "joao@example.com")));

        assertTrue(dao.isValidToInclude(person).isEmpty());
    }

    @Test
    void isValidToInclude_InvalidName_ReturnsError() {
        Person person = new Person();
        person.setName("João");
        person.setAge(30);
        person.setEmails(List.of(new Email(1, "joao@example.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("O nome deve ter pelo menos 2 partes e conter apenas letras."));
    }

    @Test
    void isValidToInclude_NullName_ReturnsError() {
        Person person = new Person();
        person.setName(null);
        person.setAge(30);
        person.setEmails(List.of(new Email(1, "joao@example.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("O nome deve ter pelo menos 2 partes e conter apenas letras."));
    }

    @Test
    void isValidToInclude_AgeZero_ReturnsError() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(0);
        person.setEmails(List.of(new Email(1, "joao@example.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("A idade deve estar entre 1 e 200."));
    }

    @Test
    void isValidToInclude_AgeAboveTwoHundred_ReturnsError() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(201);
        person.setEmails(List.of(new Email(1, "joao@example.com")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("A idade deve estar entre 1 e 200."));
    }

    @Test
    void isValidToInclude_MaxAge_ReturnsEmptyList() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(200);
        person.setEmails(List.of(new Email(1, "joao@example.com")));

        assertTrue(dao.isValidToInclude(person).isEmpty());
    }

    @Test
    void isValidToInclude_NoEmails_ReturnsError() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);
        person.setEmails(Collections.emptyList());

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Pelo menos um e-mail deve ser associado."));
    }

    @Test
    void isValidToInclude_NullEmails_ReturnsError() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);
        person.setEmails(null);

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Pelo menos um e-mail deve ser associado."));
    }

    @Test
    void isValidToInclude_InvalidEmailFormat_ReturnsError() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);
        person.setEmails(List.of(new Email(1, "joao@example")));

        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("O e-mail deve estar no formato '_____@____._____'."));
    }

    @Test
    void save_Person_DoesNotThrowException() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);
        person.setEmails(List.of(new Email(1, "joao@example.com")));

        // Just verify the method can be called without throwing exceptions
        assertDoesNotThrow(() -> dao.save(person));
    }
}

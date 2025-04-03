import org.junit.jupiter.api.Test;
import tdd.ex2.Email;
import tdd.ex2.Person;
import tdd.ex2.PersonDAO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonDAOTest {
        private final PersonDAO dao = new PersonDAO();

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
        void isValidToInclude_InvalidAge_ReturnsError() {
            Person person = new Person();
            person.setName("João Silva");
            person.setAge(0);
            person.setEmails(List.of(new Email(1, "joao@example.com")));

            List<String> errors = dao.isValidToInclude(person);
            assertTrue(errors.contains("A idade deve estar entre 1 e 200."));
        }

        @Test
        void isValidToInclude_NoEmails_ReturnsError() {
            Person person = new Person();
            person.setName("João Silva");
            person.setAge(30);
            person.setEmails(List.of());

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
}

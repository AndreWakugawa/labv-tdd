package tdd.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonDAO {
    public void save(Person p) {
    }

    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        // Validação do nome (2 partes, apenas letras)
        if (p.getName() == null || !p.getName().matches("^[A-Za-zÀ-ú]+(?: [A-Za-zÀ-ú]+)+$")) {
            errors.add("O nome deve ter pelo menos 2 partes e conter apenas letras.");
        }

        // Validação da idade (1-200)
        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("A idade deve estar entre 1 e 200.");
        }

        // Validação de e-mails (pelo menos 1 e formato válido)
        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            errors.add("Pelo menos um e-mail deve ser associado.");
        } else {
            Pattern emailPattern = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");
            for (Email email : p.getEmails()) {
                if (!emailPattern.matcher(email.getName()).matches()) {
                    errors.add("O e-mail deve estar no formato '_____@____._____'.");
                    break;
                }
            }
        }

        return errors;
    }
}
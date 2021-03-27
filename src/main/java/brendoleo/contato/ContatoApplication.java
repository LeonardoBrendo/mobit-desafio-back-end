package brendoleo.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brendoleo.contato.model.Contato;
import brendoleo.contato.repository.ContatoRepository;

@SpringBootApplication
public class ContatoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContatoApplication.class, args);
    }
}

package ag.agriconnectUtilisateur;

import ag.agriconnectUtilisateur.Entities.Utilisateur;
import ag.agriconnectUtilisateur.Repositories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AgriconnectUtilisateurApplication implements CommandLineRunner {

    private final UtilisateurRepository utilisateurRepository;

    public AgriconnectUtilisateurApplication(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AgriconnectUtilisateurApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Utilisateur u1 = new Utilisateur();
        u1.setNom("Billard");
        u1.setPrenom("Martin");

        Utilisateur u2 = new Utilisateur();
        u2.setNom("Navaud");
        u2.setPrenom("Paul-Arthur");

        Utilisateur u3 = new Utilisateur();
        u3.setNom("Tixier");
        u3.setPrenom("Eliott");

        List<Utilisateur> utilisateurs = Arrays.asList(u1, u2, u3);
        utilisateurRepository.saveAll(utilisateurs);
    }
}

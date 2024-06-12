package ag.agriconnectUtilisateur.Services;

import ag.agriconnectUtilisateur.Entities.Utilisateur;
import ag.agriconnectUtilisateur.Exceptions.UtilisateurNotFoundException;
import ag.agriconnectUtilisateur.Repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur save(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur update(Long id, Utilisateur updatedUtilisateur) throws UtilisateurNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(UtilisateurNotFoundException::new);
        utilisateur.setNom(updatedUtilisateur.getNom());
        utilisateur.setPrenom(updatedUtilisateur.getPrenom());
        // Mettez à jour ici d'autres champs si nécessaire
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateur(long idUtilisateur) throws UtilisateurNotFoundException {
        return utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(UtilisateurNotFoundException::new);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
}

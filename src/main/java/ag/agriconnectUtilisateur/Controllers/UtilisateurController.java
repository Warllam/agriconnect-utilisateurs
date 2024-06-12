package ag.agriconnectUtilisateur.Controllers;

import ag.agriconnectUtilisateur.Entities.Utilisateur;
import ag.agriconnectUtilisateur.Exceptions.UtilisateurNotFoundException;
import ag.agriconnectUtilisateur.Services.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Utilisateur save(@Valid @RequestBody Utilisateur utilisateur){
        return utilisateurService.save(utilisateur);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Utilisateur update(@PathVariable Long id, @Valid @RequestBody Utilisateur utilisateur) throws UtilisateurNotFoundException {
        return utilisateurService.update(id, utilisateur);
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateur(@PathVariable Long id) throws UtilisateurNotFoundException {
        return utilisateurService.getUtilisateur(id);
    }

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @ExceptionHandler(UtilisateurNotFoundException.class)
    public ResponseEntity<String> handleUtilisateurNotFoundException(UtilisateurNotFoundException e){
        return new ResponseEntity<>("Utilisateur non trouvé: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

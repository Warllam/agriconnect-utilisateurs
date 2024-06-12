package ag.agriconnectUtilisateur.Exceptions;

public class UtilisateurNotFoundException extends Exception{
    public UtilisateurNotFoundException(){
        super("Utilisateur non trouvé");
    }
}

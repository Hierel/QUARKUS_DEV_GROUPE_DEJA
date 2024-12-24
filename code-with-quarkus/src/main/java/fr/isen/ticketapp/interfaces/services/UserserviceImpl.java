package fr.isen.ticketapp.interfaces.services;

import fr.isen.ticketapp.interfaces.models.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserserviceImpl implements Userservice {
    // Simule une base de données en mémoire
    private final List<UserModel> userDatabase = new ArrayList<>();
    private int currentId = 1; // Simule un auto-increment pour les IDs

    /**
     * Récupère tous les utilisateurs.
     *
     * @return une liste de tous les utilisateurs
     */
    @Override
    public List<UserModel> getAllUser() {
        return new ArrayList<>(userDatabase); // Retourne une copie pour éviter des modifications externes
    }

    /**
     * Met à jour un utilisateur existant.
     *
     * @param userModel l'utilisateur à mettre à jour
     */
    @Override
    public void updateUser(UserModel userModel) {
        Optional<UserModel> existingUser = userDatabase.stream()
                .filter(user -> user.id == userModel.id)
                .findFirst();

        if (existingUser.isPresent()) {
            UserModel userToUpdate = existingUser.get();
            userToUpdate.nom = userModel.nom;
            userToUpdate.email = userModel.email;
            // Ajoutez ici d'autres champs à mettre à jour si nécessaire
        } else {
            throw new IllegalArgumentException("Utilisateur non trouvé avec l'ID : " + userModel.id);
        }
    }

    /**
     * Ajoute un nouvel utilisateur.
     *
     * @param userModel l'utilisateur à ajouter
     * @return l'utilisateur ajouté avec son ID généré
     */
    @Override
    public UserModel addUser(UserModel userModel) {
        userModel.id++; // Assigne un nouvel ID unique
        userDatabase.add(userModel);
        return userModel;
    }

    /**
     * Supprime un utilisateur par son ID.
     *
     * @param id l'ID de l'utilisateur à supprimer
     */
    @Override
    public void removeUser(int id) {
        userDatabase.removeIf(user -> user.id == id);
    }

    /**
     * Récupère un utilisateur par son ID.
     *
     * @param id l'ID de l'utilisateur
     * @return l'utilisateur correspondant ou null s'il n'existe pas
     */
    @Override
    public UserModel getOneUser(int id) {
        return userDatabase.stream()
                .filter(user -> user.id == id)
                .findFirst()
                .orElse(null);
    }
}

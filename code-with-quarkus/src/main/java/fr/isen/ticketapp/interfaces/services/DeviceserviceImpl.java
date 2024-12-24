package fr.isen.ticketapp.interfaces.services;

import fr.isen.ticketapp.interfaces.models.DeviceModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeviceserviceImpl implements Deviceservice {

    private final List<DeviceModel> deviceDatabase = new ArrayList<>();


    /**
     * Récupère tous les appareils.
     *
     * @return une liste de tous les appareils
     */
    @Override
    public List<DeviceModel> getAllDevice() {
        return new ArrayList<>(deviceDatabase); // Retourne une copie pour éviter des modifications externes
    }

    /**
     * Met à jour un appareil existant.
     *
     * @param deviceModel l'appareil à mettre à jour
     */
    @Override
    public void updateDevice(DeviceModel deviceModel) {
        Optional<DeviceModel> existingDevice = deviceDatabase.stream()
                .filter(device -> device.id == deviceModel.id)
                .findFirst();

        if (existingDevice.isPresent()) {
            DeviceModel deviceToUpdate = existingDevice.get();
            deviceToUpdate.etat = deviceModel.etat;
            deviceToUpdate.configuration = deviceModel.configuration;
            deviceToUpdate.id_user = deviceModel.id_user;
        } else {
            throw new IllegalArgumentException("Appareil non trouvé avec l'ID : " + deviceModel.id);
        }
    }

    /**
     * Supprime un appareil par son ID.
     *
     * @param id l'ID de l'appareil à supprimer
     */
    @Override
    public void removeDevice(int id) {
        deviceDatabase.removeIf(device -> device.id == id);
    }

    /**
     * Ajoute un nouvel appareil.
     *
     * @param deviceModel l'appareil à ajouter
     * @return l'appareil ajouté avec son ID généré
     */
    @Override
    public DeviceModel addDevice(DeviceModel deviceModel) {
        deviceModel.id++; // Assigne un nouvel ID unique
        deviceDatabase.add(deviceModel);
        return deviceModel;
    }

    /**
     * Récupère un appareil par son ID.
     *
     * @param id l'ID de l'appareil
     * @return l'appareil correspondant ou null s'il n'existe pas
     */
    @Override
    public DeviceModel getOneDevice(int id) {
        return deviceDatabase.stream()
                .filter(device -> device.id == id)
                .findFirst()
                .orElse(null);
    }
}

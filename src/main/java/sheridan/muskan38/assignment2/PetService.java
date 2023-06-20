package sheridan.muskan38.assignment2;

import java.util.List;
import java.util.Optional;

public interface PetService {
    List<Pet> getAllPets();

    Optional<Pet> getPetById(Long id);

    Pet savePet(Pet pet);

    void deletePet(Long id);}
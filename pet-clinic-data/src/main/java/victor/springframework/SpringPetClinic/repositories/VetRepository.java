package victor.springframework.SpringPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import victor.springframework.SpringPetClinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}

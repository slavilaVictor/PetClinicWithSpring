package victor.springframework.SpringPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import victor.springframework.SpringPetClinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}

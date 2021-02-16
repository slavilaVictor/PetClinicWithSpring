package victor.springframework.SpringPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import victor.springframework.SpringPetClinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

package victor.springframework.SpringPetClinic.services;

import victor.springframework.SpringPetClinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}

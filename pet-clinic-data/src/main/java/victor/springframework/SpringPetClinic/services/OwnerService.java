package victor.springframework.SpringPetClinic.services;

import victor.springframework.SpringPetClinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}

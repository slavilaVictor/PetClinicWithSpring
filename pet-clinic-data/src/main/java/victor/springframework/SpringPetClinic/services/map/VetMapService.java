package victor.springframework.SpringPetClinic.services.map;

import org.springframework.stereotype.Service;
import victor.springframework.SpringPetClinic.model.Speciality;
import victor.springframework.SpringPetClinic.model.Vet;
import victor.springframework.SpringPetClinic.services.SpecialtyService;
import victor.springframework.SpringPetClinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach( speciality -> {
                if(speciality.getId() == null){
                    // It will create an ID on savedSpecialty
                    Speciality savedSpecialty = specialtyService.save(speciality);
                    // I make sure that the specialty in the list does that id value
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}

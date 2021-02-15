package victor.springframework.SpringPetClinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import victor.springframework.SpringPetClinic.model.Owner;
import victor.springframework.SpringPetClinic.model.PetType;
import victor.springframework.SpringPetClinic.model.Vet;
import victor.springframework.SpringPetClinic.services.OwnerService;
import victor.springframework.SpringPetClinic.services.PetTypeService;
import victor.springframework.SpringPetClinic.services.VetService;

// By saying that this is a Component, it becomes a Spring Bean and it is registered in the Spring Context
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, OwnerService ownerService1, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService1;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}

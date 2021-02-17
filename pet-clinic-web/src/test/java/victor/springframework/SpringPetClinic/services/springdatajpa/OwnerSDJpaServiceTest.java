package victor.springframework.SpringPetClinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import victor.springframework.SpringPetClinic.model.Owner;
import victor.springframework.SpringPetClinic.repositories.OwnerRepository;
import victor.springframework.SpringPetClinic.repositories.PetRepository;
import victor.springframework.SpringPetClinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        // When I call the method "findByLasName" with any parameter, make sure you return back an owner
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        // Create the object using a mock -> I cal "findByLasName" here, so I am sure that it will return an owner because of the above line of code
        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        // I verify the invocation of the mock
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        // I build a HashSet and add two owners
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        // I am using mockito to say when "findAll" is called, I want to return that set of owners
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        // I invoke the mock here, when I call "findAll"
        Set<Owner> owners = service.findAll();

        // I expect that the HashSet is not null and has a size of 2
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        // I return an Optional here because "findById" in OwnerSDJpaService return either the owner, either null
         when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

         Owner owner = service.findById(1L);

         assertNotNull(owner);
    }

    // Make another test when I do not find that owner with the given id
    @Test
    void findByIdNotFound() {
        // I return an Optional here because "findById" in OwnerSDJpaService return either the owner, either null
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        // I'm expecting to return null
        assertNull(owner);
    }

    @Test
    void save() {
        // Create an owner to save
        Owner ownerToSave = Owner.builder().id(1L).build();

        // When I call "save" I want to return the owner
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        // I call the method
        Owner savedOwner = service.save(ownerToSave);

        // I'm expecting to be not null
        assertNotNull(savedOwner);

        // I can verify if that method was called - optional
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        // When I delete, I return nothing -> that is a good example of using "verify"
        // I verify that the method "delete" is called
        // default -> called 1 times
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}
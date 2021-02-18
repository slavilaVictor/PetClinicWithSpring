package victor.springframework.SpringPetClinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import victor.springframework.SpringPetClinic.model.Owner;
import victor.springframework.SpringPetClinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock // This will be injected into controller of type OwnerController
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        // I initialize a mock environment for my controller in order to test a lot of interactions with it
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        //mockMvc.perform(get("/owners")).andExpect(status().is(200));
        // OR
        // mockMvc.perform(get("/owners")).andExpect(status().isOk());
        // OR MORE COMPLEX
        mockMvc.perform(get("/owners")).andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2))); // 2 because I added two owners.  If I put in here 4, the test will fail
    }

    // To test another path
    @Test
    void listOwnersByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        //mockMvc.perform(get("/owners")).andExpect(status().is(200));
        // OR
        // mockMvc.perform(get("/owners")).andExpect(status().isOk());
        // OR MORE COMPLEX
        mockMvc.perform(get("/owners/index")).andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2))); // 2 because I added two owners.  If I put in here 4, the test will fail
    }

    @Test
    void findOwners() throws Exception {

        mockMvc.perform(get("/owners/find")).andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        // It is deprecated -> verifyZeroInteractions(ownerService);   -> I am looking for interactions
    }
}
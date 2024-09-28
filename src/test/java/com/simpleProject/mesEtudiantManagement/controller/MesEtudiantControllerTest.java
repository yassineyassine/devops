package com.simpleProject.mesEtudiantManagement.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.simpleProject.mesEtudiantManagement.model.MesEtudiantModule;
import com.simpleProject.mesEtudiantManagement.service.MesEtudiantService;

@SpringBootTest
@AutoConfigureMockMvc
public class MesEtudiantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MesEtudiantService mesEtudiantService;

    @Test
    void testCreateNewTajilProduct() {

    }

    @Test
    void testDeleteTajilProductById() {

    }

    @SuppressWarnings("null")
    @Test
    void testGetAllTajilProducts() throws Exception {
        //Inisiator Data
        UUID id = UUID.randomUUID();
        MesEtudiantModule tajilProducts =
            new MesEtudiantModule(id, "Bakwan", "Gorengan yang terbuat dari tepung dan sayur yang berbebtuk pipih", "Gorengan", 1000, 9);
        List<MesEtudiantModule> productList = Arrays.asList(tajilProducts);

        // Set expectations on the mock service
        when(mesEtudiantService.getAllTajilProduct()).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/mesEtudiant")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].etudiantFirstName").value("Bakwan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].etudiantLastName").value("Gorengan yang terbuat dari tepung dan sayur yang berbebtuk pipih"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].etudiantEmail").value("Gorengan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].etudiantCnssEtab").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].etudiantCIN").value(9));
    }

    @Test
    void testGetTajilProductById() {

    }

    @Test
    void testUpdateTajilProductById() {

    }
}

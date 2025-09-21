package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.entity.Dentist;
import com.dh.DentalClinicMVC.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DentistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDentistService dentistService;

    @Autowired
    private ObjectMapper objectMapper;

    private Dentist testDentist;

    @BeforeEach
    void setUp() {
        testDentist = new Dentist();
        testDentist.setId(1L);
        testDentist.setName("John");
        testDentist.setLastName("Doe");
        testDentist.setRegistration(12345);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void createDentist_Success() throws Exception {
        when(dentistService.save(any(Dentist.class))).thenReturn(testDentist);

        mockMvc.perform(post("/odontologos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testDentist)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.registration").value(12345));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void getDentistById_Success() throws Exception {
        when(dentistService.findById(1L)).thenReturn(Optional.of(testDentist));

        mockMvc.perform(get("/odontologos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void getAllDentists_Success() throws Exception {
        when(dentistService.findAll()).thenReturn(Arrays.asList(testDentist));

        mockMvc.perform(get("/odontologos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void updateDentist_Success() throws Exception {
        when(dentistService.findById(testDentist.getId())).thenReturn(Optional.of(testDentist));

        mockMvc.perform(put("/odontologos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testDentist)))
                .andExpect(status().isOk())
                .andExpect(content().string("Se actualizó el odontólogo con nombre: John"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void deleteDentist_Success() throws Exception {
        mockMvc.perform(delete("/odontologos/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Se eliminó el odontólogo co id: 1"));
    }

    @Test
    void unauthorizedAccess() throws Exception {
        mockMvc.perform(get("/odontologos"))
                .andExpect(status().isForbidden());
    }
}
package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.entity.Patient;
import com.dh.DentalClinicMVC.entity.Address;
import com.dh.DentalClinicMVC.service.IPatientService;
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

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPatientService patientService;

    @Autowired
    private ObjectMapper objectMapper;

    private Patient testPatient;

    @BeforeEach
    void setUp() {
        Address address = new Address();
        address.setStreet("Test Street");
        address.setNumber(123);
        address.setLocation("Test City");
        address.setProvince("Test Province");

        testPatient = new Patient();
        testPatient.setId(1L);
        testPatient.setName("Jane");
        testPatient.setLastName("Doe");
        testPatient.setEmail("jane.doe@test.com");
        testPatient.setCardIdentity(12345678);
        testPatient.setAdmissionOfDate(LocalDate.now());
        testPatient.setAddress(address);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void createPatient_Success() throws Exception {
        when(patientService.save(any(Patient.class))).thenReturn(testPatient);

        mockMvc.perform(post("/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testPatient)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.cardIdentity").value(12345678));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void getPatientById_Success() throws Exception {
        when(patientService.findById(1L)).thenReturn(Optional.of(testPatient));

        mockMvc.perform(get("/pacientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void getAllPatients_Success() throws Exception {
        when(patientService.findAll()).thenReturn(Arrays.asList(testPatient));

        mockMvc.perform(get("/pacientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Jane"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void updatePatient_Success() throws Exception {
        mockMvc.perform(put("/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testPatient)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void deletePatient_Success() throws Exception {
        mockMvc.perform(delete("/pacientes/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Se eliminó el paciente con id: 1"));
    }

    @Test
    void unauthorizedAccess() throws Exception {
        mockMvc.perform(get("/pacientes"))
                .andExpect(status().isForbidden());
    }
}
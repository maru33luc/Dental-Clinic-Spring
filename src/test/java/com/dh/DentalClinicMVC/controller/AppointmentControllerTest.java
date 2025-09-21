package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.dto.AppointmentDTO;
import com.dh.DentalClinicMVC.entity.Dentist;
import com.dh.DentalClinicMVC.entity.Patient;
import com.dh.DentalClinicMVC.service.IAppointmentService;
import com.dh.DentalClinicMVC.service.IDentistService;
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

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAppointmentService appointmentService;

    @MockBean
    private IDentistService dentistService;

    @MockBean
    private IPatientService patientService;

    @Autowired
    private ObjectMapper objectMapper;

    private AppointmentDTO testAppointmentDTO;
    private Dentist testDentist;
    private Patient testPatient;

    @BeforeEach
    void setUp() {
        testDentist = new Dentist();
        testDentist.setId(1L);
        testDentist.setName("John");
        testDentist.setLastName("Doe");
        testDentist.setRegistration(12345);

        testPatient = new Patient();
        testPatient.setId(1L);
        testPatient.setName("Jane");
        testPatient.setLastName("Doe");
        testPatient.setCardIdentity(12345678);

        testAppointmentDTO = new AppointmentDTO();
        testAppointmentDTO.setId(1L);
        testAppointmentDTO.setDentist_id(1L);
        testAppointmentDTO.setPatient_id(1L);
        testAppointmentDTO.setDate("2025-09-21");
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void createAppointment_Success() throws Exception {
        when(dentistService.findById(1L)).thenReturn(Optional.of(testDentist));
        when(patientService.findById(1L)).thenReturn(Optional.of(testPatient));
        when(appointmentService.save(any(AppointmentDTO.class))).thenReturn(testAppointmentDTO);

        mockMvc.perform(post("/turnos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testAppointmentDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.dentist_id").value(1))
                .andExpect(jsonPath("$.patient_id").value(1));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void createAppointment_BadRequest() throws Exception {
        when(dentistService.findById(1L)).thenReturn(Optional.empty());
        when(patientService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(post("/turnos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testAppointmentDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void getAppointmentById_Success() throws Exception {
        when(appointmentService.findById(1L)).thenReturn(Optional.of(testAppointmentDTO));

        mockMvc.perform(get("/turnos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.dentist_id").value(1))
                .andExpect(jsonPath("$.patient_id").value(1));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void getAppointmentById_NotFound() throws Exception {
        when(appointmentService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/turnos/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void getAllAppointments_Success() throws Exception {
        when(appointmentService.findAll()).thenReturn(Arrays.asList(testAppointmentDTO));

        mockMvc.perform(get("/turnos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].dentist_id").value(1))
                .andExpect(jsonPath("$[0].patient_id").value(1));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void updateAppointment_Success() throws Exception {
        when(dentistService.findById(1L)).thenReturn(Optional.of(testDentist));
        when(patientService.findById(1L)).thenReturn(Optional.of(testPatient));
        when(appointmentService.update(any(AppointmentDTO.class))).thenReturn(testAppointmentDTO);

        mockMvc.perform(put("/turnos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testAppointmentDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.dentist_id").value(1))
                .andExpect(jsonPath("$.patient_id").value(1));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void updateAppointment_BadRequest() throws Exception {
        when(dentistService.findById(1L)).thenReturn(Optional.empty());
        when(patientService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(put("/turnos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testAppointmentDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void deleteAppointment_Success() throws Exception {
        mockMvc.perform(delete("/turnos/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Se eliminó el turno con id: 1"));
    }

    @Test
    void unauthorizedAccess() throws Exception {
        mockMvc.perform(get("/turnos"))
                .andExpect(status().isForbidden());
    }
}
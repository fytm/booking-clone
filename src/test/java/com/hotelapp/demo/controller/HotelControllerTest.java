package com.hotelapp.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelapp.demo.dto.CreateHotelDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HotelControllerTest {
    @Autowired private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    String urlTemplate  = "/api/manage/hotels";
    @Test
    void createHotel_withValidPayload() throws Exception {
        //given a request to add a hotel
        CreateHotelDto testHotel = new CreateHotelDto(
                "HotelA",
                "1234 Test Street",
                "+1234567890"
        );

        //when the request is received
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post(urlTemplate)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testHotel));

        // then verify that you can perform the request
        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", notNullValue()));
    }
}
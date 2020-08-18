package com.practice.exercise.infrastructure;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.exercise.infrastructure.configuration.security.ApplicationSecurityConfigMock;
import com.practice.exercise.infrastructure.entity.device.ParamEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import com.practice.exercise.infrastructure.entity.device.DeviceEntity;
import org.junit.Before;
import org.junit.Test;
import com.practice.exercise.ExerciseApplication;
import com.practice.exercise.configuration.H2Datasource;
import com.practice.exercise.infrastructure.repository.device.DeviceJpaRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        ExerciseApplication.class,
        H2Datasource.class,
        ApplicationSecurityConfigMock.class},
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class DeviceControllerTest {

    private static final String URL = "/v1/device";

    @Autowired
    private DeviceJpaRepository deviceJpaRepository;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    private ObjectWriter objectWriter;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @Before
    public void init() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        this.objectWriter = this.objectMapper.writer().withDefaultPrettyPrinter();
    }

    @WithMockUser(username = "Joan")
    @Test
    public void getAllDevices() throws Exception {
        // Arrange
        ParamEntity paramEntity = new ParamEntity(1L, 100,70,99);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTimeFilter = LocalDateTime.parse("2016-01-25T21:34:55", formatter);
        DeviceEntity deviceEntity = deviceJpaRepository
                .save(new DeviceEntity(2L, localDateTimeFilter,
                        "STOPPED", paramEntity));

        // Act
        String response = this.mockMvc.perform(get(URL)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn().getResponse().getContentAsString();

        JSONArray jsonResponse = new JSONArray(response);
        JSONObject jsonDevice = new JSONObject(jsonResponse.get(0).toString());

        // Assert
        Assert.assertNotNull(jsonDevice);
        Assert.assertEquals(2, jsonDevice.getLong("id"));
    }



//    @WithMockUser(username = "Joan")
//    @Test
//    public void testSaveDevice() throws Exception {
//
//        ParamCommand paramCommand = new ParamCommand(101L, 100,70,99);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//        LocalDateTime localDateTimeFilter = LocalDateTime.parse("2016-01-25T21:34:55", formatter);
//
//        DeviceCommand deviceCommand = new DeviceCommand(100L, localDateTimeFilter,
//                "RUNNING", paramCommand);
//
//        String deviceCommandJson = objectWriter.writeValueAsString(deviceCommand);

    //        DeviceEntity foundEntity = deviceJpaRepository.getOne(1L);

//        ResultActions resultActions = this.mockMvc.perform(get(URL));
//
//        String resultAction = this.mockMvc.perform(post(URL)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(deviceCommandJson))
////                        .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
////        ResultActions resultActions = this.mockMvc.perform(post(URL)
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(deviceCommandJson));
//
//        JSONObject json = new JSONObject(resultAction);
//
////        String idDeviceString = this.objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), String.class);
//
//        Assert.assertEquals(3, json.get("id"));
////        Assert.assertEquals(3, Long.parseLong(idDeviceString));
//
//    }

}

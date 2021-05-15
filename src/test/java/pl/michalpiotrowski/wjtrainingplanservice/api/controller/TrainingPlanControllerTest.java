package pl.michalpiotrowski.wjtrainingplanservice.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.michalpiotrowski.wjapispecification.dto.trainingplan.TrainingPlanDayDtoRequest;
import pl.michalpiotrowski.wjapispecification.dto.trainingplan.TrainingPlanDtoRequest;
import pl.michalpiotrowski.wjtrainingplanservice.TrainingPlanTestFixture;
import pl.michalpiotrowski.wjtrainingplanservice.application.service.UserService;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc()
public class TrainingPlanControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UserService userService;

    @Before
    public void setUp() {
        Mockito.when(userService.getCurrentUserName()).thenReturn(TrainingPlanTestFixture.TRAINING_PLAN_USER);
    }

    @Test
    public void createTrainingPlan() throws Exception {
        val result = mockMvc
                .perform(
                        post("/api/v1/training-plans")
                                .content(objectMapper.writeValueAsString(
                                        TrainingPlanDtoRequest.builder()
                                                .name(TrainingPlanTestFixture.TRAINING_PLAN_NAME)
                                                .description(TrainingPlanTestFixture.TRAINING_PLAN_DESCRIPTION)
                                                .days(List.of(TrainingPlanDayDtoRequest.builder().exercisesIds(List.of()).build()))
                                                .build()
                                ))
                                .contentType("application/json")
                )
                .andExpect(status().isOk())
                .andReturn();

    }
}

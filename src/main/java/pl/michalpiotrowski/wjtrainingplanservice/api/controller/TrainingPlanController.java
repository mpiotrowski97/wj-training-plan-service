package pl.michalpiotrowski.wjtrainingplanservice.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michalpiotrowski.wjapispecification.dto.trainingplan.TrainingPlanDtoRequest;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/training-plans")
public class TrainingPlanController {

    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody @Valid TrainingPlanDtoRequest trainingPlanDtoRequest) {
        return ResponseEntity.ok().build();
    }
}

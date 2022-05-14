package com.ogoma.hr_core.boundaries.performance.goals;

import com.ogoma.hr_core.boundaries.performance.goals.entities.GoalType;
import com.ogoma.hr_core.boundaries.performance.goals.requests.GoalTypeRequest;
import com.ogoma.hr_core.boundaries.performance.goals.services.GoalTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/goal-types")
public class GoalTypeController {
    private  final GoalTypeService goalTypeService;
    public GoalTypeController(GoalTypeService goalTypeService) {
        this.goalTypeService = goalTypeService;
    }
    @GetMapping
    public ResponseEntity<?> getGoalTypes(){
        List<GoalType> goalTypeList = this.goalTypeService.getGoalTypes();
        return ResponseEntity.ok(goalTypeList);
    }
    @GetMapping(value = "/{id}")
    public  ResponseEntity<?> getGoalTypeById(@PathVariable  Long id){
        Optional<GoalType> goalType= this.goalTypeService.getGoalTypeById(id);
        return ResponseEntity.of(goalType);
    }

    @PostMapping
    public ResponseEntity<?> createGoalType(@RequestBody @Valid GoalTypeRequest goalTypeRequest){
        GoalType goalType = this.goalTypeService.createGoalType(goalTypeRequest);
        return ResponseEntity.ok(goalType);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateGoalType(@PathVariable Long id, @RequestBody @Valid GoalTypeRequest goalTypeRequest){
        Optional<GoalType> goalType = this.goalTypeService.updateGoalType(id, goalTypeRequest);
        return ResponseEntity.of(goalType);
    }

}

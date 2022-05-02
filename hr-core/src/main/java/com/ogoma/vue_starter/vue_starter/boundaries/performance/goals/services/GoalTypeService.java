package com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.services;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.entities.GoalType;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.repository.GoalTypeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.requests.GoalTypeRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalTypeService {
    private final GoalTypeRepository goalTypeRepository;
    public GoalTypeService(GoalTypeRepository goalTypeRepository) {
        this.goalTypeRepository = goalTypeRepository;
    }
    public List<GoalType>  getGoalTypes(){
       List<GoalType> goalTypes= this.goalTypeRepository.findAll();
       return  goalTypes;
    }

    public Optional<GoalType> getGoalTypeById(Long id){
       Optional<GoalType> goalType= this.goalTypeRepository.findById(id);
       return  goalType;
    }

    public GoalType createGoalType(GoalTypeRequest goalTypeRequest){
        GoalType goalType = new GoalType();
        goalType.setDescription(goalTypeRequest.getDescription());
        goalType.setStatus(goalTypeRequest.getStatus());
        goalType.setName(goalTypeRequest.getName());
        this.goalTypeRepository.save(goalType);
        return  goalType;
    }
    public Optional<GoalType> updateGoalType(Long id, GoalTypeRequest goalTypeRequest){
      Optional<GoalType> goalType= this.goalTypeRepository.findById(id);
      goalType.ifPresent(gt->{
          gt.setName(goalTypeRequest.getName());
          gt.setStatus(goalTypeRequest.getStatus());
          gt.setDescription(goalTypeRequest.getDescription());
          this.goalTypeRepository.save(gt);
      });
      return goalType;
    }
}

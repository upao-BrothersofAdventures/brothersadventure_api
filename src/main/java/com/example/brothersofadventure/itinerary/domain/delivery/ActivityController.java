import com.example.model.Activity;
import com.example.service.ActivityService;
import com.example.dto.ActivityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityDto> createActivity(@Valid @RequestBody ActivityDto activityDto) {
        ActivityDto createdActivity = activityService.createActivity(activityDto);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Long activityId) {
        ActivityDto activityDto = activityService.getActivityById(activityId);
        return new ResponseEntity<>(activityDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ActivityDto>> getAllActivities() {
        List<ActivityDto> activities = activityService.getAllActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @PutMapping("/{activityId}")
    public ResponseEntity<ActivityDto> updateActivity(
            @PathVariable Long activityId,
            @Valid @RequestBody ActivityDto activityDto) {
        ActivityDto updatedActivity = activityService.updateActivity(activityId, activityDto);
        return new ResponseEntity<>(updatedActivity, HttpStatus.OK);
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long activityId) {
        activityService.deleteActivity(activityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Puedes agregar más operaciones según tus requisitos.

}

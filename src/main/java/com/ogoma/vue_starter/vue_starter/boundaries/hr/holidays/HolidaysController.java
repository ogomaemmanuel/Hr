package com.ogoma.vue_starter.vue_starter.boundaries.hr.holidays;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.holidays.entities.Holiday;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services.HolidaysService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HolidaysController {
    private final HolidaysService holidaysService;

    public HolidaysController(HolidaysService holidaysService) {
        this.holidaysService = holidaysService;
    }

    @RequestMapping(value = "api/holidays", method = RequestMethod.GET)
    public ResponseEntity<?> getAllHolidays(PagedDataRequest pagedDataRequest) {
        Pageable pageable = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<Holiday> holidays = this.holidaysService.getAllHolidays(pageable);
        return ResponseEntity.ok(holidays);
    }
    @RequestMapping(value = "api/holidays/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllHoliday(@PathVariable Long id) {
        Holiday holiday = this.holidaysService.getAllHolidayById(id);
        return ResponseEntity.ok(holiday);
    }

    @RequestMapping(value = "api/holidays", method = RequestMethod.POST)
    public ResponseEntity<?> createHoliday(@RequestBody @Valid Holiday holiday) {
        holiday = this.holidaysService.createHoliday(holiday);
        return ResponseEntity.ok(holiday);
    }

    @RequestMapping(value = "api/holidays/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateHoliday(@PathVariable Long id, @RequestBody @Valid Holiday holiday) {
        holiday = this.holidaysService.updateHoliday(id, holiday);
        return ResponseEntity.ok(holiday);
    }

    @RequestMapping(value = "api/holidays/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeHoliday(@PathVariable Long id) {
        this.holidaysService.deleteHoliday(id);
        return ResponseEntity.ok().build();
    }

}

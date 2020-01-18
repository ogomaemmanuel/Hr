package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.holidays.HolidaysRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.holidays.entities.Holiday;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidaysService {
    private final HolidaysRepository holidaysRepository;

    public HolidaysService(HolidaysRepository holidaysRepository) {
        this.holidaysRepository = holidaysRepository;
    }

    public List<Holiday> getAllHolidays() {
        List<Holiday> holidays = this.holidaysRepository.findAll();
        return holidays;
    }

    public Holiday createHoliday(Holiday holiday) {
        holiday = this.holidaysRepository.save(holiday);
        return holiday;
    }

    public Holiday updateHoliday(Long id, Holiday holiday) {
        Holiday dbHoliday = this.holidaysRepository.findById(id).orElse(null);
        dbHoliday.setName(holiday.getName());
        dbHoliday.setDate(holiday.getDate());
        this.holidaysRepository.save(dbHoliday);
        return dbHoliday;
    }

    public void deleteHoliday(Long id) {
        Holiday holiday = this.holidaysRepository.findById(id).orElse(null);
        this.holidaysRepository.delete(holiday);
    }
}

package com.ogoma.hr_core.boundaries.hr.leave_management.services;

import com.ogoma.hr_core.boundaries.hr.holidays.HolidaysRepository;
import com.ogoma.hr_core.boundaries.hr.holidays.entities.Holiday;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    public Page<Holiday> getAllHolidays(Pageable pageable) {
        Page<Holiday> holidays = this.holidaysRepository.findAll(pageable);
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

    public Holiday getAllHolidayById(Long id) {
        Holiday holiday = this.holidaysRepository.findById(id).orElse(null);
        return holiday;
    }

    public ByteArrayOutputStream generateExcelReport() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        List<Holiday> holidayList = this.holidaysRepository.findAll();
        XSSFSheet spreadsheet = (XSSFSheet) workbook.createSheet("Holidays");
        XSSFRow row = spreadsheet.createRow(0);
        XSSFCell cell;
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Date");
        row.createCell(3).setCellValue("Description");
        int rowId = 1;
        for (Holiday holiday : holidayList) {
            row = spreadsheet.createRow(rowId++);
            cell = row.createCell(1);
            cell.setCellValue(holiday.getName());
            cell = row.createCell(2);
            cell.setCellValue(holiday.getDate());
            cell = row.createCell(3);
            cell.setCellValue(holiday.getName());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        return byteArrayOutputStream;

    }
}

package com.ogoma.hr_core.boundaries.file_management;

import com.ogoma.hr_core.boundaries.file_management.entities.File;
import com.ogoma.hr_core.boundaries.file_management.query_filters.FileQueryFilter;
import com.ogoma.hr_core.boundaries.file_management.requests.FileCreateRequest;
import com.ogoma.hr_core.boundaries.file_management.services.FilesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/files")
public class FilesController {
    private final FilesService filesService;

    public FilesController(FilesService filesService) {
        this.filesService = filesService;
    }

    @GetMapping
    public ResponseEntity<?> getFiles(FileQueryFilter fileQueryFilter) {
        List<File> files = this.filesService.getFiles(fileQueryFilter);
        return ResponseEntity.ok(files);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getFileById(@PathVariable Long id) {
        Optional<File> file =
                this.filesService.getFileByID(id);
        return ResponseEntity.of(file);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createFileJson(@RequestBody @Valid FileCreateRequest fileCreateRequest) throws Exception {
        File file = this.filesService.createFile(fileCreateRequest);
        return ResponseEntity.ok(file);
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createFile(@Valid FileCreateRequest fileCreateRequest) throws Exception {
        File file = this.filesService.createFile(fileCreateRequest);
        return ResponseEntity.ok(file);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> removeFile(@PathVariable Long id) {
        this.filesService.removeFile(id);
        return ResponseEntity.noContent().build();
    }


}

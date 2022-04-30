package com.ogoma.vue_starter.vue_starter.boundaries.file_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.file_management.entities.File;
import com.ogoma.vue_starter.vue_starter.boundaries.file_management.repositories.FileRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.file_management.requests.FileCreateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.file_management.query_filters.FileQueryFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilesService {
    private final FileRepository fileRepository;

    public FilesService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File createFile(FileCreateRequest fileCreateRequest) throws Exception {
        File file = new File();
        mapToEntity(fileCreateRequest, file);
        return file;
    }


    public Optional<File> getFileByID(Long id) {
        Optional<File> file = this.fileRepository.findById(id);
        return file;
    }

    public List<File> getFiles(FileQueryFilter fileQuery) {
        List<File> files =
                this.fileRepository.findAllByParentId(fileQuery.getParentId());
        return files;
    }

    public Optional<File> updateFile(Long id, FileCreateRequest fileCreateRequest) throws Exception {
        Optional<File> file = this.fileRepository.findById(id);
        file.ifPresent(fi -> {
            try {
                mapToEntity(fileCreateRequest, fi);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return file;
    }

    private void mapToEntity(FileCreateRequest fileCreateRequest, File file) throws Exception {
        file.setName(fileCreateRequest.getName());
        file.setType(fileCreateRequest.getType());
        if (fileCreateRequest.getParentId() != null) {
            File parent = this.fileRepository.getOne(fileCreateRequest.getParentId());
            file.setParent(parent);
        }
    }

    public void removeFile(Long id) {
        Optional<File> file = this.fileRepository.findById(id);
        file.ifPresent(fl -> {
            if (fl.getType() != File.Type.FILE) {
                this.fileRepository.deleteById(id);
                return;
            }

        });

    }
}

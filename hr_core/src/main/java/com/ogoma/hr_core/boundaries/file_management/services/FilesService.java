package com.ogoma.hr_core.boundaries.file_management.services;

import com.ogoma.hr_core.boundaries.documents.services.CloudObjectService;
import com.ogoma.hr_core.boundaries.file_management.entities.File;
import com.ogoma.hr_core.boundaries.file_management.entities.File_;
import com.ogoma.hr_core.boundaries.file_management.repositories.FileRepository;
import com.ogoma.hr_core.boundaries.file_management.requests.FileCreateRequest;
import com.ogoma.hr_core.boundaries.file_management.query_filters.FileQueryFilter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilesService {
    private final FileRepository fileRepository;
    private final CloudObjectService cloudObjectService;

    public FilesService(FileRepository fileRepository, CloudObjectService cloudObjectService) {
        this.fileRepository = fileRepository;
        this.cloudObjectService = cloudObjectService;
    }

    public File createFile(FileCreateRequest fileCreateRequest) throws Exception {
        File file = new File();
        mapToEntity(fileCreateRequest, file);
        if(fileCreateRequest.getType()== File.Type.FILE){
         String fileName=   this.cloudObjectService.createObject("aws-tutorial-ogoma",
                 fileCreateRequest.getAttachment());
         file.setFileUUID(fileName);
        }
        this.fileRepository.save(file);
        return file;
    }


    public Optional<File> getFileByID(Long id) {
        Optional<File> file = this.fileRepository.findById(id);
        return file;
    }

    public List<File> getFiles(FileQueryFilter fileQuery) {
        List<File> files =
                this.fileRepository.findAllByParentId(fileQuery.getParentId(), Sort.by(File_.TYPE).descending().and(Sort.by(File_.CREATED_AT)));
        return files;
    }

    public Optional<File> updateFile(Long id, FileCreateRequest fileCreateRequest) throws Exception {
        Optional<File> file = this.fileRepository.findById(id);
        file.ifPresent(fi -> {
            try {
                mapToEntity(fileCreateRequest, fi);
                this.fileRepository.save(fi);
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
            File parent = this.fileRepository.findById(fileCreateRequest.getParentId()).orElse(null);
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

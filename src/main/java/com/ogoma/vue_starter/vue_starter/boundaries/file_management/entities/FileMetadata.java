package com.ogoma.vue_starter.vue_starter.boundaries.file_management.entities;

import javax.persistence.*;

@Entity
@Table(name = "file_metadata")
public class FileMetadata {
    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "file_id")
    private File file;
    private String extension;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}

package com.example.photo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Entity
@Data
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Lob
    private byte[] photo;

    private String text;
}

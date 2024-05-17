package com.example.App.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PDF {
    @Id
    private Long id_pdf;
    private String pdf_path1;
    private String pdf_path2;
    private String pdf_path3;
}

package com.simpleProject.mesEtudiantManagement.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesEtudiantModule {
    private UUID etudiantId;
    private String etudiantFirstName;
    private String etudiantLastName;
    private String etudiantEmail;
    private Integer etudiantCnssEtab;
    private Integer etudiantCIN;

}

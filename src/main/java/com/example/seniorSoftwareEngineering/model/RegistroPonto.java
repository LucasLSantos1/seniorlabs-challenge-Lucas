package com.example.seniorSoftwareEngineering.model;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroPonto {
    @Getter private LocalDateTime includedAt = LocalDateTime.now();
    @Getter @Setter private int employeeId;
    @Getter @Setter private int employerId;
}

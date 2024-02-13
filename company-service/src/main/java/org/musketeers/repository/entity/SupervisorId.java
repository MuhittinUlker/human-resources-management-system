package org.musketeers.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_supervisorids")
public class SupervisorId {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String supervisorId;
}

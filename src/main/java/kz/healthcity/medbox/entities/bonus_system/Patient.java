package kz.healthcity.medbox.entities.bonus_system;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bonus_patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "biz_box_patient_id")
    private Long bizBoxPatientId;

    @Column(name = "accumulated_amount")
    private BigDecimal accumulatedAmount;

    @CreationTimestamp
    @Column(name = "date_create",updatable = false)
    private Timestamp dateCreate;

    @UpdateTimestamp
    @Column(name = "date_update")
    private Timestamp dateUpdate;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discounts;

    @OneToMany(mappedBy = "patients",fetch = FetchType.LAZY)
    List<Transaction> transactions;




}

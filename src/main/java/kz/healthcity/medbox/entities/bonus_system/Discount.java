package kz.healthcity.medbox.entities.bonus_system;

import lombok.*;
import org.hibernate.annotations.Cascade;
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
@Table(name = "bonus_discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "start_bonus_sum")
    private BigDecimal startBonusSum;

    @Column(name = "rate")
    private Byte rate;

    @Column(name = "is_active")
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "date_create",updatable = false)
    private Timestamp dateCreate;

    @UpdateTimestamp
    @Column(name = "date_update")
    private Timestamp dateUpdate;

    @OneToMany(mappedBy = "discounts",fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    List<Patient> patients;

}

package kz.healthcity.medbox.entities.bonus_system;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "bonus_transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patients;

    @Column(name = "biz_box_transaction_id")
    private Long bizBoxTransactionId;

    @Column(name = "biz_box_inner_transaction_id")
    private Long bizBoxInnerTransactionId;

    @Column(name = "payment_before")
    private BigDecimal paymentBefore;

    @Column(name = "after_payment")
    private BigDecimal afterPayment;

    @Column(name = "discount_rate")
    private Byte discountsRate;

    @Column(name = "completed")
    private Boolean completed;

    @Column(name = "canceled")
    private Boolean canceled;

    @CreationTimestamp
    @Column(name = "date")
    private Timestamp date;


}

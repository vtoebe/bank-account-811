package com.vtoebe.bankaccount811.model;

import com.vtoebe.bankaccount811.dto.request.TransferRequest;
import com.vtoebe.bankaccount811.enums.TransferTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transfer")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transfer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transfer_type")
    @Enumerated(EnumType.STRING)
    private TransferTypeEnum transferType;

    @ManyToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "id")
    private Account account;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    public Transfer(TransferRequest transferRequest) {
        this.transferType = transferRequest.getTransferType();
        this.amount = transferRequest.getAmount();
    }
}

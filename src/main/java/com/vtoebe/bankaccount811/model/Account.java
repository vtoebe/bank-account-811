package com.vtoebe.bankaccount811.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtoebe.bankaccount811.dto.request.AccountRequest;
import com.vtoebe.bankaccount811.enums.AccTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "account")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "acc_number", unique = true)
    private Integer accNumber;

    @Column(name = "agency")
    private Integer agency;

    @Column(name = "acc_type")
    @Enumerated(EnumType.STRING)
    private AccTypeEnum accType;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @JsonIgnore
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<Transfer> transferList;

    public Account(Client client, AccountRequest accountRequest){
        this.client = client;
        this.agency = accountRequest.getAgency();
        this.accNumber = accountRequest.getNumber();
        this.accType = accountRequest.getAccType();
        this.balance = accountRequest.getBalance();
    }
}

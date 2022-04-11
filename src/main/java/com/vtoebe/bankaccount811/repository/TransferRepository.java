package com.vtoebe.bankaccount811.repository;

import com.vtoebe.bankaccount811.model.Transfer;
import com.vtoebe.bankaccount811.projection.TransferView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Integer>,
        JpaSpecificationExecutor<Transfer>
{

    @Query("select t from Transfer t where t.account.accNumber = :accNumber")
    Page<Transfer> listAllTransferFromAccNumber(@Param("accNumber") Integer accNumber, Pageable pageable);

    List<TransferView> findAllByAccount_AccNumber(Integer accNumber);

}

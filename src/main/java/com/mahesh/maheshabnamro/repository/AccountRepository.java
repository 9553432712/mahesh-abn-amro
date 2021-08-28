package com.mahesh.maheshabnamro.repository;

import com.mahesh.maheshabnamro.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    AccountEntity findByAccountNumber(String accountNumber);

    @Query(value = "SELECT coalesce(max(id), 1) FROM AccountEntity")
    public Long getMaxId();

    @Transactional
    @Modifying
    @Query("update AccountEntity c set c.balance = :balance WHERE c.accountNumber = :accountNumber")
    void update(@Param("balance") BigDecimal balance,@Param("accountNumber") String accountNumber);
}

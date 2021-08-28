package com.mahesh.maheshabnamro.repository;

import com.mahesh.maheshabnamro.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    @Query(value = "SELECT coalesce(max(id), 0) FROM TransactionEntity")
    Long getMaxId();

    List<TransactionEntity> findAllByOrderByCreationDateDesc();
}

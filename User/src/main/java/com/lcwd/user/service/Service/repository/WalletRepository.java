package com.lcwd.user.service.Service.repository;

import com.lcwd.user.service.Service.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends  JpaRepository<Wallet, Integer>, JpaRepositoryImplementation<Wallet, Integer> {
}

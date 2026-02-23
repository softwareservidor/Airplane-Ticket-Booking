package com.airplaneticket.ticket.transactions.infrastructure.out.persistence;

import com.airplaneticket.ticket.transactions.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Integer> {
}

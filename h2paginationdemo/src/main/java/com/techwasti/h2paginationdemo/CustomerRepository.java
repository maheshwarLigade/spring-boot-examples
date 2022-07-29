package com.techwasti.h2paginationdemo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository <Customer, UUID> {

    Optional<List<Customer>> findAllByUserId(String userId, Pageable page);
}
package com.finovate.parking.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finovate.parking.model.Slot;
@Repository
public interface SlotRepository extends JpaRepository<Slot, UUID> {
}
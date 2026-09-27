package com.rushinga.fire.repository;

import com.rushinga.fire.model.FireIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FireRepository extends JpaRepository<FireIncident, Long> {
    List<FireIncident> findByWard(String ward);
    List<FireIncident> findByStatus(String status);
}
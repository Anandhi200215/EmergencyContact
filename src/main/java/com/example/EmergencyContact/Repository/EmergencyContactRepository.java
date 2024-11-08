package com.example.EmergencyContact.Repository;

import com.example.EmergencyContact.Entity.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact,Long> {
}

package com.example.Aug12_SpringOCR.repo;

import com.example.Aug12_SpringOCR.entity.AadharCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadharCardRepo extends JpaRepository<AadharCard,Long> {
}

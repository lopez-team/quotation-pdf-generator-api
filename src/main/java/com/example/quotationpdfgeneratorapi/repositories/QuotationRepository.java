package com.example.quotationpdfgeneratorapi.repositories;

import com.example.quotationpdfgeneratorapi.entities.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long> {

}

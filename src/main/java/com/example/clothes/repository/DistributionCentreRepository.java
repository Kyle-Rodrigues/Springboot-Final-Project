package com.example.clothes.repository;


import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.clothes.model.DistributionCentre;

public interface DistributionCentreRepository extends JpaRepository<DistributionCentre, Long> {
}

package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.TravelPackage;

public interface TravelPackageRepo extends JpaRepository<TravelPackage, Long> {

}

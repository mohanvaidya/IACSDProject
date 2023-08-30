package com.app.service;

import java.util.List;

import com.app.dto.TravelPackageDTO;
import com.app.entities.TravelPackage;

public interface TravelPackageService {

	TravelPackageDTO createPack(TravelPackageDTO packDto);

	List<TravelPackageDTO> getAllPacks();

	void deletepack(Long packId);

	TravelPackageDTO getpackById(long packId);

	TravelPackageDTO updatepack(TravelPackageDTO packDto, long packId);

	TravelPackage getTravelPackageById(Long travelPackageId);

	
}

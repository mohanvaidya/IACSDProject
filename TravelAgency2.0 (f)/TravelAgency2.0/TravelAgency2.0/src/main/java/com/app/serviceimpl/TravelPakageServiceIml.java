package com.app.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.BookingDTO;
import com.app.dto.TravelPackageDTO;
import com.app.dto.UserDTO;
import com.app.entities.Booking;
import com.app.entities.TravelPackage;
import com.app.entities.User;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.TravelPackageRepo;
import com.app.service.TravelPackageService;

@Service
@Transactional
public class TravelPakageServiceIml implements TravelPackageService  {

	
	@Autowired
	private TravelPackageRepo packRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public TravelPackageDTO createPack(TravelPackageDTO packDto) {

		TravelPackage pack = this.mapper.map(packDto, TravelPackage.class);
		TravelPackage newpack = this.packRepo.save(pack);

		return this.mapper.map(newpack, TravelPackageDTO.class);

	}
	
	@Override

	public List<TravelPackageDTO> getAllPacks() {
		List<TravelPackage> packs = packRepo.findAll();

		List<TravelPackageDTO> collect = packs.stream().map((pack) -> this.mapper.map(pack, TravelPackageDTO.class))
				.collect(Collectors.toList());
		return collect;
	}
	 @Override
		public void deletepack(Long packId) {
			TravelPackage pack = packRepo.findById(packId)
					.orElseThrow(() -> new ResourceNotFoundException("Booking", "bookingID", packId));
	          this.packRepo.delete(pack);
		}
	 @Override
	 public TravelPackageDTO updatepack(TravelPackageDTO packDto, long packId) {
			TravelPackage pack = packRepo.findById(packId)
					.orElseThrow(() -> new ResourceNotFoundException("Not a Valid User ", "id", packId));

			pack.setAccomodation(packDto.getAccomodation());
			pack.setActivities(packDto.getActivities());
			pack.setDescription(packDto.getDescription());
			pack.setDuration(packDto.getDuration());
			pack.setName(packDto.getName());
			pack.setPrice(packDto.getPrice());
			TravelPackage updatepack = this.packRepo.save(pack);
	  
			return this.mapper.map(updatepack, TravelPackageDTO.class);
		}
	 @Override
		public TravelPackageDTO getpackById(long packId) {
			TravelPackage pack = packRepo.findById(packId)
					.orElseThrow(() -> new ResourceNotFoundException("Please proivide a valid id", "paclkId", packId));
	  
			return this.mapper.map(pack, TravelPackageDTO.class);
		}

	@Override
	public TravelPackage getTravelPackageById(Long travelPackageId) {
		return packRepo.findById(travelPackageId)
                .orElseThrow(() -> new ResourceNotFoundException("TravelPackage", "packId", travelPackageId));
	}
	
	
	
}

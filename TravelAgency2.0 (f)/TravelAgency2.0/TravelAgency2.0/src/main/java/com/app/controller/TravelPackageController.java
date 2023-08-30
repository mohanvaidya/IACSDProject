package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.apiresponse.ApiResponse;
import com.app.dto.TravelPackageDTO;
import com.app.dto.UserDTO;
import com.app.service.TravelPackageService;



@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = "http://localhost:3000")
public class TravelPackageController {

	@Autowired
	private TravelPackageService packService;

	@PostMapping("/")
	public ResponseEntity<TravelPackageDTO> createpackage(@RequestBody TravelPackageDTO packDto) {

		TravelPackageDTO createpackage = packService.createPack(packDto);

		return new ResponseEntity<TravelPackageDTO>(createpackage, HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<TravelPackageDTO>> getAllpcks() {

		List<TravelPackageDTO> packs = packService.getAllPacks();
		return ResponseEntity.ok(packs);

	}


	@PutMapping("/{packId}")
	public ResponseEntity<?> updatepack(@PathVariable long packId,@RequestBody TravelPackageDTO packDto) {
		TravelPackageDTO updatepack =packService.updatepack(packDto, packId);
		return ResponseEntity.ok(updatepack);
	}
	 @DeleteMapping("{packId}")
	  public ResponseEntity<ApiResponse>deletePack(@PathVariable Long packId){
		  
		 this.packService.deletepack(packId);
		return  new ResponseEntity<ApiResponse>(new ApiResponse("Package deleted succeessfully.!",true),HttpStatus.OK);
		  
		  
	  }
	 @GetMapping("/{packId}")
		public ResponseEntity<TravelPackageDTO> getSinglepck(@PathVariable Long packId) {
			return ResponseEntity.ok(packService.getpackById(packId));
		}
 
	}



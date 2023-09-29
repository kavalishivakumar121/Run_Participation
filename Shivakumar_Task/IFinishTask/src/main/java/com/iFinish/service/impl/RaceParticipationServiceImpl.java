package com.iFinish.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iFinish.entity.RaceParticipationRegisterEntity;
import com.iFinish.repo.RaceParticipationRepo;
import com.iFinish.service.RaceParticipationService;

@Service
public class RaceParticipationServiceImpl implements RaceParticipationService{
	
	@Autowired
	private RaceParticipationRepo repo;

	public String createParticipate(RaceParticipationRegisterEntity raceParticipationRegisterEntity) {
		
		Integer participantId = raceParticipationRegisterEntity.getParticipantId();
		repo.save(raceParticipationRegisterEntity);
		if(participantId==null) {
			return "Record Saved Successfully";	
		}
		else {
			
			return "Record Updated Successfully";
		}
		
	}
}

package com.iFinish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iFinish.entity.RaceParticipationRegisterEntity;

public interface RaceParticipationRepo extends JpaRepository<RaceParticipationRegisterEntity, Integer>{

}

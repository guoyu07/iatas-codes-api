package com.github.pablocloud.iataapi.repositories;

import com.github.pablocloud.iataapi.domain.Iata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IataRepository extends JpaRepository<Iata, Long> {

    List<Iata> findAllByNameContainingIgnoreCase(String name);

    List<Iata> findAllByCodeContainingIgnoreCase(String code);

}

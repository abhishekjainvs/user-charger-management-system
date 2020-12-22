package project.spring.userchargermanagementsystem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.spring.userchargermanagementsystem.model.entity.ChargingStation;

@Repository
public interface ChargingStationRepository extends CrudRepository<ChargingStation, Long> {

	@Query("SELECT cs FROM ChargingStation cs WHERE cs.userId = :userId")
	List<ChargingStation> findByUserId(@Param("userId") String userId);

}

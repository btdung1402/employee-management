package uni.hcmus.employeemanagement.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uni.hcmus.employeemanagement.entity.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface DayOffTypeRepository extends JpaRepository<DayOffType, Long> {
	//Lấy DayOffTypeId từ tên DayOffType
	@Query("SELECT e.id FROM DayOffType e where e.type = :typeName")
	Long findByTypeName(@Param("typeName") String typeName);
	
	//Lấy danh sách các DayOffType hiện có
	@Query("SELECT type FROM DayOffType")
	List<String> findByTypeName();
}

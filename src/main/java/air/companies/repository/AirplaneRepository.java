package air.companies.repository;

import air.companies.model.Airplane;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    @Query("from Airplane a where a.name = :name")
    Optional<Airplane> findByName(@Param("name") String name);
}

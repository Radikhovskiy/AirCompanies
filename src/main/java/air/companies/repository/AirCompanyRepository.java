package air.companies.repository;

import air.companies.model.AirCompany;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
    @Query("from AirCompany a where a.name = :name")
    Optional<AirCompany> findByName(@Param("name") String name);
}

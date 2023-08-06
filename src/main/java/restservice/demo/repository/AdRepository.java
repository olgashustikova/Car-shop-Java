package restservice.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restservice.demo.entity.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
}

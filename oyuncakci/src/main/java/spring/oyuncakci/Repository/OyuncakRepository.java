package spring.oyuncakci.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.oyuncakci.Entity.Oyuncak;

public interface OyuncakRepository extends JpaRepository<Oyuncak, Long> {
}

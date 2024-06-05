package Repository;

import Entity.Barco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcoRepository extends JpaRepository<Barco, Long> {
}

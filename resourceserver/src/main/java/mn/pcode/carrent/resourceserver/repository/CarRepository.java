package mn.pcode.carrent.resourceserver.repository;

import mn.pcode.carrent.resourceserver.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    List<Car> findAll();
}

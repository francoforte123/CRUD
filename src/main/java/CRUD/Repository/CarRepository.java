package CRUD.Repository;

import CRUD.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String>{
}

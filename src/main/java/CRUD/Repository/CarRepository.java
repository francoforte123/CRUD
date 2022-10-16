package CRUD.Repository;

import CRUD.Entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public class CarRepository extends MongoRepository<Car, String>{
}

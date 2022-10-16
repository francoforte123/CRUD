package CRUD.Entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {

    @Id
    private String id;
    private String modelName;
    private String type;
}

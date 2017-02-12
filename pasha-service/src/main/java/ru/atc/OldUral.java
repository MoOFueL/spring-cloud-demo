package ru.atc;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Дмитрий on 09.02.2017.
 */
@Document(collection = "oldUrals")
public class OldUral {

    @Id
    private ObjectId id;

    private String name;

    private String make;

    public OldUral() {
    }

    public OldUral(String name, String make) {
        this.name = name;
        this.make = make;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "OldUral{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", make='" + make + '\'' +
                '}';
    }
}

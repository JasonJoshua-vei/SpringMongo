package com.veitechnologies.mongospring.repository;

import com.veitechnologies.mongospring.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface studentRepo extends MongoRepository<Student, Integer> {
}

package org.musketeers.repository;

import org.musketeers.entity.Personnel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelRepository extends MongoRepository<Personnel, String> {

    List<Personnel> findAllByCompanyId(String companyId);

}

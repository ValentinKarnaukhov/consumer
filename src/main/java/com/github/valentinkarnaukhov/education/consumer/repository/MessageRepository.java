package com.github.valentinkarnaukhov.education.consumer.repository;

import com.github.valentinkarnaukhov.education.consumer.dto.MessageDto;
import com.github.valentinkarnaukhov.education.consumer.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    @Query("{ $and : [ " +
            " { $or : [ { 'NULL' : :#{#params.companyUuid} }, { 'companyUuid' : :#{#params.companyUuid} } ] }," +
            " { $or : [ { 'NULL' : :#{#params.fromDate} }, { 'timestamp' : { $gte : :#{#params.fromDate} } } ] }," +
            " { $or : [ { 'NULL' : :#{#params.toDate} }, { 'timestamp' : { $lt : :#{#params.toDate} } } ] } " +
            "] }")
    List<Message> findAllByParameter(@Param("params") MessageDto.MessageGetRequest params);

}

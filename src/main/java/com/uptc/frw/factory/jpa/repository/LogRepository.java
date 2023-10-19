package com.uptc.frw.factory.jpa.repository;

import com.uptc.frw.factory.jpa.entity.Log;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface LogRepository extends ElasticsearchRepository<Log, String> {

    List<Log> findByAction(String action);

    List<Log> findByDescriptionContaining(String name);

}

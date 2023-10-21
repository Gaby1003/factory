package com.uptc.frw.factory.jpa.repository;

import com.uptc.frw.factory.jpa.entity.Log;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LogRepository extends ElasticsearchRepository<Log, String> {

}

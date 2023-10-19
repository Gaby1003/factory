package com.uptc.frw.factory.jpa.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

@Document(indexName = "logindex")
public class Log {


    @Id
    private String id;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @Field(type = FieldType.Text, name = "action")
    private String action;

    @Field(type = FieldType.Text, name = "beforeState")
    private String beforeState;

    @Field(type = FieldType.Text, name = "afterState")
    private String afterState;

    @Field(type = FieldType.Text, name = "table")
    private String table;

    @Field(type = FieldType.Text, name = "idRegister")
    private String idRegister;

    public Log() {
    }

    public Log(String description, String action, String beforeState, String afterState, String idRegister, String table) {
        this.description = description;
        this.action = action;
        this.beforeState = beforeState;
        this.afterState = afterState;
        this.idRegister = idRegister;
        this.table = table;
    }
}

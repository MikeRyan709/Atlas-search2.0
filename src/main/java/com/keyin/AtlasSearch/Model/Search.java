package com.keyin.AtlasSearch.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Search {
    @Id
    private long id;

    private String topic;
    private String database;

    public Search(){

    }

    public Search(String topic, String database) {
        this.topic = topic;
        this.database = database;
    }

    public Search(long id, String topic, String database) {
        this.id = id;
        this.topic = topic;
        this.database = database;
    }

    public Search(Search search) {
        this.topic = search.topic;
        this.database = search.database;
    }

    public Search(String topic) {
        this.topic = topic;
    }

    public String getTopic() { return topic; }
    public String getDatabase() { return database; }
    public long getId() { return id; }

    public void setId(long id) {this.id = id;}
    public void setTopic(String topic) { this.topic = topic; }
    public void setDatabase(String database){ this.database = database; }

    @Override
    public String toString() {
        return "Search{" +
                "topic='" + topic + '\'' +
                '}';
    }
}

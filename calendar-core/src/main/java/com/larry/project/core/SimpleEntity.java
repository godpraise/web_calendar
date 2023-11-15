package com.larry.project.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //해당 Class가 JPA Entity임을 나타냄
public class SimpleEntity {
    //이 클래스는 간단한 DataBase Table을 나타냄
    //JPA를 사용하면 객체를 DataBase에 저장하거나 검색하는 작업이 편리함

    @Id //primary key(기본 키)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키의 값이 자동으로 생성
    private Long id;

    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SimpleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

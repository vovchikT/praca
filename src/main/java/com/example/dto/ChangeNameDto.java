package com.example.dto;

public class ChangeNameDto {
    private Long Id;
    private String name;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChangeNameDto(Long id, String name) {
        Id = id;
        this.name = name;
    }
}

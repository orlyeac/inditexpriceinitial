package com.tuxpoli.inditexpriceselection.brand.domain.entity;

public class Brand {

    private Long id;
    private String name;

    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

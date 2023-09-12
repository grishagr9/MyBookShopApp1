package com.example.MyBookShopApp.data;

public class Authors {
    private Integer id;
    private String name;
    private Integer old;

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", old=" + old +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }
}

package com.revature.entity;

public class Pokemon {
    private String species;
    private String name;
    private String type1;
    private String type2;
    private int level;

    // constructor based injection:
    public Pokemon(String species, String name, String type1, String type2, int level) {
        this.species = species;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.level = level;
    }


    // this no-args contructor would let us the property based injection
    public Pokemon() {
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", level=" + level +
                '}';
    }

    // set up custom lifecycle methods:
    public void init() {
        System.out.println("Pokemon object is being created.");
    }

    public void destroy() {
        System.out.println("Pokemon object is being destroyed.");
    }
}

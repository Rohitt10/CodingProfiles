package com.example.practicesql;

public class Logic {
    int logo;
    String name;
    Logic(int logo,String name)
    {
        this.logo=logo;
        this.name=name;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


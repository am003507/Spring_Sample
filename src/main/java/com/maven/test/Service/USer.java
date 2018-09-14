package com.maven.test.Service;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class USer {
    private int id;
    private String LastName;
    private String FirstName;
    private String Address;
    private String City;


    @Override
    public String toString(){
        return "dd";
    }

}

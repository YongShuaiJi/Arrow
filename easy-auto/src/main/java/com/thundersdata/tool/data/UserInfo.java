package com.thundersdata.tool.data;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserInfo {
    public Person person  =  Fairy.create().person();
    public user getUser(){
        String name =  person.getFullName();
        Person enPerson  =  Fairy.create().person();
        String username = enPerson.getUsername();
        String password = person.getPassword();
        String sex = person.getSex().toString();
        String sexName = person.getSex().getName();
        Integer age = person.getAge();
        String teleNumber = person.getTelephoneNumber();
        String phone = person.getPhone();
        String address = person.getAddress().getAddress();
        String email = person.getEmail();
        String companyName = person.getCompany().getName();
        String companyEmail = person.getCompany().getEmail();
        LocalDate dateOfBirth = person.getDateOfBirth();
        String nationalIdentityCardNumber = person.getNationalIdentityCardNumber();

        return user.builder().username(username).password(password).name(name).sex(sex).age(age)
                .sexName(sexName).teleNumber(teleNumber).phone(phone).address(address).email(email)
                .companyName(companyName).companyEmail(companyEmail).dateOfBirth(dateOfBirth)
                .nationalIdentityCardNumber(nationalIdentityCardNumber)
                .build();
    }

}

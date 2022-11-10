package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = " Name Invalid...!")
    public String name;

    public String address;

    @NotNull(message = "Phone No cannot be null")
    // @Pattern(regexp = "^(([1-9]{1}[0-9]{9}))$",message = "Phone No Is Invalid")
    public long phoneNumber;
    @NotNull(message = "City cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City Is Invalid")
    public String city;
    @NotNull(message = "State cannot be null")
    @Pattern(regexp = "^[a-zA-Z\\s]{2,}$", message = "State Is Invalid")
    public String state;

    @NotNull(message = "ZipCode Cannot Be Empty")
    @Pattern(regexp = "^[1-9]{2}[0-9]{4,6}$",message = "Zip Code Is Invalid")
    public String zipCode;

    @NotNull(message = "Email Cannot Be Empty")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Email Is Invalid")
    public String email;

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}




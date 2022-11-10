package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.IAddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

    @Autowired
    private IAddressBookRepository addressBookRepository;
    private List<AddressBookData> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookList;
    }

    // Throwing Exception when person id not in Address Book App while retrieving from method
    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressBookList.stream().filter(empData -> empData.getPersonId() == personId)
                .findFirst().orElseThrow(() -> new AddressBookException("Person Not Found..!!"));
    }
    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressData = null;
        addressData= new AddressBookData(addressBookDTO);
        log.debug("Address Data: "+addressData.toString());
        addressBookList.add(addressData);
        return addressBookRepository.save(addressData);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressData = this.getAddressBookDataById(personId);
        addressData.setName(addressBookDTO.name);
        addressData.setAddress(addressBookDTO.address);
        addressData.setPhoneNumber(addressBookDTO.phoneNumber);
        addressData.setCity(addressBookDTO.city);
        addressData.setState(addressBookDTO.state);
        addressData.setZipCode(addressBookDTO.zipCode);
        addressData.setEmail(addressBookDTO.email);
        addressBookList.set(personId-1, addressData);
        return addressData;
    }

    @Override
    public void deleteAddressBookData(int personId) {
        addressBookList.remove(personId-1);

    }
}

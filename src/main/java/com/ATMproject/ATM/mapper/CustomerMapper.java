package com.ATMproject.ATM.mapper;

import com.ATMproject.ATM.model.dto.CustomerDTO;
import com.ATMproject.ATM.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public static Customer toCustomer(CustomerDTO customerRequest){

        Customer toReturn = new Customer();
        toReturn.setName(customerRequest.getName());
        toReturn.setAdress(customerRequest.getAdress());
        toReturn.setPhoneNumber(customerRequest.getPhoneNumber());
        return toReturn;

    }
    public static CustomerDTO toDTO(Customer customer ){
        CustomerDTO toReturn = new CustomerDTO();
        toReturn.setName(customer.getName());
        toReturn.setAdress(customer.getAdress());
        toReturn.setPhoneNumber(customer.getPhoneNumber());
        return toReturn;
    }
    public static List<CustomerDTO> toDTOList(List<Customer> list){
        List<CustomerDTO> toReturn1 = new ArrayList<>();
        for(Customer customer: list){
            CustomerDTO toReturn = new CustomerDTO();
            toReturn.setName(customer.getName());
            toReturn.setAdress(customer.getAdress());
            toReturn.setPhoneNumber(customer.getPhoneNumber());
            toReturn1.add(toReturn);
        }
        return toReturn1;

    }


}

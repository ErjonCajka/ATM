package com.ATMproject.ATM.model.dto;

import com.ATMproject.ATM.model.dto.BaseAtmDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends BaseAtmDTO {
    private String name;
    private String adress;
    private int phoneNumber;

    public CustomerDTO(Integer id, String name, String adress, int phoneNumber) {
        super(id);
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}

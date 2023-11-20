package com.ATMproject.ATM.mapper;

import com.ATMproject.ATM.model.dto.CardDTO;
import com.ATMproject.ATM.model.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardDTO toDto(Card card);

}
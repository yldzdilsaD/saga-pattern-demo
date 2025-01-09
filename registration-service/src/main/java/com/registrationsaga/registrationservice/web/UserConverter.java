package com.registrationsaga.registrationservice.web;

import com.registrationsaga.registrationservice.domain.entity.Address;
import com.registrationsaga.registrationservice.domain.entity.User;
import com.registrationsaga.registrationservice.web.rest.ui.controller.UserUiDto;

public class UserConverter
{
    public static User toUserEntity(UserUiDto user)
    {
        User userEntity = User.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .build();

        if (user.getAddresses() != null) {
            user.getAddresses().forEach(addressUiDto -> {
                Address addressEntity = Address.builder()
                    .address(addressUiDto.getAddress())
                    .city(addressUiDto.getCity())
                    .postalCode(addressUiDto.getPostalCode())
                    .country(addressUiDto.getCountry())
                    .build();

                userEntity.addAddress(addressEntity);
            });
        }

        return userEntity;
    }
}

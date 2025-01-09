package com.registrationsaga.registrationservice.web.rest.ui.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
public class UserUiDto
{
    private String salutation;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressUiDto> addresses;

    public String getDisplayedName()
    {
        StringBuilder b = new StringBuilder();

        if (StringUtils.isNotBlank(salutation))
        {
            b.append(salutation)
                .append(" ");
        }

        if (StringUtils.isNotBlank(firstName))
        {
            b.append(firstName)
                .append(" ");
        }

        if (StringUtils.isNotBlank(lastName))
        {
            b.append(lastName);
        }

        return b.toString();
    }
}

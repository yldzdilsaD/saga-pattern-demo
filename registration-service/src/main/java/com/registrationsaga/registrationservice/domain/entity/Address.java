package com.registrationsaga.registrationservice.domain.entity;


import com.registrationsaga.registrationservice.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.util.UUID;

import static com.registrationsaga.registrationservice.domain.validation.CharacterSetValidationConstants.CHARACTER_SET_PATTERN;
import static com.registrationsaga.registrationservice.domain.validation.CharacterSetValidationConstants.VALIDATION_FAILED_MESSAGE;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "address")
@Getter
@Setter
@ToString
@Entity
public class Address extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "user_id", insertable = false, updatable = false)
    private UUID userId;

    @NotNull
    @Size(min = 3, max = 250)
    @Pattern(regexp = CHARACTER_SET_PATTERN, message = VALIDATION_FAILED_MESSAGE)
    private String address;

    @NotNull
    @Size(min = 3, max = 250)
    @Pattern(regexp = CHARACTER_SET_PATTERN, message = VALIDATION_FAILED_MESSAGE)
    private String city;

    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = CHARACTER_SET_PATTERN, message = VALIDATION_FAILED_MESSAGE)
    private String postalCode;

    @NotNull
    @Size(min = 2, max = 250)
    @Pattern(regexp = CHARACTER_SET_PATTERN, message = VALIDATION_FAILED_MESSAGE)
    private String country;
}

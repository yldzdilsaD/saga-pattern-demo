package com.registrationsaga.registrationservice.domain.entity;


import com.registrationsaga.registrationservice.domain.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
import java.util.ArrayList;
import java.util.List;

import static com.registrationsaga.registrationservice.domain.validation.CharacterSetValidationConstants.CHARACTER_SET_PATTERN;
import static com.registrationsaga.registrationservice.domain.validation.CharacterSetValidationConstants.VALIDATION_FAILED_MESSAGE;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "user")
@Getter
@Setter
@ToString
@Entity
public class User extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Size(max = 8)
    @Pattern(regexp = CHARACTER_SET_PATTERN, message = VALIDATION_FAILED_MESSAGE)
    private String salutation;

    @Size(min = 1, max = 128)
    @Pattern(regexp = CHARACTER_SET_PATTERN, message = VALIDATION_FAILED_MESSAGE)
    private String firstName;

    @Size(min = 1, max = 250)
    @Pattern(regexp = CHARACTER_SET_PATTERN, message = VALIDATION_FAILED_MESSAGE)
    private String lastName;

    @Email
    @Size(min = 7, max = 250)
    @Pattern(regexp = CHARACTER_SET_PATTERN, message = VALIDATION_FAILED_MESSAGE)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Bu ilişkiyi burada tanımlıyoruz
    @JoinColumn(name = "user_id")
    private List<Address> addresses; // User'ın sahip olduğu Address'leri burada tutuyoruz

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setUserId(this.getId()); // Address'e User ID'sini atıyoruz
    }

    public void removeAddress(Address address) {
        this.addresses.remove(address);
    }
}

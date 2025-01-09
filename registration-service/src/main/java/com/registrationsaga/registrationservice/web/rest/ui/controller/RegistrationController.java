package com.registrationsaga.registrationservice.web.rest.ui.controller;

import com.registrationsaga.registrationservice.application.UserApplicationService;
import com.registrationsaga.registrationservice.web.UserConverter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController
{
    private final UserApplicationService registrationService;


    @PostMapping(value = "/adduser")
    public ResponseEntity complete(@RequestBody @Valid UserUiDto userUiDto) {
        registrationService.createUser(UserConverter.toUserEntity(userUiDto));
        return ResponseEntity.ok().build();
    }

}

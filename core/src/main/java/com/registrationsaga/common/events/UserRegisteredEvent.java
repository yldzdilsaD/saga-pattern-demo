package com.registrationsaga.common.events;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Builder
@RequiredArgsConstructor
@Getter @Setter
public class  UserRegisteredEvent
{
    private static final long serialVersionUID = 1L;
    private final UUID userId;
}

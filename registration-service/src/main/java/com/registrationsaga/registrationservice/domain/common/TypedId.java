package com.registrationsaga.registrationservice.domain.common;


import jakarta.annotation.Nullable;

import java.util.UUID;

public interface TypedId extends Comparable<TypedId>
{
    UUID getValue();

    @Nullable
    static UUID valueOfNullable(@Nullable TypedId typedId)
    {
        if (typedId == null)
        {
            return null;
        }

        return typedId.getValue();
    }

    default int compareTo(TypedId other)
    {
        if (other == null)
        {
            return 1;
        }

        return this.getValue()
                .compareTo(other.getValue());
    }
}

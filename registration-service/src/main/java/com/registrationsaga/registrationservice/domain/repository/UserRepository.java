package com.registrationsaga.registrationservice.domain.repository;

import com.registrationsaga.registrationservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>
{
}

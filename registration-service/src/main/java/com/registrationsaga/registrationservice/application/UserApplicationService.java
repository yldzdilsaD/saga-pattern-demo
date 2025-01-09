package com.registrationsaga.registrationservice.application;

import com.registrationsaga.common.events.UserRegisteredEvent;
import com.registrationsaga.registrationservice.domain.entity.User;
import com.registrationsaga.registrationservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(
    propagation = Propagation.REQUIRED
)
@RequiredArgsConstructor
public class UserApplicationService
{
    private final UserRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${registration.events.topic.name}")
    private String registrationEventsTopicName;

    public void createUser(User user) {
        log.info("Creating user");
        try{
            repository.save(user);
            UserRegisteredEvent event = UserRegisteredEvent.builder()
                .userId(user.getId())
                .build();
            kafkaTemplate.send(registrationEventsTopicName, event);
        }catch (Exception e){
            log.error("Error creating user", e);
        }

    }
}

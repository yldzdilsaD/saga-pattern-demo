package com.registrationsaga.registrationservice.web.messaging;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Value("${registration.events.topic.name}")
    private String registrationEventsTopicName;


    private static final Integer TOPIC_REPLICATION_FACTOR=3;
    private static final Integer TOPIC_PARTITIONS=3;

    @Bean
    KafkaTemplate<String, Object> kafkaTemplate(ProducerFactory<String, Object> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    NewTopic createUserRegistrationEventsTopic() {
        return TopicBuilder.name(registrationEventsTopicName)
            .partitions(TOPIC_PARTITIONS)
            .replicas(TOPIC_REPLICATION_FACTOR)
            .build();
    }

}

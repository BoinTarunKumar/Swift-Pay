package com.swiftpay.ledger.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object>
    kafkaListenerContainerFactory() {

        Map<String, Object> config =
                new HashMap<>();

        config.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers
        );

        config.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                "ledger-group"
        );

        DefaultKafkaConsumerFactory<String, Object>
                factory =
                new DefaultKafkaConsumerFactory<>(
                        config,
                        new StringDeserializer(),
                        new JsonDeserializer<>(Object.class)
                );

        ConcurrentKafkaListenerContainerFactory<String, Object>
                listenerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();

        listenerFactory.setConsumerFactory(
                factory
        );

        return listenerFactory;
    }
}
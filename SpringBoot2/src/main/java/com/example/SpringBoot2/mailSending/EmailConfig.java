package com.example.SpringBoot2.mailSending;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@Configuration
public class EmailConfig {
        @Bean
        public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
            ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

            taskExecutor.setCorePoolSize(4);
            taskExecutor.setMaxPoolSize(10);
            taskExecutor.setQueueCapacity(5);
            taskExecutor.initialize();
            return taskExecutor;
        }
}

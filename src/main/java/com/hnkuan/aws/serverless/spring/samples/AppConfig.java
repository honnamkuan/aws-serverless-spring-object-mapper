package com.hnkuan.aws.serverless.spring.samples;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnkuan.aws.serverless.spring.adapter.LambdaRequestAdapterImpl;
import com.hnkuan.aws.serverless.spring.adapter.api.LambdaRequestAdapter;
import com.hnkuan.aws.serverless.spring.samples.handler.CustomRequestHandler;
import com.hnkuan.aws.serverless.spring.samples.model.CustomRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 19/11/2017
 *
 * @author honnamkuan
 */
@Configuration
public class AppConfig {

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    CustomRequestHandler lambdaRequestHandler() {
        return new CustomRequestHandler();
    }

    @Bean
    LambdaRequestAdapter<CustomRequest> lambdaRequestAdapter() {
        return new LambdaRequestAdapterImpl<>(new TypeReference<CustomRequest>() {},
                lambdaRequestHandler(),
                objectMapper());
    }

}

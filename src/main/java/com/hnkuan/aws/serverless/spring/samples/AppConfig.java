package com.hnkuan.aws.serverless.spring.samples;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnkuan.aws.serverless.spring.adapter.AwsRequestAdapterImpl;
import com.hnkuan.aws.serverless.spring.adapter.api.AwsRequestAdapter;
import com.hnkuan.aws.serverless.spring.samples.handler.AwsRequestHandlerImpl;
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
    AwsRequestHandlerImpl customRequestHandler() {
        return new AwsRequestHandlerImpl();
    }

    @Bean
    AwsRequestAdapter<CustomRequest> awsRequestAdapter() {
        return new AwsRequestAdapterImpl<>(new TypeReference<CustomRequest>() {},
                customRequestHandler(),
                objectMapper());
    }

}

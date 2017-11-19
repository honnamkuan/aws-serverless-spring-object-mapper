package com.hnkuan.aws.serverless.spring.adapter;

import com.amazonaws.serverless.proxy.internal.model.ApiGatewayRequestContext;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnkuan.aws.serverless.spring.adapter.api.LambdaRequestAdapter;
import com.hnkuan.aws.serverless.spring.handler.api.LambdaRequestHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * Created on 19/11/2017
 *
 * @author honnamkuan
 */
@RunWith(MockitoJUnitRunner.class)
public class LambdaRequestAdapterImplTest {
    @Mock
    private AwsProxyRequest awsProxyRequest;

    private ObjectMapper objectMapper = new ObjectMapper();
    @Mock
    private LambdaRequestHandler<StubEntity> lambdaRequestHandler;
    @Mock
    private ApiGatewayRequestContext apiGatewayRequestContext;

    private LambdaRequestAdapter<StubEntity> lambdaRequestAdapter;

    @Before
    public void setUp() throws Exception {
        lambdaRequestAdapter = new LambdaRequestAdapterImpl<>(new TypeReference<StubEntity>() {},
                lambdaRequestHandler,
                objectMapper);
    }

    @Test
    public void handle() throws Exception {

        // Arrange
        when(awsProxyRequest.getRequestContext()).thenReturn(apiGatewayRequestContext);
        when(awsProxyRequest.getBody()).thenReturn("{\"id\":12,\"name\":\"personName\"}");
        ArgumentCaptor<StubEntity> argument = ArgumentCaptor.forClass(StubEntity.class);
        when(lambdaRequestHandler.handle(argument.capture(),
                eq(apiGatewayRequestContext))).thenReturn(ResponseEntity.ok()
                .header("X-Type",
                        "array")
                .body(Arrays.asList(1,
                        2,
                        3)));

        // Act
        AwsProxyResponse awsProxyResponse = lambdaRequestAdapter.handle(awsProxyRequest);

        // Assert
        InOrder inOrder = Mockito.inOrder(awsProxyRequest,
                lambdaRequestHandler);
        inOrder.verify(awsProxyRequest)
                .getBody();
        inOrder.verify(awsProxyRequest)
                .getRequestContext();
        inOrder.verify(lambdaRequestHandler)
                .handle(any(StubEntity.class),
                        eq(apiGatewayRequestContext));

        assertThat(argument.getValue()
                .getId()).isEqualTo(12);
        assertThat(argument.getValue()
                .getName()).isEqualTo("personName");

        assertThat(awsProxyResponse.getBody()).isEqualTo("[1,2,3]");
        assertThat(awsProxyResponse.getStatusCode()).isEqualTo(200);
        assertThat(awsProxyResponse.getHeaders()
                .size()).isEqualTo(1);
        assertThat(awsProxyResponse.getHeaders()
                .get("X-Type")).isEqualTo("array");
    }

    private static class StubEntity {

        private int id;

        private String name;

        int getId() {
            return id;
        }

        public void setId(int pId) {
            id = pId;
        }

        String getName() {
            return name;
        }

        public void setName(String pName) {
            name = pName;
        }
    }

}
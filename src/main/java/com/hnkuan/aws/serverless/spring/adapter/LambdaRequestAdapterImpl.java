package com.hnkuan.aws.serverless.spring.adapter;

import com.amazonaws.serverless.proxy.internal.model.ApiGatewayRequestContext;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnkuan.aws.serverless.spring.adapter.api.LambdaRequestAdapter;
import com.hnkuan.aws.serverless.spring.handler.api.LambdaRequestHandler;
import org.jooq.lambda.Unchecked;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.function.BiFunction;

/**
 * Created on 19/11/2017
 *
 * @author honnamkuan
 */
public class LambdaRequestAdapterImpl<I> implements LambdaRequestAdapter<I> {

    private final TypeReference<I> inputType;
    private final ObjectMapper mapper;
    private final LambdaRequestHandler<I> handler;


    /**
     * @param pInputType Request Object Type Reference
     * @param pHandler   The POJO request handler.
     * @param pMapper    An instance of Jackson Object Mapper.
     */
    public LambdaRequestAdapterImpl(TypeReference<I> pInputType, LambdaRequestHandler<I> pHandler,
                                    ObjectMapper pMapper) {
        Assert.notNull(pInputType,
                "pInputType must not be null");
        Assert.notNull(pHandler,
                "pHandler must not be null");
        Assert.notNull(pMapper,
                "pMapper must not be null");

        inputType = pInputType;
        handler = pHandler;
        mapper = pMapper;
    }

    /**
     * Configure proxy handling.
     *
     * @param pAwsProxyRequest AWS Proxy Request.
     * @return AWS Proxy Response.
     */
    @Override
    public AwsProxyResponse handle(AwsProxyRequest pAwsProxyRequest) {
        I requestObject = Unchecked.supplier(() -> mapper.<I>readValue(pAwsProxyRequest.getBody(),
                inputType))
                .get();

        BiFunction<I, ApiGatewayRequestContext, ResponseEntity<?>> handleFunc = handler::handle;

        ResponseEntity<?> responseEntity = handleFunc.apply(requestObject,
                pAwsProxyRequest.getRequestContext());

        String responseBody =
                Unchecked.supplier(() -> mapper.writeValueAsString(responseEntity.getBody()))
                        .get();

        return new AwsProxyResponse(responseEntity.getStatusCodeValue(),
                responseEntity.getHeaders()
                        .toSingleValueMap(),
                responseBody);
    }
}

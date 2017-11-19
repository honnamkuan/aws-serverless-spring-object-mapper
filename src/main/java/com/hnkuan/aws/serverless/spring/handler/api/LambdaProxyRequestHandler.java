package com.hnkuan.aws.serverless.spring.handler.api;

import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.hnkuan.aws.serverless.spring.adapter.api.LambdaRequestAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

/**
 * Created on 5/10/2017
 * <p>
 * The interface to be implemented for AWS API gateway proxy integration.
 *
 * @author honnamkuan
 */
public interface LambdaProxyRequestHandler {
    /**
     * Provides Spring Application Context containing {@link LambdaRequestAdapter},
     * bean.
     *
     * @return The context object.
     */
    ApplicationContext getContext();

    /**
     * Get an instance of {@link LambdaRequestAdapter}
     *
     * @return The implementation of {@link LambdaRequestAdapter}
     */
    LambdaRequestAdapter getLambdaRequestAdapter();


    /**
     * Forward {@link AwsProxyRequest} to POJO request handler.
     *
     * @param pAwsProxyRequest The {@link AwsProxyRequest}
     * @return {@link AwsProxyResponse} mapped from {@link ResponseEntity}
     */
    AwsProxyResponse handle(AwsProxyRequest pAwsProxyRequest);

}

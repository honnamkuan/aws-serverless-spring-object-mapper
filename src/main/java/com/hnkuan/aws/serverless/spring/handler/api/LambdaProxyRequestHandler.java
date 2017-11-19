package com.hnkuan.aws.serverless.spring.handler.api;

import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.hnkuan.aws.serverless.spring.adapter.LambdaRequestAdapterImpl;
import com.hnkuan.aws.serverless.spring.adapter.api.LambdaRequestAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

/**
 * Created on 5/10/2017
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
     * Forward {@link AwsProxyRequest} to POJO request handler.
     *
     * @param pAwsProxyRequest The {@link AwsProxyRequest}
     * @return {@link AwsProxyResponse} mapped from {@link ResponseEntity}
     */
    default AwsProxyResponse handle(AwsProxyRequest pAwsProxyRequest) {
        return getContext().getBean(LambdaRequestAdapterImpl.class)
                .handle(pAwsProxyRequest);
    }

}

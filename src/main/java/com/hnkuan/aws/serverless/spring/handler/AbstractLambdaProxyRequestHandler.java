package com.hnkuan.aws.serverless.spring.handler;

import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.hnkuan.aws.serverless.spring.adapter.api.LambdaRequestAdapter;
import com.hnkuan.aws.serverless.spring.handler.api.LambdaProxyRequestHandler;

import java.util.Objects;

/**
 * Created on 19/11/2017
 *
 * @author honnamkuan
 */
public abstract class AbstractLambdaProxyRequestHandler implements LambdaProxyRequestHandler {

    private LambdaRequestAdapter lambdaRequestAdapter = null;

    @Override
    public LambdaRequestAdapter getLambdaRequestAdapter() {
        if (Objects.isNull(lambdaRequestAdapter)) {
            lambdaRequestAdapter = getContext().getBean(LambdaRequestAdapter.class);
        }
        return lambdaRequestAdapter;
    }

    @Override
    public AwsProxyResponse handle(AwsProxyRequest pAwsProxyRequest) {
        return getLambdaRequestAdapter().handle(pAwsProxyRequest);
    }
}

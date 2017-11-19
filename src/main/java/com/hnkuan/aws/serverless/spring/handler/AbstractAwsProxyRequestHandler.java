package com.hnkuan.aws.serverless.spring.handler;

import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.hnkuan.aws.serverless.spring.adapter.api.AwsRequestAdapter;
import com.hnkuan.aws.serverless.spring.handler.api.AwsProxyRequestHandler;

import java.util.Objects;

/**
 * Created on 19/11/2017
 *
 * @author honnamkuan
 */
public abstract class AbstractAwsProxyRequestHandler implements AwsProxyRequestHandler {

    private AwsRequestAdapter awsRequestAdapter = null;

    @Override
    public AwsRequestAdapter getAwsRequestAdapter() {
        if (Objects.isNull(awsRequestAdapter)) {
            awsRequestAdapter = getContext().getBean(AwsRequestAdapter.class);
        }
        return awsRequestAdapter;
    }

    @Override
    public AwsProxyResponse handle(AwsProxyRequest pAwsProxyRequest) {
        return getAwsRequestAdapter().handle(pAwsProxyRequest);
    }
}

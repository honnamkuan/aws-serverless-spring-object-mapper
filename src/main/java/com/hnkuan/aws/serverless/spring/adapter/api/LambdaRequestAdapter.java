package com.hnkuan.aws.serverless.spring.adapter.api;

import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;

/**
 * Created on 4/10/2017
 * <p>
 * Proxy object to configure the mapping between AWS Lambda and {@link I} request
 *
 * @param <I> Request POJO Type
 * @author honnamkuan
 */
public interface LambdaRequestAdapter<I> {
    AwsProxyResponse handle(AwsProxyRequest pAwsProxyRequest);
}

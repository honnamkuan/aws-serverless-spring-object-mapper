package com.hnkuan.aws.serverless.spring.adapter.api;

import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;

/**
 * Created on 19/11/2017
 *
 * @author honnamkuan
 */
public interface LambdaRequestAdapter<I> {
    AwsProxyResponse handle(AwsProxyRequest pAwsProxyRequest);
}

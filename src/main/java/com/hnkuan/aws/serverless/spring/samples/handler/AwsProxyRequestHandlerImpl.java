package com.hnkuan.aws.serverless.spring.samples.handler;

import com.hnkuan.aws.serverless.spring.handler.AbstractAwsProxyRequestHandler;
import com.hnkuan.aws.serverless.spring.samples.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created on 19/11/2017
 * {@link AwsProxyRequestHandlerImpl#handle} to be configured as AWS Lambda Function Handler.
 *
 * @author honnamkuan
 */
public class AwsProxyRequestHandlerImpl extends AbstractAwsProxyRequestHandler {

    private static final ApplicationContext CONTEXT =
            new AnnotationConfigApplicationContext(AppConfig.class);

    @Override
    public ApplicationContext getContext() {
        return AwsProxyRequestHandlerImpl.CONTEXT;
    }
}

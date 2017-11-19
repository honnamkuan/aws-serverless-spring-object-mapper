package com.hnkuan.aws.serverless.spring.samples.handler;

import com.hnkuan.aws.serverless.spring.handler.AbstractLambdaProxyRequestHandler;
import com.hnkuan.aws.serverless.spring.samples.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created on 19/11/2017
 * {@link MainProxyRequestHandler#handle} is configured as AWS Lambda Function Handler.
 *
 * @author honnamkuan
 */
public class MainProxyRequestHandler extends AbstractLambdaProxyRequestHandler {

    private static final ApplicationContext CONTEXT =
            new AnnotationConfigApplicationContext(AppConfig.class);

    @Override
    public ApplicationContext getContext() {
        return MainProxyRequestHandler.CONTEXT;
    }
}

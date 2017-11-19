package com.hnkuan.aws.serverless.spring.handler.api;

import com.amazonaws.serverless.proxy.internal.model.ApiGatewayRequestContext;
import org.springframework.http.ResponseEntity;

/**
 * Created on 4/10/2017
 * <p>
 * The request handler object that accepts POJO input.
 *
 * @param <T> Input Type.
 * @author honnamkuan
 */
public interface AwsRequestHandler<T> {
    /**
     * Handle POJO input type.
     *
     * @param pInput   The POJO input type.
     * @param pContext The {@link ApiGatewayRequestContext}
     * @return Spring {@link ResponseEntity}
     */
    ResponseEntity handle(T pInput, ApiGatewayRequestContext pContext);
}

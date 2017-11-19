package com.hnkuan.aws.serverless.spring.samples.handler;

import com.amazonaws.serverless.proxy.internal.model.ApiGatewayRequestContext;
import com.hnkuan.aws.serverless.spring.handler.api.LambdaRequestHandler;
import com.hnkuan.aws.serverless.spring.samples.model.CustomRequest;
import com.hnkuan.aws.serverless.spring.samples.model.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created on 19/11/2017
 *
 * @author honnamkuan
 */
public class CustomRequestHandler implements LambdaRequestHandler<CustomRequest> {
    @Override
    public ResponseEntity handle(CustomRequest pInput, ApiGatewayRequestContext pContext) {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setErrorCode(400);
        customResponse.setMessage("Error 400 Bad Request received.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("X-Custom-Header",
                        "value123")
                .body(customResponse);


    }
}

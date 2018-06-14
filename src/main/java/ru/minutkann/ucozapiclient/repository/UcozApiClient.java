package ru.minutkann.ucozapiclient.repository;

import com.github.scribejava.apis.UcozApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class UcozApiClient {
    private final OAuth10aService service;
    private final OAuth1AccessToken accessToken;
    private final String PROTECTED_RESOURCE_URL;

    public UcozApiClient(String apiKey, String apiSecret, String token, String tokenSecret, String url) {
        this.service = new ServiceBuilder(apiKey)
                .apiSecret(apiSecret)
                .debug()
                .build(UcozApi.instance());
        this.accessToken = new OAuth1AccessToken(token, tokenSecret);
        PROTECTED_RESOURCE_URL = url;
    }

    public Response getResponse(Verb verb, String url, Map<String, String> params) throws InterruptedException, ExecutionException, IOException {
        final OAuthRequest request = new OAuthRequest(verb, PROTECTED_RESOURCE_URL + url);
        for (Map.Entry<String, String> param : params.entrySet()) {
            if(Verb.GET.equals(verb)) {
                request.addQuerystringParameter(param.getKey(), param.getValue());
            } else {
                request.addBodyParameter(param.getKey(), param.getValue());
            }
        }
        return getResponse(request);
    }

    public Response getResponse(Verb verb, String url) throws InterruptedException, ExecutionException, IOException {
        final OAuthRequest request = new OAuthRequest(verb, PROTECTED_RESOURCE_URL + url);
        return getResponse(request);
    }

    private Response getResponse(OAuthRequest request) throws InterruptedException, ExecutionException, IOException {
        service.signRequest(accessToken, request);
        return service.execute(request);
    }
}

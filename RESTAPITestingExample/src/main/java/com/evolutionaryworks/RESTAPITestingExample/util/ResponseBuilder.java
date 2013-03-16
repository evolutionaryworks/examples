package com.evolutionaryworks.RESTAPITestingExample.util;

import com.evolutionaryworks.RESTAPITestingExample.model.GoogleCurrencyApiResponse;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: nitinka
 * Date: 16/3/13
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResponseBuilder {
    private static ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    public static GoogleCurrencyApiResponse buildResponse(InputStream is) throws IOException {
        return mapper.readValue(is, GoogleCurrencyApiResponse.class);
    }
}

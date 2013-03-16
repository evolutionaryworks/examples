package com.evolutionaryworks.RESTAPITestingExample.api;

import com.evolutionaryworks.RESTAPITestingExample.model.GoogleCurrencyApiResponse;
import com.evolutionaryworks.RESTAPITestingExample.util.ResponseBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class GoogleCurrencyApi {

    private HttpClient httpClient;
    private final String googleCurrencyUrl;

    // "http://www.google.com/ig/calculator?hl=en"
    public GoogleCurrencyApi(String googleCurrencyUrl) {
        this.googleCurrencyUrl = googleCurrencyUrl;
        httpClient = new DefaultHttpClient();
    }

    public HttpResponse convert(Currency from, Currency to){
        String url = this.googleCurrencyUrl + "&q=1"+from.toString()+"=?"+to.toString();
        try {
            HttpUriRequest request = new HttpGet(url);
            return httpClient.execute(request);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get direct
    public GoogleCurrencyApiResponse convertAndReturnPoJo(Currency from, Currency to) throws IOException {
        HttpResponse httpResponse = convert(from, to);
        if(httpResponse.getStatusLine().getStatusCode() != 200)
            throw new RuntimeException(httpResponse.getStatusLine().getReasonPhrase());
        return ResponseBuilder.buildResponse(httpResponse.getEntity().getContent());
    }

    public static void main(String[] args) throws IOException {
        GoogleCurrencyApi api = new GoogleCurrencyApi("http://www.google.com/ig/calculator?hl=en");
        HttpResponse r = api.convert(Currency.USD, Currency.INR);
        System.out.println(IOUtils.toString(r.getEntity().getContent()));
    }
}

package com.evolutionaryworks.RESTAPITestingExample;

import com.evolutionaryworks.RESTAPITestingExample.api.Currency;
import com.evolutionaryworks.RESTAPITestingExample.api.GoogleCurrencyApi;
import com.evolutionaryworks.RESTAPITestingExample.model.GoogleCurrencyApiResponse;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Mocking Simple function call
 */
public class MockCovertAndReturnPoJoTest {
    private static ObjectMapper mapper;
    private GoogleCurrencyApi mockedGoogleApi;
    private GoogleCurrencyApiResponse staticResponse;

    static {
        mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    @BeforeClass
	public void setup() throws IOException {
        mockedGoogleApi = mock(GoogleCurrencyApi.class);
        staticResponse = mapper.readValue(new FileInputStream("./fixtures/googleResponse.json"), GoogleCurrencyApiResponse.class);
        when(mockedGoogleApi.convertAndReturnPoJo(any(Currency.class), any(Currency.class))).
                thenReturn(staticResponse);
    }

	@Test
	public void testMockedResponse() throws IOException {
        assertThat("Google Api Response",
                mockedGoogleApi.convertAndReturnPoJo(Currency.USD, Currency.USD),
                is(staticResponse));
	}
}

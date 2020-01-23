package pl.com.britenet.lambda;

import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AmazonLambdaRestApiApplication.class})
@WebAppConfiguration
public class AmazonLambdaRestApiApplicationTests {

    private MockLambdaContext lambdaContext;

    private SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    @Autowired
    private ObjectMapper mapper;

    public AmazonLambdaRestApiApplicationTests() {
        lambdaContext = new MockLambdaContext();
        this.handler = LambdaHandler.handler;
    }

    @Test
    public void shouldReturnAliveStatus() {
        AwsProxyRequest request = new AwsProxyRequestBuilder("/status", "GET").build();
        AwsProxyResponse response = handler.proxy(request, lambdaContext);

        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.getBody(), equalTo("ALIVE"));
    }
}

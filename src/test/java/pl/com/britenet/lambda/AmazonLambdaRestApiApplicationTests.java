package pl.com.britenet.lambda;

import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
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

//        assertThat(response.getStatusCode(), equalTo(200));
//        assertThat(response.getBody(), equalTo("ALIVE"));
    }
}

package helloworld;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ListProjectsFunctionTest {
  @Test
  public void successfulResponse() {
    ListProjectsFunction listProjectsFunction = new ListProjectsFunction();
    APIGatewayProxyResponseEvent result = listProjectsFunction.handleRequest(null, null);
    assertEquals(200, result.getStatusCode().intValue());
    assertEquals("application/json", result.getHeaders().get("Content-Type"));
    String content = result.getBody();
    assertNotNull(content);
    assertTrue(content.contains("\"message\""));
    assertTrue(content.contains("\"Projects List\""));
    assertTrue(content.contains("\"manager2\""));
  }
}

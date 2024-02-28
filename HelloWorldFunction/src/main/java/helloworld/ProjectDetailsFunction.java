package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.HashMap;
import java.util.Map;

/*
Función Lambda para el recurso de la API que pide los detalles de un proyecto
 */
public class ProjectDetailsFunction implements RequestHandler<Map<String, String>, APIGatewayProxyResponseEvent> {
    public APIGatewayProxyResponseEvent handleRequest(final Map<String, String> input, final Context context){
        //configuro el header para la respuesta tipo json:
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        //cargo en un HashMap el contenido del input y extraigo el idProject
        //Map<String, String> inputs = new HashMap<String, String>();
        //inputs = input.getQueryStringParameters();
        String idProjectInput = input.get("idProject");

        //inicializo la variable con la que voy a responder con el header
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);

        //almaceno en un String el Json con la información a enviar
        final String bodyContent = "detalles del proyecto" + idProjectInput;

        //y lo añado al formato fijado:
        String output = String.format("{ \"message\": \"Project Details\", \"details\": \"%s\" }", bodyContent);

        //devuelvo la variable APIGatewayProxyResponseEvent
        return response
                .withStatusCode(200) //si todo va bien devuelvo el código de OK 200
                .withBody(output); //y en el body el json con la información requerida en el formato acordado.
    }
}

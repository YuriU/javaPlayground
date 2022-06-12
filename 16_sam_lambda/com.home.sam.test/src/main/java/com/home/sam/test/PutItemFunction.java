package com.home.sam.test;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Collections;

public class PutItemFunction implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final int STATUS_CODE_NO_CONTENT = 204;
    private static final int STATUS_CODE_CREATED = 201;
    private final DynamoDbEnhancedClient dbClient;
    private final String tableName;
    private final TableSchema<Book> bookTableSchema;

    public PutItemFunction() {
        dbClient = DependencyFactory.dynamoDbEnhancedClient();
        tableName = System.getenv(GetItemFunction.ENV_TABLE_NAME);
        bookTableSchema = TableSchema.fromBean(Book.class);
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String body = request.getBody();
        int statusCode = STATUS_CODE_NO_CONTENT;
        if (body != null) {
            Book item = new Gson().fromJson(body, Book.class);
            if (item != null) {
                DynamoDbTable<Book> booksTable = dbClient.table(tableName, bookTableSchema);
                booksTable.putItem(item);
                statusCode = STATUS_CODE_CREATED;
            }
        }
        return new APIGatewayProxyResponseEvent().withStatusCode(statusCode)
                .withIsBase64Encoded(Boolean.FALSE)
                .withHeaders(Collections.emptyMap());
    }
}
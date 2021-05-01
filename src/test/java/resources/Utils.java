package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils
{
    public RequestSpecification createRequestSpecification() throws IOException {
        PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
        RequestSpecification request =
                new RequestSpecBuilder()
                        .setBaseUri(getGlobalValue("BaseUrl"))
                        .addQueryParam("key", "qaclick123")
                        .setContentType(ContentType.JSON).
                        addFilter(RequestLoggingFilter.logRequestTo(stream)).
                        addFilter(ResponseLoggingFilter.logResponseTo(stream))
                        .build();
        return request;
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("F:\\BDD\\src\\test\\java\\resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}

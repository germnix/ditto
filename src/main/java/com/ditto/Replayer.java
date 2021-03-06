package com.ditto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


/**
 * Handle incoming requests and supply responses from text file.
 */
public class Replayer {

    private static final Logger LOG = LoggerFactory.getLogger(Ditto.class);
    private Configuration configuration;
    private MessageFactory messageFactory;

    public Replayer(Configuration configuration) {
        this.configuration = configuration;
    }

    public void start() throws FileNotFoundException, UnsupportedEncodingException {
        messageFactory = MessageFactory.newInstance(configuration);
        setUpGetEndpoints(messageFactory);
        setUpHeadEndpoints(messageFactory);
        setUpPostEndpoints(messageFactory);
        setUpPutEndpoints(messageFactory);
        setUpDeleteEndpoints(messageFactory);
    }

    public Object handleRequest(String method, spark.Request req, spark.Response res) throws IOException {
        switch (method) {
            case "GET":
                return handleRequest(req, res, messageFactory.responsesGetByUrl());
            case "HEAD":
                return handleRequest(req, res, messageFactory.responsesHeadByUrl());
            case "POST":
                return handleRequest(req, res, messageFactory.responsesPostByUrlAndBody());
            case "PUT":
                return handleRequest(req, res, messageFactory.responsesPutByUrlAndBody());
            case "DELETE":
                return handleRequest(req, res, messageFactory.responsesDeleteByUrl());
        }
        return null;
    }

    private static void setUpGetEndpoints(MessageFactory messageFactory) {
        get("/*", (req, res) -> handleRequest(req, res, messageFactory.responsesGetByUrl()));
    }

    private static void setUpHeadEndpoints(MessageFactory messageFactory) {
        head("/*", (req, res) -> handleRequest(req, res, messageFactory.responsesHeadByUrl()));
    }

    private static void setUpDeleteEndpoints(MessageFactory messageFactory) {
        delete("/*", (req, res) -> handleRequest(req, res, messageFactory.responsesDeleteByUrl()));
    }

    private static void setUpPostEndpoints(MessageFactory messageFactory) {
        post("/*", (req, res) -> handleRequest(req, res, messageFactory.responsesPostByUrlAndBody()));
    }

    private static void setUpPutEndpoints(MessageFactory messageFactory) {
        put("/*", (req, res) -> handleRequest(req, res, messageFactory.responsesPutByUrlAndBody()));
    }

    private static Object handleRequest(spark.Request req, spark.Response res, List<RequestResponse> mappings) throws IOException {
        for (RequestResponse requestResponse : mappings) {
            if (requestResponse.getRequest().matchesRequest(req)) {
                Response response = requestResponse.getResponse();
                res.status(response.getStatusCode());

                for (Map.Entry<String, String> header : response.getHeaders().entrySet()) {
                    if (header.getKey().equalsIgnoreCase("Content-Length")) {
                        continue;
                    }
                    if (header.getKey().equalsIgnoreCase(Constants.HEADER_DELAY) ||
                        header.getKey().equalsIgnoreCase(Constants.HEADER_BODY_MATCH)) {
                        handleDelay(header);
                        continue;
                    }
                    res.header(header.getKey(), header.getValue());
                }

                return response.getBody() != null ? response.getBody() : "";
            }
        }

        res.status(404);
        return null;
    }

    private static void handleDelay(Map.Entry<String, String> header) {
        try {
            int delaySeconds = Integer.parseInt(header.getValue().trim());
            Thread.sleep(delaySeconds * 1000);
        } catch (Exception anEx) {
            LOG.warn("Exception executing delay", anEx);
        }
    }
}

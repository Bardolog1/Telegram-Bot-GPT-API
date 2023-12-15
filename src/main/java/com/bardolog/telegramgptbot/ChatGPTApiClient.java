package com.bardolog.telegramgptbot;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
import static com.bardolog.telegramgptbot.MultiSessionTelegramBot.getEnvVariable;

public class ChatGPTApiClient {

    public static final String CHAT_GPT_API_KEY = getEnvVariable("CHAT_GPT_API_KEY");
    public static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static String askGPT(String question) {


        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(API_URL);

            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Authorization", "Bearer " + CHAT_GPT_API_KEY);
            String encodedQuestion = URLEncoder.encode(question, "UTF-8");
            String requestBody = "{" +
                    "\"model\": \"gpt-3.5-turbo\", " +
                    "\"messages\": [" +

                    "{" +
                    " \"role\": \"system\", " +
                    "\"content\": \"" + encodedQuestion + "\"" +
                    "}," +

                    "{" +
                    " \"role\": \"user\", " +
                    "\"content\": \"" + encodedQuestion + "\"" +
                    "}" +
                    "]" +
                    "}";
            httpPost.setEntity(new StringEntity(requestBody));

            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));

            String line;
            StringBuilder responseContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            String jsonResponse = responseContent.toString();

            JSONObject jsonObject = new JSONObject(jsonResponse);

            JSONArray choices = jsonObject.getJSONArray("choices");
            JSONObject choice = choices.getJSONObject(0);
            JSONObject message = choice.getJSONObject("message");

            return message.getString("content");

        } catch (Exception e) {
            e.printStackTrace();
            return "Error of execution!";
        }

    }
}

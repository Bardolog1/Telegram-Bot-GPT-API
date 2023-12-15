package com.bardolog.telegramgptbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import java.io.UnsupportedEncodingException;
import static com.bardolog.telegramgptbot.ChatGPTApiClient.askGPT;






public class TelegramBotGPTMain extends MultiSessionTelegramBot {

    // Define variables para las API Keys utilizando variables de entorno en un fichero .env
    public static final String TELEGRAM_BOT_API_KEY = getEnvVariable("TELEGRAM_BOT_API_KEY");
    public static final String TELEGRAM_BOT_NAME = getEnvVariable("TELEGRAM_BOT_NAME");

    public TelegramBotGPTMain() {
        super(TELEGRAM_BOT_NAME, TELEGRAM_BOT_API_KEY );
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        if (!getMessageText().isEmpty()) {

            String userMessage = getMessageText();
            
            // Asegurarse de que el mensaje esté codificado correctamente
            try {
                userMessage = new String(getMessageText().getBytes("UTF-8"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String answer = askGPT(userMessage);
            sendTextMessageAsync(answer);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TelegramBotGPTMain());
    }
}
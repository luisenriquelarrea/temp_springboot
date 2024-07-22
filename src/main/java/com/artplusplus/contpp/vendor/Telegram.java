package com.dulcesmontes.logistica.vendor;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import io.github.cdimascio.dotenv.Dotenv;

public class Telegram {
    Dotenv dotenv = null;
    private TelegramBot bot = null;

    public Telegram(String botType){
        dotenv = Dotenv.configure().load();
        String token = "";
        if(botType.equals("customer"))
            token = dotenv.get("TELEGRAM_CUSTOMER_TOKEN");
        if(token != null)
            bot = new TelegramBot(token);
    }

    public boolean sendMessage(String chatId, String message){
        if(bot == null)
            return false;
        SendMessage request = new SendMessage(chatId, message);
        SendResponse sendResponse = bot.execute(request);
        return sendResponse.isOk();
    }
}

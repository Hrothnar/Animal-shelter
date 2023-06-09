package re.st.animalshelter;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import re.st.animalshelter.service.CommandService;
import re.st.animalshelter.utility.Distributor;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TelegramBotListener implements UpdatesListener {
    private final TelegramBot telegramBot;
    private final Distributor distributor;

    @Autowired
    public TelegramBotListener(TelegramBot telegramBot, Distributor distributor) {
        this.telegramBot = telegramBot;
        this.distributor = distributor;
    }

    @Override
    public int process(List<Update> updateList) {
        for (Update update : updateList) {
            distributor.catchUpdate(update);
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    @PostConstruct
    private void init() {
        telegramBot.setUpdatesListener(this);
        new CommandService().addCommands(telegramBot);
    }
}

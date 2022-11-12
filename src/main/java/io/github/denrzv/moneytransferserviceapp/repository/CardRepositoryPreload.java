package io.github.denrzv.moneytransferserviceapp.repository;

import io.github.denrzv.moneytransferserviceapp.model.Amount;
import io.github.denrzv.moneytransferserviceapp.model.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardRepositoryPreload {
    private static final Logger log = LoggerFactory.getLogger(CardRepository.class);

    @Bean
    CommandLineRunner initDatabase(CardRepository repository) {
        return args -> {
            log.info("Загрузка карты в репозиторий " + repository.addCard(new Card("1111111111111111"),
                    new Amount(100000, "RUR")));
            log.info("Загрузка карты в репозиторий " + repository.addCard(new Card("2222222222222222"),
                    new Amount(100000, "RUR")));
        };
    }
}

package ru.atc.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Created by Дмитрий on 08.02.2017.
 */
@Service
class AccountCLR implements CommandLineRunner {

    private AccountRepository accountRepository;

    @Autowired
    public AccountCLR(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("dima,kek", "dima2,kek2", "pavel,pavel")
                .map(x -> x.split(","))
                .forEach(tuple -> accountRepository.save(new Account(tuple[0], tuple[1], true)));
    }
}
package ru.atc.messaging;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.atc.domain.OldUral;

/**
 * Created by Дмитрий on 12.02.2017.
 */
@MessagingGateway
public interface OldUralsWriter {

    @Gateway(requestChannel = "output")
    void write(OldUral oldUral);
}


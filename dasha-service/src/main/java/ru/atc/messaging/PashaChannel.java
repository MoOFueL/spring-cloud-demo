package ru.atc.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Дмитрий on 12.02.2017.
 */
public interface PashaChannel {

    @Output
    MessageChannel output();
}

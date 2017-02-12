package ru.atc;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Дмитрий on 12.02.2017.
 */
public interface OldUralInputChannel {

    @Input
    SubscribableChannel input();
}

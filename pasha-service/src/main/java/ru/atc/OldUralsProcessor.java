package ru.atc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by Дмитрий on 12.02.2017.
 */
@MessageEndpoint
public class OldUralsProcessor {

    private OldUralsRepository oldUralsRepository;

    @Autowired
    public OldUralsProcessor(OldUralsRepository oldUralsRepository) {
        this.oldUralsRepository = oldUralsRepository;
    }

    @ServiceActivator(inputChannel = "input")
    public void onNewOldUral(OldUral oldUral) {
        this.oldUralsRepository.save(new OldUral(oldUral.getName(), oldUral.getMake()));
    }
}

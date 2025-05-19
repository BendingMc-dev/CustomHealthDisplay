package me;

import java.util.UUID;

public class objectClass {
    public UUID damager;
    public UUID damaged;
    public long time;

    public objectClass(UUID damager, UUID damaged, long time) {
        this.damager = damager;
        this.damaged = damaged;
        this.time = time;
    }
}

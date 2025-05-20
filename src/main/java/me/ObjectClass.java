package me;

import java.util.UUID;

public class ObjectClass {
    public UUID damager;
    public UUID damaged;
    public long time;

    public ObjectClass(UUID damager, UUID damaged, long time) {
        this.damager = damager;
        this.damaged = damaged;
        this.time = time;
    }
}

package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class InfoTrain implements Comparable<InfoTrain> {
    private final String codTrain;
    private final String departurePoint;
    private final String time;
    private final String delay;

    public InfoTrain(String codTrain, String departurePoint, String time, String delay) {
        this.codTrain = codTrain;
        this.departurePoint = departurePoint;
        this.time = time;
        this.delay = delay;
    }

    @Override
    public int compareTo(@NotNull InfoTrain o) {
        String[] tmp = time.split(":");
        String[] tmp2 = o.time.split(":");
        int thisTimeToInt = Integer.parseInt(tmp[0] + tmp[1] + "");
        int timetwo = Integer.parseInt(tmp2[0] + tmp2[1] + "");

        return Integer.compare(thisTimeToInt, timetwo);
    }

    public String codTrain() {
        return codTrain;
    }

    public String departurePoint() {
        return departurePoint;
    }

    public String time() {
        return time;
    }

    public String delay() {
        return delay;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (InfoTrain) obj;
        return Objects.equals(this.codTrain, that.codTrain) &&
                Objects.equals(this.departurePoint, that.departurePoint) &&
                Objects.equals(this.time, that.time) &&
                Objects.equals(this.delay, that.delay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codTrain, departurePoint, time, delay);
    }

    @Override
    public String toString() {
        return "InfoTrain[" +
                "codTrain=" + codTrain + ", " +
                "departurePoint=" + departurePoint + ", " +
                "time=" + time + ", " +
                "delay=" + delay + ']';
    }

}

package it.unimi.di.sweng.esame;

import it.unimi.di.sweng.esame.model.InfoTrain;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Observable {
    void addObserver(@NotNull Observer obs);
    void notifyObservers();
    @NotNull List<InfoTrain> getFirstHalf();

    @NotNull List<InfoTrain> getSecondHalf();

}

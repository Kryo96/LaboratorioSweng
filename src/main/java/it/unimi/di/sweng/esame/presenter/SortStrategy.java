package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.model.InfoTrain;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface SortStrategy {

    @NotNull  List<InfoTrain> sortTrain(List<InfoTrain> model);
}

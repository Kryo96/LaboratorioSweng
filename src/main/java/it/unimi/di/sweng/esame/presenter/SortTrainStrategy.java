package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.model.InfoTrain;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class SortTrainStrategy implements SortStrategy{
    @Override
    public @NotNull List<InfoTrain> sortTrain(List<InfoTrain> list) {
        Collections.sort(list);
        return list;
    }
}

package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.view.SetDelayView;
import org.jetbrains.annotations.NotNull;

public class DelayPresenter implements InputPresenter{

    private final Model model;

    public DelayPresenter(Model m, SetDelayView v){
        model = m;
        v.addHandlers(this);
    }

    @Override
    public void action(String text1, String text2) {
        String [] tmp = text1.split(" ");
        model.addDelay(tmp[0] + " " + tmp[1], text2);
    }

}

package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.InfoTrain;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.view.DepartureView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DeparturePresenter implements InputPresenter, Observer {

    private final Model model;
    private final SortStrategy strategy;
    private final DepartureView view1;
    private final DepartureView view2;

    public DeparturePresenter(Model m, DepartureView v1, DepartureView v2, SortStrategy s ){
        model = m;
        strategy = s;
        view1 = v1;
        view2 = v2;
        view1.addHandlers(this);
        view2.addHandlers(this);
        model.addObserver(this);
    }


    @Override
    public void action(String text1, String text2) {
       String [] tmp = text1.split(" ");
        model.trenoPartito(tmp[0] + " " + tmp[1]);
    }

    @Override
    public void update(@NotNull Observable model) {
        List<InfoTrain> primaView = strategy.sortTrain(model.getFirstHalf());
        List<InfoTrain> secondaView = strategy.sortTrain(model.getSecondHalf());
        int i = 0;
        for (InfoTrain x : primaView) {
            view1.set(i, x.codTrain() + " " + x.departurePoint() + " " + x.time() + " " + x.delay());
            i++;
        }

        for(; i< Main.MAX_ROW_ITEMS_IN_VIEW; i++){
            view1.set(i, "---");
        }

        i = 0;
        for (InfoTrain x : secondaView) {
            view2.set(i,  x.codTrain() + " " + x.departurePoint() + " " + x.time() + " " + x.delay());
            i++;
        }

        for(; i< Main.MAX_ROW_ITEMS_IN_VIEW; i++){
            view2.set(i, "---");
        }

    }
}

package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Main;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.*;

public class Model implements Observable {

  private final @NotNull List<InfoTrain> infoTrains = new ArrayList<>();
  private final @NotNull List<Observer> observers = new ArrayList<>();



  public void readFile() {
    InputStream is = Main.class.getResourceAsStream("/trains.csv");
    assert is != null;
    Scanner s = new Scanner(is);

    while (s.hasNextLine()) {
      String linea = s.nextLine();
      String[] el = linea.split(",");
      String cod = el[0];
      String destination = el[1];
      String depTime = el[2];
      String delay = el[3];

      InfoTrain infoTrain = new InfoTrain(cod, destination, depTime, delay);
      infoTrains.add(infoTrain);

    }

    notifyObservers();
  }


  public List<InfoTrain> getState(){
    return Collections.unmodifiableList(infoTrains);
  }

  public void addDelay(@NotNull String codTrain, @NotNull String delay) {
    int index = 0;
    for (InfoTrain x : infoTrains) {
      if(x.codTrain().equals(codTrain)){
        index = infoTrains.indexOf(x);
      }
    }

    InfoTrain tmp = new InfoTrain(infoTrains.get(index).codTrain(), infoTrains.get(index).departurePoint(), infoTrains.get(index).time(), delay);
    infoTrains.remove(infoTrains.get(index));
    infoTrains.add(0, tmp);
    notifyObservers();

  }


  public void trenoPartito(@NotNull String codTreno){
    int index = 0;
    for (InfoTrain x : infoTrains) {
      if(x.codTrain().equals(codTreno)){
        index = infoTrains.indexOf(x);
      }
    }

    infoTrains.remove(infoTrains.get(index));
    notifyObservers();
  }


  @Override
  public void addObserver(@NotNull Observer obs) {
    observers.add(obs);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(this);
    }
  }

  @Override
  public @NotNull List<InfoTrain> getFirstHalf() {
    List<InfoTrain> tmp;
    if(infoTrains.size() >= 8)
      tmp = infoTrains.subList(0, 8);
    else
      tmp = infoTrains.subList(0, infoTrains.size());
    return tmp;
  }

  @Override
  public @NotNull List<InfoTrain> getSecondHalf() {
    List<InfoTrain> tmp;
    if(infoTrains.size() >= 16)
       tmp = infoTrains.subList(8, 16);
    else if(infoTrains.size() <= 8)
      tmp = new ArrayList<>();
    else
      tmp = infoTrains.subList(8, infoTrains.size());
    return tmp;
  }
}

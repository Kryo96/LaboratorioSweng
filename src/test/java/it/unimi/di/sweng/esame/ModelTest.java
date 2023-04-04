package it.unimi.di.sweng.esame;

import it.unimi.di.sweng.esame.model.Model;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class ModelTest {

    @Test
    public void readFileTest(){

        Model SUT = new Model();
        SUT.readFile();

        assertThat(SUT.getState().get(0).codTrain()).isEqualTo("TI 3029");


    }
    @Test
    public void addDelay(){

        Model SUT = new Model();
        SUT.readFile();
        SUT.addDelay("TI 3029", "10");

        assertThat(SUT.getState().get(0).delay()).isEqualTo("10");

    }

    @Test
    public void removeTrain(){
        Model SUT = new Model();
        SUT.readFile();

        SUT.trenoPartito("TI 3029");
        assertThat(SUT.getState().get(0).codTrain()).isEqualTo("TN 2629");
    }

    @Test
    public void firstSecondHalfTest() {
        Model SUT = new Model();
        SUT.readFile();

        assertThat(SUT.getFirstHalf().get(0).codTrain()).isEqualTo("TI 3029");
        assertThat(SUT.getSecondHalf().get(0).codTrain()).isEqualTo("TN 10928");
    }

    @Test
    public void notifyTest(){
        Observer obs = Mockito.mock(Observer.class);
        Model SUT = new Model();
        SUT.addObserver(obs);

        SUT.readFile();
        SUT.addDelay("TI 3029", "10");
        SUT.trenoPartito("TI 3029");
        verify(obs, times(3)).update(SUT);

    }
}



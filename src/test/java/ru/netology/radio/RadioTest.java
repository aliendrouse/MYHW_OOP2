package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    void shouldSetCurrentStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        int expected = 5;
        int actual = radio.setCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


     @Test
     void shouldNotSetStationAboveMax() {
         Radio radio = new Radio();
         radio.setCurrentStation(10);

         int expected = 0;
         int actual = radio.setCurrentStation();

         Assertions.assertEquals(expected, actual);
     }


    @Test
    void shouldNotSetStationBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);

        int expected = 0;
        int actual = radio.setCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.next();

        int expected = 6;
        int actual = radio.setCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToZeroAfterNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();

        int expected = 0;
        int actual = radio.setCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prev();

        int expected = 4;
        int actual = radio.setCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToNineAfterZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();

        int expected = 9;
        int actual = radio.setCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();

        int expected = 1;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}
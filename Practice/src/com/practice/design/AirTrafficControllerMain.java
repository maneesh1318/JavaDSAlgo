package com.practice.design;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AirTrafficControllerMain {
    public static void main(String args[]){

    }
}

class Position{
    double latitute;
    double longitude;
    double height;
}

interface AirSpace{
    List<Aircraft> getPlanesInAirSpace(AirSpace airSpace);
}

interface Aircraft{
    void changePosition(Position position);
    void land();
    void takeOff();
}

interface Radar{
    List<Position> observeAirSpace();
}

interface AirTrafficController{
    List<Aircraft> getAllPlanesInAirSpace();
    void askToLand(Aircraft aircraft);
    void grantPermissionTakeOff(Aircraft aircraft);
    void grantPermissionToLand(Aircraft aircraft);
}

class AircraftImpl implements Aircraft{
    Position position;

    AircraftImpl(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void changePosition(Position position) {

    }

    @Override
    public void land() {

    }

    @Override
    public void takeOff() {

    }
}


class RadarImpl implements Radar{
    @Override
    public List<Position> observeAirSpace() {
        return null;
    }
}

class AirspaceIml extends Observable implements AirSpace{
    AirspaceIml(AirTrafficControllerImpl airTrafficController){
        addObserver(airTrafficController);
    }

    @Override
    public List<Aircraft> getPlanesInAirSpace(AirSpace airSpace) {
        return null;
    }
}

class AirTrafficControllerImpl implements AirTrafficController,Observer{
    AirSpace airSpace;
    List<Aircraft> aircrafts;

    @Override
    public void update(Observable o, Object arg) {
        aircrafts = airSpace.getPlanesInAirSpace(airSpace);
    }

    @Override
    public List<Aircraft> getAllPlanesInAirSpace() {
        return aircrafts;
    }

    @Override
    public void askToLand(Aircraft aircraft) {

    }

    @Override
    public void grantPermissionTakeOff(Aircraft aircraft) {

    }

    @Override
    public void grantPermissionToLand(Aircraft aircraft) {

    }
}
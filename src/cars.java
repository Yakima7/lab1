package src;

import java.awt.*;

public abstract class cars implements Movable {

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public compass direction; // Direction of the car
    public double xcoord; // X coordinate of the car
    public double ycoord; // Y coordinate of the car

    public enum compass {
        North, East, West, South
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void move(){
       compass dircar = direction;
        switch(dircar) {
            case North:
                ycoord += currentSpeed;
                break;
            case East:
                xcoord += currentSpeed;
                break;
            case West:
                xcoord -= currentSpeed;
                break;
            case South:
                ycoord -= currentSpeed;
                break;
        }
    }
    public void turnLeft() {
        compass dircar = direction;
        switch (dircar) {
            case North:
                direction = compass.West;
                break;
            case East:
                direction = compass.North;
                break;
            case West:
                direction = compass.South;
                break;
            case South:
                direction = compass.East;
                break;
        }
    }
    public void turnRight(){
        compass dircar = direction;
        switch (dircar) {
            case North:
                direction = compass.East;
                break;
            case East:
                direction = compass.South;
                break;
            case West:
                direction = compass.North;
                break;
            case South:
                direction = compass.West;
                break;
        }
    }
/*
    // TODO fix this method according to lab pm
    public void gas(double amount) {
    if amount is range(double 0, double 1){
        incrementSpeed(amount);
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }
    */
}


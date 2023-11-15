package src;

import java.awt.*;

public abstract class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private compass direction; // Direction of the car
    private double xcoord; // X coordinate of the car
    private double ycoord; // Y coordinate of the car

    public enum compass {
        North, East, West, South
    }

    Car(int nrDoors, double enginePower, Color color,
        String modelName, int size){

        this.nrDoors=nrDoors;
        this.enginePower=enginePower;
        this.color=color;
        this.modelName=modelName;
        this.direction=compass.North;
        this.currentSpeed=0;
        this.xcoord=0;
        this.ycoord=0;
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

    public double getYcoord(){
        return ycoord;
    }

    public double getXcoord(){
        return xcoord;
    }

    public void setYcoord(double y) { ycoord = y; }

    public void setXcoord(double x) { xcoord = x;}

    public compass getDirection(){
        return direction;
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

    public int getSize() {return size;}

    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
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


    public void gas(double amount) {
        if (amount > 0 && amount < 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount > 0 && amount < 1) {
            decrementSpeed(amount);
        }
    }


}


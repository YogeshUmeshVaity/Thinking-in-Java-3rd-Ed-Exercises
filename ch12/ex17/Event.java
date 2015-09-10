//: c08:controller:Event.java
// The common methods for any control event.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// This control framework
//package ex17.controller;

import java.lang.*;

public abstract class Event {
  private long eventTime;
  protected final long delayTime;
  public Event(long delayTime) {
    this.delayTime = delayTime;
    start();
  }
  public void start() { // Allows restarting
    eventTime = System.currentTimeMillis() + delayTime;
  }
  public static Event factory(String type, long time) {
    GreenhouseControls gc = new GreenhouseControls();
    if(type.equals("LightOn")) return gc.new LightOn(time);
    if(type.equals("LightOff")) return gc.new LightOff(time);
    if(type.equals("WaterOn")) return gc.new WaterOn(time);
    if(type.equals("WaterOff")) return gc.new WaterOff(time);
    if(type.equals("ThermostatNight")) return gc.new ThermostatNight(time);
    if(type.equals("ThermostatDay")) return gc.new ThermostatDay(time);
    if(type.equals("FanOn")) return gc.new FanOn(time);
    if(type.equals("FanOff")) return gc.new FanOff(time);
    if(type.equals("Bell")) return gc.new Bell(time);
    throw new RuntimeException("Wrong event name : " + type);
  }
  public boolean ready() {
    return System.currentTimeMillis() >= eventTime;
  }
  public abstract void action();
} ///:~

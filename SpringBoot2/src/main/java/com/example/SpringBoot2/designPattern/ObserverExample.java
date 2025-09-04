package com.example.SpringBoot2.designPattern;

import java.util.ArrayList;
import java.util.List;

interface Observer
{
    void update(String message);
}

class Subject
{
    List<Observer>observers=new ArrayList<>();

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public void notifyMessage()
    {
        for(Observer observer:observers)
        {
            observer.update("Video uploaded");
        }
    }
}
class Email implements Observer
{
    public void update(String message)
    {
        System.out.println("Email "+message);
    }
}
class SMS implements Observer
{
    public void update(String message)
    {
        System.out.println("SMS "+message);
    }
}
public class ObserverExample {

    public static void main(String[] args) {
        Subject subject=new Subject();
        subject.addObserver(new Email());
        subject.addObserver(new SMS());

        subject.notifyMessage();
    }
}

package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import cs5004.animator.model.AbstractChange;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewType;

public class Controller implements IController, ActionListener {
  private AnimationModel model;
  private IView view;
  private int speed;
  private Timer timer;
  private int currentTick = 1;
  private boolean looping = false;
  private int finalTime;


  public Controller(AnimationModel model, IView view, int speed) {
    this.model = model;
    this.view = view;
    this.speed = speed;
    //TODO: gotta set the action listener, see old visual view maybe for inspo
    this.timer = new Timer(1000 / this.speed, this);
    this.finalTime = model.getFinalTime();
  }

  @Override
  public void setTick(int tick) {
    this.currentTick = tick;
  }

  @Override
  public int getTick() {
    return this.currentTick;
  }


  @Override
  public void toggleLooping() {
    if (this.getTick() >= model.getFinalTime()) {
      setTick(1);
    }
  }

  @Override
  public void pause() {
    this.timer.stop();
    // TODO: may have to havethe view replay the current loop on loop
    //  or just display that set of shapes statically
  }

  @Override
  public void restart() {
    setTick(1);
  }


  @Override
  public void adjustSpeed(int speed){

  }

  @Override
  public void go(AnimationModel model, ViewType view) {
    while(true) {
      //call the visual view here, the ones without any mid view actions can end right after, the other 3 can go outside of the while loop`

      //TODO below here put in the mid view actions for playback view, at the end of the loop return the model to the visual view?

    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
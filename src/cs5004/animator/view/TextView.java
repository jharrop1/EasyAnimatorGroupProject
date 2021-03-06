package cs5004.animator.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;

import cs5004.animator.model.AnimationModel;

/**
 * Creates the textual representation.
 */
public class TextView implements IView {
  AnimationModel model;
  Appendable fileOutput;

  public TextView(AnimationModel model, Appendable fileOutput) {
    this.model = model;
    this.fileOutput = fileOutput;
  }

  @Override
  public void run() throws IOException {
    try {
      fileOutput.append(model.toString());
    } catch (IOException e) {
      System.out.println("Error with the file writer.");
    }
  }

  @Override
  public void setUpdatedShapes(int currentTick) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Text View cannot set updated shapes");
  }

  @Override
  public void setCurrentShapes(AnimationModel model) {
    throw new UnsupportedOperationException("Text View cannot set updated shapes");
  }

  @Override
  public ViewType getViewType() {
    return ViewType.TEXT;
  }

  @Override
  public void setSpeed(int speed) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("SVG View cannot set speed");
  }

  @Override
  public void setListeners(ActionListener clicks, KeyListener keys) {
    //SVG view does not have listeners, it is a method from the interface.
  }
}

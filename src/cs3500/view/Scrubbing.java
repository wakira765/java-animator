package cs3500.view;

import java.awt.event.ActionEvent;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cs3500.animation.RoIAnimation;
import cs3500.controller.IViewListener;

/**
 * A class that extends the functionality of an EditPanel to add scrubbing. To use interchangeably
 * with EditPanel in EditView, it is one of EditPanel rather than has a EditPanel. It is a
 * ChangeListener that listens to the adjustments from scrubbing. If the animation is paused, it
 * will remain paused.
 */
public class Scrubbing extends EditPanel implements ChangeListener {
  protected final JSlider scrub;

  /**
   * Default constructor for a Scrubbing. Initiates the JSlider.
   *
   * @param model the model to initialize
   * @param speed the speed of the animation
   */
  public Scrubbing(RoIAnimation model, int speed) {
    super(model, speed);
    scrub = new JSlider(0, model.lastTick(), 0);
    this.add(scrub);
  }

  /**
   * Additionally sets the change listener for the JSlider.
   *
   * @param buttons the listener
   */
  @Override
  public void setListeners(IViewListener buttons) {
    super.setListeners(buttons);
    scrub.addChangeListener(this);
  }

  /**
   * Sets the tick of the animation as specified by the JSlider.
   *
   * @param e the change event
   */
  @Override
  public void stateChanged(ChangeEvent e) {
    this.tick = scrub.getValue();
  }

  /**
   * Updates the JSlider as necessary if the last tick is changed.
   */
  @Override
  public void updateLastTick(int tick) {
    if (this.lastTick < tick) {
      this.lastTick = tick;
      scrub.setMaximum(tick);
    }
  }

  /**
   * As tick is updated, updates the position ot the JSlider as well.
   *
   * @param e the event
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    super.actionPerformed(e);
    scrub.setValue(this.tick);
  }

  /**
   * Sets a change listener.
   *
   * @param change the given listener.
   */
  public void setChange(ChangeListener change) {
    this.scrub.addChangeListener(change);
  }

  /**
   * Gets the JSlider.
   */
  public JSlider getScrub() {
    return this.scrub;
  }
}

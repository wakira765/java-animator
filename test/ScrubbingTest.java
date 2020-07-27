import org.junit.Test;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cs3500.animation.Animation;
import cs3500.animation.IAnimation;
import cs3500.view.Scrubbing;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Scrubbing implementation.
 */
public class ScrubbingTest {
  IAnimation model = new Animation.Builder()
          .declareShape("R", "rectangle")
          .addMotion("R", 1, 10, 10, 10, 10, 10, 10, 255,
                  100, 30, 30, 30, 30, 10, 10, 255)
          .build();

  Scrubbing scrub = new Scrubbing(model.toRO(), 1);
  Mock mock = new Mock();


  // tests the constructor
  @Test(expected = NullPointerException.class)
  public void nullModel() {
    new Scrubbing(null, 1);
  }

  // tests the initial values of the scrubber.
  @Test
  public void initialValues() {
    assertEquals(0, mock.getValue());
    assertEquals(0, mock.getMin());
    assertEquals(0, mock.getMax());
    assertEquals(0, mock.getOrientation());
    scrub.setChange(mock);
    mock.stateChanged(new ChangeEvent(scrub.getScrub()));
    assertEquals(0, mock.getValue());
    assertEquals(0, mock.getMin());
    assertEquals(100, mock.getMax());
    assertEquals(0, mock.getOrientation());
  }

  // tests if the scrubber correctly updates its max.
  @Test
  public void lastTick() {
    assertEquals(0, mock.getMax());
    scrub.setChange(mock);
    mock.stateChanged(new ChangeEvent(scrub.getScrub()));
    assertEquals(100, mock.getMax());
    scrub.updateLastTick(200);
    mock.stateChanged(new ChangeEvent(scrub.getScrub()));
    assertEquals(200, mock.getMax());
  }

  // tests if the scrubber properly updates its value.
  @Test
  public void adjusted() {
    assertEquals(0, mock.getValue());
    scrub.setChange(mock);
    scrub.getScrub().setValue(30);
    mock.stateChanged(new ChangeEvent(scrub.getScrub()));
    assertEquals(30, mock.getValue());
  }

  /**
   * A Mock class that acts as a listener to the changes in the Scrubber. The class stores these
   * changes to allow testing of the Scrubber's behavior.
   */
  public class Mock implements ChangeListener {
    public int value;
    public int max;
    public int min;
    public int orientation;

    /**
     * Default constructor of mock.
     */
    public Mock() {
      // purposely empty
    }

    /**
     * Sets the values to test.
     *
     * @param e the change.
     */
    @Override
    public void stateChanged(ChangeEvent e) {
      JSlider slider = (JSlider) e.getSource();
      this.value = slider.getValue();
      this.max = slider.getMaximum();
      this.min = slider.getMinimum();
      this.orientation = slider.getOrientation();
    }

    /**
     * Gets the value of the scrubber.
     */
    public int getValue() {
      return this.value;
    }

    /**
     * Gets the max setting of the scrubber.
     */
    public int getMax() {
      return this.max;
    }

    /**
     * Gets the min setting of the scrubber.
     */
    public int getMin() {
      return this.min;
    }

    /**
     * Gets the orientation of the scrubber.
     */
    public int getOrientation() {
      return this.orientation;
    }
  }
}
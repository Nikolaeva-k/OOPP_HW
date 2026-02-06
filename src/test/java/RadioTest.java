import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void defaultValues() {
        Radio radio = new Radio();

        Assertions.assertEquals(0, radio.getMinStation());
        Assertions.assertEquals(9, radio.getMaxStation());
        Assertions.assertEquals(0, radio.getMinVolume());
        Assertions.assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void shouldSetStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);

        Assertions.assertEquals(8, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(10);

        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);

        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldUseDefaultStationCount() {
        Radio radio = new Radio(0);

        Assertions.assertEquals(9, radio.getMaxStation());
    }

    @Test
    public void shouldSwitchNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.next();

        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.prev();

        Assertions.assertEquals(8, radio.getCurrentStation());
    }

    @Test
    public void shouldBeZeroForNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldBeNineForZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();

        Assertions.assertEquals(9, radio.getCurrentStation());
    }


    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(90);
        radio.louder();

        Assertions.assertEquals(91, radio.getCurrentVolume());
    }

    @Test
    public void shouldReduceVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(85);
        radio.quieter();

        Assertions.assertEquals(84, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.louder();

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.quieter();

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeAboveMax2() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.setCurrentVolume(111);

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowMin2() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.setCurrentVolume(-3);

        Assertions.assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void test() {
        Radio radio = new Radio(20);

        radio.setCurrentStation(15);

        int expected = 15;
        int actual = radio.getCurrentStation();
        ;
        Assertions.assertEquals(expected, actual);
    }
}

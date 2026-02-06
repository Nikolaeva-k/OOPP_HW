public class Radio {

    private int stationCount;
    private int currentStation;

    private int currentVolume;

    public Radio() {

        this(10);
    }

    public Radio(int stationCount) {
        if (stationCount <= 0) {
            this.stationCount = 10;
        } else {
            this.stationCount = stationCount;
        }
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    //работа со станциями
    public int getCurrentStation() {
        return currentStation;
    }

    public int getMaxStation() {
        return stationCount - 1;
    }

    public int getMinStation() {
        return 0;
    }

    public void setCurrentStation(int station) {
        if (station < getMinStation()) {
            return;
        }
        if (station > getMaxStation()) {
            return;
        }
        this.currentStation = station;

    }

    public void next() {
        if (currentStation != getMaxStation()) {
            currentStation++;
        } else {
            currentStation = getMinStation();
        }
    }

    public void prev() {
        if (currentStation != getMinStation()) {
            currentStation--;
        } else {
            currentStation = getMaxStation();
        }
    }

    //работа с громкостью

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMaxVolume() {
        return 100;
    }

    public int getMinVolume() {
        return 0;
    }

    public void setCurrentVolume(int volume) {
        if (volume < getMinVolume()) {
            return;
        }
        if (volume > getMaxVolume()) {
            return;
        }
        this.currentVolume = volume;
    }

    public void louder() {
        if (currentVolume < getMaxVolume()) {
            currentVolume++;
        }
    }

    public void quieter() {
        if (currentVolume > getMinVolume()) {
            currentVolume--;
        }
    }
}




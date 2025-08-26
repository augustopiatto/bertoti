public class WeatherStationCoupled {
    private WeatherDisplayCoupled phoneDisplay;
    private WeatherDisplayCoupled webDisplay;
    private WeatherDisplayCoupled tvDisplay;

    public void setDisplays(WeatherDisplayCoupled phone, WeatherDisplayCoupled web, WeatherDisplayCoupled tv) {
        this.phoneDisplay = phone;
        this.webDisplay = web;
        this.tvDisplay = tv;
    }

    public void updateWeatherData(float temperature, float humidity, float pressure) {
        if (phoneDisplay != null) {
            phoneDisplay.showData(temperature, humidity, pressure);
        }

        if (webDisplay != null) {
            webDisplay.showData(temperature, humidity, pressure);
        }

        if (tvDisplay != null) {
            tvDisplay.showData(temperature, humidity, pressure);
        }
    }

    public void removeDisplay(String displayName) {
        if (phoneDisplay != null && phoneDisplay.getDisplayName().equals(displayName)) {
            phoneDisplay = null;
        } else if (webDisplay != null && webDisplay.getDisplayName().equals(displayName)) {
            webDisplay = null;
        } else if (tvDisplay != null && tvDisplay.getDisplayName().equals(displayName)) {
            tvDisplay = null;
        }
    }
}
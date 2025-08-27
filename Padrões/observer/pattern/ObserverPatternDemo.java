package observer.pattern;

class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        
        WeatherDisplay phoneApp = new WeatherDisplay("Aplicativo de Celular");
        WeatherDisplay webSite = new WeatherDisplay("Website");
        WeatherDisplay tvDisplay = new WeatherDisplay("TV da Sala");
        
        station.registerObserver(phoneApp);
        station.registerObserver(webSite);
        station.registerObserver(tvDisplay);
        
        System.out.println("--- Primeira medição ---");
        station.setMeasurements(25.2f, 65.0f, 1013.1f);
        
        station.removeObserver(tvDisplay);
        
        System.out.println("\n--- Segunda medição (sem TV) ---");
        station.setMeasurements(26.7f, 70.0f, 1010.3f);
    }
}

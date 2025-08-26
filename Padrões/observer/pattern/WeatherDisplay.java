package observer.pattern;

class WeatherDisplay implements Observer {
    private String name;
    
    public WeatherDisplay(String name) {
        this.name = name;
    }
    
    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println(name + " - Nova atualização: " +
                           "Temperatura: " + temp + "°C, " +
                           "Umidade: " + humidity + "%, " +
                           "Pressão: " + pressure + " hPa");
    }
}

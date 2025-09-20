public class WeatherRecord {
    private String date;      
    private String city;
    private double temperature;

    public WeatherRecord(String date, String city, double temperature) {
        this.date = date;
        this.city = city;
        this.temperature = temperature;
    }

    
    public String getDate() { return date; }
    public String getCity() { return city; }
    public double getTemperature() { return temperature; }

   
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", City: " + city + ", Temp: " + temperature;
    }
}


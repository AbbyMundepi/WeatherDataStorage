import java.util.*;

public class WeatherDataStorage {
    private double[][] temperatureData;   // rows = years, cols = cities
    private String[] cities;
    private int startYear;
    private final double SENTINEL = Double.MIN_VALUE; // for sparse data

    public WeatherDataStorage(int years, String[] cities, int startYear) {
        this.temperatureData = new double[years][cities.length];
        this.cities = cities;
        this.startYear = startYear;

        
        for (int i = 0; i < years; i++) {
            Arrays.fill(temperatureData[i], SENTINEL);
        }
    }

  
    public void insert(String city, int year, double temp) {
        int row = year - startYear;
        int col = getCityIndex(city);
        if (row >= 0 && row < temperatureData.length && col != -1) {
            temperatureData[row][col] = temp;
        }
    }

    
    public void delete(String city, int year) {
        int row = year - startYear;
        int col = getCityIndex(city);
        if (row >= 0 && row < temperatureData.length && col != -1) {
            temperatureData[row][col] = SENTINEL;
        }
    }

  
    public void retrieve(String city) {
        int col = getCityIndex(city);
        if (col == -1) return;

        System.out.println("Weather data for " + city + ":");
        for (int i = 0; i < temperatureData.length; i++) {
            double temp = temperatureData[i][col];
            int year = startYear + i;
            if (temp != SENTINEL)
                System.out.println(year + " -> " + temp);
            else
                System.out.println(year + " -> No data");
        }
    }

    
    public void rowMajorAccess() {
        System.out.println("Row-Major Access:");
        for (int i = 0; i < temperatureData.length; i++) {
            for (int j = 0; j < temperatureData[i].length; j++) {
                System.out.print(temperatureData[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Column-major access
    public void columnMajorAccess() {
        System.out.println("Column-Major Access:");
        for (int j = 0; j < cities.length; j++) {
            for (int i = 0; i < temperatureData.length; i++) {
                System.out.print(temperatureData[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void handleSparseData() {
        System.out.println("Sparse Data Representation:");
        for (int i = 0; i < temperatureData.length; i++) {
            for (int j = 0; j < cities.length; j++) {
                if (temperatureData[i][j] != SENTINEL) {
                    int year = startYear + i;
                    System.out.println("Year: " + year + ", City: " + cities[j] +
                                       ", Temp: " + temperatureData[i][j]);
                }
            }
        }
    }

    
    private int getCityIndex(String city) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equalsIgnoreCase(city)) return i;
        }
        return -1;
    }

    // Complexity analysis (prints summary)
    public void analyzeComplexity() {
        System.out.println("\nComplexity Analysis:");
        System.out.println("Insert: O(1) - Direct index access");
        System.out.println("Delete: O(1) - Direct index access");
        System.out.println("Retrieve: O(n) - Depends on number of years");
        System.out.println("Space: O(Y * C), where Y = years, C = cities");
    }
}

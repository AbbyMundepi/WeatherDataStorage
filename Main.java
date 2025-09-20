public class Main {
    public static void main(String[] args) {
        String[] cities = {"Delhi", "Mumbai", "Chennai"};
        WeatherDataStorage storage = new WeatherDataStorage(5, cities, 2021);

        storage.insert("Delhi", 2021, 32.5);
        storage.insert("Delhi", 2022, 30.2);
        storage.insert("Mumbai", 2021, 28.1);
        storage.insert("Chennai", 2023, 35.0);

        storage.retrieve("Delhi");

        
        storage.rowMajorAccess();
        storage.columnMajorAccess();

        
        storage.handleSparseData();

        
        storage.delete("Delhi", 2022);
        storage.retrieve("Delhi");

       
        storage.analyzeComplexity();
    }
}

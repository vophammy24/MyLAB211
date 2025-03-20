package mylab211.WEEK8;

public class EastAsiaCountries extends Country {
    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        super.display();
        System.out.print("\t" + countryTerrain);
    }
}

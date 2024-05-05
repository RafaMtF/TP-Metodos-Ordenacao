import java.util.Scanner;

public class Acomodacoes {
    private int roomId;
    private int hostId;
    private int reviews;
    private int accommodates;
    private String roomType;
    private String country;
    private String city;
    private String neighbourhood;
    private String propertyType;
    private double overallSatisfaction;
    private double bedrooms;
    private double price;

    public Acomodacoes() {
        this.roomId = 0;
        this.hostId = 0;
        this.reviews = 0;
        this.accommodates = 0;
        this.roomType = "roomType";
        this.country = "country";
        this.city = "city";
        this.neighbourhood = "neighbourhood";
        this.propertyType = "propertyType";
        this.overallSatisfaction = 0;
        this.bedrooms = 0;
        this.price = 0;
    }

    public Acomodacoes(int roomId, int hostId, String roomType, String country, String city, String neighbourhood,
            int reviews, double overallSatisfaction, int accommodates,
            double bedrooms, double price, String propertyType) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.reviews = reviews;
        this.accommodates = accommodates;
        this.roomType = roomType;
        this.country = country;
        this.city = city;
        this.neighbourhood = neighbourhood;
        this.propertyType = propertyType;
        this.overallSatisfaction = overallSatisfaction;
        this.bedrooms = bedrooms;
        this.price = price;
    }

    public void ler() {

        Scanner scanner = new Scanner(System.in);

        this.roomId = scanner.nextInt();
        this.hostId = scanner.nextInt();
        this.roomType = scanner.nextLine();
        this.country = scanner.nextLine();
        this.city = scanner.nextLine();
        this.neighbourhood = scanner.nextLine();
        this.reviews = scanner.nextInt();
        this.overallSatisfaction = scanner.nextDouble();
        this.accommodates = scanner.nextInt();
        this.bedrooms = scanner.nextDouble();
        this.price = scanner.nextDouble();
        this.propertyType = scanner.nextLine();

        scanner.close();

    }

    public void imprimir() {
        System.out.println("[" + roomId + " ## " + hostId + " ## " + roomType + " ## " + country + " ## " + city
                + " ## " + neighbourhood + " ## " + reviews + " ## " + overallSatisfaction + " ## " + accommodates
                + " ## " + bedrooms + " ## " + price + " ## " + propertyType + "]");
    }

    public Acomodacoes clone() {
        return new Acomodacoes(this.roomId, this.hostId, this.roomType, this.country, this.city, this.neighbourhood,
                this.reviews, this.overallSatisfaction, this.accommodates, this.bedrooms, this.price,
                this.propertyType);
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public int getAccommodates() {
        return accommodates;
    }

    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public double getOverallSatisfaction() {
        return overallSatisfaction;
    }

    public void setOverallSatisfaction(double overallSatisfaction) {
        this.overallSatisfaction = overallSatisfaction;
    }

    public double getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

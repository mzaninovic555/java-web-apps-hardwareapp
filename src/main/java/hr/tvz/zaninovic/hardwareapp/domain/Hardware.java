package hr.tvz.zaninovic.hardwareapp.domain;

public class Hardware {
    private String name, code;
    private double price;
    private HardwareType hardwareType;
    private int amount;

    public Hardware(String name, String code, double price, HardwareType hardwareType, int amount) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.hardwareType = hardwareType;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

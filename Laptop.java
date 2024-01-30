package Java_introduction_Final_HW;

import java.util.Objects;

public class Laptop {
    private int ram;
    private int hdCapacity;
    private String os;
    private String brand;
    private int price;


    public Laptop(int ram, int hdCapacity, String os, String brand, int price) {
        this.price = price;
        this.ram = ram;
        this.hdCapacity = hdCapacity;
        this.os = os;
        this.brand = brand;
        
    }

    public int getRam() {
        return ram;
    }

    public int getHdCapacity() {
        return hdCapacity;
    }

    public String getOs() {
        return os;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdCapacity(int hdCapacity) {
        this.hdCapacity = hdCapacity;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Цена: %d, ОЗУ: %d, Объем ЖД: %d, ОС: %s, Бренд: %s", price, ram, hdCapacity, os, brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, hdCapacity, os, brand, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;          
        }
        var l = (Laptop) obj;
        return ram == l.ram && hdCapacity == l.hdCapacity && os.equals(l.os) && brand.equals(l.brand) && price == l.price;
    }
}

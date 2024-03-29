package com.rocketzki.persistedh2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
    @Id
    private int id;
    private String producer;
    private String model;
    private Double price;
    private String processorManufacturer;

    public Laptop() {

    }

    public Laptop(String producer, String model, Double price, String processorManufacturer) {
        this.model = model;
        this.producer = producer;
        this.price = price;
        this.processorManufacturer = processorManufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getProducer() {
        return producer;
    }

    public Double getPrice() {
        return price;
    }

    public String getProcessorManufacturer() {
        return processorManufacturer;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", processorManufacturer='" + processorManufacturer + '\'' +
                '}';
    }
}

package com.chainanalysis.kryptos.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class NomicsPriceDTO {
    @XmlElement
    private String name;

    @XmlElement
    private String price;

    public NomicsPriceDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NomicsPriceDTO that = (NomicsPriceDTO) o;
        return name.equals(that.name) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "NomicsPriceDTO{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

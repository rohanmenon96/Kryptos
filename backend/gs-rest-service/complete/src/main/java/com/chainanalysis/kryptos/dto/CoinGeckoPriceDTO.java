package com.chainanalysis.kryptos.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class CoinGeckoPriceDTO {

    @XmlElement
    private String usd;

    public CoinGeckoPriceDTO() {
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinGeckoPriceDTO that = (CoinGeckoPriceDTO) o;
        return Objects.equals(usd, that.usd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usd);
    }

    @Override
    public String toString() {
        return "CoinGeckoPriceDTO{" +
                "usd='" + usd + '\'' +
                '}';
    }
}

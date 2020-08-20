package com.chainanalysis.kryptos.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class CoinGeckoResponseDTO {

    @XmlElement
    private CoinGeckoPriceDTO bitcoin;

    @XmlElement
    private CoinGeckoPriceDTO ethereum;

    public CoinGeckoResponseDTO() {
    }

    public CoinGeckoPriceDTO getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(CoinGeckoPriceDTO bitcoin) {
        this.bitcoin = bitcoin;
    }

    public CoinGeckoPriceDTO getEthereum() {
        return ethereum;
    }

    public void setEthereum(CoinGeckoPriceDTO ethereum) {
        this.ethereum = ethereum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinGeckoResponseDTO that = (CoinGeckoResponseDTO) o;
        return bitcoin.equals(that.bitcoin) &&
                ethereum.equals(that.ethereum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bitcoin, ethereum);
    }

    @Override
    public String toString() {
        return "CoinGeckoResponseDTO{" +
                "bitcoin=" + bitcoin +
                ", ethereum=" + ethereum +
                '}';
    }
}

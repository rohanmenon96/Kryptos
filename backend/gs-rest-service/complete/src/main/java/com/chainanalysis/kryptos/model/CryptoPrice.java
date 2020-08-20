package com.chainanalysis.kryptos.model;

import com.chainanalysis.kryptos.dto.CoinGeckoResponseDTO;
import com.chainanalysis.kryptos.dto.NomicsPriceDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class CryptoPrice {

    @XmlElement
    private String bitcoinPrice;

    @XmlElement
    private String ethereumPrice;

    @XmlElement
    private String exchangeName;

    public CryptoPrice(CoinGeckoResponseDTO coinGeckoResponseDTO, String exchangeName) {
        this.bitcoinPrice = coinGeckoResponseDTO.getBitcoin().getUsd();
        this.ethereumPrice = coinGeckoResponseDTO.getEthereum().getUsd();
        this.exchangeName = exchangeName;
    }

    public CryptoPrice(List<NomicsPriceDTO> nomicsPriceDTOS, String exchangeName) {
        this.exchangeName = exchangeName;
        for (NomicsPriceDTO nomicsPriceDTO : nomicsPriceDTOS) {
            if (nomicsPriceDTO.getName().equals("Bitcoin")) {
                this.bitcoinPrice = nomicsPriceDTO.getPrice();
            } else {
                this.ethereumPrice = nomicsPriceDTO.getPrice();
            }
        }
    }

    public CryptoPrice() {
    }

    public String getBitcoinPrice() {
        return bitcoinPrice;
    }

    public void setBitcoinPrice(String bitcoinPrice) {
        this.bitcoinPrice = bitcoinPrice;
    }

    public String getEthereumPrice() {
        return ethereumPrice;
    }

    public void setEthereumPrice(String ethereumPrice) {
        this.ethereumPrice = ethereumPrice;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    @Override
    public String toString() {
        return "CryptoPrice{" +
                "bitcoinPrice='" + bitcoinPrice + '\'' +
                ", ethereumPrice='" + ethereumPrice + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptoPrice that = (CryptoPrice) o;
        return bitcoinPrice.equals(that.bitcoinPrice) &&
                ethereumPrice.equals(that.ethereumPrice) &&
                exchangeName.equals(that.exchangeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bitcoinPrice, ethereumPrice, exchangeName);
    }
}

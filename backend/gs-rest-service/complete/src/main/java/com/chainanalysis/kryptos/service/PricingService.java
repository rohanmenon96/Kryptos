package com.chainanalysis.kryptos.service;

import com.chainanalysis.kryptos.model.CryptoPrice;

import java.io.IOException;
import java.net.URISyntaxException;

public interface PricingService {
    CryptoPrice getCryptoPriceNomics() throws URISyntaxException, IOException;

    CryptoPrice getCryptoPriceCoinGecko() throws URISyntaxException, IOException;
}

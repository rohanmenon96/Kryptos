package com.chainanalysis.kryptos.service.impl;

import com.chainanalysis.kryptos.constants.Constants;
import com.chainanalysis.kryptos.model.CryptoPrice;
import com.chainanalysis.kryptos.service.PricingService;
import com.chainanalysis.kryptos.util.JsonUtil;
import com.chainanalysis.kryptos.util.PropertiesUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PricingServiceImpl implements PricingService {

    public CryptoPrice getCryptoPriceCoinGecko() throws URISyntaxException, IOException {
        String coinGeckoApiResponse = makeAPICall(Constants.COIN_GECKO_URL, null);
        return convertCoinGeckoResponseToBitcoinPrice(coinGeckoApiResponse);
    }

    public CryptoPrice getCryptoPriceNomics() throws URISyntaxException, IOException {
        String apiKey = PropertiesUtil.getProperties(Constants.APPLICATION_PROPERTIES).getProperty("API_KEY");
        List<NameValuePair> nomicsParameters = getNomicsParameters(apiKey);
        String nomicsApiResponse = makeAPICall(Constants.NOMICS_URL, nomicsParameters, apiKey);
        return convertCoinGeckoResponseToBitcoinPrices(nomicsApiResponse);
    }

    private List<NameValuePair> getNomicsParameters(String apiKey) {
        List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
        paratmers.add(new BasicNameValuePair("key", apiKey));
        paratmers.add(new BasicNameValuePair("ids", "BTC,ETH"));
        paratmers.add(new BasicNameValuePair("convert", "USD"));
        paratmers.add(new BasicNameValuePair("interval", "1d"));
        return paratmers;
    }

    private String makeAPICall(String uri, List<NameValuePair> parameters)
            throws URISyntaxException, IOException {
        return makeAPICall(uri, parameters, null);
    }

    private String makeAPICall(String uri, List<NameValuePair> parameters, String apiKey)
            throws URISyntaxException, IOException {
        String response_content = "";

        URIBuilder query = new URIBuilder(uri);
        if (parameters != null) {
            query.addParameters(parameters);
        }

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());

        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        if (apiKey != null) {
            request.addHeader("X-CMC_PRO_API_KEY", apiKey);
        }

        try (CloseableHttpResponse response = client.execute(request)) {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            response_content = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        }

        return response_content;
    }

    private CryptoPrice convertCoinGeckoResponseToBitcoinPrices(String apiResponse) throws JsonProcessingException {
        return new CryptoPrice(JsonUtil.parseNomicsResponse(apiResponse), "Nomics");
    }

    private CryptoPrice convertCoinGeckoResponseToBitcoinPrice(String apiResponse) throws JsonProcessingException {
        return new CryptoPrice(JsonUtil.parseCoinGeckoResponse(apiResponse), "CoinGecko");
    }


}

package com.chainanalysis.kryptos.util;

import com.chainanalysis.kryptos.dto.CoinGeckoResponseDTO;
import com.chainanalysis.kryptos.dto.NomicsPriceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static CoinGeckoResponseDTO parseCoinGeckoResponse(String apiResponse) throws JsonProcessingException {
        return objectMapper.readValue(apiResponse, CoinGeckoResponseDTO.class);
    }

    public static List<NomicsPriceDTO> parseNomicsResponse(String apiResponse) throws JsonProcessingException {
        return Arrays.asList(objectMapper.readValue(apiResponse, NomicsPriceDTO[].class));
    }
}

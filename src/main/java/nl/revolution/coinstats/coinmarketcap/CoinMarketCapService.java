package nl.revolution.coinstats.coinmarketcap;

import nl.revolution.coinstats.CoinMarketCapItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class CoinMarketCapService {

    private static final String API_URL = "https://api.coinmarketcap.com/v1/ticker/";

    @Autowired
    private RestTemplate restTemplate;

    private List<CoinMarketCapItem> items = new ArrayList<>();

    @Scheduled(fixedRate = 5000)
    public void update() {
        List<CoinMarketCapItem> newItems = asList(restTemplate.getForObject(API_URL, CoinMarketCapItem[].class));
        items.clear();
        items.addAll(newItems);
    }

    public List<CoinMarketCapItem> getData() {
        return items;
    }
}

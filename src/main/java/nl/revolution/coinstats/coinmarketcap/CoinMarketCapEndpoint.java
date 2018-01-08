package nl.revolution.coinstats.coinmarketcap;

import nl.revolution.coinstats.CoinMarketCapItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coinmarketcap")
public class CoinMarketCapEndpoint {

    @Autowired
    public CoinMarketCapService service;

    @GetMapping
    public List<CoinMarketCapItem> getCoinMarketCapData() {
        return service.getData().stream().limit(10).collect(Collectors.toList());
    }

}

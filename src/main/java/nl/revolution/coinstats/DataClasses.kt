package nl.revolution.coinstats

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class CoinMarketCapItem(
        val id: String,
        val name: String,
        val symbol: String,
        val rank: String,
        val price_usd: String,
        val price_btc: String,
        @JsonProperty("24h_volume_usd") val _24h_volume_usd: String,
        val market_cap_usd: String,
        val available_supply: String,
        val total_supply: String,
        val max_supply: String?,
        val percent_change_1h: String,
        val percent_change_24h: String,
        val percent_change_7d: String,
        val last_updated: String
)
package com.example.internetsale.service;

import com.example.internetsale.entity.MarketDto;
import com.example.internetsale.model.Market;
import com.example.internetsale.repo.MarketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {

    private final MarketRepo marketRepo;

    @Autowired
    public MarketService(MarketRepo marketRepo) {

        this.marketRepo = marketRepo;
    }

    public List<MarketDto> listMarkets(String name) {
        if (name == null) {
            List<Market> listMarkets = marketRepo.findAll();
            List<MarketDto> result = new ArrayList<>();
            for(int i=0; i<listMarkets.size();i++){
                MarketDto marketDto = new MarketDto();
                marketDto.setId(listMarkets.get(i).getId());
                marketDto.setName(listMarkets.get(i).getName());
                marketDto.setLocation(listMarkets.get(i).getLocation());
                marketDto.setItems_name(listMarkets.get(i).getItemNo().getName());
                result.add(marketDto);
            }
            return result;
        } else {
            //return marketRepo.findByName(name);
            return new ArrayList<>();
        }
//        return items.stream()
//                .filter(item -> item.getName().contains(itemName))
//                .collect(Collectors.toList());
    }

    public Market saveMarket(Market newMarket) {
        return marketRepo.save(newMarket);
    }

    public Market findById(Long id) {
        return marketRepo.findMarketById(id);
    }

    public void deleteItem(Long items_Id) {
        marketRepo.deleteById(items_Id);
    }

    public Market updateMarket(Long id, Market newMarket) {
        Market market = marketRepo.findMarketById(id);
        market.setName(newMarket.getName());
        market.setLocation(newMarket.getLocation());
        market.setItems_id(newMarket.getItems_id());

        return marketRepo.save(market);
    }

    public Market getMarketById(Long id) {
        Market result = marketRepo.findMarketById(id);
        //тут обработка
        return result;
    }


}

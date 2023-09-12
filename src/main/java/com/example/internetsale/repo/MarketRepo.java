package com.example.internetsale.repo;



import com.example.internetsale.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepo extends JpaRepository<Market, Long> {

    List<Market> findByName(String name);

    Market findMarketById(Long id);
}
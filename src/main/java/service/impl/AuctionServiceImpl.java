package service.impl;

import entity.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AuctionRepository;
import service.AuctionService;

@Service
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Auction add(Auction auction) {
        return auctionRepository.add(auction);
    }

    @Override
    public Auction get(Long id) {
        return auctionRepository.get(id);
    }

    @Override
    public Auction update(Auction auction) {
        return auctionRepository.update(auction);
    }
}

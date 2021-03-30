package repository.impl;

import entity.Auction;
import org.springframework.stereotype.Repository;
import repository.AuctionRepository;
import storage.Storage;

@Repository
public class AuctionRepositoryImpl implements AuctionRepository {

    @Override
    public Auction add(Auction auction) {
        auction.setId(Storage.generateAuctionId());
        Storage.getAuctions().add(auction);
        return auction;
    }

    @Override
    public Auction get(Long id) {
        return Storage.getAuctions().stream()
                .filter(auction -> auction.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Cant find auction with id " + id));
    }

    @Override
    public Auction update(Auction auction) {
        Auction auctionFromStorage = get(auction.getId());
        auctionFromStorage.setProduct(auction.getProduct());
        auctionFromStorage.setBids(auction.getBids());
        return auctionFromStorage;
    }
}

package repository;

import entity.Auction;

public interface AuctionRepository {
    Auction add(Auction auction);

    Auction get(Long id);

    Auction update(Auction auction);
}

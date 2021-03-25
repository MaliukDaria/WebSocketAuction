package service;

import entity.Auction;

public interface AuctionService {
    Auction add(Auction auction);

    Auction get(Long id);

    Auction update(Auction auction);
}

package service;

import entity.Auction;
import entity.Bid;

public interface AuctionService {
    Auction add(Auction auction);

    Auction get(Long id);

    Auction update(Auction auction);

    Auction makeBid(Long auctionId, Bid bid);
}

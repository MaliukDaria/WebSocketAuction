package controller;

import entity.Auction;
import entity.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AuctionService;

@Controller
public class AuctionController {
    private final AuctionService auctionService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @RequestMapping("/websocket/api/chat/get/{id}")
    @ResponseBody
    public Auction getAuction(@PathVariable Long id) throws Exception {
        Auction auction = auctionService.get(id);
        return auction;
    }

    @MessageMapping("/websocket/api/chat/makeBid/{auctionId}")
    //@SendTo("/topic/messages/{auctionId}")
    public String makeBid(@DestinationVariable Long auctionId, Bid bid) throws Exception {
        Auction auction = auctionService.makeBid(auctionId, bid);
        String response = bid.getCustomer().getLogin() + " bids " + bid.getBitAmount();
        simpMessagingTemplate.convertAndSend("/topic/messages/" + auctionId, response);
        return response;
    }
}

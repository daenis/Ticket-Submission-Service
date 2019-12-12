package com.api.controller;

import com.api.service.TicketService;
import com.api.dto.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/ticket-service/v1/tickets")
    public ResponseEntity<?> submitTicket(@RequestBody Ticket ticket) {
        ticketService.submitTicket(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

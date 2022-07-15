package com.api.controller;

import com.api.service.TicketService;
import com.api.dto.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    @GetMapping("/ticket-service/v1/tickets")
    public ResponseEntity<?> findTickets() {
        List<Ticket> tickets = ticketService.findTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

}

package com.api.controller;

import com.api.dto.Ticket;
import com.api.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TicketControllerTest {

    private Ticket ticket;

    @Mock
    private TicketService ticketService;

    private TicketController ticketController;

    @BeforeEach
    void init() {
        ticket = new Ticket();

        ticketController = new TicketController(ticketService);
    }

    @Test
    void testSubmitTicket_correctResponseIsReturned() {
        ResponseEntity<?> predictedResponse = new ResponseEntity<>(HttpStatus.OK);

        ResponseEntity<?> returnedResponse = ticketController.submitTicket(ticket);

        assertEquals(predictedResponse, returnedResponse, "The expected response was not returned.");
    }

    @Test
    void testSubmitTicket_ticketIsSubmitted() {
        ticketController.submitTicket(ticket);

        verify(ticketService, times(1)).submitTicket(ticket);
    }

}

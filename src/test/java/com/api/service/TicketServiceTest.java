package com.api.service;

import com.api.dto.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    private String department;
    private Ticket ticket;

    private String submissionMessage;

    private String printedMessage;

    @Mock
    private TicketSubmissionService ticketSubmissionService;

    @Mock
    private TicketSubmissionServiceFactory ticketSubmissionServiceFactory;

    private TicketService ticketService;

    @BeforeEach
    void init() {
        department = "Business Tech";
        ticket = new Ticket();
        ticket.setDepartment(department);

        submissionMessage = "Ticket submitted";

        printedMessage = "";

        ticketService = new TicketService(ticketSubmissionServiceFactory) {
            @Override
            void printMessage(String message) {
                printedMessage = submissionMessage;
            }
        };
    }

    @Test
    void testSubmitTicket() {
        when(ticketSubmissionServiceFactory.getTicketSubmissionServiceForDepartment(department)).thenReturn(ticketSubmissionService);
        when(ticketSubmissionService.submitTicket(ticket)).thenReturn(submissionMessage);

        ticketService.submitTicket(ticket);

        assertEquals(submissionMessage, printedMessage, "The expected submission message was not printed.");
    }

}

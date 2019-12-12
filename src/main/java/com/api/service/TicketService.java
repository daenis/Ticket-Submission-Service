package com.api.service;

import com.api.dto.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketSubmissionServiceFactory ticketSubmissionServiceFactory;

    public TicketService(TicketSubmissionServiceFactory ticketSubmissionServiceFactory) {
        this.ticketSubmissionServiceFactory = ticketSubmissionServiceFactory;
    }

    public void submitTicket(Ticket ticket) {
        String department = ticket.getDepartment();
        TicketSubmissionService ticketSubmissionService = ticketSubmissionServiceFactory.getTicketSubmissionServiceForDepartment(department);

        String message = ticketSubmissionService.submitTicket(ticket);
        printMessage(message);
    }

    void printMessage(String message) {
        System.out.println(message);
    }

}

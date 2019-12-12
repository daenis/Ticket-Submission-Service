package com.api.service;

import com.api.dto.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketSubmissionServiceFactoryTest {

    private String departmentName;
    private TicketSubmissionService ticketSubmissionService;
    private List<TicketSubmissionService> ticketSubmissionServices;

    private TicketSubmissionServiceFactory ticketSubmissionServiceFactory;

    @BeforeEach
    void init() {
        departmentName = "Technology";
        ticketSubmissionService = new TicketSubmissionService() {
            @Override public String getDepartmentName() { return departmentName; }
            @Override public String submitTicket(Ticket ticket) { return ""; }
        };
        ticketSubmissionServices = Collections.singletonList(ticketSubmissionService);

        ticketSubmissionServiceFactory = new TicketSubmissionServiceFactory(ticketSubmissionServices);
    }

    @Test
    void testGetTicketSubmissionServiceForDepartment() {
        TicketSubmissionService returnedTicketSubmissionService = ticketSubmissionServiceFactory.getTicketSubmissionServiceForDepartment(departmentName);

        assertEquals(ticketSubmissionService, returnedTicketSubmissionService, "The ticket submission service was not retrieved.");
    }

    @Test
    void testGetTicketSubmissionServiceForDepartment_ticketSubmissionServiceDoesNotExist_exceptionIsThrown() {
        String invalidDepartmentName = "Quality Analysis";
        String predictedMessage = "Received ticket for unknown department: " + invalidDepartmentName;

        UnknownTicketSubmissionServiceException thrown = assertThrows(UnknownTicketSubmissionServiceException.class, () -> ticketSubmissionServiceFactory.getTicketSubmissionServiceForDepartment(invalidDepartmentName));

        assertEquals(predictedMessage, thrown.getMessage(), "There is a problem with the message of the exception.");
    }

}

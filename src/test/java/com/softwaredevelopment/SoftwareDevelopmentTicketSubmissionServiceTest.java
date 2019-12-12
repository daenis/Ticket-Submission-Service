package com.softwaredevelopment;

import com.api.dto.Ticket;
import com.core.DepartmentName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoftwareDevelopmentTicketSubmissionServiceTest {

    private String identifier;
    private Ticket ticket;

    private SoftwareDevelopmentTicketSubmissionService softwareDevelopmentTicketSubmissionService;

    @BeforeEach
    void init() {
        identifier = "1233";
        ticket = new Ticket();
        ticket.setIdentifier(identifier);

        softwareDevelopmentTicketSubmissionService = new SoftwareDevelopmentTicketSubmissionService();
    }

    @Test
    void testGetDepartmentName() {
        String returnedDepartmentName = softwareDevelopmentTicketSubmissionService.getDepartmentName();

        assertEquals(DepartmentName.SOFTWARE_DEVELOPMENT.getValue(), returnedDepartmentName, "The expected department name was not returned.");
    }

    @Test
    void testSubmitTicket() {
        String predictedMessage = getPredictedMessage();

        String returnedMessage = softwareDevelopmentTicketSubmissionService.submitTicket(ticket);

        assertEquals(predictedMessage, returnedMessage, "The expected message was not returned.");
    }

    private String getPredictedMessage() {
        return "Ticket with ID " + identifier + " has been submitted to the Software Development department.";
    }

}

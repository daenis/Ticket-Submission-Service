package com.informationtechnology;

import com.api.dto.Ticket;
import com.core.DepartmentName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InformationTechnologyTicketSubmissionServiceTest {

    private String identifier;
    private Ticket ticket;

    private InformationTechnologyTicketSubmissionService informationTechnologyTicketSubmissionService;

    @BeforeEach
    void init() {
        identifier = "743829";
        ticket = new Ticket();
        ticket.setIdentifier(identifier);

        informationTechnologyTicketSubmissionService = new InformationTechnologyTicketSubmissionService();
    }

    @Test
    void testGetDepartmentName() {
        String returnedDepartmentName = informationTechnologyTicketSubmissionService.getDepartmentName();

        assertEquals(DepartmentName.INFORMATION_TECHNOLOGY.getValue(), returnedDepartmentName, "The expected department name was not returned.");
    }

    @Test
    void testSubmitTicket() {
        String predictedMessage = getPredictedMessage();

        String returnedMessage = informationTechnologyTicketSubmissionService.submitTicket(ticket);

        assertEquals(predictedMessage, returnedMessage, "The expected message was not returned.");
    }

    private String getPredictedMessage() {
        return "Ticket with ID " + identifier + " has been submitted to the Information Technology department.";
    }

}

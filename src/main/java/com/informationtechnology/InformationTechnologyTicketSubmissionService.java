package com.informationtechnology;

import com.api.dto.Ticket;
import com.api.service.TicketSubmissionService;
import com.core.DepartmentName;
import org.springframework.stereotype.Service;

@Service
public class InformationTechnologyTicketSubmissionService implements TicketSubmissionService {

    @Override
    public String getDepartmentName() {
        return DepartmentName.INFORMATION_TECHNOLOGY.getValue();
    }

    @Override
    public String submitTicket(Ticket ticket) {
        return "Ticket with ID " + ticket.getIdentifier() + " has been submitted to the Information Technology department.";
    }

}

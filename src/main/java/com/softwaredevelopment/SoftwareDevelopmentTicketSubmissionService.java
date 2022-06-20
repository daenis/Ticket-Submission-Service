package com.softwaredevelopment;

import com.api.dto.Ticket;
import com.api.service.TicketSubmissionService;
import com.core.DepartmentName;
import org.springframework.stereotype.Service;

@Service
public class SoftwareDevelopmentTicketSubmissionService implements TicketSubmissionService {

    @Override
    public String getDepartmentName() {
        return DepartmentName.SOFTWARE_DEVELOPMENT.getValue();
    }

    @Override
    public String submitTicket(Ticket ticket) {
        System.out.println("trial version");
        return "Ticket with ID " + ticket.getIdentifier() + " has been submitted to the Software Development department.";
    }

}

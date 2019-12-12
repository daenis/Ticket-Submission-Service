package com.api.service;

import com.api.dto.Ticket;

public interface TicketSubmissionService {

    String getDepartmentName();

    String submitTicket(Ticket ticket);

}

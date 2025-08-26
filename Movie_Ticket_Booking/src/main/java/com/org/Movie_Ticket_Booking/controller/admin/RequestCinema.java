package com.org.Movie_Ticket_Booking.controller.admin;

import com.org.Movie_Ticket_Booking.constants.ViewNames;
import com.org.Movie_Ticket_Booking.dto.respone.UpgradeRqResponse;
import com.org.Movie_Ticket_Booking.entity.enums.UpgradeRequestStatus;
import com.org.Movie_Ticket_Booking.service.UpgradeRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class RequestCinema extends AdminController{
    private final UpgradeRequestService upgradeRequestService;

    @GetMapping("/request_cinemas")
    public String requestCinemas(@RequestParam(required = false) String status,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 Model model){
        Page<UpgradeRqResponse> requestsPage;

        if (status != null && !status.isBlank()) {
            requestsPage  = upgradeRequestService.getRequestsByStatus(status, PageRequest.of(page, size));
        } else {
            requestsPage  = upgradeRequestService.getAllRequest(PageRequest.of(page, size));
        }

        model.addAttribute("activePage", "request");
        model.addAttribute("content", ViewNames.CONTENT_REQUEST_CINEMAS);
        model.addAttribute("requests", requestsPage);
        model.addAttribute("statuses", UpgradeRequestStatus.values());
        model.addAttribute("status", status);
        return ViewNames.LAYOUT_ADMIN;
    }

    @GetMapping("/request_cinemas/{id}")
    @ResponseBody
    public UpgradeRqResponse getDetail(@PathVariable Long id) {
        return upgradeRequestService.getDetailByID(id);
    }

}

package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.events;


import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.UsersRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.enums.LeaveStatuses;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequestHistory;
import com.ogoma.vue_starter.vue_starter.controllers.AuthController;
import com.ogoma.vue_starter.vue_starter.entities.User;
import com.ogoma.vue_starter.vue_starter.utils.mail.EmailModel;
import com.ogoma.vue_starter.vue_starter.utils.mail.MailSender;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Component
@Async("threadPoolTaskExecutor")
public class LeaveRequestEventListener {

    private final MailSender mailSender;

    private final UsersRepository usersRepository;

    public LeaveRequestEventListener(MailSender mailSender, UsersRepository usersRepository) {
        this.mailSender = mailSender;
        this.usersRepository = usersRepository;
    }

    @EventListener
    public void handleEvent(LeaveRequestEvent leaveRequestEvent) {
        LeaveRequestHistory leaveRequestHistory =
                leaveRequestEvent.getRequestEventData().getLeaveRequestHistory();
        if (leaveRequestHistory.getLeaveStatuses().equals(LeaveStatuses.NEW)) {
            processNewLeaveEvent(leaveRequestEvent);
        }

    }

    private void processNewLeaveEvent(LeaveRequestEvent leaveRequestEvent) {
        LeaveRequestHistory leaveRequestHistory = leaveRequestEvent.getRequestEventData().getLeaveRequestHistory();
        LeaveRequest leaveRequest = leaveRequestHistory.getLeaveRequest();
        User userInPlace = this.usersRepository.findByStaffId(leaveRequest.getInPlaceId());
        Map<String, Object> emailTemplateVariables = new HashMap<>();
        emailTemplateVariables.put("username", userInPlace.getFirstName());
        EmailModel emailModel = new EmailModel();
        emailModel.setSubject("In Place Leave Request Approval");
        emailModel.setHtml(true);
        emailModel.setTo(userInPlace.getEmail());
        emailModel.setTemplateVariable(emailTemplateVariables);
        emailModel.setTemplatePath("/new_leave_request");
        UriComponentsBuilder base = leaveRequestEvent.getRequestEventData().getUriComponentsBuilder();
        //ServletUriComponentsBuilder.fromContextPath(leaveRequestEvent.getRequestEventData().getHttpServletRequest()).path("/");
        //ToDO set url for leave approval here
        String url = base.build().toString();
        emailTemplateVariables.put("link", url);
        try {
            this.mailSender.sendMail(emailModel);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

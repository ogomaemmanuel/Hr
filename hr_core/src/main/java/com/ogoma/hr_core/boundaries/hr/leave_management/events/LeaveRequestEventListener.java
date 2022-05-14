package com.ogoma.hr_core.boundaries.hr.leave_management.events;


import com.ogoma.hr_core.boundaries.access_control.repositories.UsersRepository;
import com.ogoma.hr_core.boundaries.hr.employee_management.enums.LeaveStatuses;
import com.ogoma.hr_core.boundaries.hr.leave_management.entities.LeaveRequest;
import com.ogoma.hr_core.boundaries.hr.leave_management.entities.LeaveRequestHistory;
import com.ogoma.hr_core.boundaries.notifications.entities.Notification;
import com.ogoma.hr_core.boundaries.notifications.services.NotificationsService;
import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.utils.mail.EmailModel;
import com.ogoma.hr_core.utils.mail.MailSender;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Component
@Async("threadPoolTaskExecutor")
public class LeaveRequestEventListener {

    private final MailSender mailSender;

    private final UsersRepository usersRepository;

    private final NotificationsService notificationsService;

    public LeaveRequestEventListener(MailSender mailSender, UsersRepository usersRepository, NotificationsService notificationsService) {
        this.mailSender = mailSender;
        this.usersRepository = usersRepository;
        this.notificationsService = notificationsService;
    }

    @EventListener
    public void handleEvent(LeaveRequestEvent leaveRequestEvent) {
        LeaveRequestHistory leaveRequestHistory =
                leaveRequestEvent.getRequestEventData().getLeaveRequestHistory();
        if (leaveRequestHistory.getLeaveStatuses().equals(LeaveStatuses.NEW.name())) {
            processNewLeaveEvent(leaveRequestEvent);
        }
        if (leaveRequestHistory.getLeaveStatuses().equals(LeaveStatuses.WITHDRAWN.name())) {
            processWithdrawalEvent(leaveRequestEvent);
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
            Notification notification = new Notification()
                    .setMessage(userInPlace.getFirstName() + " has made a new leave request and" +
                            " selected you to be in place from " + leaveRequest.getStartDate() + " to "
                            + leaveRequest.getStartDate())
                    .setRead(false)
                    .setUserId(userInPlace.getId());
            this.notificationsService.createNotification(notification);
            this.mailSender.sendMail(emailModel);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private void processWithdrawalEvent(LeaveRequestEvent leaveRequestEvent) {
        LeaveRequestHistory leaveRequestHistory = leaveRequestEvent.getRequestEventData().getLeaveRequestHistory();
        LeaveRequest leaveRequest = leaveRequestHistory.getLeaveRequest();
        User userInPlace = this.usersRepository.findByStaffId(leaveRequest.getInPlaceId());
        Map<String, Object> emailTemplateVariables = new HashMap<>();
        //applicant username, hi ! username has withdrawn
        emailTemplateVariables.put("username", leaveRequest.getApplicant().getFirstName());
        EmailModel emailModel = new EmailModel();
        emailModel.setSubject("Leave request withdrawn");
        emailModel.setHtml(true);
        //message is sent to in place user
        emailModel.setTo(userInPlace.getEmail());
        emailModel.setTemplateVariable(emailTemplateVariables);
        emailModel.setTemplatePath("/leave_withdrawal");
        try {
            Notification notification = new Notification()
                    .setMessage(leaveRequest.getApplicant().getFirstName() + " has withdrawn the leave request made earlier. No further action is required on your part")
                    .setRead(false)
                    .setUserId(userInPlace.getId());
            this.notificationsService.createNotification(notification);
            this.mailSender.sendMail(emailModel);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

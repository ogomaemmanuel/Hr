package com.ogoma.hr_core.utils.mail;

import java.util.Map;

public class EmailModel {
    private String to;
    private String text;
    private String subject;
    private boolean isHtml;
    private String attachmentPath;
    private String templatePath;
    private Map<String, Object> templateVariable;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public void setHtml(boolean html) {
        isHtml = html;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public Map<String, Object> getTemplateVariable() {
        return templateVariable;
    }

    public void setTemplateVariable(Map<String, Object> templateVariable) {
        this.templateVariable = templateVariable;
    }
}

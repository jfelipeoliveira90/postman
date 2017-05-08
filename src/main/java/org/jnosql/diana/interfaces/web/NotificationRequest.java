package org.jnosql.diana.interfaces.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public class NotificationRequest implements Serializable {
    private static final long serialVersionUID = -3568716491690227143L;

    private String from;
    private String to;
    private String subject;
    private String templateToken;
    private Map<String, Object> params;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getTemplateToken() {
        return templateToken;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("from", from)
                .add("to", to)
                .add("subject", subject)
                .add("templateToken", templateToken)
                .add("params", params)
                .toString();
    }
}

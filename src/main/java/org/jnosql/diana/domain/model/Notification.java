package org.jnosql.diana.domain.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.jnosql.diana.api.column.Column;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JsonAutoDetect(fieldVisibility = ANY)
public final class Notification implements Serializable {
    private static final long serialVersionUID = -9186825842872001833L;

    private long id;
    private String from;
    private String to;
    private String subject;
    private Template template;
    private Map<String, Object> params;

    Notification() {

    }

    private Notification(Builder builder) {
        this.id = builder.id;
        this.from = builder.from;
        this.to = builder.to;
        this.subject = builder.subject;
        this.template = builder.template;
        this.params = builder.params;
    }

    List<Column> toColumn() {
        return ImmutableList.of(Column.of("id", id),
                Column.of("des_from", from),
                Column.of("des_to", to),
                Column.of("des_subject", subject),
                Column.of("des_body", template.getBody()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to=" + to +
                ", subject='" + subject + '\'' +
                ", template=" + template +
                ", params=" + params +
                '}';
    }

    public static class Builder {
        private Long id;
        private String from;
        private String to;
        private String subject;
        private Template template;
        private Map<String, Object> params;

        public Builder withId(Long id) {
            checkArgument(id < 0L);
            this.id = id;
            return this;
        }

        public Builder withFrom(String from) {
            this.from = checkNotNull(from);
            return this;
        }

        public Builder withTo(String to) {
            this.to = checkNotNull(to);
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = checkNotNull(subject);
            return this;
        }

        public Builder withTemplate(Template template) {
            this.template = checkNotNull(template);
            return this;
        }

        public Builder withParams(Map<String, Object> params) {
            this.params = checkNotNull(params);
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}

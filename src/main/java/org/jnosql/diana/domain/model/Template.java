package org.jnosql.diana.domain.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.google.common.base.Preconditions.checkNotNull;

@JsonAutoDetect(fieldVisibility = ANY)
public final class Template implements Serializable {
    private static final long serialVersionUID = 4379203439231812358L;

    private String token;
    private String body;

    Template() {

    }

    private Template(Builder builder) {
        this.token = builder.token;
        this.body = builder.body;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return Objects.equal(token, template.token);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(token);
    }

    @Override
    public String toString() {
        return "Template{" +
                "token='" + token + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public final class Builder {
        private String token;
        private String body;

        public Builder withToken(String token) {
            this.token = checkNotNull(token);
            return this;
        }

        public Builder withBody(String body) {
            this.body = checkNotNull(body);
            return this;
        }

        public Template build() {
            return new Template(this);
        }
    }
}

package org.jnosql.diana.domain.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

public final class Template implements Serializable {
    private static final long serialVersionUID = 4379203439231812358L;

    private final String id;
    private final String token;
    private final String layout;

    private Template(Builder builder) {
        this.id = builder.id;
        this.token = builder.token;
        this.layout = builder.layout;
    }

    public String getLayout() {
        return layout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return Objects.equal(id, template.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("token", token)
                .add("layout", layout)
                .toString();
    }

    public static class Builder {
        private String id;
        private String token;
        private String layout;

        public Builder withId(String id) {
            this.id = checkNotNull(id);
            return this;
        }

        public Builder withToken(String token) {
            this.token = checkNotNull(token);
            return this;
        }

        public Builder withLayout(String layout) {
            this.layout = checkNotNull(layout);
            return this;
        }

        public Template build() {
            return new Template(this);
        }
    }
}

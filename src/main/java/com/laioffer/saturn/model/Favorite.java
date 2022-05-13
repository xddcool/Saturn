package com.laioffer.saturn.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "favorite")
@JsonDeserialize(builder = Favorite.Builder.class)
public class Favorite implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;

    @JsonProperty("itemId")
    private Long itemId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Favorite() {}

    public Favorite(Builder builder) {
        this.username = builder.username;
        this.itemId = itemId;
    }

    public static class Builder {
        @JsonProperty("username")
        private String username;

        @JsonProperty("itemId")
        private Long itemId;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setItemId(Long itemId) {
            this.itemId = itemId;
            return this;
        }

        public Favorite builder() {
            return new Favorite(this);
        }
    }
}

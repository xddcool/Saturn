package com.laioffer.saturn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

@Entity
@Table(name = "ask")
//@JsonDeserialize(builder = Ask.Builder.class)
public class Ask {
    private static final long serialVersionUID = 1L;

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;

    //@JsonProperty("item_id")
    //private Long itemId;

    @JsonProperty("ask_by")
    private String askBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Item getItemId() {
//        return item;
//    }
//
//    public void setItemId(Long itemId) {
//        this.itemId = itemId;
//    }


    public Item getItem() {
        return item;
    }

    public Ask setItem(Item item) {
        this.item = item;
        return this;
    }

    public String getAskBy() {
        return askBy;
    }

    public void setAskBy(String askBy) {
        this.askBy = askBy;
    }

    public Ask() {

    }
    public Ask(Item item, String askBy) {
        this.item = item;
        this.askBy = askBy;
    }

//    private Ask(Builder builder) {
//        this.id = builder.id;
//        this.item = builder.item;
//        this.askBy = builder.askBy;
//    }
//
//    public static class Builder{
//
//        @JsonProperty("id")
//        private Long id;
//
//        @JsonProperty("item_id")
//        private Long itemId;
//
//        @JsonProperty("ask_by")
//        private String askBy;
//
//        public Builder setId(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder setItemId(Long itemId) {
//            this.itemId = itemId;
//            return this;
//        }
//
//        public Builder setAskBy(String askBy) {
//            this.askBy = askBy;
//            return this;
//        }
//
//        public Ask build() {return new Ask(this);}
//    }
}

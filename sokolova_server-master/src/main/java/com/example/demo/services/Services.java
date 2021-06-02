package com.example.demo.services;

import com.example.demo.shares.Shares;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Services {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private float price;

    @ManyToOne
    @JoinColumn(name = "shares_id", referencedColumnName = "id")
    private Shares share;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Nullable
    public Shares getShare() {
        return share;
    }

    public void setShare(@Nullable Shares share) {
        this.share = share;
    }
}

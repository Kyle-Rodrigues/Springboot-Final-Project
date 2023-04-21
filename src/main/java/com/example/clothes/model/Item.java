package com.example.clothes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    public enum Brand {
        Nike("Nike"), Adidas("Addidas"), Gucci("Gucci");

        public String title;

        private Brand(String title) {
            this.title = title;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank

    private String name;
    @Min(2021)

    private int yearCreated;

    @Min(1000)
    private int price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = true)
    private DistributionCentre distributionCentre;
    private Brand brand;

    private int quantity;

    public long getDistributionCentreId() {
        return distributionCentre.getId();
    }
}

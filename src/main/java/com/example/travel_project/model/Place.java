package com.example.travel_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "places")
public class Place extends AbstractEntity<Long>{

    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "timezone")
    private String timezone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

    @OneToMany(mappedBy = "place")
    @Builder.Default
    private Set<TripHasPlace> tripPlaces = new HashSet<>();

    @OneToMany(mappedBy = "place")
    @Builder.Default
    private Set<PlaceHasCategory> placeCategories = new HashSet<>();

    @OneToMany(mappedBy = "place")
    @Builder.Default
    private Set<Favorite> favorites = new HashSet<>();

}

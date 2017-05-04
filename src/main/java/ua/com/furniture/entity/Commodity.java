package ua.com.furniture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private Subcategory subcategory;

    @JsonIgnore
    @OneToMany(mappedBy = "commodity")
    private List<CommodityForOrder> commoditiesForOrder = new ArrayList<>();

    private String brand;

    private String country;

    private String material;

    private String color;

    private String style;

    private int price;

    private String image;

    private String description;

    private boolean promo;

    private boolean recent;

    @Transient
    @JsonProperty
    private String imageFile;
}
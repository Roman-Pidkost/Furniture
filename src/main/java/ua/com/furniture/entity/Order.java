package ua.com.furniture.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String phone;

    private boolean archive;

    private String comments;

    private boolean status;

    @JsonProperty("goodsOrdered")
    @OneToMany(mappedBy = "order")
    private List<CommodityForOrder> commoditiesForOrder = new ArrayList<>();
}

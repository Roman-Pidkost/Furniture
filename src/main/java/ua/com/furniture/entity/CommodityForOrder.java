package ua.com.furniture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CommodityForOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    @JsonIgnore
    @ManyToOne
    private Commodity commodity;

    @JsonIgnore
    @ManyToOne
    private Order order;
}

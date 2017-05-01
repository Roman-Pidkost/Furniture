package ua.com.furniture.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CommodityForOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    @ManyToOne
    private Commodity commodity;

    @ManyToOne
    private Order order;
}

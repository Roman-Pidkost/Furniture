package ua.com.furniture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "subcategory")
    private List<Commodity> commodities = new ArrayList<>();

    public Subcategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}

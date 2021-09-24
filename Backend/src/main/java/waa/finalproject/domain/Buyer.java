package waa.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer extends User{

    @Column(name = "balance")
    private float balance;

    @Column(name = "fullName")
    private String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private ShoppingCart shoppingCart;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable
    @JsonIgnore
    private Set<Seller> following;

    @OneToMany(mappedBy= "buyer",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Order> orders;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Review> reviews;
}

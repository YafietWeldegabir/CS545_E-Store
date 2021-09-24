package waa.finalproject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Orders")
public class Order extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name="buyer_id")
    private Buyer buyer;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Address shippingAddress;

    @ManyToOne
    private Address billingAddress;
    
}

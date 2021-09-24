package waa.finalproject.service.invoice;

import waa.finalproject.domain.Invoice;
import waa.finalproject.domain.Order;

import java.util.List;


public interface InvoiceService {

    Invoice generateInvoice(List<Order> orders);
}

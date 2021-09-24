package waa.finalproject.service.invoice;

import waa.finalproject.domain.Invoice;
import waa.finalproject.domain.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public Invoice generateInvoice(List<Order> orders) {
        return null;
    }
}

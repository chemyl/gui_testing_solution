package dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Order {
    private String orderNumber;
    private String deliveryAddress;
    private List<HistoryOrder> historyOrderList;
    private PriceRequest priceRequest;
}

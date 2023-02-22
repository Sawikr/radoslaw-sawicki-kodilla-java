package com.kodilla.good.pattern.challengesOrderService;

public class ProductOrderService {

    private final InformationService informationService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                           final OrderService orderService,
                           final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }



    public void process(final OrderRequest orderRequest, final OrderProduct orderProduct) {
        boolean isOrder = orderService.order(orderRequest.getUser(), orderRequest.getFrom(),
                orderRequest.getTo());

        if (isOrder) {
            informationService.inform(orderRequest.getUser(), orderProduct);
            orderRepository.createOrder(orderRequest.getUser(), orderProduct, orderRequest.getFrom(), orderRequest.getTo());
            new OrderDto(orderRequest.getUser(), true);
        } else {
            new OrderDto(orderRequest.getUser(), false);
        }
    }
}

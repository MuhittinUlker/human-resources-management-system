package org.musketeers.rabbitmq.consumer;

import lombok.RequiredArgsConstructor;
import org.musketeers.rabbitmq.model.GetCompanyDetailsByPersonnelResponseModel;
import org.musketeers.service.CompanyService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCompanyDetailsByPersonnelRequestConsumer {

    private final CompanyService companyService;

    @RabbitListener(queues = "${rabbitmq.get-company-details-by-personnel-queue}")
    public GetCompanyDetailsByPersonnelResponseModel getCompanyDetailsByPersonnel(String personnelId) {
        return companyService.getCompanyDetailsByPersonnel(personnelId);
    }


}

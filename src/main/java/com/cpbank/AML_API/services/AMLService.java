package com.cpbank.AML_API.services;

import com.cpbank.AML_API.models.AMLRequest;
import com.cpbank.AML_API.models.AMLResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@Service
public class AMLService {
    @Autowired
    private RestTemplateBuilder restTemplate;

    public AMLResponse getRiskLevel(AMLRequest request) {
        String url = "https://data-uat-intuition.cambodiapostbank.com.kh/api/v1/f4a10790-2f67-457a-ac0f-04f3f10ac583/dataSets/5c464510-2087-4bb2-b91e-ae04c080ddc2/documents?runStrategy=true&includeDetail=true";
        System.out.println("after string url");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AMLRequest> entity = new HttpEntity<>(request, headers);
        System.out.println("this entity===>"+entity);
        ResponseEntity<AMLResponse> response = restTemplate.build().exchange(url, HttpMethod.POST, entity, AMLResponse.class);

        System.out.println("this response====>"+response);

        return response.getBody();
    }
}

package com.mycompany.invoise.invoice.api;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
/*
    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){
        return invoiceService.createInvoice(invoice);
    }
*/
    @GetMapping
    public Iterable<Invoice> list(){
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        invoices.forEach(invoice -> {
            final Customer customer = restTemplate.getForObject("http://customer-service/customer/"+invoice.getIdCustomer(), Customer.class);
            assert customer != null;
            final Address address = restTemplate.getForObject("http://customer-service/address/"+customer.getAddress().getId(), Address.class);
            System.out.println(address);
            customer.setAddress(address);
            invoice.setCustomer(customer);
        });
        return invoices;
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){
        Invoice invoice = invoiceService.getInvoiceByNumber(number);
        invoice.setCustomer(restTemplate.getForObject("http://localhost:8081/customer/"+invoice.getIdCustomer(), Customer.class));
        return invoice;
    }

    /*@GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){
        System.out.println("La méthode displayInvoiceCreateForm a été invoquée");
        return "invoice-create-form";
    }*/

}

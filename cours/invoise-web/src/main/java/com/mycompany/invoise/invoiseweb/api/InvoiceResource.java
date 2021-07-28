package com.mycompany.invoise.invoiseweb.api;

import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){
        return invoiceService.createInvoice(invoice);
    }

    @GetMapping
    public Iterable<Invoice> list(){
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        return invoices;
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){
        Invoice invoice = invoiceService.getInvoiceByNumber(number);
        return invoice;
    }

    /*@GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){
        System.out.println("La méthode displayInvoiceCreateForm a été invoquée");
        return "invoice-create-form";
    }*/

}

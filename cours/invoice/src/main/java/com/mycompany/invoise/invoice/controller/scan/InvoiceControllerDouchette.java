package com.mycompany.invoise.invoice.controller.scan;

import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public String createInvoice(Invoice invoice) {
        System.out.println("Usage of a scanner");
        invoice = new Invoice();
        Customer customer = new Customer("Antho");
        invoice.setCustomer(customer);
        invoiceService.createInvoice(invoice);

        return null;
    }
}

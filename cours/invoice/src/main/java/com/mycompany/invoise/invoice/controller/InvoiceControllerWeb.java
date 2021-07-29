package com.mycompany.invoise.invoice.controller;

import com.mycompany.invoise.core.entity.invoice.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceControllerWeb {
/*
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results){
        if(results.hasErrors()){
            return "invoice-create-form";
        }
        Invoice invoice = new Invoice();
        Customer customer = new Customer(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);
        Address adresse = new Address(invoiceForm.getStreetName(),invoiceForm.getStreetNumber(),invoiceForm.getCity(),invoiceForm.getZipCode(),invoiceForm.getCountry());
        customer.setAddress(adresse);
        //invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoiceService.createInvoice(invoice);

        return "invoice-created";
    }
*/
    @GetMapping("/home")
    public String displayHome(){
        System.out.println("La méthode displayHome a été invoquée");
        return "invoice-home";
    }

    /*@GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model){
        System.out.println("La méthode displayInvoice a été invoquée");
        Invoice invoice = invoiceService.getInvoiceByNumber(number);
        model.addAttribute("invoice", invoice);
        return "invoice-details";
    }*/
/*
    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){
        System.out.println("La méthode displayInvoiceCreateForm a été invoquée");
        return "invoice-create-form";
    }
*/
}

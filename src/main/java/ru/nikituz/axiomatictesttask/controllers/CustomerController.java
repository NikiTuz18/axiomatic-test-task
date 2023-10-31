package ru.nikituz.axiomatictesttask.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoCustomer;
import ru.nikituz.axiomatictesttask.dto.search.CustomerSearch;
import ru.nikituz.axiomatictesttask.services.CustomerService;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public String customers(Model model){
        model.addAttribute("customers", customerService.getAll());
        return "customers";
    }

    @GetMapping("/{id}")
    public String customer(@PathVariable("id") long id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer-info";
    }

    @GetMapping("/{id}/edit")
    public String editCustomer(@PathVariable("id") long id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer-edit";
    }

    @PatchMapping("/{id}")
    public String updateCustomer(@ModelAttribute("customer") @Valid DtoCustomer dtoUpdatedCustomer,
                                 BindingResult bindingResult,
                                 @PathVariable("id") long id){
        if(bindingResult.hasErrors()){
            return "customer-edit";
        }
        customerService.updateById(id, dtoUpdatedCustomer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable long id){
        customerService.deletedById(id);
        return "redirect:/customers";
    }

    @GetMapping("/search")
    public String customerSearch(@RequestParam(value = "searchQuery") String searchQuery,
                                 @RequestParam(value = "searchType") CustomerSearch.SearchType searchType,
                                 Model model){
        model.addAttribute(
                "customers",
                this.customerService.search(new CustomerSearch(searchQuery, searchType))
        );
        return "customers";
    }
}

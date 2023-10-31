package ru.nikituz.axiomatictesttask.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoCustomer;
import ru.nikituz.axiomatictesttask.services.RequestService;

import java.math.BigDecimal;

@Controller
@RequestMapping("/requests")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @GetMapping("/new")
    private String newRequest(Model model){
        model.addAttribute("customer", new DtoCustomer());
        return "request-new";
    }

    @GetMapping
    private String requests(Model model){
        model.addAttribute("requests", requestService.getAll());
        return "requests";
    }

    @PostMapping
    private String createRequest(@ModelAttribute("customer") @Valid DtoCustomer dtoCustomer,
                                 BindingResult bindingResult){
        return requestService.responseFromRequest(dtoCustomer, bindingResult);
    }

    @GetMapping("/new/result")
    public String resultOfCreateRequest(
            @RequestParam(value = "approvalStatus") boolean approvalStatus,
            @RequestParam(value = "period", required = false) Integer period,
            @RequestParam(value = "approvedAmount", required = false) BigDecimal approvedAmount,
            Model model){
        model.addAttribute("approvalStatus", approvalStatus);
        model.addAttribute("period", period);
        model.addAttribute("approvedAmount", approvedAmount);
        return "request-new-result";
    }

}

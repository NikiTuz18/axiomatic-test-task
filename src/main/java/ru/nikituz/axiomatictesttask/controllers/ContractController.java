package ru.nikituz.axiomatictesttask.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nikituz.axiomatictesttask.services.ContractService;

@Controller
@RequestMapping("/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    public String contracts(Model model){
        model.addAttribute("contracts", contractService.getAll());
        return "contracts";
    }

    @PatchMapping("/{id}")
    public String signContract(@PathVariable("id") long id){
        contractService.sign(id);
        return "redirect:/contracts";
    }
}

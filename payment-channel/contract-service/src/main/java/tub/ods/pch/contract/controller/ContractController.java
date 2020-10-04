package tub.ods.pch.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tub.ods.pch.contract.model.Contractmerkle;
import tub.ods.pch.contract.service.ContractmerkleService;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    Contractmerkle service;
    
    @GetMapping("/owner")
    public String getOwnerAccount() {
    	return service.getRoots();
    }
    
    @PostMapping
    public Contractmerkle createContract(@RequestBody Contractmerkle newContract) throws Exception {
    	return service.createContract(newContract);
    }
    
}

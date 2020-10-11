package tub.ods.pch.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tub.ods.pch.contract.model.Contract;
import tub.ods.pch.contract.service.ContractmerkleService;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    Contract service;
    
    @GetMapping("/owner")
    public String getOwnerAccount() {
    	return service.getRoots();
    }
    
    @PostMapping
    public Contract createContract(@RequestBody Contract newContract) throws Exception {
    	return service.createContract(newContract);
    }
    
}

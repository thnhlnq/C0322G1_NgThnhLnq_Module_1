package com.example.service.contract.impl;

import com.example.model.contract.ContractDetail;
import com.example.repository.contract.IContractDetailRepository;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}

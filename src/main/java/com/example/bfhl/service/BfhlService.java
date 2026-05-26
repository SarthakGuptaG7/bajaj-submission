package com.example.bfhl.service;

import com.example.bfhl.dto.RequestDTO;
import com.example.bfhl.dto.ResponseDTO;

public interface BfhlService {
    ResponseDTO processData(RequestDTO request);
}

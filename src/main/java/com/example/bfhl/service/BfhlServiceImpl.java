package com.example.bfhl.service;

import com.example.bfhl.dto.RequestDTO;
import com.example.bfhl.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public ResponseDTO processData(RequestDTO request) {
        ResponseDTO response = new ResponseDTO();
        
        try {
            List<String> data = request.getData();
            if (data == null) {
                data = new ArrayList<>();
            }

            List<String> evenNumbers = new ArrayList<>();
            List<String> oddNumbers = new ArrayList<>();
            List<String> alphabets = new ArrayList<>();
            List<String> specialCharacters = new ArrayList<>();
            long sum = 0;

            for (String item : data) {
                if (isNumber(item)) {
                    int num = Integer.parseInt(item);
                    sum += num;
                    if (num % 2 == 0) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                } else if (isAlphabet(item)) {
                    alphabets.add(item.toUpperCase());
                } else {
                    specialCharacters.add(item);
                }
            }

            // Generate concat_string: reverse alphabetical characters only, alternating caps
            List<String> alphabetsOnly = new ArrayList<>();
            for (String item : data) {
                if (isAlphabet(item)) {
                    alphabetsOnly.add(item);
                }
            }
            Collections.reverse(alphabetsOnly);
            String joined = String.join("", alphabetsOnly);
            StringBuilder alternatingCaps = new StringBuilder();
            for (int i = 0; i < joined.length(); i++) {
                char c = joined.charAt(i);
                if (i % 2 == 0) {
                    alternatingCaps.append(Character.toUpperCase(c));
                } else {
                    alternatingCaps.append(Character.toLowerCase(c));
                }
            }

            response.setIs_success(true);
            response.setUser_id("sarthak_sharma_26052026");
            response.setEmail("sarthak@example.com");
            response.setRoll_number("ABCD123");
            response.setEven_numbers(evenNumbers);
            response.setOdd_numbers(oddNumbers);
            response.setAlphabets(alphabets);
            response.setSpecial_characters(specialCharacters);
            response.setSum(String.valueOf(sum));
            response.setConcat_string(alternatingCaps.toString());

        } catch (Exception e) {
            response.setIs_success(false);
        }

        return response;
    }

    private boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isAlphabet(String s) {
        return s != null && s.length() == 1 && Character.isLetter(s.charAt(0));
    }
}

package com.example.bfhl;

import com.example.bfhl.dto.RequestDTO;
import com.example.bfhl.dto.ResponseDTO;
import com.example.bfhl.service.BfhlServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {

    private final BfhlServiceImpl bfhlService = new BfhlServiceImpl();

    @Test
    public void testProcessData() {
        RequestDTO request = new RequestDTO();
        request.setData(Arrays.asList("a", "1", "b", "2", "$"));

        ResponseDTO response = bfhlService.processData(request);

        assertTrue(response.isIs_success());
        assertEquals("3", response.getSum());
        assertEquals(Arrays.asList("2"), response.getEven_numbers());
        assertEquals(Arrays.asList("1"), response.getOdd_numbers());
        assertEquals(Arrays.asList("A", "B"), response.getAlphabets());
        assertEquals(Arrays.asList("$"), response.getSpecial_characters());
        
        // alphabets: a, b
        // reversed: b, a
        // joined: ba
        // alternating: Ba
        assertEquals("Ba", response.getConcat_string());
    }
}

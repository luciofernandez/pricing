package com.inditex.pricing.infrastructure.rest.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BrandPriceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void getPriceSuccess1Test() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06-14T10:00:00")
                 .param("brandId", "1")
                 .param("productId", "35455"))
         .andExpect(status().isOk())
//         .andDo(print())
         .andExpect(content().contentType("application/json"))
         .andExpect(jsonPath("$.length()").value(6))
         .andExpect(jsonPath("$.productId").value(35455))
         .andExpect(jsonPath("$.brandId").value(1))
         .andExpect(jsonPath("$.priceList").value(1))
         .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
         .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
         .andExpect(jsonPath("$.price").value("35.50 EUR"));    	 
    }
    
    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void getPriceSuccess2Test() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06-14T16:00:00")
                 .param("brandId", "1")
                 .param("productId", "35455"))
         .andExpect(status().isOk())
//         .andDo(print())
         .andExpect(content().contentType("application/json"))
         .andExpect(jsonPath("$.length()").value(6))
         .andExpect(jsonPath("$.productId").value(35455))
         .andExpect(jsonPath("$.brandId").value(1))
         .andExpect(jsonPath("$.priceList").value(2))
         .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
         .andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"))
         .andExpect(jsonPath("$.price").value("25.45 EUR"));    	 
    }
	
    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void getPriceSuccess3Test() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06-14T21:00:00")
                 .param("brandId", "1")
                 .param("productId", "35455"))
         .andExpect(status().isOk())
//         .andDo(print())
         .andExpect(content().contentType("application/json"))
         .andExpect(jsonPath("$.length()").value(6))
         .andExpect(jsonPath("$.productId").value(35455))
         .andExpect(jsonPath("$.brandId").value(1))
         .andExpect(jsonPath("$.priceList").value(1))
         .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
         .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
         .andExpect(jsonPath("$.price").value("35.50 EUR"));    	 
    }
    
    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void getPriceSuccess4Test() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06-15T10:00:00")
                 .param("brandId", "1")
                 .param("productId", "35455"))
         .andExpect(status().isOk())
//         .andDo(print())
         .andExpect(content().contentType("application/json"))
         .andExpect(jsonPath("$.length()").value(6))
         .andExpect(jsonPath("$.productId").value(35455))
         .andExpect(jsonPath("$.brandId").value(1))
         .andExpect(jsonPath("$.priceList").value(3))
         .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
         .andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"))
         .andExpect(jsonPath("$.price").value("30.50 EUR"));    	 
    }
    
    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void getPriceSuccess5Test() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06-16T21:00:00")
                 .param("brandId", "1")
                 .param("productId", "35455"))
         .andExpect(status().isOk())
//         .andDo(print())
         .andExpect(content().contentType("application/json"))
         .andExpect(jsonPath("$.length()").value(6))
         .andExpect(jsonPath("$.productId").value(35455))
         .andExpect(jsonPath("$.brandId").value(1))
         .andExpect(jsonPath("$.priceList").value(4))
         .andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
         .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
         .andExpect(jsonPath("$.price").value("38.95 EUR"));    	 
    }
    
    @Test
    void getPriceNotFoundKOTest() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06-14T10:00:05")
                 .param("brandId", "1")
                 .param("productId", "36000"))
         .andExpect(status().isNotFound())  
         .andExpect(jsonPath("$.error").value("404 NOT_FOUND"))
         .andExpect(jsonPath("$.message").value("No price found for the given criteria brandId: 1 productId: 36000 applicationDate: 2020-06-14T10:00:05")); 	 
    }
    
    @Test
    void getPriceInvalidDateKOTest() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06T10:00:00")
                 .param("brandId", "1")
                 .param("productId", "35455"))
         .andExpect(status().isBadRequest())  
         .andExpect(jsonPath("$.error").value("400 BAD_REQUEST"))
         .andExpect(jsonPath("$.message").value("2020-06T10:00:00 invalid date")); 	 
    }
    
    @Test
    void getPriceMissingParamKOTest() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06-14T10:00:00")
//                 .param("brandId", "1")
                 .param("productId", "35455"))
         .andExpect(status().isBadRequest())  
         .andExpect(jsonPath("$.error").value("400 BAD_REQUEST"))
         .andExpect(jsonPath("$.message").value("Required request parameter 'brandId' for method parameter type Integer is not present")); 	 
    }    
    
    
    @Test
    void getPriceInvalidValueDataTypeKOTest() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06-14T10:00:00")
                 .param("brandId", "ttttt")
                 .param("productId", "35455"))
         .andExpect(status().isBadRequest())  
         .andExpect(jsonPath("$.error").value("400 BAD_REQUEST"))
         .andExpect(jsonPath("$.message").value("Method parameter 'brandId': Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'; For input string: \"ttttt\"")); 	 
    }      
    
    @Test
    void getPriceInvalidNameParamKOTest() throws Exception {
    	 mockMvc.perform(get("/inditex/prices")
                 .param("applicationDate", "2020-06-14T10:00:00")
                 .param("brandId", "1")
                 .param("productName", "35455"))
         .andExpect(status().isBadRequest())  
         .andExpect(jsonPath("$.error").value("400 BAD_REQUEST"))
         .andExpect(jsonPath("$.message").value("Required request parameter 'productId' for method parameter type Integer is not present")); 	 
    }          
}

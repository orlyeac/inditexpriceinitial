package com.tuxpoli.priceselection.price.application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FinalPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void itShouldReturnPrice1() throws Exception {
        // given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("applicationDate", "2020-06-14-10.00.00");
        params.add("productId", "35455");
        params.add("brandId", "1");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/prices/final")
                .params(params);

        // when
        ResultActions mockPerformed = this.mockMvc.perform(
                request
        );

        // then
        mockPerformed
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14-00.00.00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31-23.59.59")))
                .andExpect(jsonPath("$.price", is(35.50)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    @Test
    void itShouldReturnPrice2() throws Exception {
        // given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("applicationDate", "2020-06-14-16.00.00");
        params.add("productId", "35455");
        params.add("brandId", "1");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/prices/final")
                .params(params);

        // when
        ResultActions mockPerformed = this.mockMvc.perform(
                request
        );

        // then
        mockPerformed
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(2)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14-15.00.00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-14-18.30.00")))
                .andExpect(jsonPath("$.price", is(25.45)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    @Test
    void itShouldReturnPrice3() throws Exception {
        // given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("applicationDate", "2020-06-14-21.00.00");
        params.add("productId", "35455");
        params.add("brandId", "1");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/prices/final")
                .params(params);

        // when
        ResultActions mockPerformed = this.mockMvc.perform(
                request
        );

        // then
        mockPerformed
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14-00.00.00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31-23.59.59")))
                .andExpect(jsonPath("$.price", is(35.50)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    @Test
    void itShouldReturnPrice4() throws Exception {
        // given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("applicationDate", "2020-06-15-10.00.00");
        params.add("productId", "35455");
        params.add("brandId", "1");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/prices/final")
                .params(params);

        // when
        ResultActions mockPerformed = this.mockMvc.perform(
                request
        );

        // then
        mockPerformed
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(3)))
                .andExpect(jsonPath("$.startDate", is("2020-06-15-00.00.00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-15-11.00.00")))
                .andExpect(jsonPath("$.price", is(30.50)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    @Test
    void itShouldReturnPrice5() throws Exception {
        // given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("applicationDate", "2020-06-16-21.00.00");
        params.add("productId", "35455");
        params.add("brandId", "1");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/prices/final")
                .params(params);

        // when
        ResultActions mockPerformed = this.mockMvc.perform(
                request
        );

        // then
        mockPerformed
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(4)))
                .andExpect(jsonPath("$.startDate", is("2020-06-15-16.00.00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31-23.59.59")))
                .andExpect(jsonPath("$.price", is(38.95)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }
}
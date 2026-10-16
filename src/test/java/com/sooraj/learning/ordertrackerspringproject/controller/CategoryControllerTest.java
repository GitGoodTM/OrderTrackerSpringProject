package com.sooraj.learning.ordertrackerspringproject.controller;

import com.sooraj.learning.ordertrackerspringproject.exception.DuplicateCategoryException;
import com.sooraj.learning.ordertrackerspringproject.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CategoryService categoryService;

    @Test
    public void createCategory_whenNameAlreadyExists_returns409() throws Exception{
        //given
        Mockito.when(categoryService.create(any())).thenThrow(new DuplicateCategoryException("Electronics"));
        //when
        mockMvc.perform(post("/api/categories").contentType(MediaType.APPLICATION_JSON).content("""
                {"categoryName":"Electronics"}"""))
        //then
                .andExpectAll(status().isConflict(),
                        (ResultMatcher) jsonPath("$.status").value(409),
                        (ResultMatcher) jsonPath("$.message").value("Category: Electronics already exists"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"","   "})
    public void createCategory_whereNameInvalid_returns400(String body) throws Exception{
        //no given
        //when
        mockMvc.perform(post("/api/categories").contentType(MediaType.APPLICATION_JSON).content(body));
        //then
        status().isBadRequest();
        jsonPath("$.status").value(400);
        verify(categoryService, never()).create(any());
    }
}

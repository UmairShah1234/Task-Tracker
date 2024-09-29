package com.company.TaskTracker.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtils {

    public String getObjectToString(Object object){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(object);
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getStringToObject(String message,Class aClass){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(message,aClass.getClass());
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

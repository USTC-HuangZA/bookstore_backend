package com.reins.bookstore.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtils {
    public static void errorMsg(HttpServletResponse response, String msg, Integer httpStatus) {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = null;
        response.setStatus(httpStatus);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try {
            writer = response.getWriter();
            mapper.writeValue(writer, msg);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
    public static <ResultDTO> void out(HttpServletResponse response, ResultDTO result) {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = null;
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try {
            writer = response.getWriter();
            mapper.writeValue(writer, result);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
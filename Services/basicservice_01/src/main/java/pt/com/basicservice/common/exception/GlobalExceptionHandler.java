package pt.com.basicservice.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ProblemDetail> notFoundException(Exception ex, WebRequest request) {
        log.debug("Start - notFoundException");

        try {
            logRequestData(request);
            log.error(ex.getMessage(), ex);
        } finally {
            log.debug("End - notFoundException");
        }

        return new ResponseEntity<>(ProblemDetail.forStatus(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> globalException(Exception ex, WebRequest request) {
        log.debug("Start - globalException");

        try {
            logRequestData(request);
            log.error(ex.getMessage(), ex);
        } finally {
            log.debug("End - globalException");
        }

        return new ResponseEntity<>(ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void logRequestData(WebRequest request) {
        log.error("Request Path: [{}]", getPath(request));
        log.error("Request Headers: [{}]", getHeaders(request));
        log.error("Request Body: [{}]", getBody(request));
    }

    private static String getPath(WebRequest request) {
        return request.getDescription(false).replace("uri=", "");
    }

    private static String getHeaders(WebRequest request) {
        StringBuilder headers = new StringBuilder();

        try {
            Iterator<String> headerNames = request.getHeaderNames();
            while (headerNames.hasNext()) {
                if (StringUtils.hasText(headers.toString())) {
                    headers.append(";");
                }

                String headerName = headerNames.next();
                headers.append(headerName).append("=").append(request.getHeader(headerName));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return headers.toString();
    }

    private static String getBody(WebRequest request) {
        StringBuilder stringBuilder = new StringBuilder();

        HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();

        try {
            BufferedReader reader = servletRequest.getReader();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return stringBuilder.toString().trim();
    }
}

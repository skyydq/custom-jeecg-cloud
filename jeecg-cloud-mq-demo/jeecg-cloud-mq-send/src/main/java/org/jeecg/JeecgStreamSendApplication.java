package org.jeecg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class JeecgStreamSendApplication {

  public static void main(String[] args) throws UnknownHostException {
    SpringApplication.run(JeecgStreamSendApplication.class, args);
  }
}
package com.example.demo_spring;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ConfigurationProperties(prefix = "item")
public class Item {
    private String name;
    private int value;
}

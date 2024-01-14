package com.grocery.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Set;

@Builder
@AllArgsConstructor
public class JDomain {

    public final String domain;
    public final Set<String> persons;

}

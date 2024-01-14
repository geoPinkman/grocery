package com.grocery.api.model;

import com.grocery.api.dom.Domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Set;

@Builder
@AllArgsConstructor
public class JPerson {

    public final String nickname;
    public final String phoneNumber;
    public final String address;
    public final String additionalInfo;
    public final Set<String> domains;

}

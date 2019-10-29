package org.cargain.flight.feign.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author cintiaargain
 *
 */
@Setter
@Getter
@ToString
public class PassengerResponse implements Serializable {

    private static final long serialVersionUID = -1912889839898184066L;

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String gender;

    private String phone;
}

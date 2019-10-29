package org.cargain.flight.passenger.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author cintiaargain
 *
 */
@Builder
@Getter
@Setter // Should be removed after business logic gonna be ready
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PASSENGER")
public class Passenger implements Serializable {

    private static final long serialVersionUID = -1912889839898184066L;

    @Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_id_seq")
	@SequenceGenerator(name = "passenger_id_seq", sequenceName = "passenger_id_seq", allocationSize = 1)
	@Column(name = "passenger_id")
	private Long id;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;
}

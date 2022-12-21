package com.online_shopping.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  @NotEmpty
  @Size(min = 4)
  private String name;

  @Column(name = "gender")
  @NotEmpty
  private String gender;

  @Column(name = "phone_number")
  @NotNull
  private String phoneNumber;

  @Column(name = "email")
  @Email
  @NotEmpty
  private String email;

  @Column(name = "address")
  private String address;

}

package com.bookmanagement.booklendingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="persons")
public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Yalnızca harf içermelidir.")
        @Column(name="ad_soyad")
        private String nameSurname;

        @NotEmpty
        @Email(message = "E-posta formatına uygun değil.")
        @Column(name="email")
        private String email;
        @NotEmpty
        @Digits(integer = 10,fraction = 0, message = "Telefon numarası 10 rakamlı olmalıdır.")
        @Column(name="tc")
        private Long tc;

        @NotEmpty
        @Digits(integer = 10,fraction = 0, message = "Telefon numarası 10 rakamlı olmalıdır.")
        @Column(name="tel_no")
        private Long phoneNumber;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNameSurname() {
            return nameSurname;
        }

        public void setNameSurname(String nameSurname) {
            this.nameSurname = nameSurname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Long getTc() {
            return tc;
        }

        public void setTc(Long tc) {
            this.tc = tc;
        }

        public Long getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
}

package restservice.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

    @Entity
    public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        public Person(Long id, String personFirstName, String personLastName, String personEmail) {
            this.id = id;
            this.personFirstName = personFirstName;
            this.personLastName = personLastName;
            this.personEmail = personEmail;
        }

        private String personFirstName;
        private String personLastName;

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getPersonFirstName() {
            return personFirstName;
        }
        public void setPersonFirstName(String personFirstName) {
            this.personFirstName = personFirstName;
        }
        public String getPersonLastName() {
            return personLastName;
        }
        public void setPersonLastName(String personLastName) {
            this.personLastName = personLastName;
        }
        public String getPersonEmail() {
            return personEmail;
        }
        public void setPersonEmail(String personEmail) {
            this.personEmail = personEmail;
        }
        private String personEmail;

    }


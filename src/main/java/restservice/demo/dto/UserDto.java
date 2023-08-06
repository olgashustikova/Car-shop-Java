package restservice.demo.dto;

public class UserDto {
        private String firstName;
        private String lastName;
        private String address;
        private String email;
        private Number password;

        public UserDto() {
        }

        public UserDto(String firstName, String lastName, String address, String email, Number password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.email = email;
            this.password = password;
        }

    public UserDto(String firstName, String lastName, String address, String email) {
    }

    public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Number getPassword() {
        return password;
    }

    public void setPassword(Number password) {
        this.password = password;
    }

        @Override
        public String toString() {
            return "carproject.demo.User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", address='" + address + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }


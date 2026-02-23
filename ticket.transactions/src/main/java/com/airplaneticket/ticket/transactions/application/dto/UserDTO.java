package com.airplaneticket.ticket.transactions.application.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

        private int idUser;
        @Size(max = 30, message = "Username es muy extenso, 30 caracteres máximo")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username solo puede contener letras y números")
        private String username;
        public int getIdUser() { return idUser; }
        public void setIdUser(int idUser) { this.idUser = idUser; }
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
}

package com.OnceFactoriaF5.miemakeup.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ResourceController {

        @GetMapping("/login")
        public String loginEndpoint() {
            return "Login!";
        }

        @GetMapping("/admin")
        public String adminEndpoint() {
            return "Admin!";
        }

        @GetMapping("/client")
        public String userEndpoint() {
            return "Client!";
        }

        @GetMapping("/all")
        public String allRolesEndpoint() {
            return "All Roles!";
        }

        @DeleteMapping("/delete")
        public String deleteEndpoint(@RequestBody String s) {
            return "I am deleting " + s;
        }
}

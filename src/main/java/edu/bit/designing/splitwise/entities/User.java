package edu.bit.designing.splitwise.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public record User(String userId, String name, String email, String mobileNumber) {
}

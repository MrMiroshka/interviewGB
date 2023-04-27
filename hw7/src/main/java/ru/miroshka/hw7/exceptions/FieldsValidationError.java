package ru.miroshka.hw7.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldsValidationError {
    private List<String> errorFieldsMessages;
}

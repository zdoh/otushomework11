package ru.zdoher.hw.service;

import org.springframework.stereotype.Service;
import ru.zdoher.hw.domain.Profile;

@Service
public class AcquaintanceServiceImpl implements AcquaintanceService {
    private final ConsoleService consoleService;

    public AcquaintanceServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void makeAcquantance(Profile profile) {
        consoleService.printString("Добро пожаловать в тест, представьтесь пожалуйста.");
        consoleService.printString("Ваше имя: ");
        profile.setName(consoleService.getString());
        consoleService.printString("Ваша фамилия: ");
        profile.setSurname(consoleService.getString());
    }
}

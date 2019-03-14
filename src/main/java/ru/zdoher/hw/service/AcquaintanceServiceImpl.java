package ru.zdoher.hw.service;

import org.springframework.stereotype.Service;
import ru.zdoher.hw.domain.Profile;

@Service
public class AcquaintanceServiceImpl implements AcquaintanceService {
    private final ConsoleService consoleService;

    private LocalizationService localizationService;

    public AcquaintanceServiceImpl(ConsoleService consoleService, LocalizationService localizationService) {
        this.consoleService = consoleService;
        this.localizationService = localizationService;
    }

    @Override
    public void makeAcquantance(Profile profile) {
        consoleService.printString(localizationService.getMessage("message.presentation"));
        consoleService.printString(localizationService.getMessage("message.enterName"));
        profile.setName(consoleService.getString());
        consoleService.printString(localizationService.getMessage("message.enterSurname"));
        profile.setSurname(consoleService.getString());
    }
}

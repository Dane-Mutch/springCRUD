package App.Services;

import App.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SoccerService implements ISoccerService {

    @Autowired
    private AccountRepository accountRepository;

}

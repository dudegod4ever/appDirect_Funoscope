package funoscope.services;

import funoscope.domain.UserAppDirectDto;
import funoscope.web.generatedxml.event.Event.Creator;

public interface UserAppDirectService {
    UserAppDirectDto addUser(Creator pCreator);

    int removeUser(Creator pCreator);
}

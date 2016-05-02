package funoscope.services.adapter;

import org.springframework.stereotype.Service;

import funoscope.domain.UserAppDirectDto;
import funoscope.web.generatedxml.event.Event.Creator;

@Service
public class UserAppDirectAdapter {

    public UserAppDirectDto createAppDirectUserAdapterFromCreator(Creator pCreator) {
        UserAppDirectDto appDirectUserDto = new UserAppDirectDto();

        appDirectUserDto.setEmail(pCreator.getEmail());
        appDirectUserDto.setFirstName(pCreator.getFirstName());
        appDirectUserDto.setLastName(pCreator.getLastName());
        appDirectUserDto.setOpenId(pCreator.getOpenId());
        appDirectUserDto.setUuid(pCreator.getUuid());

        return appDirectUserDto;
    }
}

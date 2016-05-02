package funoscope.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import funoscope.domain.UserAppDirectDto;
import funoscope.services.adapter.UserAppDirectAdapter;
import funoscope.services.dao.UserAppDirectDao;
import funoscope.web.generatedxml.event.Event.Creator;

@Service
public class UserAppDirectServiceImpl implements UserAppDirectService {

    @Autowired
    private UserAppDirectAdapter appDirectUserAdapter;

    @Autowired
    private UserAppDirectDao userAppDirectDao;

    @Override
    public UserAppDirectDto addUser(Creator pCreator) {
        UserAppDirectDto userAppDirectDto = appDirectUserAdapter.createAppDirectUserAdapterFromCreator(pCreator);
        return userAppDirectDao.addUser(userAppDirectDto);
    }

    @Override
    public int removeUser(Creator pCreator) {
        UserAppDirectDto userAppDirectDto = appDirectUserAdapter.createAppDirectUserAdapterFromCreator(pCreator);
        return userAppDirectDao.removeUser(userAppDirectDto);
    }
}

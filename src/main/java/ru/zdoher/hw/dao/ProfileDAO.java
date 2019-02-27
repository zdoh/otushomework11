package ru.zdoher.hw.dao;

import ru.zdoher.hw.domain.Profile;

import java.util.Map;

public interface ProfileDAO {

    public Map<Integer, Profile> getAllProfiles();
    public Profile getProfileByID(Integer id);

}

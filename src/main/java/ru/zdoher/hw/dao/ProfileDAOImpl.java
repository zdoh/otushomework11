package ru.zdoher.hw.dao;

import ru.zdoher.hw.domain.Profile;

import java.util.HashMap;
import java.util.Map;

public class ProfileDAOImpl implements ProfileDAO {
    private Map<Integer, Profile> profileMap = new HashMap<>();



    @Override
    public Map<Integer, Profile> getAllProfiles() {
        return profileMap;
    }

    @Override
    public Profile getProfileByID(Integer id) {
        return profileMap.getOrDefault(id, null);
    }
}
